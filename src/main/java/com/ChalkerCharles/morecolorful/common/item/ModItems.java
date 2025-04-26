package com.ChalkerCharles.morecolorful.common.item;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.block.ModBlocks;
import com.ChalkerCharles.morecolorful.common.item.common.DuckweedsItem;
import com.ChalkerCharles.morecolorful.common.item.musical_instruments.*;
import com.ChalkerCharles.morecolorful.util.EnumExtensions;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;

import java.util.function.Supplier;


public class ModItems {
    // Blocks
    public static final BlockItem HARP = fromBlock(ModBlocks.HARP);
    public static final BlockItem UPRIGHT_PIANO = fromBlock(ModBlocks.UPRIGHT_PIANO);
    public static final BlockItem GRAND_PIANO = fromBlock(ModBlocks.GRAND_PIANO);
    public static final BlockItem BASS_DRUM = fromBlock(ModBlocks.BASS_DRUM);
    public static final BlockItem SNARE_DRUM = fromBlock(ModBlocks.SNARE_DRUM);
    public static final BlockItem TOMTOM_DRUM = fromBlock(ModBlocks.TOMTOM_DRUM);
    public static final BlockItem HIHAT = fromBlock(ModBlocks.HIHAT);
    public static final BlockItem RIDE_CYMBAL = fromBlock(ModBlocks.RIDE_CYMBAL);
    public static final BlockItem CRASH_CYMBAL = fromBlock(ModBlocks.CRASH_CYMBAL);
    public static final BlockItem DRUM_SET = fromBlock(ModBlocks.DRUM_SET);
    public static final BlockItem CHIMES = fromBlock(ModBlocks.CHIMES);
    public static final BlockItem GLOCKENSPIEL = fromBlock(ModBlocks.GLOCKENSPIEL);
    public static final BlockItem XYLOPHONE = fromBlock(ModBlocks.XYLOPHONE);
    public static final BlockItem VIBRAPHONE = fromBlock(ModBlocks.VIBRAPHONE);
    public static final BlockItem SYNTHESIZER_KEYBOARD_BIT = registerSynthesizerKeyboard(ModBlocks.SYNTHESIZER_KEYBOARD_BIT);
    public static final BlockItem SYNTHESIZER_KEYBOARD_PLING = registerSynthesizerKeyboard(ModBlocks.SYNTHESIZER_KEYBOARD_PLING);
    public static final BlockItem SYNTHESIZER_KEYBOARD_SCULK = registerSynthesizerKeyboard(ModBlocks.SYNTHESIZER_KEYBOARD_SCULK);
    public static final BlockItem SYNTHESIZER_KEYBOARD_AMETHYST = registerSynthesizerKeyboard(ModBlocks.SYNTHESIZER_KEYBOARD_AMETHYST);
    public static final BlockItem SYNTHESIZER_KEYBOARD_SAW = registerSynthesizerKeyboard(ModBlocks.SYNTHESIZER_KEYBOARD_SAW);
    public static final BlockItem SYNTHESIZER_KEYBOARD_PLUCK = registerSynthesizerKeyboard(ModBlocks.SYNTHESIZER_KEYBOARD_PLUCK);
    public static final BlockItem SYNTHESIZER_KEYBOARD_SYNTH_BASS = registerSynthesizerKeyboard(ModBlocks.SYNTHESIZER_KEYBOARD_SYNTH_BASS);
    public static final BlockItem GUZHENG = fromBlock(ModBlocks.GUZHENG);

