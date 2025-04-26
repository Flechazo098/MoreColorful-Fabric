package com.ChalkerCharles.morecolorful.util.mixin;

import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public interface ChunkLevelGetter {
    @Nullable
    default Level moreColorful_Fabric$getLevel () {
        return null;
    }
}