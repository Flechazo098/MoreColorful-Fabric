package com.ChalkerCharles.morecolorful.common.block;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.block.entity.CrashCymbalBlockEntity;
import com.ChalkerCharles.morecolorful.common.block.entity.DrumSetBlockEntity;
import com.ChalkerCharles.morecolorful.common.block.entity.HiHatBlockEntity;
import com.ChalkerCharles.morecolorful.common.block.entity.RideCymbalBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

@SuppressWarnings("DataFlowIssue")
public class ModBlockEntities {
    public static BlockEntityType<HiHatBlockEntity> HIHAT;
    public static BlockEntityType<RideCymbalBlockEntity> RIDE_CYMBAL;
    public static BlockEntityType<CrashCymbalBlockEntity> CRASH_CYMBAL;
    public static BlockEntityType<DrumSetBlockEntity> DRUM_SET;

    public static void register() {
        HIHAT = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "hi_hat"),
                BlockEntityType.Builder.of(HiHatBlockEntity::new, ModBlocks.HIHAT).build(null)
        );

        RIDE_CYMBAL = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "ride_cymbal"),
                BlockEntityType.Builder.of(RideCymbalBlockEntity::new, ModBlocks.RIDE_CYMBAL).build(null)
        );

        CRASH_CYMBAL = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "crash_cymbal"),
                BlockEntityType.Builder.of(CrashCymbalBlockEntity::new, ModBlocks.CRASH_CYMBAL).build(null)
        );

        DRUM_SET = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "drum_set"),
                BlockEntityType.Builder.of(DrumSetBlockEntity::new, ModBlocks.DRUM_SET).build(null)
        );
    }
}