package com.ChalkerCharles.morecolorful.common.block;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.client.particle.ModParticles;
import com.ChalkerCharles.morecolorful.common.block.common.*;
import com.ChalkerCharles.morecolorful.common.block.musical_instruments.*;
import com.ChalkerCharles.morecolorful.common.block.properties.*;
import com.ChalkerCharles.morecolorful.common.item.musical_instruments.InstrumentsType;
import com.ChalkerCharles.morecolorful.common.worldgen.features.trees.ModTreeGrower;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.of;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy;

public class ModBlocks {

    // Musical Instruments
    public static final Block HARP = register("harp", new HarpBlock(InstrumentsType.HARP, ofFullCopy(Blocks.IRON_BARS).mapColor(MapColor.TERRACOTTA_YELLOW).strength(3.0F, 6.0F).pushReaction(PushReaction.DESTROY)));
    public static final Block UPRIGHT_PIANO = register("upright_piano", new UprightPianoBlock(InstrumentsType.PIANO_LOW, ofFullCopy(Blocks.IRON_BARS).mapColor(MapColor.COLOR_BLACK).strength(3.0F, 6.0F).pushReaction(PushReaction.BLOCK)));
    public static final Block GRAND_PIANO = register("grand_piano", new GrandPianoBlock(InstrumentsType.PIANO_LOW, ofFullCopy(Blocks.IRON_BARS).mapColor(MapColor.COLOR_BLACK).strength(3.0F, 6.0F).pushReaction(PushReaction.BLOCK)));
    public static final Block BASS_DRUM = register("bass_drum", new BassDrumBlock(InstrumentsType.BASS_DRUM, of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block SNARE_DRUM = register("snare_drum", new SnareDrumBlock(InstrumentsType.SNARE, ofFullCopy(Blocks.COPPER_BLOCK).mapColor(MapColor.QUARTZ).pushReaction(PushReaction.DESTROY).forceSolidOn()));
    public static final Block TOMTOM_DRUM = register("tom-tom_drum", new TomTomDrumBlock(InstrumentsType.TOM, of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.CHERRY_WOOD).forceSolidOn()));
    public static final Block HIHAT = register("hi-hat", new HiHatBlock(InstrumentsType.HAT, ofFullCopy(Blocks.COPPER_GRATE).mapColor(MapColor.GOLD).pushReaction(PushReaction.DESTROY)));
    public static final Block RIDE_CYMBAL = register("ride_cymbal", new RideCymbalBlock(InstrumentsType.RIDE, ofFullCopy(Blocks.COPPER_GRATE).mapColor(MapColor.GOLD).pushReaction(PushReaction.DESTROY).forceSolidOn()));
    public static final Block CRASH_CYMBAL = register("crash_cymbal", new CrashCymbalBlock(InstrumentsType.CRASH, ofFullCopy(Blocks.COPPER_GRATE).mapColor(MapColor.GOLD).pushReaction(PushReaction.DESTROY).forceSolidOn()));
    public static final Block DRUM_SET = register("drum_set", new DrumSetBlock(of().mapColor(MapColor.METAL).strength(3.0F, 6.0F).noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.COPPER).forceSolidOn()));
    public static final Block CHIMES = register("chimes", new ChimesBlock(InstrumentsType.CHIMES, ofFullCopy(Blocks.COPPER_GRATE).mapColor(MapColor.METAL).instrument(NoteBlockInstrument.CHIME).pushReaction(PushReaction.DESTROY)));
    public static final Block GLOCKENSPIEL = register("glockenspiel", new GlockenspielBlock(InstrumentsType.GLOCKENSPIEL, ofFullCopy(Blocks.COPPER_GRATE).mapColor(MapColor.GOLD).instrument(NoteBlockInstrument.BELL).pushReaction(PushReaction.DESTROY).forceSolidOn()));
    public static final Block XYLOPHONE = register("xylophone", new XylophoneBlock(InstrumentsType.XYLOPHONE, ofFullCopy(Blocks.BONE_BLOCK).mapColor(MapColor.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final Block VIBRAPHONE = register("vibraphone", new VibraphoneBlock(InstrumentsType.VIBRAPHONE, ofFullCopy(Blocks.COPPER_BLOCK).mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).pushReaction(PushReaction.DESTROY)));
    public static final Block SYNTHESIZER_KEYBOARD_BIT = register("synthesizer_keyboard_bit", new SynthesizerKeyboardBlock(InstrumentsType.BIT, ofFullCopy(Blocks.IRON_BARS).mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BIT).emissiveRendering(Blocks::always)));
    public static final Block SYNTHESIZER_KEYBOARD_PLING = register("synthesizer_keyboard_pling", new SynthesizerKeyboardBlock(InstrumentsType.PLING, ofFullCopy(Blocks.IRON_BARS).mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.PLING)));
    public static final Block SYNTHESIZER_KEYBOARD_SCULK = register("synthesizer_keyboard_sculk", new SynthesizerKeyboardBlock(InstrumentsType.SCULK, ofFullCopy(Blocks.SCULK_CATALYST).instrument(NoteBlockInstrumentExtension.SCULK).emissiveRendering(Blocks::always)));
    public static final Block SYNTHESIZER_KEYBOARD_AMETHYST = register("synthesizer_keyboard_amethyst", new SynthesizerKeyboardBlock(InstrumentsType.CRYSTAL, ofFullCopy(Blocks.AMETHYST_CLUSTER).instrument(NoteBlockInstrumentExtension.CRYSTAL).emissiveRendering(Blocks::always)));
    public static final Block SYNTHESIZER_KEYBOARD_SAW = register("synthesizer_keyboard_saw", new SynthesizerKeyboardBlock(InstrumentsType.SAW, ofFullCopy(Blocks.IRON_BARS).mapColor(MapColor.CRIMSON_NYLIUM).instrument(NoteBlockInstrumentExtension.SAW)));
    public static final Block SYNTHESIZER_KEYBOARD_PLUCK = register("synthesizer_keyboard_pluck", new SynthesizerKeyboardBlock(InstrumentsType.PLUCK, ofFullCopy(Blocks.IRON_BARS).mapColor(MapColor.LAPIS).instrument(NoteBlockInstrumentExtension.PLUCK)));
    public static final Block SYNTHESIZER_KEYBOARD_SYNTH_BASS = register("synthesizer_keyboard_synth_bass", new SynthesizerKeyboardBlock(InstrumentsType.SYNTH_BASS, ofFullCopy(Blocks.IRON_BARS).mapColor(MapColor.METAL).instrument(NoteBlockInstrumentExtension.SYNTH_BASS)));
    public static final Block GUZHENG = register("guzheng", new GuzhengBlock(InstrumentsType.GUZHENG, ofFullCopy(Blocks.CHERRY_PLANKS).mapColor(MapColor.COLOR_BROWN).pushReaction(PushReaction.DESTROY)));

