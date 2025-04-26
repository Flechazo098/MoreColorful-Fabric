package com.ChalkerCharles.morecolorful.mixin.chunk;

import com.ChalkerCharles.morecolorful.util.mixin.ChunkLevelGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import javax.annotation.Nullable;

@Mixin(ChunkAccess.class)
public abstract class ChunkAccessMixin implements ChunkLevelGetter {
    @Unique
    @Nullable private Level level;

    @Override
    @Nullable
    public Level moreColorful_Fabric$getLevel() {
        return this.level;
    }
}