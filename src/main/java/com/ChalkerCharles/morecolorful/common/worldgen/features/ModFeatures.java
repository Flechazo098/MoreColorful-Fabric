package com.ChalkerCharles.morecolorful.common.worldgen.features;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.worldgen.features.misc.ModLakeFeature;
import com.ChalkerCharles.morecolorful.common.worldgen.features.misc.ReedFeature;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;

@SuppressWarnings("deprecation")
public class ModFeatures {
    public static final ModLakeFeature LAKE = register("lake", new ModLakeFeature(LakeFeature.Configuration.CODEC));
    public static final ReedFeature REED = register("reed", new ReedFeature(ProbabilityFeatureConfiguration.CODEC));

    private static <T extends Feature<?>> T register(String name, T feature) {
        return Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, name), feature);
    }

    public static void init() {
    }
}