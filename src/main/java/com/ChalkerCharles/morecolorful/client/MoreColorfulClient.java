package com.ChalkerCharles.morecolorful.client;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.client.model.ModLayerDefinitions;
import com.ChalkerCharles.morecolorful.client.model.ModModelLayers;
import com.ChalkerCharles.morecolorful.client.particle.ModParticles;
import com.ChalkerCharles.morecolorful.client.particle.ParticleProvidersRegistry;
import com.ChalkerCharles.morecolorful.client.renderer.RenderersRegistry;
import net.fabricmc.api.ClientModInitializer;

public class MoreColorfulClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        try {
            // 首先初始化不依赖于枚举扩展的组件
            ModLayerDefinitions.init();
            ModModelLayers.init();
            ModParticles.init();
            ParticleProvidersRegistry.init();
            RenderersRegistry.init();
            ColorHandlersRegistry.init();
            ModClientEvents.init();
            ModKeyMapping.init();
            
            // 最后初始化依赖于枚举扩展的组件
            ModItemClientSetup.init();
            
            MoreColorful.LOGGER.info("MoreColorfulClient initialized successfully");
        } catch (Exception e) {
            MoreColorful.LOGGER.error("Error initializing MoreColorfulClient", e);
        }
    }
}
