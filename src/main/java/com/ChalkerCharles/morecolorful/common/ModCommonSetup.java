package com.ChalkerCharles.morecolorful.common;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.block.ModBlocks;
import com.ChalkerCharles.morecolorful.util.BlockEntityTypeHelper;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.HashMap;
import java.util.Map;

public final class ModCommonSetup {
    
    public static void init() {
        setStrippedWoodBlocks();
        addFlowerPotBlocks();
        setFlammableBlocks();
        addBlockEntity();
    }
    
    public static void setStrippedWoodBlocks() {
        HashMap<Block, Block> strippables = new HashMap<>(AxeItem.STRIPPABLES);
        strippables.put(ModBlocks.CRABAPPLE_LOG, ModBlocks.STRIPPED_CRABAPPLE_LOG);
        strippables.put(ModBlocks.CRABAPPLE_WOOD, ModBlocks.STRIPPED_CRABAPPLE_WOOD);
        strippables.put(ModBlocks.EBONY_LOG, ModBlocks.STRIPPED_EBONY_LOG);
        strippables.put(ModBlocks.EBONY_WOOD, ModBlocks.STRIPPED_EBONY_WOOD);
        strippables.put(ModBlocks.GINKGO_LOG, ModBlocks.STRIPPED_GINKGO_LOG);
        strippables.put(ModBlocks.GINKGO_WOOD, ModBlocks.STRIPPED_GINKGO_WOOD);
        strippables.put(ModBlocks.MAPLE_LOG, ModBlocks.STRIPPED_MAPLE_LOG);
        strippables.put(ModBlocks.MAPLE_WOOD, ModBlocks.STRIPPED_MAPLE_WOOD);
        strippables.put(ModBlocks.FROST_LOG, ModBlocks.STRIPPED_FROST_LOG);
        strippables.put(ModBlocks.FROST_WOOD, ModBlocks.STRIPPED_FROST_WOOD);
        strippables.put(ModBlocks.DAWN_REDWOOD_LOG, ModBlocks.STRIPPED_DAWN_REDWOOD_LOG);
        strippables.put(ModBlocks.DAWN_REDWOOD_WOOD, ModBlocks.STRIPPED_DAWN_REDWOOD_WOOD);
        strippables.put(ModBlocks.JACARANDA_LOG, ModBlocks.STRIPPED_JACARANDA_LOG);
        strippables.put(ModBlocks.JACARANDA_WOOD, ModBlocks.STRIPPED_JACARANDA_WOOD);
        strippables.put(ModBlocks.WILLOW_LOG, ModBlocks.STRIPPED_WILLOW_LOG);
        strippables.put(ModBlocks.WILLOW_WOOD, ModBlocks.STRIPPED_WILLOW_WOOD);

        AxeItem.STRIPPABLES = strippables;
    }



