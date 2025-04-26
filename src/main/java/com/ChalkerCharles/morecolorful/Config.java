package com.ChalkerCharles.morecolorful;

import com.ChalkerCharles.morecolorful.common.worldgen.ModBiomeModifiers;
import com.ChalkerCharles.morecolorful.util.FileUtils;
import com.ChalkerCharles.morecolorful.util.StringParser;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;
import java.util.stream.Collectors;

public class Config implements ConfigData {
    private static final String prefix = MoreColorful.MODID + ".config.";
    private static Config INSTANCE;

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("block")
    public BlockConfig block = new BlockConfig();

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("loot")
    public LootConfig loot = new LootConfig();

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("world")
    public WorldConfig world = new WorldConfig();

    public static Object2IntMap<List<BlockState>> blockTemperature;
    public static Object2IntMap<List<BlockState>> thermalResistance;
    public static Set<ResourceKey<Biome>> disabledBiomes;

    public static class BlockConfig {
        @Comment("Introduce thermal system for blocks. Now each block has a temperature level, and the temperature level will decrease while spreading.\nIce and snow only melt when the temperature is high enough, instead of depending on light level.\nThe conduction of heat will be affected by block's thermal resistance.")
        public boolean thermalSystem = true;

        @Comment("Define a proper temperature value (Range: 0-15) for blocks with certain block state. Or you can also override the More Colorful configs. Block states are optional.\nFormat: \"<block name>[block states]=<value>\". Example: \"minecraft:sea_lantern=0\", \"minecraft:redstone_lamp[lit=true]=12\"")
        public List<String> blockTemperature = new ArrayList<>();

        @Comment("Define a proper thermal resistance value (Range: 1-15) for blocks with certain block state, by default the value is 3. Or you can also override the More Colorful configs. Block states are optional.\nFormat: \"<block name>[block states]=<value>\". Example: \"minecraft:stone=3\", \"minecraft:oak_fence[waterlogged=true]=4\"")
        public List<String> thermalResistance = new ArrayList<>();
    }

    public static class LootConfig {
        @Comment("Add new loots in suspicious blocks, and you can get them by archaeology.")
        public boolean archaeologyLoots = true;
    }

    public static class WorldConfig {
        @Comment("The weight of More Colorful Biome regions in the overworld. Set to 0 to disable it.")
        @ConfigEntry.BoundedDiscrete(min = 0, max = Integer.MAX_VALUE)
        public int overworldRegionWeight = 10;

        @Comment("A list of biomes that are disabled from world generation.")
        public List<String> disabledBiomes = new ArrayList<>();

        @Comment("Allow More Colorful to add new features to vanilla biomes.")
        public boolean allowAddingFeatures = true;
    }

    public static void init() {
        AutoConfig.register(Config.class, JanksonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(Config.class).getConfig();
        loadConfigValues();
    }

    public static void loadConfigValues() {
        blockTemperature = INSTANCE.block.blockTemperature.stream()
                .map(StringParser::parseBlockEntry)
                .filter(StringParser.BlockEntry::validate)
                .collect(Collectors.toMap(StringParser.BlockEntry::getStates, entry -> Integer.parseInt(entry.value()), (i, j) -> j, Object2IntOpenHashMap::new));

        thermalResistance = INSTANCE.block.thermalResistance.stream()
                .map(StringParser::parseBlockEntry)
                .filter(StringParser.BlockEntry::validate)
                .collect(Collectors.toMap(StringParser.BlockEntry::getStates, entry -> Integer.parseInt(entry.value()), (i, j) -> j, Object2IntOpenHashMap::new));

        disabledBiomes = INSTANCE.world.disabledBiomes.stream()
                .map(biome -> ResourceKey.create(Registries.BIOME, ResourceLocation.parse(biome)))
                .collect(Collectors.toSet());

        checkBiomeModifier(INSTANCE.world.allowAddingFeatures, ModBiomeModifiers.ADD_FEATURE_MODIFIERS, "Add Feature");
    }

    @SuppressWarnings("SameParameterValue")
    private static void checkBiomeModifier(boolean enabled, List<String> modifiers, String name) {
        if (enabled) {
            FileUtils.enableBiomeModifiers(modifiers);
            MoreColorful.LOGGER.info("Enabled Biome Modifiers: {}", name);
        } else {
            FileUtils.disableBiomeModifiers(modifiers);
            MoreColorful.LOGGER.info("Disabled Biome Modifiers: {}", name);
        }
    }

    public static boolean isThermalSystemEnabled() {
        return INSTANCE.block.thermalSystem;
    }

    public static boolean isArchaeologyLootsEnabled() {
        return INSTANCE.loot.archaeologyLoots;
    }

    public static int getOverworldRegionWeight() {
        return INSTANCE.world.overworldRegionWeight;
    }

    public static boolean isAllowAddingFeatures() {
        return INSTANCE.world.allowAddingFeatures;
    }

    @Override
    public void validatePostLoad() {
        loadConfigValues();
    }
}