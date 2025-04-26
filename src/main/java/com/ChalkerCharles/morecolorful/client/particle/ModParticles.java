package com.ChalkerCharles.morecolorful.client.particle;

import com.ChalkerCharles.morecolorful.MoreColorful;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;

public class ModParticles {
    public static final SimpleParticleType CRABAPPLE_LEAVES = register("crabapple_leaves");
    public static final SimpleParticleType WHITE_CHERRY_LEAVES = register("white_cherry_leaves");
    public static final SimpleParticleType ORANGE_BIRCH_LEAVES = register("orange_birch_leaves");
    public static final SimpleParticleType YELLOW_BIRCH_LEAVES = register("yellow_birch_leaves");
    public static final SimpleParticleType GINKGO_LEAVES = register("ginkgo_leaves");
    public static final SimpleParticleType MAPLE_LEAVES = register("maple_leaves");
    public static final SimpleParticleType FROST_LEAVES = register("frost_leaves");
    public static final SimpleParticleType DAWN_REDWOOD_LEAVES = register("dawn_redwood_leaves");
    public static final SimpleParticleType JACARANDA_LEAVES = register("jacaranda_leaves");

    private static SimpleParticleType register(String name) {
        return Registry.register(
                BuiltInRegistries.PARTICLE_TYPE,
                ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, name),
                FabricParticleTypes.simple()
        );
    }

    public static void init() {
    }
}