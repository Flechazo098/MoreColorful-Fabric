package com.ChalkerCharles.morecolorful;

import com.ChalkerCharles.morecolorful.common.ModCompostables;
import com.ChalkerCharles.morecolorful.common.ModFuels;
import com.ChalkerCharles.morecolorful.common.ModSounds;
import com.ChalkerCharles.morecolorful.common.ModStats;
import com.ChalkerCharles.morecolorful.common.block.ModBlockEntities;
import com.ChalkerCharles.morecolorful.common.block.ModBlocks;
import com.ChalkerCharles.morecolorful.common.block.VanillaBlockPropertyModifier;
import com.ChalkerCharles.morecolorful.common.item.ModCreativeTabs;
import com.ChalkerCharles.morecolorful.common.item.ModItems;
import com.ChalkerCharles.morecolorful.common.level.ModChunkStatus;
import com.ChalkerCharles.morecolorful.common.loot.ModLootTableModifier;
import com.ChalkerCharles.morecolorful.common.worldgen.biomes.ModBiomeSetup;
import com.ChalkerCharles.morecolorful.common.worldgen.features.ModFeatures;
import com.ChalkerCharles.morecolorful.common.worldgen.features.trees.ModFoliagePlacers;
import com.ChalkerCharles.morecolorful.common.worldgen.features.trees.ModRootPlacers;
import com.ChalkerCharles.morecolorful.common.worldgen.features.trees.ModTreeDecorators;
import com.ChalkerCharles.morecolorful.common.worldgen.features.trees.ModTrunkPlacers;
import com.ChalkerCharles.morecolorful.network.NetworkingRegistry;
import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;

import java.util.Random;

public class MoreColorful implements ModInitializer {
    public static final String MODID = "morecolorful";
    public static final Logger LOGGER = LogUtils.getLogger();
    private final Random random = new Random();

    @Override
    public void onInitialize() {
        int i = random.nextInt(4);
        switch (i) {
            case 0 -> LOGGER.info("Thank You For Downloading!");
            case 1 -> LOGGER.info("Hope You Have Fun!");
            case 2 -> LOGGER.info("I'm Doing Well! :)");
            case 3 -> LOGGER.info("Long Time No See!");
        }
        
        // 初始化配置
        Config.init();
        
        ModItems.init();
        ModBlocks.init();
        ModBlockEntities.init();
        ModSounds.init();
        ModStats.init();
        ModCreativeTabs.init();
        ModLootTableModifier.register();
        ModFoliagePlacers.init();
        ModTrunkPlacers.init();
        ModRootPlacers.init();
        ModTreeDecorators.init();
        ModFeatures.init();
        ModChunkStatus.init();
        new NetworkingRegistry().register();

        VanillaBlockPropertyModifier.modifyProperties();

        ModStats.init();
        ModChunkStatus.modifyFullStatus();

        registerServerEvents();

        if (FabricLoader.getInstance().isModLoaded("terrablender")) {
            CommonLifecycleEvents.TAGS_LOADED.register((registries, client) -> {
                try {
                    LOGGER.info("正在初始化 TerraBlender 集成...");
                    ModBiomeSetup.registerRegions();
                    ModBiomeSetup.registerSurfaceRules();
                    LOGGER.info("TerraBlender 集成初始化完成");
                } catch (Exception e) {
                    LOGGER.error("TerraBlender 集成初始化失败", e);
                }
            });
        }

        // 添加检查，确保配置已初始化
        if (Config.disabledBiomes != null) {
            Config.disabledBiomes.forEach(biome -> LOGGER.info("Biome Disabled: {}", biome.location()));
        } else {
            LOGGER.warn("Config.disabledBiomes is null, skipping biome disable logging");
        }

        ModCompostables.register();
        ModFuels.register();
    }

    private void registerServerEvents() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            int i = random.nextInt(4);
            switch (i) {
                case 0 -> LOGGER.info("More Colorful!");
                case 1 -> LOGGER.info("Hello Server!");
                case 2 -> LOGGER.info("Have A Nice Day!");
                case 3 -> LOGGER.info("YAY! Server Time!");
            }
        });

        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            int i = random.nextInt(4);
            switch (i) {
                case 0 -> LOGGER.info("Goodbye!");
                case 1 -> LOGGER.info("Bye-bye!");
                case 2 -> LOGGER.info("I'll Miss You.");
                case 3 -> LOGGER.info("See You Around!");
            }
        });
    }
}