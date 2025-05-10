package com.ChalkerCharles.morecolorful.common.block.common;

import com.ChalkerCharles.morecolorful.common.block.entity.MCFSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class MCFStandingSignBlock extends StandingSignBlock {
    public MCFStandingSignBlock (WoodType woodType, Properties properties) {
        super(woodType, properties);
    }

    @Override
    public BlockEntity newBlockEntity (BlockPos blockPos, BlockState blockState) {
        return new MCFSignBlockEntity(blockPos, blockState);
    }
}
