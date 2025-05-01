package com.ChalkerCharles.morecolorful.common.worldgen;

import com.ChalkerCharles.morecolorful.common.worldgen.biomes.ModBiomes;
import com.ChalkerCharles.morecolorful.common.worldgen.placements.ModVegetationPlacements;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ModBiomeModifiers {
    public static final String ADD_FLOWER_CHERRY = "add_flower_cherry";
    public static final String PATCH_STRAWBERRY_BUSH = "patch_strawberry_bush";
    public static final String PATCH_BLUEBERRY_BUSH = "patch_blueberry_bush";
    public static final String PATCH_CROCUS = "patch_crocus";
    public static final String PATCH_WATER_GRASS = "patch_water_grass";
    public static final String PATCH_GERBERA_DAISY = "patch_gerbera_daisy";
    public static final String PATCH_CATTAIL = "patch_cattail";
    public static final String PATCH_REED = "patch_reed";
    public static final String PATCH_WATER_LILY = "patch_water_lily";
    public static final String PATCH_DUCKWEEDS = "patch_duckweeds";
    public static final String PATCH_BUTTERCUPS = "patch_buttercups";
    public static final String PATCH_FORGET_ME_NOTS = "patch_forget-me-nots";
    public static final String PATCH_SPEEDWELLS = "patch_speedwells";
    public static final String TREES_WILLOW = "trees_willow";
    public static final String PATCH_WOOD_SORRELS = "patch_wood_sorrels";

    public static final List<String> ADD_FEATURE_MODIFIERS = Arrays.asList(
            ADD_FLOWER_CHERRY,
            PATCH_STRAWBERRY_BUSH,
            PATCH_BLUEBERRY_BUSH,
            PATCH_CROCUS,
            PATCH_WATER_GRASS,
            PATCH_GERBERA_DAISY,
            PATCH_CATTAIL,
            PATCH_REED,
            PATCH_WATER_LILY,
            PATCH_DUCKWEEDS,
            PATCH_BUTTERCUPS,
            PATCH_FORGET_ME_NOTS,
            PATCH_SPEEDWELLS,
            TREES_WILLOW,
            PATCH_WOOD_SORRELS
    );

    public static void registerBiomeModifications() {
        addDecoration(
                ADD_FLOWER_CHERRY,
                ModVegetationPlacements.FLOWER_CHERRY,
                BiomeSelectors.includeByKey(Biomes.CHERRY_GROVE),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );

        addDecoration(
                PATCH_STRAWBERRY_BUSH,
                ModVegetationPlacements.PATCH_STRAWBERRY_BUSH,
                BiomeSelectors.includeByKey(Biomes.FOREST, Biomes.FLOWER_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );

        addDecoration(
                PATCH_BLUEBERRY_BUSH,
                ModVegetationPlacements.PATCH_BLUEBERRY_BUSH,
                BiomeSelectors.includeByKey(Biomes.PLAINS, Biomes.MEADOW),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );

        addDecoration(
                PATCH_CROCUS,
                ModVegetationPlacements.PATCH_CROCUS,
                BiomeSelectors.includeByKey(
                        Biomes.SNOWY_PLAINS,
                        Biomes.SNOWY_TAIGA,
                        Biomes.WINDSWEPT_FOREST,
                        ModBiomes.ICE_MARSH
                ),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );

        addDecoration(
                PATCH_WATER_GRASS,
                ModVegetationPlacements.PATCH_WATER_GRASS,
                BiomeSelectors.includeByKey(
                        Biomes.SWAMP,
                        Biomes.MANGROVE_SWAMP,
                        ModBiomes.DAWN_REDWOOD_SWAMP,
                        ModBiomes.WILLOW_BAYOU,
                        ModBiomes.ICE_MARSH
                ),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );

        addDecoration(
                PATCH_GERBERA_DAISY,
                ModVegetationPlacements.PATCH_GERBERA_DAISY,
                BiomeSelectors.includeByKey(
                        Biomes.SAVANNA,
                        Biomes.SAVANNA_PLATEAU,
                        Biomes.WINDSWEPT_SAVANNA
                ),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );

        addDecoration(
                PATCH_CATTAIL,
                ModVegetationPlacements.PATCH_CATTAIL,
                BiomeSelectors.includeByKey(
                        Biomes.RIVER,
                        Biomes.SWAMP,
                        ModBiomes.DAWN_REDWOOD_SWAMP,
                        ModBiomes.WILLOW_BAYOU,
                        ModBiomes.ICE_MARSH
                ),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );

        addDecoration(
                PATCH_REED,
                ModVegetationPlacements.PATCH_REED,
                BiomeSelectors.includeByKey(
                        Biomes.RIVER,
                        Biomes.SWAMP,
                        ModBiomes.DAWN_REDWOOD_SWAMP,
                        ModBiomes.WILLOW_BAYOU,
                        ModBiomes.ICE_MARSH
                ),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );

        addDecoration(
                PATCH_WATER_LILY,
                ModVegetationPlacements.PATCH_WATER_LILY,
                BiomeSelectors.includeByKey(
                        Biomes.SWAMP,
                        Biomes.MANGROVE_SWAMP,
                        ModBiomes.WILLOW_BAYOU
                ),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );

        addDecoration(
                PATCH_DUCKWEEDS,
                ModVegetationPlacements.PATCH_DUCKWEEDS,
                BiomeSelectors.includeByKey(
                        Biomes.SWAMP,
                        Biomes.MANGROVE_SWAMP,
                        ModBiomes.DAWN_REDWOOD_SWAMP,
                        ModBiomes.MARSH,
                        ModBiomes.WILLOW_BAYOU
                ),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );

        addDecoration(
                PATCH_BUTTERCUPS,
                ModVegetationPlacements.PATCH_BUTTERCUPS,
                BiomeSelectors.includeByKey(
                        Biomes.SWAMP,
                        ModBiomes.MARSH,
                        ModBiomes.WILLOW_BAYOU
                ),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );

        addDecoration(
                PATCH_FORGET_ME_NOTS,
                ModVegetationPlacements.PATCH_FORGET_ME_NOTS,
                BiomeSelectors.includeByKey(
                        Biomes.MEADOW,
                        Biomes.FLOWER_FOREST,
                        Biomes.OLD_GROWTH_BIRCH_FOREST
                ),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );

        addDecoration(
                PATCH_SPEEDWELLS,
                ModVegetationPlacements.PATCH_SPEEDWELLS,
                BiomeSelectors.includeByKey(
                        Biomes.FOREST,
                        Biomes.FLOWER_FOREST,
                        Biomes.BIRCH_FOREST
                ),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );

        addDecoration(
                TREES_WILLOW,
                ModVegetationPlacements.TREES_WILLOW,
                BiomeSelectors.includeByKey(
                        Biomes.RIVER,
                        Biomes.SWAMP,
                        ModBiomes.MARSH
                ),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );

        addDecoration(
                PATCH_WOOD_SORRELS,
                ModVegetationPlacements.PATCH_WOOD_SORRELS,
                BiomeSelectors.includeByKey(
                        Biomes.FOREST,
                        Biomes.FLOWER_FOREST,
                        Biomes.BIRCH_FOREST,
                        Biomes.OLD_GROWTH_BIRCH_FOREST,
                        Biomes.DARK_FOREST,
                        Biomes.PLAINS,
                        Biomes.MEADOW,
                        ModBiomes.AUTUMN_BIRCH_FOREST,
                        ModBiomes.GOLDEN_GROVE,
                        ModBiomes.SUNSET_VALLEY
                ),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );
    }

    private static void addDecoration(
            String name,
            ResourceKey<PlacedFeature> Decoration,
            Predicate<BiomeSelectionContext> selector,
            GenerationStep.Decoration step
    ) {
        BiomeModifications.addFeature(
                selector,
                step,
                Decoration
        );
    }

    @SafeVarargs
    private static Predicate<BiomeSelectionContext> includeByKey(ResourceKey<Biome>... biomes) {
        return BiomeSelectors.includeByKey(biomes);
    }
}