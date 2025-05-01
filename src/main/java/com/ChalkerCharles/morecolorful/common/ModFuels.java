package com.ChalkerCharles.morecolorful.common;

import com.ChalkerCharles.morecolorful.MoreColorful;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModFuels {
    public static void register() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        // 注册标签
        registerTag(registry, "leaf_litters", 50);

        // 注册单个物品 - 100 tick
        registerItems(registry, 100, "dawn_redwood_roots");

        // 注册单个物品 - 200 tick
        registerItems(registry, 200,
                "banjo", "bass", "cello", "didgeridoo", "drumstick",
                "erhu", "fiddle_bow", "flute", "guitar", "pipa", "violin"
        );

        // 注册单个物品 - 300 tick
        registerItems(registry, 300,
                "bass_drum", "guzheng", "tom-tom_drum", "xylophone"
        );

        MoreColorful.LOGGER.info("Registered fuel items");
    }

    private static void registerTag(FuelRegistry registry, String tagName, int burnTime) {
        TagKey<Item> tag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, tagName));
        registry.add(tag, burnTime);
    }

    private static void registerItems(FuelRegistry registry, int burnTime, String... itemIds) {
        for (String itemId : itemIds) {
            Item item = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, itemId));
            registry.add(item, burnTime);
        }
    }
}