    public static final BlockItem CRABAPPLE_LOG = fromBlock(ModBlocks.CRABAPPLE_LOG);
    public static final BlockItem CRABAPPLE_WOOD = fromBlock(ModBlocks.CRABAPPLE_WOOD);
    public static final BlockItem STRIPPED_CRABAPPLE_LOG = fromBlock(ModBlocks.STRIPPED_CRABAPPLE_LOG);
    public static final BlockItem STRIPPED_CRABAPPLE_WOOD = fromBlock(ModBlocks.STRIPPED_CRABAPPLE_WOOD);
    public static final BlockItem CRABAPPLE_PLANKS = fromBlock(ModBlocks.CRABAPPLE_PLANKS);
    public static final BlockItem CRABAPPLE_STAIRS = fromBlock(ModBlocks.CRABAPPLE_STAIRS);
    public static final BlockItem CRABAPPLE_SLAB = fromBlock(ModBlocks.CRABAPPLE_SLAB);
    public static final BlockItem CRABAPPLE_FENCE = fromBlock(ModBlocks.CRABAPPLE_FENCE);
    public static final BlockItem CRABAPPLE_FENCE_GATE = fromBlock(ModBlocks.CRABAPPLE_FENCE_GATE);
    public static final BlockItem CRABAPPLE_DOOR = fromBlock(ModBlocks.CRABAPPLE_DOOR);
    public static final BlockItem CRABAPPLE_TRAPDOOR = fromBlock(ModBlocks.CRABAPPLE_TRAPDOOR);
    public static final BlockItem CRABAPPLE_PRESSURE_PLATE = fromBlock(ModBlocks.CRABAPPLE_PRESSURE_PLATE);
    public static final BlockItem CRABAPPLE_BUTTON = fromBlock(ModBlocks.CRABAPPLE_BUTTON);
    public static final BlockItem CRABAPPLE_SIGN = registerSign(ModBlocks.CRABAPPLE_SIGN, ModBlocks.CRABAPPLE_WALL_SIGN);
    public static final BlockItem CRABAPPLE_HANGING_SIGN = registerHangingSign(ModBlocks.CRABAPPLE_HANGING_SIGN, ModBlocks.CRABAPPLE_WALL_HANGING_SIGN);
    public static final BlockItem EBONY_LOG = fromBlock(ModBlocks.EBONY_LOG);
    public static final BlockItem EBONY_WOOD = fromBlock(ModBlocks.EBONY_WOOD);
    public static final BlockItem STRIPPED_EBONY_LOG = fromBlock(ModBlocks.STRIPPED_EBONY_LOG);
    public static final BlockItem STRIPPED_EBONY_WOOD = fromBlock(ModBlocks.STRIPPED_EBONY_WOOD);
    public static final BlockItem EBONY_PLANKS = fromBlock(ModBlocks.EBONY_PLANKS);
    public static final BlockItem EBONY_STAIRS = fromBlock(ModBlocks.EBONY_STAIRS);
    public static final BlockItem EBONY_SLAB = fromBlock(ModBlocks.EBONY_SLAB);
    public static final BlockItem EBONY_FENCE = fromBlock(ModBlocks.EBONY_FENCE);
    public static final BlockItem EBONY_FENCE_GATE = fromBlock(ModBlocks.EBONY_FENCE_GATE);
    public static final BlockItem EBONY_DOOR = fromBlock(ModBlocks.EBONY_DOOR);
    public static final BlockItem EBONY_TRAPDOOR = fromBlock(ModBlocks.EBONY_TRAPDOOR);
    public static final BlockItem EBONY_PRESSURE_PLATE = fromBlock(ModBlocks.EBONY_PRESSURE_PLATE);
    public static final BlockItem EBONY_BUTTON = fromBlock(ModBlocks.EBONY_BUTTON);
    public static final BlockItem EBONY_SIGN = registerSign(ModBlocks.EBONY_SIGN, ModBlocks.EBONY_WALL_SIGN);
    public static final BlockItem EBONY_HANGING_SIGN = registerHangingSign(ModBlocks.EBONY_HANGING_SIGN, ModBlocks.EBONY_WALL_HANGING_SIGN);
    public static final BlockItem GINKGO_LOG = fromBlock(ModBlocks.GINKGO_LOG);
    public static final BlockItem GINKGO_WOOD = fromBlock(ModBlocks.GINKGO_WOOD);
    public static final BlockItem STRIPPED_GINKGO_LOG = fromBlock(ModBlocks.STRIPPED_GINKGO_LOG);
    public static final BlockItem STRIPPED_GINKGO_WOOD = fromBlock(ModBlocks.STRIPPED_GINKGO_WOOD);
    public static final BlockItem GINKGO_PLANKS = fromBlock(ModBlocks.GINKGO_PLANKS);
    public static final BlockItem GINKGO_STAIRS = fromBlock(ModBlocks.GINKGO_STAIRS);
    public static final BlockItem GINKGO_SLAB = fromBlock(ModBlocks.GINKGO_SLAB);
    public static final BlockItem GINKGO_FENCE = fromBlock(ModBlocks.GINKGO_FENCE);
    public static final BlockItem GINKGO_FENCE_GATE = fromBlock(ModBlocks.GINKGO_FENCE_GATE);
    public static final BlockItem GINKGO_DOOR = fromBlock(ModBlocks.GINKGO_DOOR);
    public static final BlockItem GINKGO_TRAPDOOR = fromBlock(ModBlocks.GINKGO_TRAPDOOR);
    public static final BlockItem GINKGO_PRESSURE_PLATE = fromBlock(ModBlocks.GINKGO_PRESSURE_PLATE);
    public static final BlockItem GINKGO_BUTTON = fromBlock(ModBlocks.GINKGO_BUTTON);
    public static final BlockItem GINKGO_SIGN = registerSign(ModBlocks.GINKGO_SIGN, ModBlocks.GINKGO_WALL_SIGN);
    public static final BlockItem GINKGO_HANGING_SIGN = registerHangingSign(ModBlocks.GINKGO_HANGING_SIGN, ModBlocks.GINKGO_WALL_HANGING_SIGN);
    public static final BlockItem MAPLE_LOG = fromBlock(ModBlocks.MAPLE_LOG);
    public static final BlockItem MAPLE_WOOD = fromBlock(ModBlocks.MAPLE_WOOD);
    public static final BlockItem STRIPPED_MAPLE_LOG = fromBlock(ModBlocks.STRIPPED_MAPLE_LOG);
    public static final BlockItem STRIPPED_MAPLE_WOOD = fromBlock(ModBlocks.STRIPPED_MAPLE_WOOD);
    public static final BlockItem MAPLE_PLANKS = fromBlock(ModBlocks.MAPLE_PLANKS);
    public static final BlockItem MAPLE_STAIRS = fromBlock(ModBlocks.MAPLE_STAIRS);
    public static final BlockItem MAPLE_SLAB = fromBlock(ModBlocks.MAPLE_SLAB);
    public static final BlockItem MAPLE_FENCE = fromBlock(ModBlocks.MAPLE_FENCE);
    public static final BlockItem MAPLE_FENCE_GATE = fromBlock(ModBlocks.MAPLE_FENCE_GATE);
    public static final BlockItem MAPLE_DOOR = fromBlock(ModBlocks.MAPLE_DOOR);
    public static final BlockItem MAPLE_TRAPDOOR = fromBlock(ModBlocks.MAPLE_TRAPDOOR);
    public static final BlockItem MAPLE_PRESSURE_PLATE = fromBlock(ModBlocks.MAPLE_PRESSURE_PLATE);
    public static final BlockItem MAPLE_BUTTON = fromBlock(ModBlocks.MAPLE_BUTTON);
    public static final BlockItem MAPLE_SIGN = registerSign(ModBlocks.MAPLE_SIGN, ModBlocks.MAPLE_WALL_SIGN);
    public static final BlockItem MAPLE_HANGING_SIGN = registerHangingSign(ModBlocks.MAPLE_HANGING_SIGN, ModBlocks.MAPLE_WALL_HANGING_SIGN);
    public static final BlockItem FROST_LOG = fromBlock(ModBlocks.FROST_LOG);
    public static final BlockItem FROST_WOOD = fromBlock(ModBlocks.FROST_WOOD);
    public static final BlockItem STRIPPED_FROST_LOG = fromBlock(ModBlocks.STRIPPED_FROST_LOG);
    public static final BlockItem STRIPPED_FROST_WOOD = fromBlock(ModBlocks.STRIPPED_FROST_WOOD);
    public static final BlockItem FROST_PLANKS = fromBlock(ModBlocks.FROST_PLANKS);
    public static final BlockItem FROST_STAIRS = fromBlock(ModBlocks.FROST_STAIRS);
    public static final BlockItem FROST_SLAB = fromBlock(ModBlocks.FROST_SLAB);
    public static final BlockItem FROST_FENCE = fromBlock(ModBlocks.FROST_FENCE);
    public static final BlockItem FROST_FENCE_GATE = fromBlock(ModBlocks.FROST_FENCE_GATE);
    public static final BlockItem FROST_DOOR = fromBlock(ModBlocks.FROST_DOOR);
    public static final BlockItem FROST_TRAPDOOR = fromBlock(ModBlocks.FROST_TRAPDOOR);
    public static final BlockItem FROST_PRESSURE_PLATE = fromBlock(ModBlocks.FROST_PRESSURE_PLATE);
    public static final BlockItem FROST_BUTTON = fromBlock(ModBlocks.FROST_BUTTON);
    public static final BlockItem FROST_SIGN = registerSign(ModBlocks.FROST_SIGN, ModBlocks.FROST_WALL_SIGN);
    public static final BlockItem FROST_HANGING_SIGN = registerHangingSign(ModBlocks.FROST_HANGING_SIGN, ModBlocks.FROST_WALL_HANGING_SIGN);
    public static final BlockItem DAWN_REDWOOD_LOG = fromBlock(ModBlocks.DAWN_REDWOOD_LOG);
    public static final BlockItem DAWN_REDWOOD_WOOD = fromBlock(ModBlocks.DAWN_REDWOOD_WOOD);
    public static final BlockItem STRIPPED_DAWN_REDWOOD_LOG = fromBlock(ModBlocks.STRIPPED_DAWN_REDWOOD_LOG);
    public static final BlockItem STRIPPED_DAWN_REDWOOD_WOOD = fromBlock(ModBlocks.STRIPPED_DAWN_REDWOOD_WOOD);
    public static final BlockItem DAWN_REDWOOD_PLANKS = fromBlock(ModBlocks.DAWN_REDWOOD_PLANKS);
    public static final BlockItem DAWN_REDWOOD_STAIRS = fromBlock(ModBlocks.DAWN_REDWOOD_STAIRS);
    public static final BlockItem DAWN_REDWOOD_SLAB = fromBlock(ModBlocks.DAWN_REDWOOD_SLAB);
    public static final BlockItem DAWN_REDWOOD_FENCE = fromBlock(ModBlocks.DAWN_REDWOOD_FENCE);
    public static final BlockItem DAWN_REDWOOD_FENCE_GATE = fromBlock(ModBlocks.DAWN_REDWOOD_FENCE_GATE);
    public static final BlockItem DAWN_REDWOOD_DOOR = fromBlock(ModBlocks.DAWN_REDWOOD_DOOR);
    public static final BlockItem DAWN_REDWOOD_TRAPDOOR = fromBlock(ModBlocks.DAWN_REDWOOD_TRAPDOOR);
    public static final BlockItem DAWN_REDWOOD_PRESSURE_PLATE = fromBlock(ModBlocks.DAWN_REDWOOD_PRESSURE_PLATE);
    public static final BlockItem DAWN_REDWOOD_BUTTON = fromBlock(ModBlocks.DAWN_REDWOOD_BUTTON);
    public static final BlockItem DAWN_REDWOOD_SIGN = registerSign(ModBlocks.DAWN_REDWOOD_SIGN, ModBlocks.DAWN_REDWOOD_WALL_SIGN);
    public static final BlockItem DAWN_REDWOOD_HANGING_SIGN = registerHangingSign(ModBlocks.DAWN_REDWOOD_HANGING_SIGN, ModBlocks.DAWN_REDWOOD_WALL_HANGING_SIGN);
    public static final BlockItem JACARANDA_LOG = fromBlock(ModBlocks.JACARANDA_LOG);
    public static final BlockItem JACARANDA_WOOD = fromBlock(ModBlocks.JACARANDA_WOOD);
    public static final BlockItem STRIPPED_JACARANDA_LOG = fromBlock(ModBlocks.STRIPPED_JACARANDA_LOG);
    public static final BlockItem STRIPPED_JACARANDA_WOOD = fromBlock(ModBlocks.STRIPPED_JACARANDA_WOOD);
    public static final BlockItem JACARANDA_PLANKS = fromBlock(ModBlocks.JACARANDA_PLANKS);
    public static final BlockItem JACARANDA_STAIRS = fromBlock(ModBlocks.JACARANDA_STAIRS);
    public static final BlockItem JACARANDA_SLAB = fromBlock(ModBlocks.JACARANDA_SLAB);
    public static final BlockItem JACARANDA_FENCE = fromBlock(ModBlocks.JACARANDA_FENCE);
    public static final BlockItem JACARANDA_FENCE_GATE = fromBlock(ModBlocks.JACARANDA_FENCE_GATE);
    public static final BlockItem JACARANDA_DOOR = fromBlock(ModBlocks.JACARANDA_DOOR);
    public static final BlockItem JACARANDA_TRAPDOOR = fromBlock(ModBlocks.JACARANDA_TRAPDOOR);
    public static final BlockItem JACARANDA_PRESSURE_PLATE = fromBlock(ModBlocks.JACARANDA_PRESSURE_PLATE);
    public static final BlockItem JACARANDA_BUTTON = fromBlock(ModBlocks.JACARANDA_BUTTON);
    public static final BlockItem JACARANDA_SIGN = registerSign(ModBlocks.JACARANDA_SIGN, ModBlocks.JACARANDA_WALL_SIGN);
    public static final BlockItem JACARANDA_HANGING_SIGN = registerHangingSign(ModBlocks.JACARANDA_HANGING_SIGN, ModBlocks.JACARANDA_WALL_HANGING_SIGN);
    public static final BlockItem WILLOW_LOG = fromBlock(ModBlocks.WILLOW_LOG);
    public static final BlockItem WILLOW_WOOD = fromBlock(ModBlocks.WILLOW_WOOD);
    public static final BlockItem STRIPPED_WILLOW_LOG = fromBlock(ModBlocks.STRIPPED_WILLOW_LOG);
    public static final BlockItem STRIPPED_WILLOW_WOOD = fromBlock(ModBlocks.STRIPPED_WILLOW_WOOD);
    public static final BlockItem WILLOW_PLANKS = fromBlock(ModBlocks.WILLOW_PLANKS);
    public static final BlockItem WILLOW_STAIRS = fromBlock(ModBlocks.WILLOW_STAIRS);
    public static final BlockItem WILLOW_SLAB = fromBlock(ModBlocks.WILLOW_SLAB);
    public static final BlockItem WILLOW_FENCE = fromBlock(ModBlocks.WILLOW_FENCE);
    public static final BlockItem WILLOW_FENCE_GATE = fromBlock(ModBlocks.WILLOW_FENCE_GATE);
    public static final BlockItem WILLOW_DOOR = fromBlock(ModBlocks.WILLOW_DOOR);
    public static final BlockItem WILLOW_TRAPDOOR = fromBlock(ModBlocks.WILLOW_TRAPDOOR);
    public static final BlockItem WILLOW_PRESSURE_PLATE = fromBlock(ModBlocks.WILLOW_PRESSURE_PLATE);
    public static final BlockItem WILLOW_BUTTON = fromBlock(ModBlocks.WILLOW_BUTTON);
    public static final BlockItem WILLOW_SIGN = registerSign(ModBlocks.WILLOW_SIGN, ModBlocks.WILLOW_WALL_SIGN);
    public static final BlockItem WILLOW_HANGING_SIGN = registerHangingSign(ModBlocks.WILLOW_HANGING_SIGN, ModBlocks.WILLOW_WALL_HANGING_SIGN);

