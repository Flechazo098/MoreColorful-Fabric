package com.ChalkerCharles.morecolorful.common.block;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.block.entity.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("DataFlowIssue")
public class ModBlockEntities {
    public static BlockEntityType<HiHatBlockEntity> HIHAT;
    public static BlockEntityType<RideCymbalBlockEntity> RIDE_CYMBAL;
    public static BlockEntityType<CrashCymbalBlockEntity> CRASH_CYMBAL;
    public static BlockEntityType<DrumSetBlockEntity> DRUM_SET;

    public static BlockEntityType<MCFSignBlockEntity> SIGN;
    public static BlockEntityType<MCFHangingSignBlockEntity> HANGING_SIGN;


    static Set<Block> SIGNS = Set.of(
            ModBlocks.CRABAPPLE_SIGN, ModBlocks.CRABAPPLE_WALL_SIGN,
            ModBlocks.DAWN_REDWOOD_SIGN, ModBlocks.DAWN_REDWOOD_WALL_SIGN,
            ModBlocks.EBONY_SIGN, ModBlocks.EBONY_WALL_SIGN,
            ModBlocks.FROST_SIGN, ModBlocks.FROST_WALL_SIGN,
            ModBlocks.GINKGO_SIGN, ModBlocks.GINKGO_WALL_SIGN,
            ModBlocks.JACARANDA_SIGN, ModBlocks.JACARANDA_WALL_SIGN,
            ModBlocks.MAPLE_SIGN, ModBlocks.MAPLE_WALL_SIGN,
            ModBlocks.WILLOW_SIGN, ModBlocks.WILLOW_WALL_SIGN
    );

    static Set<Block> HANGING_SIGNS = Set.of(
            ModBlocks.CRABAPPLE_HANGING_SIGN, ModBlocks.CRABAPPLE_WALL_HANGING_SIGN,
            ModBlocks.DAWN_REDWOOD_HANGING_SIGN, ModBlocks.DAWN_REDWOOD_WALL_HANGING_SIGN,
            ModBlocks.EBONY_HANGING_SIGN, ModBlocks.EBONY_WALL_HANGING_SIGN,
            ModBlocks.FROST_HANGING_SIGN, ModBlocks.FROST_WALL_HANGING_SIGN,
            ModBlocks.GINKGO_HANGING_SIGN, ModBlocks.GINKGO_WALL_HANGING_SIGN,
            ModBlocks.JACARANDA_HANGING_SIGN, ModBlocks.JACARANDA_WALL_HANGING_SIGN,
            ModBlocks.MAPLE_HANGING_SIGN, ModBlocks.MAPLE_WALL_HANGING_SIGN,
            ModBlocks.WILLOW_HANGING_SIGN, ModBlocks.WILLOW_WALL_HANGING_SIGN
    );

    public static void init () {
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

        SIGN = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "sign"),
                BlockEntityType.Builder.of(MCFSignBlockEntity::new,
                        new HashSet<>(SIGNS).toArray(new Block[0])
                        ).build()
        );

        HANGING_SIGN = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "haning_sign"),
                BlockEntityType.Builder.of(MCFHangingSignBlockEntity::new,
                        new HashSet<>(HANGING_SIGNS).toArray(new Block[0])
                ).build()
        );
    }
}