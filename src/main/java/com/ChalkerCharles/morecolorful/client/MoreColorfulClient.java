package com.ChalkerCharles.morecolorful.client;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.client.model.*;
import com.ChalkerCharles.morecolorful.client.model.geometry.RegisterGeometryLoadersCallback;
import com.ChalkerCharles.morecolorful.client.particle.ModParticles;
import com.ChalkerCharles.morecolorful.client.particle.ParticleProvidersRegistry;
import com.ChalkerCharles.morecolorful.client.renderer.RenderersRegistry;
import com.ChalkerCharles.morecolorful.common.block.ModBlocks;
import com.ChalkerCharles.morecolorful.util.TransformationHelper;
import com.mojang.math.Transformation;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;

public class MoreColorfulClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
            // 首先初始化不依赖于枚举扩展的组件
            ModelLoadingPlugin.register(ModModelLoadingRegistry.INSTANCE);

            RegisterGeometryLoadersCallback.EVENT.register(loaders -> loaders.put(ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "separate_transforms"), SeparateTransformsModel.Loader.INSTANCE));
            BlockModel.GSON = BlockModel.GSON.newBuilder()
                .registerTypeAdapter(Transformation.class, new TransformationHelper.Deserializer())
                .create();
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
            setRenderLayers();
    }

    public static void setRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BABY_BLUE_EYES, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEGONIAS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEBERRY_BUSH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BUTTERCUPS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CATTAIL, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHIMES, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CLOSED_DAYBLOOM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRABAPPLE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CROCUS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DAFFODIL, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DAWN_REDWOOD_ROOTS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DAWN_REDWOOD_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DUCKWEEDS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EDELWEISS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FORGET_ME_NOTS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FROSTY_PETALS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FROST_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GERBERA_DAISY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GINKGO_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GINKGO_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GINKGO_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_CHRYSANTHEMUM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GUZHENG, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.IRIS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JACARANDA_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JACARANDA_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JACARANDA_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAVENDER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OPEN_DAYBLOOM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_BIRCH_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_CARNATION, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_DAISY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_LAVENDER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RAPESEED_FLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_CARNATION, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_SPIDER_LILY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHORT_WATER_GRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAWBERRY_BUSH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TALL_RAPESEED_FLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TALL_WATER_GRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VIBRAPHONE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VIOLETS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_CARNATION, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_CHERRY_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_PETALS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILLOW_BRANCHES, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILLOW_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILLOW_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILLOW_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.XYLOPHONE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_BIRCH_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_CHRYSANTHEMUM, RenderType.cutout());
    }
}
