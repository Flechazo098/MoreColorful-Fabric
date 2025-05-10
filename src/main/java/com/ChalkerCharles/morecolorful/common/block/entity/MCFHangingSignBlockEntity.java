package com.ChalkerCharles.morecolorful.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MCFHangingSignBlockEntity extends HangingSignBlockEntity {
    public static BlockEntityType<?> HANGING_SIGN;

    public MCFHangingSignBlockEntity (BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public boolean isValidBlockState (BlockState blockState) {
        return this.getType().isValid(blockState);
    }

    @Override
    public BlockEntityType<?> getType () {
        return HANGING_SIGN;
    }
}