        public static void addFlowerPotBlocks() {
                // 获取原版花盆方块
                FlowerPotBlock pot = (FlowerPotBlock) Blocks.FLOWER_POT;

                // 使用反射获取 POTTED_BY_CONTENT 字段并修改它
                try {
                        // 获取 POTTED_BY_CONTENT 字段
                        java.lang.reflect.Field field = FlowerPotBlock.class.getDeclaredField("POTTED_BY_CONTENT");
                        field.setAccessible(true);

                        // 获取当前映射
                        @SuppressWarnings("unchecked")
                        Map<Block, Block> pottedByContent = (Map<Block, Block>) field.get(null);

                        // 如果映射是不可变的，创建一个新的可变映射
                        if (!(pottedByContent instanceof HashMap)) {
                                pottedByContent = new HashMap<>(pottedByContent);
                                field.set(null, pottedByContent);
                        }

                        // 添加我们的花盆映射
                        registerPottedPlant(pottedByContent, ModBlocks.CRABAPPLE_SAPLING, ModBlocks.POTTED_CRABAPPLE_SAPLING);
                        registerPottedPlant(pottedByContent, ModBlocks.WHITE_CHERRY_SAPLING, ModBlocks.POTTED_WHITE_CHERRY_SAPLING);
                        registerPottedPlant(pottedByContent, ModBlocks.ORANGE_BIRCH_SAPLING, ModBlocks.POTTED_ORANGE_BIRCH_SAPLING);
                        registerPottedPlant(pottedByContent, ModBlocks.YELLOW_BIRCH_SAPLING, ModBlocks.POTTED_YELLOW_BIRCH_SAPLING);
                        registerPottedPlant(pottedByContent, ModBlocks.GINKGO_SAPLING, ModBlocks.POTTED_GINKGO_SAPLING);
                        registerPottedPlant(pottedByContent, ModBlocks.MAPLE_SAPLING, ModBlocks.POTTED_MAPLE_SAPLING);
                        registerPottedPlant(pottedByContent, ModBlocks.FROST_SAPLING, ModBlocks.POTTED_FROST_SAPLING);
                        registerPottedPlant(pottedByContent, ModBlocks.DAWN_REDWOOD_SAPLING, ModBlocks.POTTED_DAWN_REDWOOD_SAPLING);
                        registerPottedPlant(pottedByContent, ModBlocks.JACARANDA_SAPLING, ModBlocks.POTTED_JACARANDA_SAPLING);
                        registerPottedPlant(pottedByContent, ModBlocks.WILLOW_SAPLING, ModBlocks.POTTED_WILLOW_SAPLING);
                        registerPottedPlant(pottedByContent, ModBlocks.PINK_DAISY, ModBlocks.POTTED_PINK_DAISY);
                        registerPottedPlant(pottedByContent, ModBlocks.RED_CARNATION, ModBlocks.POTTED_RED_CARNATION);
                        registerPottedPlant(pottedByContent, ModBlocks.PINK_CARNATION, ModBlocks.POTTED_PINK_CARNATION);
                        registerPottedPlant(pottedByContent, ModBlocks.WHITE_CARNATION, ModBlocks.POTTED_WHITE_CARNATION);
                        registerPottedPlant(pottedByContent, ModBlocks.RED_SPIDER_LILY, ModBlocks.POTTED_RED_SPIDER_LILY);
                        registerPottedPlant(pottedByContent, ModBlocks.YELLOW_CHRYSANTHEMUM, ModBlocks.POTTED_YELLOW_CHRYSANTHEMUM);
                        registerPottedPlant(pottedByContent, ModBlocks.GREEN_CHRYSANTHEMUM, ModBlocks.POTTED_GREEN_CHRYSANTHEMUM);
                        registerPottedPlant(pottedByContent, ModBlocks.OPEN_DAYBLOOM, ModBlocks.POTTED_OPEN_DAYBLOOM);
                        registerPottedPlant(pottedByContent, ModBlocks.CLOSED_DAYBLOOM, ModBlocks.POTTED_CLOSED_DAYBLOOM);
                        registerPottedPlant(pottedByContent, ModBlocks.EDELWEISS, ModBlocks.POTTED_EDELWEISS);
                        registerPottedPlant(pottedByContent, ModBlocks.CROCUS, ModBlocks.POTTED_CROCUS);
                        registerPottedPlant(pottedByContent, ModBlocks.IRIS, ModBlocks.POTTED_IRIS);
                        registerPottedPlant(pottedByContent, ModBlocks.LAVENDER, ModBlocks.POTTED_LAVENDER);
                        registerPottedPlant(pottedByContent, ModBlocks.DAFFODIL, ModBlocks.POTTED_DAFFODIL);
                        registerPottedPlant(pottedByContent, ModBlocks.GERBERA_DAISY, ModBlocks.POTTED_GERBERA_DAISY);
                        registerPottedPlant(pottedByContent, ModBlocks.RAPESEED_FLOWER, ModBlocks.POTTED_RAPESEED_FLOWER);

                } catch (Exception e) {
                        MoreColorful.LOGGER.error("无法注册花盆方块: {}", e.getMessage());
                        MoreColorful.LOGGER.error("异常详情:", e);
                }
        }

