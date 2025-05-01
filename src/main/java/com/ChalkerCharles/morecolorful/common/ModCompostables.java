package com.ChalkerCharles.morecolorful.common;

import com.ChalkerCharles.morecolorful.MoreColorful;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModCompostables {
    public static void register() {
        CompostingChanceRegistry registry = CompostingChanceRegistry.INSTANCE;

        registerItems(registry,0.3F,
                "orange_birch_leaf_litter",
                "yellow_birch_leaf_litter",
                "ginkgo_leaf_litter",
                "maple_leaf_litter",
                "dawn_redwood_leaf_litter");

        registerItems(registry, 0.3F,
                "baby-blue-eyes", "begonias", "blueberries", "buttercups",
                "crabapple_leaves", "crabapple_sapling", "dawn_redwood_leaves",
                "dawn_redwood_roots", "dawn_redwood_sapling", "duckweeds",
                "forget-me-nots", "frost_leaves", "frost_sapling", "frosty_petals",
                "ginkgo_leaves", "ginkgo_sapling", "jacaranda_leaves",
                "jacaranda_sapling", "maple_leaves", "maple_sapling",
                "orange_birch_leaves", "orange_birch_sapling", "short_water_grass",
                "speedwells", "strawberry", "violets", "white_cherry_leaves",
                "white_cherry_sapling", "white_petals", "willow_leaves",
                "willow_sapling", "wood_sorrels", "yellow_birch_leaves",
                "yellow_birch_sapling"
        );

        registerItems(registry, 0.5F,
                "tall_water_grass", "willow_branches"
        );

        registerItems(registry, 0.65F,
                "cattail", "closed_blue_water_lily", "closed_daybloom",
                "closed_water_lily", "closed_white_water_lily", "crocus",
                "daffodil", "edelweiss", "gerbera_daisy", "green_chrysanthemum",
                "iris", "lavender", "open_blue_water_lily", "open_daybloom",
                "open_water_lily", "open_white_water_lily", "pink_carnation",
                "pink_daisy", "rapeseed_flower", "red_carnation", "red_spider_lily",
                "reed", "tall_rapeseed_flower", "white_carnation",
                "yellow_chrysanthemum"
        );

        MoreColorful.LOGGER.info("Registered compostable items");
    }


    private static void registerItems(CompostingChanceRegistry registry, float chance, String... itemIds) {
        for (String itemId : itemIds) {
            Item item = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, itemId));
            registry.add(item, chance);
        }
    }
}