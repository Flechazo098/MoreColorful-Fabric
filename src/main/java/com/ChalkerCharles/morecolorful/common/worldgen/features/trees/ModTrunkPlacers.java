package com.ChalkerCharles.morecolorful.common.worldgen.features.trees;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.worldgen.features.trees.trunklplacers.DawnRedwoodTrunkPlacer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class ModTrunkPlacers {
    public static final TrunkPlacerType<DawnRedwoodTrunkPlacer> DAWN_REDWOOD_TRUNK_PLACER =
            register("dawn_redwood_trunk_placer", new TrunkPlacerType<>(DawnRedwoodTrunkPlacer.CODEC));

    private static <P extends TrunkPlacerType<?>> P register(String name, P placerType) {
        return Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, name), placerType);
    }

    public static void init() {
    }
}