        private static void registerPottedPlant(Map<Block, Block> pottedByContent, Block plant, Block pottedPlant) {
                pottedByContent.put(plant, pottedPlant);
        }



    public static void setFlammableBlocks() {
            FireBlock fireblock = (FireBlock) Blocks.FIRE;
            fireblock.setFlammable(ModBlocks.CRABAPPLE_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.CRABAPPLE_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_CRABAPPLE_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_CRABAPPLE_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.CRABAPPLE_PLANKS, 5, 20);
            fireblock.setFlammable(ModBlocks.CRABAPPLE_STAIRS, 5, 20);
            fireblock.setFlammable(ModBlocks.CRABAPPLE_SLAB, 5, 20);
            fireblock.setFlammable(ModBlocks.CRABAPPLE_FENCE, 5, 20);
            fireblock.setFlammable(ModBlocks.CRABAPPLE_FENCE_GATE, 5, 20);

            fireblock.setFlammable(ModBlocks.EBONY_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.EBONY_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_EBONY_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_EBONY_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.EBONY_PLANKS, 5, 20);
            fireblock.setFlammable(ModBlocks.EBONY_STAIRS, 5, 20);
            fireblock.setFlammable(ModBlocks.EBONY_SLAB, 5, 20);
            fireblock.setFlammable(ModBlocks.EBONY_FENCE, 5, 20);
            fireblock.setFlammable(ModBlocks.EBONY_FENCE_GATE, 5, 20);

            fireblock.setFlammable(ModBlocks.GINKGO_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.GINKGO_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_GINKGO_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_GINKGO_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.GINKGO_PLANKS, 5, 20);
            fireblock.setFlammable(ModBlocks.GINKGO_STAIRS, 5, 20);
            fireblock.setFlammable(ModBlocks.GINKGO_SLAB, 5, 20);
            fireblock.setFlammable(ModBlocks.GINKGO_FENCE, 5, 20);
            fireblock.setFlammable(ModBlocks.GINKGO_FENCE_GATE, 5, 20);

            fireblock.setFlammable(ModBlocks.MAPLE_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.MAPLE_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_MAPLE_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_MAPLE_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.MAPLE_PLANKS, 5, 20);
            fireblock.setFlammable(ModBlocks.MAPLE_STAIRS, 5, 20);
            fireblock.setFlammable(ModBlocks.MAPLE_SLAB, 5, 20);
            fireblock.setFlammable(ModBlocks.MAPLE_FENCE, 5, 20);
            fireblock.setFlammable(ModBlocks.MAPLE_FENCE_GATE, 5, 20);

            fireblock.setFlammable(ModBlocks.FROST_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.FROST_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_FROST_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_FROST_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.FROST_PLANKS, 5, 20);
            fireblock.setFlammable(ModBlocks.FROST_STAIRS, 5, 20);
            fireblock.setFlammable(ModBlocks.FROST_SLAB, 5, 20);
            fireblock.setFlammable(ModBlocks.FROST_FENCE, 5, 20);
            fireblock.setFlammable(ModBlocks.FROST_FENCE_GATE, 5, 20);

            fireblock.setFlammable(ModBlocks.DAWN_REDWOOD_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.DAWN_REDWOOD_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_DAWN_REDWOOD_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_DAWN_REDWOOD_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.DAWN_REDWOOD_PLANKS, 5, 20);
            fireblock.setFlammable(ModBlocks.DAWN_REDWOOD_STAIRS, 5, 20);
            fireblock.setFlammable(ModBlocks.DAWN_REDWOOD_SLAB, 5, 20);
            fireblock.setFlammable(ModBlocks.DAWN_REDWOOD_FENCE, 5, 20);
            fireblock.setFlammable(ModBlocks.DAWN_REDWOOD_FENCE_GATE, 5, 20);
            fireblock.setFlammable(ModBlocks.DAWN_REDWOOD_ROOTS, 5, 20);

            fireblock.setFlammable(ModBlocks.JACARANDA_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.JACARANDA_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_JACARANDA_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_JACARANDA_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.JACARANDA_PLANKS, 5, 20);
            fireblock.setFlammable(ModBlocks.JACARANDA_STAIRS, 5, 20);
            fireblock.setFlammable(ModBlocks.JACARANDA_SLAB, 5, 20);
            fireblock.setFlammable(ModBlocks.JACARANDA_FENCE, 5, 20);
            fireblock.setFlammable(ModBlocks.JACARANDA_FENCE_GATE, 5, 20);

            fireblock.setFlammable(ModBlocks.WILLOW_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.WILLOW_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_WILLOW_LOG, 5, 5);
            fireblock.setFlammable(ModBlocks.STRIPPED_WILLOW_WOOD, 5, 5);
            fireblock.setFlammable(ModBlocks.WILLOW_PLANKS, 5, 20);
            fireblock.setFlammable(ModBlocks.WILLOW_STAIRS, 5, 20);
            fireblock.setFlammable(ModBlocks.WILLOW_SLAB, 5, 20);
            fireblock.setFlammable(ModBlocks.WILLOW_FENCE, 5, 20);
            fireblock.setFlammable(ModBlocks.WILLOW_FENCE_GATE, 5, 20);

            fireblock.setFlammable(ModBlocks.CRABAPPLE_LEAVES, 30, 60);
            fireblock.setFlammable(ModBlocks.BEGONIAS, 60, 100);
            fireblock.setFlammable(ModBlocks.WHITE_CHERRY_LEAVES, 30, 60);
            fireblock.setFlammable(ModBlocks.WHITE_PETALS, 60, 100);
            fireblock.setFlammable(ModBlocks.ORANGE_BIRCH_LEAVES, 30, 60);
            fireblock.setFlammable(ModBlocks.ORANGE_BIRCH_LEAF_LITTER, 60, 100);
            fireblock.setFlammable(ModBlocks.YELLOW_BIRCH_LEAVES, 30, 60);
            fireblock.setFlammable(ModBlocks.YELLOW_BIRCH_LEAF_LITTER, 60, 100);
            fireblock.setFlammable(ModBlocks.GINKGO_LEAVES, 30, 60);
            fireblock.setFlammable(ModBlocks.GINKGO_LEAF_LITTER, 60, 100);
            fireblock.setFlammable(ModBlocks.MAPLE_LEAVES, 30, 60);
            fireblock.setFlammable(ModBlocks.MAPLE_LEAF_LITTER, 60, 100);
            fireblock.setFlammable(ModBlocks.FROST_LEAVES, 30, 60);
            fireblock.setFlammable(ModBlocks.FROSTY_PETALS, 60, 100);
            fireblock.setFlammable(ModBlocks.DAWN_REDWOOD_LEAVES, 30, 60);
            fireblock.setFlammable(ModBlocks.DAWN_REDWOOD_LEAF_LITTER, 60, 100);
            fireblock.setFlammable(ModBlocks.JACARANDA_LEAVES, 30, 60);
            fireblock.setFlammable(ModBlocks.VIOLETS, 60, 100);
            fireblock.setFlammable(ModBlocks.BUTTERCUPS, 60, 100);
            fireblock.setFlammable(ModBlocks.FORGET_ME_NOTS, 60, 100);
            fireblock.setFlammable(ModBlocks.BABY_BLUE_EYES, 60, 100);
            fireblock.setFlammable(ModBlocks.SPEEDWELLS, 60, 100);
            fireblock.setFlammable(ModBlocks.WOOD_SORRELS, 60, 100);
            fireblock.setFlammable(ModBlocks.WILLOW_LEAVES, 30, 60);
            fireblock.setFlammable(ModBlocks.WILLOW_BRANCHES, 15, 100);

            fireblock.setFlammable(ModBlocks.PINK_DAISY, 60, 100);
            fireblock.setFlammable(ModBlocks.RED_CARNATION, 60, 100);
            fireblock.setFlammable(ModBlocks.PINK_CARNATION, 60, 100);
            fireblock.setFlammable(ModBlocks.WHITE_CARNATION, 60, 100);
            fireblock.setFlammable(ModBlocks.RED_SPIDER_LILY, 60, 100);
            fireblock.setFlammable(ModBlocks.YELLOW_CHRYSANTHEMUM, 60, 100);
            fireblock.setFlammable(ModBlocks.GREEN_CHRYSANTHEMUM, 60, 100);
            fireblock.setFlammable(ModBlocks.OPEN_DAYBLOOM, 60, 100);
            fireblock.setFlammable(ModBlocks.CLOSED_DAYBLOOM, 60, 100);
            fireblock.setFlammable(ModBlocks.EDELWEISS, 60, 100);
            fireblock.setFlammable(ModBlocks.CROCUS, 60, 100);
            fireblock.setFlammable(ModBlocks.IRIS, 60, 100);
            fireblock.setFlammable(ModBlocks.LAVENDER, 60, 100);
            fireblock.setFlammable(ModBlocks.DAFFODIL, 60, 100);
            fireblock.setFlammable(ModBlocks.GERBERA_DAISY, 60, 100);
            fireblock.setFlammable(ModBlocks.RAPESEED_FLOWER, 60, 100);

            fireblock.setFlammable(ModBlocks.CATTAIL, 60, 100);
            fireblock.setFlammable(ModBlocks.TALL_RAPESEED_FLOWER, 60, 100);

            fireblock.setFlammable(ModBlocks.SHORT_WATER_GRASS, 60, 100);
            fireblock.setFlammable(ModBlocks.TALL_WATER_GRASS, 60, 100);
            fireblock.setFlammable(ModBlocks.REED, 60, 100);
            fireblock.setFlammable(ModBlocks.STRAWBERRY_BUSH, 60, 100);
            fireblock.setFlammable(ModBlocks.BLUEBERRY_BUSH, 60, 100);
    }


