package com.ChalkerCharles.morecolorful.common.block.properties;

import com.ChalkerCharles.morecolorful.common.ModSounds;
import net.minecraft.world.level.block.SoundType;

public class ModSoundTypes {
    public static final SoundType RARE_WOOD = new SoundType(
            1.0F,
            1.0F,
            ModSounds.RARE_WOOD_BREAK,
            ModSounds.RARE_WOOD_STEP,
            ModSounds.RARE_WOOD_PLACE,
            ModSounds.RARE_WOOD_HIT,
            ModSounds.RARE_WOOD_FALL
    );
    public static final SoundType RARE_WOOD_HANGING_SIGN = new SoundType(
            1.0F,
            1.0F,
            ModSounds.RARE_WOOD_HANGING_SIGN_BREAK,
            ModSounds.RARE_WOOD_HANGING_SIGN_STEP,
            ModSounds.RARE_WOOD_HANGING_SIGN_PLACE,
            ModSounds.RARE_WOOD_HANGING_SIGN_HIT,
            ModSounds.RARE_WOOD_HANGING_SIGN_FALL
    );
    public static final SoundType LEAF_LITTER = new SoundType(
            1.0F,
            1.0F,
            ModSounds.LEAF_LITTER_BREAK,
            ModSounds.LEAF_LITTER_STEP,
            ModSounds.LEAF_LITTER_PLACE,
            ModSounds.LEAF_LITTER_HIT,
            ModSounds.LEAF_LITTER_FALL
    );
}
