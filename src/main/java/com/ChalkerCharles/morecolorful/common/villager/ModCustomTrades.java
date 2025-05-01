package com.ChalkerCharles.morecolorful.common.villager;

import com.ChalkerCharles.morecolorful.common.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;

public class ModCustomTrades {

    public static void registerTrades() {
        registerWandererTrades();
    }

    private static void registerWandererTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add(buy(ModItems.EBONY_LOG, 8, 1, 4, 1));

            factories.add(buy(ModItems.RED_CARNATION, 1, 1, 12, 1));
            factories.add(buy(ModItems.PINK_CARNATION, 1, 1, 12, 1));
            factories.add(buy(ModItems.PINK_DAISY, 1, 1, 12, 1));
            factories.add(buy(ModItems.WHITE_CARNATION, 1, 1, 12, 1));
            factories.add(buy(ModItems.RED_SPIDER_LILY, 1, 1, 12, 1));
            factories.add(buy(ModItems.YELLOW_CHRYSANTHEMUM, 1, 1, 12, 1));
            factories.add(buy(ModItems.GREEN_CHRYSANTHEMUM, 1, 1, 12, 1));
            factories.add(buy(ModItems.OPEN_DAYBLOOM, 1, 1, 12, 1));
            factories.add(buy(ModItems.EDELWEISS, 1, 1, 12, 1));
            factories.add(buy(ModItems.CROCUS, 1, 1, 12, 1));
            factories.add(buy(ModItems.IRIS, 1, 1, 12, 1));
            factories.add(buy(ModItems.LAVENDER, 1, 1, 12, 1));
            factories.add(buy(ModItems.DAFFODIL, 1, 1, 12, 1));
            factories.add(buy(ModItems.GERBERA_DAISY, 1, 1, 12, 1));
            factories.add(buy(ModItems.RAPESEED_FLOWER, 1, 1, 12, 1));

            factories.add(buy(ModItems.CRABAPPLE_SAPLING, 1, 5, 8, 1));
            factories.add(buy(ModItems.WHITE_CHERRY_SAPLING, 1, 5, 8, 1));
            factories.add(buy(ModItems.ORANGE_BIRCH_SAPLING, 1, 5, 8, 1));
            factories.add(buy(ModItems.YELLOW_BIRCH_SAPLING, 1, 5, 8, 1));
            factories.add(buy(ModItems.GINKGO_SAPLING, 1, 5, 8, 1));
            factories.add(buy(ModItems.MAPLE_SAPLING, 1, 5, 8, 1));
            factories.add(buy(ModItems.FROST_SAPLING, 1, 5, 8, 1));
            factories.add(buy(ModItems.DAWN_REDWOOD_SAPLING, 1, 5, 8, 1));
            factories.add(buy(ModItems.JACARANDA_SAPLING, 1, 5, 8, 1));
            factories.add(buy(ModItems.WILLOW_SAPLING, 1, 5, 8, 1));
        });
    }

    private static VillagerTrades.ItemListing sell(ItemLike item, int itemCount, int maxTrades, int xp) {
        return (entity, random) -> new MerchantOffer(
                new ItemCost(item, itemCount),
                new ItemStack(Items.EMERALD),
                maxTrades, xp, 0.05F);
    }

    private static VillagerTrades.ItemListing buy(ItemLike item, int itemCount, int emeralds, int maxTrades, int xp) {
        return (entity, random) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, emeralds),
                new ItemStack(item, itemCount),
                maxTrades, xp, 0.05F);
    }
}