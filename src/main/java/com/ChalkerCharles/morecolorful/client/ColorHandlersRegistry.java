package com.ChalkerCharles.morecolorful.client;

import com.ChalkerCharles.morecolorful.common.block.ModBlocks;
import com.ChalkerCharles.morecolorful.common.block.common.ReedBlock;
import com.ChalkerCharles.morecolorful.common.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.awt.*;

@Environment(EnvType.CLIENT)
public class ColorHandlersRegistry {

    public static void init() {
        registerBlockColors();
        registerItemColors();
    }

    private static void registerBlockColors() {
        ColorProviderRegistry.BLOCK.register((pState, pLevel, pPos, pTintIndex) -> {
                    if (pTintIndex != 0) {
                        return pLevel != null && pPos != null ? BiomeColors.getAverageGrassColor(pLevel, pPos) : GrassColor.getDefaultColor();
                    } else {
                        return -1;
                    }
                },
                ModBlocks.BEGONIAS,
                ModBlocks.WHITE_PETALS,
                ModBlocks.FROSTY_PETALS,
                ModBlocks.VIOLETS,
                ModBlocks.BUTTERCUPS,
                ModBlocks.FORGET_ME_NOTS,
                ModBlocks.BABY_BLUE_EYES,
                ModBlocks.SPEEDWELLS,
                ModBlocks.WOOD_SORRELS
        );

        ColorProviderRegistry.BLOCK.register((pState, pLevel, pPos, pTintIndex) ->
                        pLevel != null && pPos != null
                                ? BiomeColors.getAverageGrassColor(pLevel, pPos)
                                : GrassColor.getDefaultColor(),
                ModBlocks.DUCKWEEDS
        );

        ColorProviderRegistry.BLOCK.register((pState, pLevel, pPos, pTintIndex) ->
                        pLevel != null && pPos != null
                                ? BiomeColors.getAverageGrassColor(
                                pLevel, pState.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.LOWER ? pPos : pPos.below())
                                : GrassColor.getDefaultColor(),
                ModBlocks.SHORT_WATER_GRASS,
                ModBlocks.TALL_WATER_GRASS
        );

        ColorProviderRegistry.BLOCK.register((pState, pLevel, pPos, pTintIndex) -> {
            if (pTintIndex == 0) {
                return pLevel != null && pPos != null
                        ? BiomeColors.getAverageGrassColor(pLevel, ReedBlock.getBottomPos(pPos, pState))
                        : GrassColor.getDefaultColor();
            } else {
                return pLevel != null && pPos != null ? getReedColor(pLevel, pPos) : 0xe8e8e1;
            }
        }, ModBlocks.REED);

        ColorProviderRegistry.BLOCK.register((pState, pLevel, pPos, pTintIndex) ->
                        pLevel != null && pPos != null
                                ? BiomeColors.getAverageFoliageColor(pLevel, pPos)
                                : FoliageColor.getDefaultColor(),
                ModBlocks.WILLOW_LEAVES,
                ModBlocks.WILLOW_BRANCHES
        );
    }

    private static void registerItemColors() {
        ColorProviderRegistry.ITEM.register((pStack, pTintIndex) -> 0x7cbd6b,
                ModItems.SHORT_WATER_GRASS,
                ModItems.TALL_WATER_GRASS
        );

        ColorProviderRegistry.ITEM.register((pStack, pTintIndex) -> 0x71c35c,
                ModItems.DUCKWEEDS
        );

        ColorProviderRegistry.ITEM.register((pStack, pTintIndex) -> 0x64b34f,
                ModItems.WILLOW_LEAVES,
                ModItems.WILLOW_BRANCHES
        );
    }

    private static int getReedColor(BlockAndTintGetter pLevel, BlockPos pPos) {
        Color color = new Color(BiomeColors.getAverageGrassColor(pLevel, pPos));
        float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        float hue = hsb[0];
        Color newColor = Color.getHSBColor((hue + 64) / 2, 0.1F, 0.85F);
        return newColor.getRGB();
    }
}