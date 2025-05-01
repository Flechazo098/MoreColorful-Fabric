package com.ChalkerCharles.morecolorful.client.particle;

import com.ChalkerCharles.morecolorful.client.particle.particles.LeafParticle;
import com.ChalkerCharles.morecolorful.client.particle.particles.PetalParticle;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

@Environment(EnvType.CLIENT)
public class ParticleProvidersRegistry {

    private static void registerParticleProviders() {
        ParticleFactoryRegistry registry = ParticleFactoryRegistry.getInstance();

        registry.register(ModParticles.CRABAPPLE_LEAVES, PetalParticle.Provider::new);
        registry.register(ModParticles.WHITE_CHERRY_LEAVES, PetalParticle.Provider::new);
        registry.register(ModParticles.ORANGE_BIRCH_LEAVES, LeafParticle.Provider::new);
        registry.register(ModParticles.YELLOW_BIRCH_LEAVES, LeafParticle.Provider::new);
        registry.register(ModParticles.GINKGO_LEAVES, LeafParticle.Provider::new);
        registry.register(ModParticles.MAPLE_LEAVES, LeafParticle.Provider::new);
        registry.register(ModParticles.FROST_LEAVES, PetalParticle.Provider::new);
        registry.register(ModParticles.DAWN_REDWOOD_LEAVES, LeafParticle.Provider::new);
        registry.register(ModParticles.JACARANDA_LEAVES, PetalParticle.Provider::new);
    }

    public static void init() {
        registerParticleProviders();
    }
}