        public static void addBlockEntity() {
                BlockEntityTypeHelper.addValidBlocks(BlockEntityType.SIGN,
                        ModBlocks.CRABAPPLE_SIGN,
                        ModBlocks.CRABAPPLE_WALL_SIGN,
                        ModBlocks.EBONY_SIGN,
                        ModBlocks.EBONY_WALL_SIGN,
                        ModBlocks.GINKGO_SIGN,
                        ModBlocks.GINKGO_WALL_SIGN,
                        ModBlocks.MAPLE_SIGN,
                        ModBlocks.MAPLE_WALL_SIGN,
                        ModBlocks.FROST_SIGN,
                        ModBlocks.FROST_WALL_SIGN,
                        ModBlocks.DAWN_REDWOOD_SIGN,
                        ModBlocks.DAWN_REDWOOD_WALL_SIGN,
                        ModBlocks.JACARANDA_SIGN,
                        ModBlocks.JACARANDA_WALL_SIGN,
                        ModBlocks.WILLOW_SIGN,
                        ModBlocks.WILLOW_WALL_SIGN);

                BlockEntityTypeHelper.addValidBlocks(BlockEntityType.HANGING_SIGN,
                        ModBlocks.CRABAPPLE_HANGING_SIGN,
                        ModBlocks.CRABAPPLE_WALL_HANGING_SIGN,
                        ModBlocks.EBONY_HANGING_SIGN,
                        ModBlocks.EBONY_WALL_HANGING_SIGN,
                        ModBlocks.GINKGO_HANGING_SIGN,
                        ModBlocks.GINKGO_WALL_HANGING_SIGN,
                        ModBlocks.MAPLE_HANGING_SIGN,
                        ModBlocks.MAPLE_WALL_HANGING_SIGN,
                        ModBlocks.FROST_HANGING_SIGN,
                        ModBlocks.FROST_WALL_HANGING_SIGN,
                        ModBlocks.DAWN_REDWOOD_HANGING_SIGN,
                        ModBlocks.DAWN_REDWOOD_WALL_HANGING_SIGN,
                        ModBlocks.JACARANDA_HANGING_SIGN,
                        ModBlocks.JACARANDA_WALL_HANGING_SIGN,
                        ModBlocks.WILLOW_HANGING_SIGN,
                        ModBlocks.WILLOW_WALL_HANGING_SIGN);
        }
}