    public static final BlockItem CRABAPPLE_LEAVES = fromBlock(ModBlocks.CRABAPPLE_LEAVES);
    public static final BlockItem CRABAPPLE_SAPLING = fromBlock(ModBlocks.CRABAPPLE_SAPLING);
    public static final BlockItem BEGONIAS = fromBlock(ModBlocks.BEGONIAS);
    public static final BlockItem WHITE_CHERRY_LEAVES = fromBlock(ModBlocks.WHITE_CHERRY_LEAVES);
    public static final BlockItem WHITE_CHERRY_SAPLING = fromBlock(ModBlocks.WHITE_CHERRY_SAPLING);
    public static final BlockItem WHITE_PETALS = fromBlock(ModBlocks.WHITE_PETALS);
    public static final BlockItem ORANGE_BIRCH_LEAVES = fromBlock(ModBlocks.ORANGE_BIRCH_LEAVES);
    public static final BlockItem ORANGE_BIRCH_SAPLING = fromBlock(ModBlocks.ORANGE_BIRCH_SAPLING);
    public static final BlockItem ORANGE_BIRCH_LEAF_LITTER = fromBlock(ModBlocks.ORANGE_BIRCH_LEAF_LITTER);
    public static final BlockItem YELLOW_BIRCH_LEAVES = fromBlock(ModBlocks.YELLOW_BIRCH_LEAVES);
    public static final BlockItem YELLOW_BIRCH_SAPLING = fromBlock(ModBlocks.YELLOW_BIRCH_SAPLING);
    public static final BlockItem YELLOW_BIRCH_LEAF_LITTER = fromBlock(ModBlocks.YELLOW_BIRCH_LEAF_LITTER);
    public static final BlockItem GINKGO_LEAVES = fromBlock(ModBlocks.GINKGO_LEAVES);
    public static final BlockItem GINKGO_SAPLING = fromBlock(ModBlocks.GINKGO_SAPLING);
    public static final BlockItem GINKGO_LEAF_LITTER = fromBlock(ModBlocks.GINKGO_LEAF_LITTER);
    public static final BlockItem MAPLE_LEAVES = fromBlock(ModBlocks.MAPLE_LEAVES);
    public static final BlockItem MAPLE_SAPLING = fromBlock(ModBlocks.MAPLE_SAPLING);
    public static final BlockItem MAPLE_LEAF_LITTER = fromBlock(ModBlocks.MAPLE_LEAF_LITTER);
    public static final BlockItem FROST_LEAVES = fromBlock(ModBlocks.FROST_LEAVES);
    public static final BlockItem FROST_SAPLING = fromBlock(ModBlocks.FROST_SAPLING);
    public static final BlockItem FROSTY_PETALS = fromBlock(ModBlocks.FROSTY_PETALS);
    public static final BlockItem DAWN_REDWOOD_LEAVES = fromBlock(ModBlocks.DAWN_REDWOOD_LEAVES);
    public static final BlockItem DAWN_REDWOOD_SAPLING = fromBlock(ModBlocks.DAWN_REDWOOD_SAPLING);
    public static final BlockItem DAWN_REDWOOD_LEAF_LITTER = fromBlock(ModBlocks.DAWN_REDWOOD_LEAF_LITTER);
    public static final BlockItem DAWN_REDWOOD_ROOTS = fromBlock(ModBlocks.DAWN_REDWOOD_ROOTS);
    public static final BlockItem JACARANDA_LEAVES = fromBlock(ModBlocks.JACARANDA_LEAVES);
    public static final BlockItem JACARANDA_SAPLING = fromBlock(ModBlocks.JACARANDA_SAPLING);
    public static final BlockItem VIOLETS = fromBlock(ModBlocks.VIOLETS);
    public static final BlockItem BUTTERCUPS = fromBlock(ModBlocks.BUTTERCUPS);
    public static final BlockItem FORGET_ME_NOTS = fromBlock(ModBlocks.FORGET_ME_NOTS);
    public static final BlockItem BABY_BLUE_EYES = fromBlock(ModBlocks.BABY_BLUE_EYES);
    public static final BlockItem SPEEDWELLS = fromBlock(ModBlocks.SPEEDWELLS);
    public static final BlockItem WOOD_SORRELS = fromBlock(ModBlocks.WOOD_SORRELS);
    public static final BlockItem WILLOW_LEAVES = fromBlock(ModBlocks.WILLOW_LEAVES);
    public static final BlockItem WILLOW_SAPLING = fromBlock(ModBlocks.WILLOW_SAPLING);
    public static final BlockItem WILLOW_BRANCHES = fromBlock(ModBlocks.WILLOW_BRANCHES);

