package com.ChalkerCharles.morecolorful.common.block.common;

import com.ChalkerCharles.morecolorful.common.block.ModBlocks;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class WaterLilyBlock extends WaterlilyBlock implements BonemealableBlock {
    private static final VoxelShape COLLISION = Block.box(1.0, 0.0, 1.0, 15.0, 1.5, 15.0);
    private static final VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 6.0, 15.0);

    private static final Supplier<BiMap<Block, Block>> FALLING_ASLEEP = () -> ImmutableBiMap.of(
            ModBlocks.OPEN_WATER_LILY, ModBlocks.CLOSED_WATER_LILY,
            ModBlocks.OPEN_WHITE_WATER_LILY, ModBlocks.CLOSED_WHITE_WATER_LILY,
            ModBlocks.OPEN_BLUE_WATER_LILY, ModBlocks.CLOSED_BLUE_WATER_LILY
    );

    private static final Supplier<BiMap<Block, Block>> WAKING_UP = () -> FALLING_ASLEEP.get().inverse();

    private final boolean isOpen;

    public WaterLilyBlock(boolean isOpen, Properties properties) {
        super(properties);
        this.isOpen = isOpen;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return COLLISION;
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        tryChangingState(pState, pLevel, pPos);
        super.randomTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        tryChangingState(pState, pLevel, pPos);
        super.tick(pState, pLevel, pPos, pRandom);
    }

    private void tryChangingState(BlockState state, ServerLevel level, BlockPos pos) {
        if (level.dimensionType().natural() && level.isDay() != isOpen) {
            level.setBlock(pos, getOpposite(state), Block.UPDATE_ALL);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(state));
        }
    }

    private BlockState getOpposite(BlockState state) {
        BiMap<Block, Block> map = isOpen ? FALLING_ASLEEP.get() : WAKING_UP.get();
        return map.get(state.getBlock()).defaultBlockState();
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        popResource(level, pos, new ItemStack(this));
    }
}