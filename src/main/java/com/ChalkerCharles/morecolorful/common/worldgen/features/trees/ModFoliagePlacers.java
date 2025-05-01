package com.ChalkerCharles.morecolorful.common.worldgen.features.trees;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.worldgen.features.trees.foliageplacers.DawnRedwoodFoliagePlacer;
import com.ChalkerCharles.morecolorful.common.worldgen.features.trees.foliageplacers.GinkgoFoliagePlacer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class ModFoliagePlacers {
    public static final FoliagePlacerType<GinkgoFoliagePlacer> GINKGO_FOLIAGE_PLACER =
            register("ginkgo_foliage_placer", new FoliagePlacerType<>(GinkgoFoliagePlacer.CODEC));
    public static final FoliagePlacerType<DawnRedwoodFoliagePlacer> DAWN_REDWOOD_FOLIAGE_PLACER =
            register("dawn_redwood_foliage_placer", new FoliagePlacerType<>(DawnRedwoodFoliagePlacer.CODEC));

    private static <P extends FoliagePlacerType<?>> P register(String name, P placerType) {
        return Registry.register(BuiltInRegistries.FOLIAGE_PLACER_TYPE, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, name), placerType);
    }

    public static void init() {
    }
}