    public static final BlockItem PINK_DAISY = fromBlock(ModBlocks.PINK_DAISY);
    public static final BlockItem RED_CARNATION = fromBlock(ModBlocks.RED_CARNATION);
    public static final BlockItem PINK_CARNATION = fromBlock(ModBlocks.PINK_CARNATION);
    public static final BlockItem WHITE_CARNATION = fromBlock(ModBlocks.WHITE_CARNATION);
    public static final BlockItem RED_SPIDER_LILY = fromBlock(ModBlocks.RED_SPIDER_LILY);
    public static final BlockItem YELLOW_CHRYSANTHEMUM = fromBlock(ModBlocks.YELLOW_CHRYSANTHEMUM);
    public static final BlockItem GREEN_CHRYSANTHEMUM = fromBlock(ModBlocks.GREEN_CHRYSANTHEMUM);
    public static final BlockItem OPEN_DAYBLOOM = fromBlock(ModBlocks.OPEN_DAYBLOOM);
    public static final BlockItem CLOSED_DAYBLOOM = fromBlock(ModBlocks.CLOSED_DAYBLOOM);
    public static final BlockItem EDELWEISS = fromBlock(ModBlocks.EDELWEISS);
    public static final BlockItem CROCUS = fromBlock(ModBlocks.CROCUS);
    public static final BlockItem IRIS = fromBlock(ModBlocks.IRIS);
    public static final BlockItem LAVENDER = fromBlock(ModBlocks.LAVENDER);
    public static final BlockItem DAFFODIL = fromBlock(ModBlocks.DAFFODIL);
    public static final BlockItem GERBERA_DAISY = fromBlock(ModBlocks.GERBERA_DAISY);
    public static final BlockItem RAPESEED_FLOWER = fromBlock(ModBlocks.RAPESEED_FLOWER);

