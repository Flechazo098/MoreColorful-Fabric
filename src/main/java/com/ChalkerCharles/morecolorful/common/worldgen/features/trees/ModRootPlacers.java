package com.ChalkerCharles.morecolorful.common.worldgen.features.trees;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.worldgen.features.trees.rootplacers.DawnRedwoodRootPlacer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.rootplacers.RootPlacerType;

public class ModRootPlacers {
    public static final RootPlacerType<DawnRedwoodRootPlacer> DAWN_REDWOOD_PLACER =
            register("dawn_redwood_root_placer", new RootPlacerType<>(DawnRedwoodRootPlacer.CODEC));

    private static <P extends RootPlacerType<?>> P register(String name, P placerType) {
        return Registry.register(BuiltInRegistries.ROOT_PLACER_TYPE, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, name), placerType);
    }

    public static void init() {
    }
}