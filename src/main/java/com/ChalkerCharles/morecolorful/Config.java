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

public class Config {
    private static ModConfig INSTANCE;

    public static Object2IntMap<List<BlockState>> blockTemperature;
    public static Object2IntMap<List<BlockState>> thermalResistance;
    public static Set<ResourceKey<Biome>> disabledBiomes;

    public static void init() {
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        loadConfig();
    }

    public static void loadConfig() {
        blockTemperature = INSTANCE.blockTemperature.stream()
                .map(StringParser::parseBlockEntry)
                .filter(StringParser.BlockEntry::validate)
                .collect(Collectors.toMap(StringParser.BlockEntry::getStates, entry -> Integer.parseInt(entry.value()), (i, j) -> j, Object2IntOpenHashMap::new));
        
        thermalResistance = INSTANCE.thermalResistance.stream()
                .map(StringParser::parseBlockEntry)
                .filter(StringParser.BlockEntry::validate)
                .collect(Collectors.toMap(StringParser.BlockEntry::getStates, entry -> Integer.parseInt(entry.value()), (i, j) -> j, Object2IntOpenHashMap::new));
        
        disabledBiomes = INSTANCE.disabledBiomes.stream()
                .map(biome -> ResourceKey.create(Registries.BIOME, ResourceLocation.parse(biome)))
                .collect(Collectors.toSet());

        checkBiomeModifier(INSTANCE.allowAddingFeatures, ModBiomeModifiers.ADD_FEATURE_MODIFIERS, "Add Feature");
    }

    public static boolean isThermalSystemEnabled() {
        return INSTANCE.thermalSystem;
    }

    public static boolean isArchaeologyLootsEnabled() {
        return INSTANCE.archaeologyLoots;
    }

    public static int getOverworldRegionWeight() {
        return INSTANCE.overworldRegionWeight;
    }

    public static boolean isAllowAddingFeatures() {
        return INSTANCE.allowAddingFeatures;
    }

    private static void checkBiomeModifier(boolean enabled, List<String> modifiers, String name) {
        if (enabled) {
            FileUtils.enableBiomeModifiers(modifiers);
            MoreColorful.LOGGER.info("启用生物群系修改器: {}", name);
        } else {
            FileUtils.disableBiomeModifiers(modifiers);
            MoreColorful.LOGGER.info("禁用生物群系修改器: {}", name);
        }
    }

    @me.shedaniel.autoconfig.annotation.Config(name = MoreColorful.MODID)
    public static class ModConfig implements ConfigData {
        @ConfigEntry.Gui.CollapsibleObject
        @ConfigEntry.Gui.Tooltip
        @Comment("方块相关配置")
        public BlockConfig block = new BlockConfig();

        @ConfigEntry.Gui.CollapsibleObject
        @ConfigEntry.Gui.Tooltip
        @Comment("战利品相关配置")
        public LootConfig loot = new LootConfig();

        @ConfigEntry.Gui.CollapsibleObject
        @ConfigEntry.Gui.Tooltip
        @Comment("世界生成相关配置")
        public WorldGenConfig worldGen = new WorldGenConfig();

        @ConfigEntry.Gui.Excluded
        public boolean thermalSystem = true;
        
        @ConfigEntry.Gui.Excluded
        public List<String> blockTemperature = new ArrayList<>();
        
        @ConfigEntry.Gui.Excluded
        public List<String> thermalResistance = new ArrayList<>();
        
        @ConfigEntry.Gui.Excluded
        public boolean archaeologyLoots = true;
        
        @ConfigEntry.Gui.Excluded
        public int overworldRegionWeight = 10;
        
        @ConfigEntry.Gui.Excluded
        public List<String> disabledBiomes = new ArrayList<>();
        
        @ConfigEntry.Gui.Excluded
        public boolean allowAddingFeatures = true;

        @Override
        public void validatePostLoad() {
            this.thermalSystem = block.thermalSystem;
            this.blockTemperature = block.blockTemperature;
            this.thermalResistance = block.thermalResistance;
            this.archaeologyLoots = loot.archaeologyLoots;
            this.overworldRegionWeight = worldGen.overworldRegionWeight;
            this.disabledBiomes = worldGen.disabledBiomes;
            this.allowAddingFeatures = worldGen.allowAddingFeatures;
        }
    }

    public static class BlockConfig {
        @ConfigEntry.Gui.Tooltip(count = 3)
        @Comment("为方块引入了热力系统。现在每个方块都有一个温度值，温度会在传播过程中衰减。\n冰雪只会在温度足够高时融化，而不是取决于光照等级。\n热的传导会受到方块热阻的影响。")
        public boolean thermalSystem = true;

        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("为具有特定方块状态的方块定义一个合适的温度值（范围：0-15），或者你也可以覆盖本模组的配置。方块状态是可选的。\n格式：\"<方块名称>[方块状态]=<值>\"。例子：\"minecraft:sea_lantern=0\"，\"minecraft:redstone_lamp[lit=true]=12\"")
        public List<String> blockTemperature = new ArrayList<>();

        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("为具有特定方块状态的方块定义一个合适的热阻值（范围：1-15），默认值是3。或者你也可以覆盖本模组的配置。方块状态是可选的。\n格式：\"<方块名称>[方块状态]=<值>\"。例子：\"minecraft:stone=3\"，\"minecraft:oak_fence[waterlogged=true]=4\"")
        public List<String> thermalResistance = new ArrayList<>();
    }

    public static class LootConfig {
        @ConfigEntry.Gui.Tooltip
        @Comment("在可疑方块中添加新的战利品，你可以通过考古获得它们。")
        public boolean archaeologyLoots = true;
    }

    public static class WorldGenConfig {
        @ConfigEntry.Gui.Tooltip
        @Comment("更加多彩的世界生物群系区域在主世界中的权重。设置为0以禁用它。")
        @ConfigEntry.BoundedDiscrete(min = 0, max = Integer.MAX_VALUE)
        public int overworldRegionWeight = 10;

        @ConfigEntry.Gui.Tooltip
        @Comment("从世界生成中禁用的生物群系列表。")
        public List<String> disabledBiomes = new ArrayList<>();

        @ConfigEntry.Gui.Tooltip
        @Comment("允许更加多彩的世界向原版生物群系添加新的特性。")
        public boolean allowAddingFeatures = true;
    }
}