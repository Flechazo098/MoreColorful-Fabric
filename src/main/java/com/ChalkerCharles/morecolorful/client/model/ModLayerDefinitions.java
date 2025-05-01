package com.ChalkerCharles.morecolorful.client.model;

import com.ChalkerCharles.morecolorful.client.renderer.block.CymbalRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

@Environment(EnvType.CLIENT)
public class ModLayerDefinitions {

    private static void registerLayerDefinitions() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RIDE_CYMBAL, CymbalRenderer::createRide);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRASH_CYMBAL, CymbalRenderer::createCrash);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DRUM_SET_RIDE, CymbalRenderer::createDrumSetRide);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DRUM_SET_CRASH, CymbalRenderer::createDrumSetCrash);
    }
    public static void init() {
        registerLayerDefinitions();
    }
}