    public static final BlockItem CATTAIL = fromBlock(ModBlocks.CATTAIL);
    public static final BlockItem TALL_RAPESEED_FLOWER = fromBlock(ModBlocks.TALL_RAPESEED_FLOWER);

    public static final BlockItem SHORT_WATER_GRASS = fromBlock(ModBlocks.SHORT_WATER_GRASS);
    public static final BlockItem TALL_WATER_GRASS = fromBlock(ModBlocks.TALL_WATER_GRASS);
    public static final BlockItem REED = fromBlock(ModBlocks.REED);
    public static final BlockItem OPEN_WATER_LILY = registerPlaceOnWaterItem(ModBlocks.OPEN_WATER_LILY);
    public static final BlockItem OPEN_WHITE_WATER_LILY = registerPlaceOnWaterItem(ModBlocks.OPEN_WHITE_WATER_LILY);
    public static final BlockItem OPEN_BLUE_WATER_LILY = registerPlaceOnWaterItem(ModBlocks.OPEN_BLUE_WATER_LILY);
    public static final BlockItem CLOSED_WATER_LILY = registerPlaceOnWaterItem(ModBlocks.CLOSED_WATER_LILY);
    public static final BlockItem CLOSED_WHITE_WATER_LILY = registerPlaceOnWaterItem(ModBlocks.CLOSED_WHITE_WATER_LILY);
    public static final BlockItem CLOSED_BLUE_WATER_LILY = registerPlaceOnWaterItem(ModBlocks.CLOSED_BLUE_WATER_LILY);
    public static final BlockItem DUCKWEEDS = fromBlock(ModBlocks.DUCKWEEDS, () -> new DuckweedsItem(ModBlocks.DUCKWEEDS, new Item.Properties()));

