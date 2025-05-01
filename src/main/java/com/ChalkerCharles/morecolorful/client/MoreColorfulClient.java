package com.ChalkerCharles.morecolorful.client;

import com.ChalkerCharles.morecolorful.client.model.ModLayerDefinitions;
import com.ChalkerCharles.morecolorful.client.model.ModModelLayers;
import com.ChalkerCharles.morecolorful.client.particle.ModParticles;
import com.ChalkerCharles.morecolorful.client.particle.ParticleProvidersRegistry;
import com.ChalkerCharles.morecolorful.client.renderer.RenderersRegistry;
import net.fabricmc.api.ClientModInitializer;

public class MoreColorfulClient implements ClientModInitializer {
    @Override
    public void onInitializeClient () {
        ModLayerDefinitions.init();
        ModModelLayers.init();
        ModParticles.init();
        ParticleProvidersRegistry.init();
        RenderersRegistry.init();
        ColorHandlersRegistry.init();
        ModClientEvents.init();
        ModKeyMapping.init();
        ModItemClientSetup.init();
    }
}
