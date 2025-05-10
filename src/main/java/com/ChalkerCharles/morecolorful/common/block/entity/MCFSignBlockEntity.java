package com.ChalkerCharles.morecolorful.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MCFSignBlockEntity extends SignBlockEntity {
    public static BlockEntityType<?> SIGN;

    public MCFSignBlockEntity (BlockPos blockPos, BlockState blockState) {
        super(SIGN, blockPos, blockState);
    }
}