    // Items
    public static final Item VIOLIN = registerItem("violin", new BowedStringInstrumentItem(InstrumentsType.VIOLIN, new Item.Properties().stacksTo(1)));
    public static final Item FIDDLE_BOW = registerItem("fiddle_bow", new Item(new Item.Properties().stacksTo(1)));
    public static final Item DRUMSTICK = registerItem("drumstick", new DrumstickItem(new Item.Properties()));
    public static final Item BASS = registerItem("bass", new GuitarItem(InstrumentsType.BASS, new Item.Properties().stacksTo(1)));
    public static final Item GUITAR = registerItem("guitar", new GuitarItem(InstrumentsType.GUITAR, new Item.Properties().stacksTo(1)));
    public static final Item FLUTE = registerItem("flute", new BothHandsInstrumentItem(InstrumentsType.FLUTE, new Item.Properties().stacksTo(1)));
    public static final Item COW_BELL = registerItem("cow_bell", new CowBellItem(InstrumentsType.COW_BELL, new Item.Properties().stacksTo(1)));
    public static final Item DIDGERIDOO = registerItem("didgeridoo", new DidgeridooItem(InstrumentsType.DIDGERIDOO, new Item.Properties().stacksTo(1)));
    public static final Item BANJO = registerItem("banjo", new GuitarItem(InstrumentsType.BANJO, new Item.Properties().stacksTo(1)));
    public static final Item CELLO = registerItem("cello", new BowedStringInstrumentItem(InstrumentsType.CELLO, new Item.Properties().stacksTo(1)));
    public static final Item ELECTRIC_GUITAR = registerItem("electric_guitar", new GuitarItem(InstrumentsType.ELECTRIC_GUITAR, new Item.Properties().stacksTo(1)));
    public static final Item TRUMPET = registerItem("trumpet", new TrumpetItem(InstrumentsType.TRUMPET, new Item.Properties().stacksTo(1)));
    public static final Item SAXOPHONE = registerItem("saxophone", new DidgeridooItem(InstrumentsType.SAXOPHONE, new Item.Properties().stacksTo(1)));
    public static final Item OCARINA = registerItem("ocarina", new DidgeridooItem(InstrumentsType.OCARINA, new Item.Properties().stacksTo(1)));
    public static final Item HARMONICA = registerItem("harmonica", new DidgeridooItem(InstrumentsType.HARMONICA, new Item.Properties().stacksTo(1)));
    public static final Item PIPA = registerItem("pipa", new BothHandsInstrumentItem(InstrumentsType.PIPA, new Item.Properties().stacksTo(1)));
    public static final Item ERHU = registerItem("erhu", new BowedStringInstrumentItem(InstrumentsType.ERHU, new Item.Properties().stacksTo(1)));

