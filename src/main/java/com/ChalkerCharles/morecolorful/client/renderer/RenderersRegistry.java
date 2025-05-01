package com.ChalkerCharles.morecolorful.client.renderer;

import com.ChalkerCharles.morecolorful.client.renderer.block.CymbalRenderer;
import com.ChalkerCharles.morecolorful.common.block.ModBlockEntities;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

@Environment(EnvType.CLIENT)
public class RenderersRegistry {
    private static void registerRenderers() {
        BlockEntityRenderers.register(ModBlockEntities.RIDE_CYMBAL, CymbalRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.CRASH_CYMBAL, CymbalRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.DRUM_SET, CymbalRenderer::new);
    }

    public static void init() {
        registerRenderers();
    }
}