    // Common Blocks
    public static final RotatedPillarBlock CRABAPPLE_LOG = register("crabapple_log", log(Blocks.CHERRY_LOG, MapColor.TERRACOTTA_PINK, MapColor.TERRACOTTA_GRAY));
    public static final RotatedPillarBlock CRABAPPLE_WOOD = register("crabapple_wood", new RotatedPillarBlock(ofFullCopy(Blocks.CHERRY_WOOD).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final RotatedPillarBlock STRIPPED_CRABAPPLE_LOG = register("stripped_crabapple_log", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_CHERRY_LOG).mapColor(MapColor.TERRACOTTA_PINK)));
    public static final RotatedPillarBlock STRIPPED_CRABAPPLE_WOOD = register("stripped_crabapple_wood", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD).mapColor(MapColor.TERRACOTTA_PINK)));
    public static final Block CRABAPPLE_PLANKS = register("crabapple_planks", new Block(ofFullCopy(Blocks.CHERRY_PLANKS).mapColor(MapColor.TERRACOTTA_PINK)));
    public static final StairBlock CRABAPPLE_STAIRS = register("crabapple_stairs", stair(CRABAPPLE_PLANKS));
    public static final SlabBlock CRABAPPLE_SLAB = register("crabapple_slab", new SlabBlock(ofFullCopy(Blocks.CHERRY_SLAB).mapColor(MapColor.TERRACOTTA_PINK)));
    public static final FenceBlock CRABAPPLE_FENCE = register("crabapple_fence", new FenceBlock(ofFullCopy(Blocks.CHERRY_FENCE).mapColor(MapColor.TERRACOTTA_PINK)));
    public static final FenceGateBlock CRABAPPLE_FENCE_GATE = register("crabapple_fence_gate", new FenceGateBlock(ModWoodTypes.CRABAPPLE, ofFullCopy(Blocks.CHERRY_FENCE).mapColor(MapColor.TERRACOTTA_PINK)));
    public static final DoorBlock CRABAPPLE_DOOR = register("crabapple_door", new DoorBlock(ModBlockSetTypes.CRABAPPLE, ofFullCopy(Blocks.CHERRY_DOOR).mapColor(MapColor.TERRACOTTA_PINK)));
    public static final TrapDoorBlock CRABAPPLE_TRAPDOOR = register("crabapple_trapdoor", new TrapDoorBlock(ModBlockSetTypes.CRABAPPLE, ofFullCopy(Blocks.CHERRY_TRAPDOOR).mapColor(MapColor.TERRACOTTA_PINK)));
    public static final PressurePlateBlock CRABAPPLE_PRESSURE_PLATE = register("crabapple_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.CRABAPPLE, ofFullCopy(Blocks.CHERRY_PRESSURE_PLATE).mapColor(MapColor.TERRACOTTA_PINK)));
    public static final ButtonBlock CRABAPPLE_BUTTON = register("crabapple_button", woodenButton(ModBlockSetTypes.CRABAPPLE, Blocks.CHERRY_BUTTON, MapColor.TERRACOTTA_PINK));
    public static final MCFStandingSignBlock CRABAPPLE_SIGN = register("crabapple_sign", new MCFStandingSignBlock(ModWoodTypes.CRABAPPLE, ofFullCopy(Blocks.CHERRY_SIGN).mapColor(MapColor.TERRACOTTA_PINK)));
    public static final MCFWallSignBlock CRABAPPLE_WALL_SIGN = register("crabapple_wall_sign", new MCFWallSignBlock(ModWoodTypes.CRABAPPLE, ofFullCopy(Blocks.CHERRY_WALL_SIGN).mapColor(MapColor.TERRACOTTA_PINK)));
    public static final MCFCeilingHangingSignBlock CRABAPPLE_HANGING_SIGN = register("crabapple_hanging_sign", new MCFCeilingHangingSignBlock(ModWoodTypes.CRABAPPLE, ofFullCopy(Blocks.CHERRY_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_PINK)));
    public static final MCFWallHangingSignBlock CRABAPPLE_WALL_HANGING_SIGN = register("crabapple_wall_hanging_sign", new MCFWallHangingSignBlock(ModWoodTypes.CRABAPPLE, ofFullCopy(Blocks.CHERRY_WALL_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_PINK)));
    public static final LeavesBlock CRABAPPLE_LEAVES = register("crabapple_leaves", new PetalLeavesBlock(ofFullCopy(Blocks.CHERRY_LEAVES).mapColor(MapColorExtension.CRABAPPLE), ModParticles.CRABAPPLE_LEAVES));
    public static final SaplingBlock CRABAPPLE_SAPLING = register("crabapple_sapling", new SaplingBlock(ModTreeGrower.CRABAPPLE, ofFullCopy(Blocks.CHERRY_SAPLING).mapColor(MapColorExtension.CRABAPPLE)));
    public static final FlowerPotBlock POTTED_CRABAPPLE_SAPLING = register("potted_crabapple_sapling", flowerPot(CRABAPPLE_SAPLING));
    public static final PinkPetalsBlock BEGONIAS = register("begonias", new PinkPetalsBlock(ofFullCopy(Blocks.PINK_PETALS).mapColor(MapColorExtension.BEGONIA)));

    public static final RotatedPillarBlock EBONY_LOG = register("ebony_log", rareLog(MapColor.TERRACOTTA_BLACK, MapColor.TERRACOTTA_LIGHT_GRAY));
    public static final RotatedPillarBlock EBONY_WOOD = register("ebony_wood", new RotatedPillarBlock(ofFullCopy(Blocks.OAK_WOOD).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).strength(2.5F).sound(ModSoundTypes.RARE_WOOD).instrument(NoteBlockInstrumentExtension.GUZHENG)));
    public static final RotatedPillarBlock STRIPPED_EBONY_LOG = register("stripped_ebony_log", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.TERRACOTTA_BLACK).strength(2.5F).sound(ModSoundTypes.RARE_WOOD).instrument(NoteBlockInstrumentExtension.GUZHENG)));
    public static final RotatedPillarBlock STRIPPED_EBONY_WOOD = register("stripped_ebony_wood", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.TERRACOTTA_BLACK).strength(2.5F).sound(ModSoundTypes.RARE_WOOD).instrument(NoteBlockInstrumentExtension.GUZHENG)));
    public static final Block EBONY_PLANKS = register("ebony_planks", new Block(ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.TERRACOTTA_BLACK).strength(2.5F, 3.0F).sound(ModSoundTypes.RARE_WOOD).instrument(NoteBlockInstrumentExtension.GUZHENG)));
    public static final StairBlock EBONY_STAIRS = register("ebony_stairs", stair(EBONY_PLANKS));
    public static final SlabBlock EBONY_SLAB = register("ebony_slab", new SlabBlock(ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.TERRACOTTA_BLACK).strength(2.5F, 3.0F).sound(ModSoundTypes.RARE_WOOD).instrument(NoteBlockInstrumentExtension.GUZHENG)));
    public static final FenceBlock EBONY_FENCE = register("ebony_fence", new FenceBlock(ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.TERRACOTTA_BLACK).strength(2.5F, 3.0F).sound(ModSoundTypes.RARE_WOOD).instrument(NoteBlockInstrumentExtension.GUZHENG)));
    public static final FenceGateBlock EBONY_FENCE_GATE = register("ebony_fence_gate", new FenceGateBlock(ModWoodTypes.EBONY, ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.TERRACOTTA_BLACK).strength(2.5F, 3.0F).instrument(NoteBlockInstrumentExtension.GUZHENG)));
    public static final DoorBlock EBONY_DOOR = register("ebony_door", new DoorBlock(ModBlockSetTypes.EBONY, ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.TERRACOTTA_BLACK).strength(3.5F).instrument(NoteBlockInstrumentExtension.GUZHENG)));
    public static final TrapDoorBlock EBONY_TRAPDOOR = register("ebony_trapdoor", new TrapDoorBlock(ModBlockSetTypes.EBONY, ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.TERRACOTTA_BLACK).strength(3.5F).instrument(NoteBlockInstrumentExtension.GUZHENG)));
    public static final PressurePlateBlock EBONY_PRESSURE_PLATE = register("ebony_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.EBONY, ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrumentExtension.GUZHENG)));
    public static final ButtonBlock EBONY_BUTTON = register("ebony_button", rareWoodButton(ModBlockSetTypes.EBONY, Blocks.OAK_BUTTON, MapColor.TERRACOTTA_BLACK));
    public static final MCFStandingSignBlock EBONY_SIGN = register("ebony_sign", new MCFStandingSignBlock(ModWoodTypes.EBONY, ofFullCopy(Blocks.OAK_SIGN).mapColor(MapColor.TERRACOTTA_BLACK).strength(1.5F).instrument(NoteBlockInstrumentExtension.GUZHENG)));
    public static final MCFWallSignBlock EBONY_WALL_SIGN = register("ebony_wall_sign", new MCFWallSignBlock(ModWoodTypes.EBONY, ofFullCopy(Blocks.OAK_WALL_SIGN).mapColor(MapColor.TERRACOTTA_BLACK).strength(1.5F).instrument(NoteBlockInstrumentExtension.GUZHENG)));
    public static final MCFCeilingHangingSignBlock EBONY_HANGING_SIGN = register("ebony_hanging_sign", new MCFCeilingHangingSignBlock(ModWoodTypes.EBONY, ofFullCopy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_BLACK).strength(1.5F).instrument(NoteBlockInstrumentExtension.GUZHENG)));
    public static final MCFWallHangingSignBlock EBONY_WALL_HANGING_SIGN = register("ebony_wall_hanging_sign", new MCFWallHangingSignBlock(ModWoodTypes.EBONY, ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_BLACK).strength(1.5F).instrument(NoteBlockInstrumentExtension.GUZHENG)));


    public static final LeavesBlock WHITE_CHERRY_LEAVES = register("white_cherry_leaves", new PetalLeavesBlock(ofFullCopy(Blocks.CHERRY_LEAVES).mapColor(MapColor.SNOW), ModParticles.WHITE_CHERRY_LEAVES));
    public static final SaplingBlock WHITE_CHERRY_SAPLING = register("white_cherry_sapling", new SaplingBlock(ModTreeGrower.WHITE_CHERRY, ofFullCopy(Blocks.CHERRY_SAPLING).mapColor(MapColor.SNOW)));
    public static final FlowerPotBlock POTTED_WHITE_CHERRY_SAPLING = register("potted_white_cherry_sapling", flowerPot(WHITE_CHERRY_SAPLING));
    public static final PinkPetalsBlock WHITE_PETALS = register("white_petals", new PinkPetalsBlock(ofFullCopy(Blocks.PINK_PETALS).mapColor(MapColor.SNOW)));
    public static final LeavesBlock ORANGE_BIRCH_LEAVES = register("orange_birch_leaves", new FallingLeavesBlock(ofFullCopy(Blocks.BIRCH_LEAVES).mapColor(MapColorExtension.ORANGE_BIRCH), ModParticles.ORANGE_BIRCH_LEAVES));
    public static final SaplingBlock ORANGE_BIRCH_SAPLING = register("orange_birch_sapling", new SaplingBlock(ModTreeGrower.ORANGE_BIRCH, ofFullCopy(Blocks.BIRCH_SAPLING).mapColor(MapColorExtension.ORANGE_BIRCH)));
    public static final FlowerPotBlock POTTED_ORANGE_BIRCH_SAPLING = register("potted_orange_birch_sapling", flowerPot(ORANGE_BIRCH_SAPLING));
    public static final LeafLitterBlock ORANGE_BIRCH_LEAF_LITTER = register("orange_birch_leaf_litter", new LeafLitterBlock(ofFullCopy(Blocks.PINK_PETALS).mapColor(MapColorExtension.ORANGE_BIRCH).sound(ModSoundTypes.LEAF_LITTER).replaceable()));
    public static final LeavesBlock YELLOW_BIRCH_LEAVES = register("yellow_birch_leaves", new FallingLeavesBlock(ofFullCopy(Blocks.BIRCH_LEAVES).mapColor(MapColor.TERRACOTTA_YELLOW), ModParticles.YELLOW_BIRCH_LEAVES));
    public static final SaplingBlock YELLOW_BIRCH_SAPLING = register("yellow_birch_sapling", new SaplingBlock(ModTreeGrower.YELLOW_BIRCH, ofFullCopy(Blocks.BIRCH_SAPLING).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final FlowerPotBlock POTTED_YELLOW_BIRCH_SAPLING = register("potted_yellow_birch_sapling", flowerPot(YELLOW_BIRCH_SAPLING));
    public static final LeafLitterBlock YELLOW_BIRCH_LEAF_LITTER = register("yellow_birch_leaf_litter", new LeafLitterBlock(ofFullCopy(ORANGE_BIRCH_LEAF_LITTER).mapColor(MapColor.TERRACOTTA_YELLOW).sound(ModSoundTypes.LEAF_LITTER).replaceable()));

    public static final RotatedPillarBlock GINKGO_LOG = register("ginkgo_log", log(Blocks.OAK_LOG, MapColor.SAND, MapColor.WOOD));
    public static final RotatedPillarBlock GINKGO_WOOD = register("ginkgo_wood", new RotatedPillarBlock(ofFullCopy(Blocks.OAK_WOOD)));
    public static final RotatedPillarBlock STRIPPED_GINKGO_LOG = register("stripped_ginkgo_log", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.SAND)));
    public static final RotatedPillarBlock STRIPPED_GINKGO_WOOD = register("stripped_ginkgo_wood", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.SAND)));
    public static final Block GINKGO_PLANKS = register("ginkgo_planks", new Block(ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.SAND)));
    public static final StairBlock GINKGO_STAIRS = register("ginkgo_stairs", stair(GINKGO_PLANKS));
    public static final SlabBlock GINKGO_SLAB = register("ginkgo_slab", new SlabBlock(ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.SAND)));
    public static final FenceBlock GINKGO_FENCE = register("ginkgo_fence", new FenceBlock(ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.SAND)));
    public static final FenceGateBlock GINKGO_FENCE_GATE = register("ginkgo_fence_gate", new FenceGateBlock(ModWoodTypes.GINKGO, ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.SAND)));
    public static final DoorBlock GINKGO_DOOR = register("ginkgo_door", new DoorBlock(ModBlockSetTypes.GINKGO, ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.SAND)));
    public static final TrapDoorBlock GINKGO_TRAPDOOR = register("ginkgo_trapdoor", new TrapDoorBlock(ModBlockSetTypes.GINKGO, ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.SAND)));
    public static final PressurePlateBlock GINKGO_PRESSURE_PLATE = register("ginkgo_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.GINKGO, ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.SAND)));
    public static final ButtonBlock GINKGO_BUTTON = register("ginkgo_button", woodenButton(ModBlockSetTypes.GINKGO, Blocks.OAK_BUTTON, MapColor.SAND));
    public static final MCFStandingSignBlock GINKGO_SIGN = register("ginkgo_sign", new MCFStandingSignBlock(ModWoodTypes.GINKGO, ofFullCopy(Blocks.OAK_SIGN).mapColor(MapColor.SAND)));
    public static final MCFWallSignBlock GINKGO_WALL_SIGN = register("ginkgo_wall_sign", new MCFWallSignBlock(ModWoodTypes.GINKGO, ofFullCopy(Blocks.OAK_WALL_SIGN).mapColor(MapColor.SAND)));
    public static final MCFCeilingHangingSignBlock GINKGO_HANGING_SIGN = register("ginkgo_hanging_sign", new MCFCeilingHangingSignBlock(ModWoodTypes.GINKGO, ofFullCopy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.SAND)));
    public static final MCFWallHangingSignBlock GINKGO_WALL_HANGING_SIGN = register("ginkgo_wall_hanging_sign", new MCFWallHangingSignBlock(ModWoodTypes.GINKGO, ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).mapColor(MapColor.SAND)));
    public static final LeavesBlock GINKGO_LEAVES = register("ginkgo_leaves", new FallingLeavesBlock(ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.GOLD), ModParticles.GINKGO_LEAVES));
    public static final SaplingBlock GINKGO_SAPLING = register("ginkgo_sapling", new SaplingBlock(ModTreeGrower.GINKGO, ofFullCopy(Blocks.OAK_SAPLING).mapColor(MapColor.GOLD)));
    public static final FlowerPotBlock POTTED_GINKGO_SAPLING = register("potted_ginkgo_sapling", flowerPot(GINKGO_SAPLING));
    public static final LeafLitterBlock GINKGO_LEAF_LITTER = register("ginkgo_leaf_litter", new LeafLitterBlock(ofFullCopy(ModBlocks.ORANGE_BIRCH_LEAF_LITTER).mapColor(MapColor.GOLD)));

    public static final RotatedPillarBlock MAPLE_LOG = register("maple_log", log(Blocks.OAK_LOG, MapColor.RAW_IRON, MapColor.WOOD));
    public static final RotatedPillarBlock MAPLE_WOOD = register("maple_wood", new RotatedPillarBlock(ofFullCopy(Blocks.OAK_WOOD)));
    public static final RotatedPillarBlock STRIPPED_MAPLE_LOG = register("stripped_maple_log", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.RAW_IRON)));
    public static final RotatedPillarBlock STRIPPED_MAPLE_WOOD = register("stripped_maple_wood", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.RAW_IRON)));
    public static final Block MAPLE_PLANKS = register("maple_planks", new Block(ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.RAW_IRON)));
    public static final StairBlock MAPLE_STAIRS = register("maple_stairs", stair(MAPLE_PLANKS));
    public static final SlabBlock MAPLE_SLAB = register("maple_slab", new SlabBlock(ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.RAW_IRON)));
    public static final FenceBlock MAPLE_FENCE = register("maple_fence", new FenceBlock(ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.RAW_IRON)));
    public static final FenceGateBlock MAPLE_FENCE_GATE = register("maple_fence_gate", new FenceGateBlock(ModWoodTypes.MAPLE, ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.RAW_IRON)));
    public static final DoorBlock MAPLE_DOOR = register("maple_door", new DoorBlock(ModBlockSetTypes.MAPLE, ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.RAW_IRON)));
    public static final TrapDoorBlock MAPLE_TRAPDOOR = register("maple_trapdoor", new TrapDoorBlock(ModBlockSetTypes.MAPLE, ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.RAW_IRON)));
    public static final PressurePlateBlock MAPLE_PRESSURE_PLATE = register("maple_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.MAPLE, ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.RAW_IRON)));
    public static final ButtonBlock MAPLE_BUTTON = register("maple_button", woodenButton(ModBlockSetTypes.MAPLE, Blocks.OAK_BUTTON, MapColor.RAW_IRON));
    public static final MCFStandingSignBlock MAPLE_SIGN = register("maple_sign", new MCFStandingSignBlock(ModWoodTypes.MAPLE, ofFullCopy(Blocks.OAK_SIGN).mapColor(MapColor.RAW_IRON)));
    public static final MCFWallSignBlock MAPLE_WALL_SIGN = register("maple_wall_sign", new MCFWallSignBlock(ModWoodTypes.MAPLE, ofFullCopy(Blocks.OAK_WALL_SIGN).mapColor(MapColor.RAW_IRON)));
    public static final MCFCeilingHangingSignBlock MAPLE_HANGING_SIGN = register("maple_hanging_sign", new MCFCeilingHangingSignBlock(ModWoodTypes.MAPLE, ofFullCopy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.RAW_IRON)));
    public static final MCFWallHangingSignBlock MAPLE_WALL_HANGING_SIGN = register("maple_wall_hanging_sign", new MCFWallHangingSignBlock(ModWoodTypes.MAPLE, ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).mapColor(MapColor.RAW_IRON)));
    public static final LeavesBlock MAPLE_LEAVES = register("maple_leaves", new FallingLeavesBlock(ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_RED), ModParticles.MAPLE_LEAVES));
    public static final SaplingBlock MAPLE_SAPLING = register("maple_sapling", new SaplingBlock(ModTreeGrower.MAPLE, ofFullCopy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_RED)));
    public static final FlowerPotBlock POTTED_MAPLE_SAPLING = register("potted_maple_sapling", flowerPot(MAPLE_SAPLING));
    public static final LeafLitterBlock MAPLE_LEAF_LITTER = register("maple_leaf_litter", new LeafLitterBlock(ofFullCopy(ModBlocks.ORANGE_BIRCH_LEAF_LITTER).mapColor(MapColor.TERRACOTTA_RED)));
    public static final RotatedPillarBlock FROST_LOG = register("frost_log", log(Blocks.CHERRY_LOG, MapColorExtension.FROST_WOOD, MapColor.TERRACOTTA_BLUE));
    public static final RotatedPillarBlock FROST_WOOD = register("frost_wood", new RotatedPillarBlock(ofFullCopy(Blocks.CHERRY_WOOD).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final RotatedPillarBlock STRIPPED_FROST_LOG = register("stripped_frost_log", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_CHERRY_LOG).mapColor(MapColorExtension.FROST_WOOD)));
    public static final RotatedPillarBlock STRIPPED_FROST_WOOD = register("stripped_frost_wood", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD).mapColor(MapColorExtension.FROST_WOOD)));
    public static final Block FROST_PLANKS = register("frost_planks", new Block(ofFullCopy(Blocks.CHERRY_PLANKS).mapColor(MapColorExtension.FROST_WOOD)));
    public static final StairBlock FROST_STAIRS = register("frost_stairs", stair(FROST_PLANKS));
    public static final SlabBlock FROST_SLAB = register("frost_slab", new SlabBlock(ofFullCopy(Blocks.CHERRY_SLAB).mapColor(MapColorExtension.FROST_WOOD)));
    public static final FenceBlock FROST_FENCE = register("frost_fence", new FenceBlock(ofFullCopy(Blocks.CHERRY_FENCE).mapColor(MapColorExtension.FROST_WOOD)));
    public static final FenceGateBlock FROST_FENCE_GATE = register("frost_fence_gate", new FenceGateBlock(ModWoodTypes.FROST, ofFullCopy(Blocks.CHERRY_FENCE).mapColor(MapColorExtension.FROST_WOOD)));
    public static final DoorBlock FROST_DOOR = register("frost_door", new DoorBlock(ModBlockSetTypes.FROST, ofFullCopy(Blocks.CHERRY_DOOR).mapColor(MapColorExtension.FROST_WOOD)));
    public static final TrapDoorBlock FROST_TRAPDOOR = register("frost_trapdoor", new TrapDoorBlock(ModBlockSetTypes.FROST, ofFullCopy(Blocks.CHERRY_TRAPDOOR).mapColor(MapColorExtension.FROST_WOOD)));
    public static final PressurePlateBlock FROST_PRESSURE_PLATE = register("frost_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.FROST, ofFullCopy(Blocks.CHERRY_PRESSURE_PLATE).mapColor(MapColorExtension.FROST_WOOD)));
    public static final ButtonBlock FROST_BUTTON = register("frost_button", woodenButton(ModBlockSetTypes.FROST, Blocks.CHERRY_BUTTON, MapColorExtension.FROST_WOOD));
    public static final MCFStandingSignBlock FROST_SIGN = register("frost_sign", new MCFStandingSignBlock(ModWoodTypes.FROST, ofFullCopy(Blocks.CHERRY_SIGN).mapColor(MapColorExtension.FROST_WOOD)));
    public static final MCFWallSignBlock FROST_WALL_SIGN = register("frost_wall_sign", new MCFWallSignBlock(ModWoodTypes.FROST, ofFullCopy(Blocks.CHERRY_WALL_SIGN).mapColor(MapColorExtension.FROST_WOOD)));
    public static final MCFCeilingHangingSignBlock FROST_HANGING_SIGN = register("frost_hanging_sign", new MCFCeilingHangingSignBlock(ModWoodTypes.FROST, ofFullCopy(Blocks.CHERRY_HANGING_SIGN).mapColor(MapColorExtension.FROST_WOOD)));
    public static final MCFWallHangingSignBlock FROST_WALL_HANGING_SIGN = register("frost_wall_hanging_sign", new MCFWallHangingSignBlock(ModWoodTypes.FROST, ofFullCopy(Blocks.CHERRY_WALL_HANGING_SIGN).mapColor(MapColorExtension.FROST_WOOD)));
    public static final LeavesBlock FROST_LEAVES = register("frost_leaves", new PetalLeavesBlock(ofFullCopy(Blocks.CHERRY_LEAVES).mapColor(MapColorExtension.FROST), ModParticles.FROST_LEAVES));
    public static final SaplingBlock FROST_SAPLING = register("frost_sapling", new SaplingBlock(ModTreeGrower.FROST, ofFullCopy(Blocks.CHERRY_SAPLING).mapColor(MapColorExtension.FROST)));
    public static final FlowerPotBlock POTTED_FROST_SAPLING = register("potted_frost_sapling", flowerPot(FROST_SAPLING));
    public static final PinkPetalsBlock FROSTY_PETALS = register("frosty_petals", new PinkPetalsBlock(ofFullCopy(Blocks.PINK_PETALS).mapColor(MapColorExtension.FROST)));
    public static final RotatedPillarBlock DAWN_REDWOOD_LOG = register("dawn_redwood_log", log(Blocks.OAK_LOG, MapColor.TERRACOTTA_ORANGE, MapColor.COLOR_BROWN));
    public static final RotatedPillarBlock DAWN_REDWOOD_WOOD = register("dawn_redwood_wood", new RotatedPillarBlock(ofFullCopy(Blocks.OAK_WOOD).mapColor(MapColor.COLOR_BROWN)));
    public static final RotatedPillarBlock STRIPPED_DAWN_REDWOOD_LOG = register("stripped_dawn_redwood_log", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final RotatedPillarBlock STRIPPED_DAWN_REDWOOD_WOOD = register("stripped_dawn_redwood_wood", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block DAWN_REDWOOD_PLANKS = register("dawn_redwood_planks", new Block(ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final StairBlock DAWN_REDWOOD_STAIRS = register("dawn_redwood_stairs", stair(DAWN_REDWOOD_PLANKS));
    public static final SlabBlock DAWN_REDWOOD_SLAB = register("dawn_redwood_slab", new SlabBlock(ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final FenceBlock DAWN_REDWOOD_FENCE = register("dawn_redwood_fence", new FenceBlock(ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final FenceGateBlock DAWN_REDWOOD_FENCE_GATE = register("dawn_redwood_fence_gate", new FenceGateBlock(ModWoodTypes.DAWN_REDWOOD, ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final DoorBlock DAWN_REDWOOD_DOOR = register("dawn_redwood_door", new DoorBlock(ModBlockSetTypes.DAWN_REDWOOD, ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final TrapDoorBlock DAWN_REDWOOD_TRAPDOOR = register("dawn_redwood_trapdoor", new TrapDoorBlock(ModBlockSetTypes.DAWN_REDWOOD, ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final PressurePlateBlock DAWN_REDWOOD_PRESSURE_PLATE = register("dawn_redwood_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.DAWN_REDWOOD, ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final ButtonBlock DAWN_REDWOOD_BUTTON = register("dawn_redwood_button", woodenButton(ModBlockSetTypes.DAWN_REDWOOD, Blocks.OAK_BUTTON, MapColor.TERRACOTTA_ORANGE));
    public static final MCFStandingSignBlock DAWN_REDWOOD_SIGN = register("dawn_redwood_sign", new MCFStandingSignBlock(ModWoodTypes.DAWN_REDWOOD, ofFullCopy(Blocks.OAK_SIGN).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final MCFWallSignBlock DAWN_REDWOOD_WALL_SIGN = register("dawn_redwood_wall_sign", new MCFWallSignBlock(ModWoodTypes.DAWN_REDWOOD, ofFullCopy(Blocks.OAK_WALL_SIGN).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final MCFCeilingHangingSignBlock DAWN_REDWOOD_HANGING_SIGN = register("dawn_redwood_hanging_sign", new MCFCeilingHangingSignBlock(ModWoodTypes.DAWN_REDWOOD, ofFullCopy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final MCFWallHangingSignBlock DAWN_REDWOOD_WALL_HANGING_SIGN = register("dawn_redwood_wall_hanging_sign", new MCFWallHangingSignBlock(ModWoodTypes.DAWN_REDWOOD, ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final LeavesBlock DAWN_REDWOOD_LEAVES = register("dawn_redwood_leaves", new FallingLeavesBlock(ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_ORANGE), ModParticles.DAWN_REDWOOD_LEAVES));
    public static final SaplingBlock DAWN_REDWOOD_SAPLING = register("dawn_redwood_sapling", new WaterloggedSaplingBlock(ModTreeGrower.DAWN_REDWOOD, ofFullCopy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final FlowerPotBlock POTTED_DAWN_REDWOOD_SAPLING = register("potted_dawn_redwood_sapling", flowerPot(DAWN_REDWOOD_SAPLING));
    public static final LeafLitterBlock DAWN_REDWOOD_LEAF_LITTER = register("dawn_redwood_leaf_litter", new LeafLitterBlock(ofFullCopy(ModBlocks.ORANGE_BIRCH_LEAF_LITTER).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block DAWN_REDWOOD_ROOTS = register("dawn_redwood_roots", new DawnRedwoodRootBlock(ofFullCopy(Blocks.MANGROVE_ROOTS).mapColor(MapColor.COLOR_BROWN)));

    public static final RotatedPillarBlock JACARANDA_LOG = register("jacaranda_log", log(Blocks.CHERRY_LOG, MapColorExtension.JACARANDA_WOOD, MapColor.TERRACOTTA_LIGHT_GRAY));
    public static final RotatedPillarBlock JACARANDA_WOOD = register("jacaranda_wood", new RotatedPillarBlock(ofFullCopy(Blocks.CHERRY_WOOD).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)));
    public static final RotatedPillarBlock STRIPPED_JACARANDA_LOG = register("stripped_jacaranda_log", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_CHERRY_LOG).mapColor(MapColorExtension.JACARANDA_WOOD)));
    public static final RotatedPillarBlock STRIPPED_JACARANDA_WOOD = register("stripped_jacaranda_wood", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD).mapColor(MapColorExtension.JACARANDA_WOOD)));
    public static final Block JACARANDA_PLANKS = register("jacaranda_planks", new Block(ofFullCopy(Blocks.CHERRY_PLANKS).mapColor(MapColorExtension.JACARANDA_WOOD)));
    public static final StairBlock JACARANDA_STAIRS = register("jacaranda_stairs", stair(JACARANDA_PLANKS));
    public static final SlabBlock JACARANDA_SLAB = register("jacaranda_slab", new SlabBlock(ofFullCopy(Blocks.CHERRY_SLAB).mapColor(MapColorExtension.JACARANDA_WOOD)));
    public static final FenceBlock JACARANDA_FENCE = register("jacaranda_fence", new FenceBlock(ofFullCopy(Blocks.CHERRY_FENCE).mapColor(MapColorExtension.JACARANDA_WOOD)));
    public static final FenceGateBlock JACARANDA_FENCE_GATE = register("jacaranda_fence_gate", new FenceGateBlock(ModWoodTypes.JACARANDA, ofFullCopy(Blocks.CHERRY_FENCE).mapColor(MapColorExtension.JACARANDA_WOOD)));
    public static final DoorBlock JACARANDA_DOOR = register("jacaranda_door", new DoorBlock(ModBlockSetTypes.JACARANDA, ofFullCopy(Blocks.CHERRY_DOOR).mapColor(MapColorExtension.JACARANDA_WOOD)));
    public static final TrapDoorBlock JACARANDA_TRAPDOOR = register("jacaranda_trapdoor", new TrapDoorBlock(ModBlockSetTypes.JACARANDA, ofFullCopy(Blocks.CHERRY_TRAPDOOR).mapColor(MapColorExtension.JACARANDA_WOOD)));
    public static final PressurePlateBlock JACARANDA_PRESSURE_PLATE = register("jacaranda_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.JACARANDA, ofFullCopy(Blocks.CHERRY_PRESSURE_PLATE).mapColor(MapColorExtension.JACARANDA_WOOD)));
    public static final ButtonBlock JACARANDA_BUTTON = register("jacaranda_button", woodenButton(ModBlockSetTypes.JACARANDA, Blocks.CHERRY_BUTTON, MapColorExtension.JACARANDA_WOOD));
    public static final MCFStandingSignBlock JACARANDA_SIGN = register("jacaranda_sign", new MCFStandingSignBlock(ModWoodTypes.JACARANDA, ofFullCopy(Blocks.CHERRY_SIGN).mapColor(MapColorExtension.JACARANDA_WOOD)));
    public static final MCFWallSignBlock JACARANDA_WALL_SIGN = register("jacaranda_wall_sign", new MCFWallSignBlock(ModWoodTypes.JACARANDA, ofFullCopy(Blocks.CHERRY_WALL_SIGN).mapColor(MapColorExtension.JACARANDA_WOOD)));
    public static final MCFCeilingHangingSignBlock JACARANDA_HANGING_SIGN = register("jacaranda_hanging_sign", new MCFCeilingHangingSignBlock(ModWoodTypes.JACARANDA, ofFullCopy(Blocks.CHERRY_HANGING_SIGN).mapColor(MapColorExtension.JACARANDA_WOOD)));
    public static final MCFWallHangingSignBlock JACARANDA_WALL_HANGING_SIGN = register("jacaranda_wall_hanging_sign", new MCFWallHangingSignBlock(ModWoodTypes.JACARANDA, ofFullCopy(Blocks.CHERRY_WALL_HANGING_SIGN).mapColor(MapColorExtension.JACARANDA_WOOD)));
    public static final LeavesBlock JACARANDA_LEAVES = register("jacaranda_leaves", new PetalLeavesBlock(ofFullCopy(Blocks.CHERRY_LEAVES).mapColor(MapColorExtension.JACARANDA), ModParticles.JACARANDA_LEAVES));
    public static final SaplingBlock JACARANDA_SAPLING = register("jacaranda_sapling", new SaplingBlock(ModTreeGrower.JACARANDA, ofFullCopy(Blocks.CHERRY_SAPLING).mapColor(MapColorExtension.JACARANDA)));
    public static final FlowerPotBlock POTTED_JACARANDA_SAPLING = register("potted_jacaranda_sapling", flowerPot(JACARANDA_SAPLING));
    public static final PinkPetalsBlock VIOLETS = register("violets", new TallFlowerbedBlock(ofFullCopy(Blocks.PINK_PETALS).mapColor(MapColorExtension.JACARANDA)));
    public static final PinkPetalsBlock BUTTERCUPS = register("buttercups", new TallFlowerbedBlock(ofFullCopy(Blocks.PINK_PETALS).mapColor(MapColor.COLOR_YELLOW)));
    public static final PinkPetalsBlock FORGET_ME_NOTS = register("forget-me-nots", new TallFlowerbedBlock(ofFullCopy(Blocks.PINK_PETALS).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final PinkPetalsBlock BABY_BLUE_EYES = register("baby-blue-eyes", new TallFlowerbedBlock(ofFullCopy(Blocks.PINK_PETALS).mapColor(MapColor.LAPIS)));
    public static final PinkPetalsBlock SPEEDWELLS = register("speedwells", new PinkPetalsBlock(ofFullCopy(Blocks.PINK_PETALS).mapColor(MapColor.COLOR_BLUE)));
    public static final PinkPetalsBlock WOOD_SORRELS = register("wood_sorrels", new PinkPetalsBlock(ofFullCopy(Blocks.PINK_PETALS).mapColor(MapColor.COLOR_MAGENTA)));

    public static final RotatedPillarBlock WILLOW_LOG = register("willow_log", log(Blocks.OAK_LOG, MapColor.GLOW_LICHEN, MapColor.TERRACOTTA_GREEN));
    public static final RotatedPillarBlock WILLOW_WOOD = register("willow_wood", new RotatedPillarBlock(ofFullCopy(Blocks.OAK_WOOD).mapColor(MapColor.TERRACOTTA_GREEN)));
    public static final RotatedPillarBlock STRIPPED_WILLOW_LOG = register("stripped_willow_log", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.GLOW_LICHEN)));
    public static final RotatedPillarBlock STRIPPED_WILLOW_WOOD = register("stripped_willow_wood", new RotatedPillarBlock(ofFullCopy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.GLOW_LICHEN)));
    public static final Block WILLOW_PLANKS = register("willow_planks", new Block(ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.GLOW_LICHEN)));
    public static final StairBlock WILLOW_STAIRS = register("willow_stairs", stair(WILLOW_PLANKS));
    public static final SlabBlock WILLOW_SLAB = register("willow_slab", new SlabBlock(ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.GLOW_LICHEN)));
    public static final FenceBlock WILLOW_FENCE = register("willow_fence", new FenceBlock(ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.GLOW_LICHEN)));
    public static final FenceGateBlock WILLOW_FENCE_GATE = register("willow_fence_gate", new FenceGateBlock(ModWoodTypes.WILLOW, ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.GLOW_LICHEN)));
    public static final DoorBlock WILLOW_DOOR = register("willow_door", new DoorBlock(ModBlockSetTypes.WILLOW, ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.GLOW_LICHEN)));
    public static final TrapDoorBlock WILLOW_TRAPDOOR = register("willow_trapdoor", new TrapDoorBlock(ModBlockSetTypes.WILLOW, ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.GLOW_LICHEN)));
    public static final PressurePlateBlock WILLOW_PRESSURE_PLATE = register("willow_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.WILLOW, ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.GLOW_LICHEN)));
    public static final ButtonBlock WILLOW_BUTTON = register("willow_button", woodenButton(ModBlockSetTypes.WILLOW, Blocks.OAK_BUTTON, MapColor.GLOW_LICHEN));
    public static final MCFStandingSignBlock WILLOW_SIGN = register("willow_sign", new MCFStandingSignBlock(ModWoodTypes.WILLOW, ofFullCopy(Blocks.OAK_SIGN).mapColor(MapColor.GLOW_LICHEN)));
    public static final MCFWallSignBlock WILLOW_WALL_SIGN = register("willow_wall_sign", new MCFWallSignBlock(ModWoodTypes.WILLOW, ofFullCopy(Blocks.OAK_WALL_SIGN).mapColor(MapColor.GLOW_LICHEN)));
    public static final MCFCeilingHangingSignBlock WILLOW_HANGING_SIGN = register("willow_hanging_sign", new MCFCeilingHangingSignBlock(ModWoodTypes.WILLOW, ofFullCopy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.GLOW_LICHEN)));
    public static final MCFWallHangingSignBlock WILLOW_WALL_HANGING_SIGN = register("willow_wall_hanging_sign", new MCFWallHangingSignBlock(ModWoodTypes.WILLOW, ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).mapColor(MapColor.GLOW_LICHEN)));
    public static final LeavesBlock WILLOW_LEAVES = register("willow_leaves", new LeavesBlock(ofFullCopy(Blocks.OAK_LEAVES)));
    public static final SaplingBlock WILLOW_SAPLING = register("willow_sapling", new WaterloggedSaplingBlock(ModTreeGrower.WILLOW, ofFullCopy(Blocks.OAK_SAPLING)));
    public static final FlowerPotBlock POTTED_WILLOW_SAPLING = register("potted_willow_sapling", flowerPot(WILLOW_SAPLING));
    public static final Block WILLOW_BRANCHES = register("willow_branches", new WillowBranchesBlock(of().ignitedByLava().mapColor(MapColor.PLANT).noCollission().sound(SoundType.VINE).pushReaction(PushReaction.DESTROY)));

    public static final FlowerBlock PINK_DAISY = register("pink_daisy", new FlowerBlock(MobEffects.REGENERATION, 8.0F, flowerProperties().mapColor(MapColor.COLOR_PINK)));
    public static final FlowerPotBlock POTTED_PINK_DAISY = register("potted_pink_daisy", flowerPot(PINK_DAISY));
    public static final FlowerBlock RED_CARNATION = register("red_carnation", new FlowerBlock(MobEffects.DAMAGE_BOOST, 9.0F, flowerProperties().mapColor(MapColor.COLOR_RED)));
    public static final FlowerPotBlock POTTED_RED_CARNATION = register("potted_red_carnation", flowerPot(RED_CARNATION));
    public static final FlowerBlock PINK_CARNATION = register("pink_carnation", new FlowerBlock(MobEffects.DAMAGE_BOOST, 9.0F, flowerProperties().mapColor(MapColor.COLOR_PINK)));
    public static final FlowerPotBlock POTTED_PINK_CARNATION = register("potted_pink_carnation", flowerPot(PINK_CARNATION));
    public static final FlowerBlock WHITE_CARNATION = register("white_carnation", new FlowerBlock(MobEffects.DAMAGE_BOOST, 9.0F, flowerProperties().mapColor(MapColor.SNOW)));
    public static final FlowerPotBlock POTTED_WHITE_CARNATION = register("potted_white_carnation", flowerPot(WHITE_CARNATION));
    public static final FlowerBlock RED_SPIDER_LILY = register("red_spider_lily", new FlowerBlock(MobEffects.POISON, 10.0F, flowerProperties().mapColor(MapColor.COLOR_RED)));
    public static final FlowerPotBlock POTTED_RED_SPIDER_LILY = register("potted_red_spider_lily", flowerPot(RED_SPIDER_LILY));
    public static final FlowerBlock YELLOW_CHRYSANTHEMUM = register("yellow_chrysanthemum", new FlowerBlock(MobEffects.DAMAGE_RESISTANCE, 6.0F, flowerProperties().mapColor(MapColor.COLOR_YELLOW)));
    public static final FlowerPotBlock POTTED_YELLOW_CHRYSANTHEMUM = register("potted_yellow_chrysanthemum", flowerPot(YELLOW_CHRYSANTHEMUM));
    public static final FlowerBlock GREEN_CHRYSANTHEMUM = register("green_chrysanthemum", new FlowerBlock(MobEffects.DAMAGE_RESISTANCE, 6.0F, flowerProperties().mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final FlowerPotBlock POTTED_GREEN_CHRYSANTHEMUM = register("potted_green_chrysanthemum", flowerPot(GREEN_CHRYSANTHEMUM));
    public static final FlowerBlock OPEN_DAYBLOOM = register("open_daybloom", new DaybloomBlock(DaybloomBlock.Type.OPEN, flowerProperties().mapColor(MapColor.COLOR_YELLOW).randomTicks()));
    public static final FlowerPotBlock POTTED_OPEN_DAYBLOOM = register("potted_open_daybloom", new FlowerPotBlock(OPEN_DAYBLOOM, flowerPotProperties().randomTicks()));
    public static final FlowerBlock CLOSED_DAYBLOOM = register("closed_daybloom", new DaybloomBlock(DaybloomBlock.Type.CLOSED, flowerProperties().mapColor(MapColor.PLANT).randomTicks()));
    public static final FlowerPotBlock POTTED_CLOSED_DAYBLOOM = register("potted_closed_daybloom", new FlowerPotBlock(CLOSED_DAYBLOOM, flowerPotProperties().randomTicks()));
    public static final FlowerBlock EDELWEISS = register("edelweiss", new FlowerBlock(MobEffects.FIRE_RESISTANCE, 6.0F, flowerProperties().mapColor(MapColor.SNOW)));
    public static final FlowerPotBlock POTTED_EDELWEISS = register("potted_edelweiss", flowerPot(EDELWEISS));
    public static final FlowerBlock CROCUS = register("crocus", new FlowerBlock(MobEffects.MOVEMENT_SPEED, 8.0F, flowerProperties().mapColor(MapColor.COLOR_PURPLE)));
    public static final FlowerPotBlock POTTED_CROCUS = register("potted_crocus", flowerPot(CROCUS));
    public static final FlowerBlock IRIS = register("iris", new FlowerBlock(MobEffects.SATURATION, 0.35F, flowerProperties().mapColor(MapColor.COLOR_PURPLE)));
    public static final FlowerPotBlock POTTED_IRIS = register("potted_iris", flowerPot(IRIS));
    public static final FlowerBlock LAVENDER = register("lavender", new FlowerBlock(MobEffects.REGENERATION, 8.0F, flowerProperties().mapColor(MapColor.COLOR_PURPLE)));
    public static final FlowerPotBlock POTTED_LAVENDER = register("potted_lavender", flowerPot(LAVENDER));
    public static final FlowerBlock DAFFODIL = register("daffodil", new FlowerBlock(MobEffects.POISON, 11.0F, flowerProperties().mapColor(MapColor.GOLD)));
    public static final FlowerPotBlock POTTED_DAFFODIL = register("potted_daffodil", flowerPot(DAFFODIL));
    public static final FlowerBlock GERBERA_DAISY = register("gerbera_daisy", new FlowerBlock(MobEffects.REGENERATION, 4.0F, flowerProperties().mapColor(MapColor.COLOR_MAGENTA)));
    public static final FlowerPotBlock POTTED_GERBERA_DAISY = register("potted_gerbera_daisy", flowerPot(GERBERA_DAISY));
    public static final FlowerBlock RAPESEED_FLOWER = register("rapeseed_flower", new FlowerBlock(MobEffects.SATURATION, 0.35F, flowerProperties().mapColor(MapColor.COLOR_YELLOW)));
    public static final FlowerPotBlock POTTED_RAPESEED_FLOWER = register("potted_rapeseed_flower", flowerPot(RAPESEED_FLOWER));

    public static final Block CATTAIL = register("cattail", new CattailBlock(tallFlowerProperties().mapColor(MapColor.COLOR_BROWN)));
    public static final Block TALL_RAPESEED_FLOWER = register("tall_rapeseed_flower", new TallFlowerBlock(tallFlowerProperties().mapColor(MapColor.COLOR_YELLOW)));

    public static final Block SHORT_WATER_GRASS = register("short_water_grass", new WaterGrassBlock(ofFullCopy(Blocks.TALL_GRASS).sound(SoundType.WET_GRASS)));
    public static final Block TALL_WATER_GRASS = register("tall_water_grass", new WaterGrassBlock(ofFullCopy(Blocks.TALL_GRASS).sound(SoundType.WET_GRASS)));
    public static final Block REED = register("reed", new ReedBlock(tallFlowerProperties().mapColor(MapColor.GLOW_LICHEN)));
    public static final Block STRAWBERRY_BUSH = register("strawberry_bush", new BerryBushBlock(ofFullCopy(Blocks.SWEET_BERRY_BUSH)));
    public static final Block BLUEBERRY_BUSH = register("blueberry_bush", new BerryBushBlock(ofFullCopy(Blocks.SWEET_BERRY_BUSH)));
    public static final Block OPEN_WATER_LILY = register("open_water_lily", new WaterLilyBlock(true, ofFullCopy(Blocks.LILY_PAD).mapColor(MapColor.COLOR_PINK).randomTicks()));
    public static final Block OPEN_WHITE_WATER_LILY = register("open_white_water_lily", new WaterLilyBlock(true, ofFullCopy(Blocks.LILY_PAD).mapColor(MapColor.SNOW).randomTicks()));
    public static final Block OPEN_BLUE_WATER_LILY = register("open_blue_water_lily", new WaterLilyBlock(true, ofFullCopy(Blocks.LILY_PAD).mapColor(MapColor.COLOR_BLUE).randomTicks()));
    public static final Block CLOSED_WATER_LILY = register("closed_water_lily", new WaterLilyBlock(false, ofFullCopy(Blocks.LILY_PAD).randomTicks()));
    public static final Block CLOSED_WHITE_WATER_LILY = register("closed_white_water_lily", new WaterLilyBlock(false, ofFullCopy(Blocks.LILY_PAD).randomTicks()));
    public static final Block CLOSED_BLUE_WATER_LILY = register("closed_blue_water_lily", new WaterLilyBlock(false, ofFullCopy(Blocks.LILY_PAD).randomTicks()));
    public static final Block DUCKWEEDS = register("duckweeds", new DuckweedsBlock(ofFullCopy(Blocks.LILY_PAD).replaceable().noCollission()));


    // 辅助方法
    private static <T extends Block> T register(String name, T block) {
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, name), block);
    }

    private static RotatedPillarBlock log(Block block, MapColor topColor, MapColor sideColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(block).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor));
    }

    private static RotatedPillarBlock rareLog(MapColor topColor, MapColor sideColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor).strength(2.5F).sound(ModSoundTypes.RARE_WOOD).instrument(NoteBlockInstrumentExtension.GUZHENG));
    }

    private static StairBlock stair(Block block) {
        return new StairBlock(block.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(block));
    }

    private static ButtonBlock woodenButton(BlockSetType blockSetType, Block block, MapColor mapColor) {
        return new ButtonBlock(blockSetType, 30, BlockBehaviour.Properties.ofFullCopy(block).mapColor(mapColor).noCollission().strength(0.5F));
    }

    private static ButtonBlock rareWoodButton(BlockSetType blockSetType, Block block, MapColor mapColor) {
        return new ButtonBlock(blockSetType, 30, BlockBehaviour.Properties.ofFullCopy(block).mapColor(mapColor).noCollission().strength(0.5F).sound(ModSoundTypes.RARE_WOOD).instrument(NoteBlockInstrumentExtension.GUZHENG));
    }

    private static FlowerPotBlock flowerPot(Block block) {
        return new FlowerPotBlock(block, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT));
    }
    private static BlockBehaviour.Properties flowerProperties() {
        return of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY);
    }
    private static BlockBehaviour.Properties tallFlowerProperties() {
        return flowerProperties().ignitedByLava();
    }
    private static BlockBehaviour.Properties flowerPotProperties() {
        return of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
    }

    public static void init() {
    }
}