    public static final Item CRABAPPLE_BOAT = registerItem("crabapple_boat", new BoatItem(false, EnumExtensions.BoatType.CRABAPPLE, new Item.Properties().stacksTo(1)));
    public static final Item CRABAPPLE_CHEST_BOAT = registerItem("crabapple_chest_boat", new BoatItem(true, EnumExtensions.BoatType.CRABAPPLE, new Item.Properties().stacksTo(1)));
    public static final Item EBONY_BOAT = registerItem("ebony_boat", new BoatItem(false, EnumExtensions.BoatType.EBONY, new Item.Properties().stacksTo(1)));
    public static final Item EBONY_CHEST_BOAT = registerItem("ebony_chest_boat", new BoatItem(true, EnumExtensions.BoatType.EBONY, new Item.Properties().stacksTo(1)));
    public static final Item GINKGO_BOAT = registerItem("ginkgo_boat", new BoatItem(false, EnumExtensions.BoatType.GINKGO, new Item.Properties().stacksTo(1)));
    public static final Item GINKGO_CHEST_BOAT = registerItem("ginkgo_chest_boat", new BoatItem(true, EnumExtensions.BoatType.GINKGO, new Item.Properties().stacksTo(1)));
    public static final Item MAPLE_BOAT = registerItem("maple_boat", new BoatItem(false, EnumExtensions.BoatType.MAPLE, new Item.Properties().stacksTo(1)));
    public static final Item MAPLE_CHEST_BOAT = registerItem("maple_chest_boat", new BoatItem(true, EnumExtensions.BoatType.MAPLE, new Item.Properties().stacksTo(1)));
    public static final Item FROST_BOAT = registerItem("frost_boat", new BoatItem(false, EnumExtensions.BoatType.FROST, new Item.Properties().stacksTo(1)));
    public static final Item FROST_CHEST_BOAT = registerItem("frost_chest_boat", new BoatItem(true, EnumExtensions.BoatType.FROST, new Item.Properties().stacksTo(1)));
    public static final Item DAWN_REDWOOD_BOAT = registerItem("dawn_redwood_boat", new BoatItem(false, EnumExtensions.BoatType.DAWN_REDWOOD, new Item.Properties().stacksTo(1)));
    public static final Item DAWN_REDWOOD_CHEST_BOAT = registerItem("dawn_redwood_chest_boat", new BoatItem(true, EnumExtensions.BoatType.DAWN_REDWOOD, new Item.Properties().stacksTo(1)));
    public static final Item JACARANDA_BOAT = registerItem("jacaranda_boat", new BoatItem(false, EnumExtensions.BoatType.JACARANDA, new Item.Properties().stacksTo(1)));
    public static final Item JACARANDA_CHEST_BOAT = registerItem("jacaranda_chest_boat", new BoatItem(true, EnumExtensions.BoatType.JACARANDA, new Item.Properties().stacksTo(1)));
    public static final Item WILLOW_BOAT = registerItem("willow_boat", new BoatItem(false, EnumExtensions.BoatType.WILLOW, new Item.Properties().stacksTo(1)));
    public static final Item WILLOW_CHEST_BOAT = registerItem("willow_chest_boat", new BoatItem(true, EnumExtensions.BoatType.WILLOW, new Item.Properties().stacksTo(1)));

    public static final Item STRAWBERRY = registerItem("strawberry", new ItemNameBlockItem(ModBlocks.STRAWBERRY_BUSH, new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final Item BLUEBERRIES = registerItem("blueberries", new ItemNameBlockItem(ModBlocks.BLUEBERRY_BUSH, new Item.Properties().food(ModFoods.BLUEBERRY)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, name), item);
    }

    public static BlockItem registerBlockItem(String path, BlockItem blockItem) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, path), blockItem);
    }

    private static BlockItem fromBlock(Block block) {
        return fromBlock(block, () -> new BlockItem(block, new Item.Properties()));
    }

    private static BlockItem fromBlock(Block block, Supplier<? extends BlockItem> itemFactory) {
        BlockItem blockItem = itemFactory.get();
        return registerBlockItem(BuiltInRegistries.BLOCK.getKey(block).getPath(), blockItem);
    }

    private static BlockItem registerSynthesizerKeyboard(Block block) {
        return fromBlock(block, () -> new SynthesizerKeyboardItem(block, new Item.Properties()));
    }

    private static BlockItem registerSign(Block sign, Block wallSign) {
        return fromBlock(sign, () -> new SignItem(new Item.Properties().stacksTo(16), (StandingSignBlock) sign, (WallSignBlock) wallSign));
    }

    private static BlockItem registerHangingSign(Block hangingSign, Block wallHangingSign) {
        return fromBlock(hangingSign, () -> new HangingSignItem((CeilingHangingSignBlock) hangingSign, (WallHangingSignBlock) wallHangingSign, new Item.Properties().stacksTo(16)));
    }


    private static BlockItem registerPlaceOnWaterItem(Block block) {
        return fromBlock(block, () -> new PlaceOnWaterBlockItem(block, new Item.Properties()));
    }

    public static void init(){
    }
}