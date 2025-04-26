package com.ChalkerCharles.morecolorful.common;

import com.ChalkerCharles.morecolorful.MoreColorful;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.core.Registry;

public class ModStats {
    public static final ResourceLocation INTERACT_WITH_HARP = register("interact_with_harp");
    public static final ResourceLocation INTERACT_WITH_PIANO = register("interact_with_piano");
    public static final ResourceLocation INTERACT_WITH_BASS_DRUM = register("interact_with_bass_drum");
    public static final ResourceLocation INTERACT_WITH_SNARE = register("interact_with_snare");
    public static final ResourceLocation INTERACT_WITH_TOM = register("interact_with_tom");
    public static final ResourceLocation INTERACT_WITH_HAT = register("interact_with_hat");
    public static final ResourceLocation INTERACT_WITH_RIDE = register("interact_with_ride");
    public static final ResourceLocation INTERACT_WITH_CRASH = register("interact_with_crash");
    public static final ResourceLocation INTERACT_WITH_DRUM_SET = register("interact_with_drum_set");
    public static final ResourceLocation INTERACT_WITH_GLOCKENSPIEL = register("interact_with_glockenspiel");
    public static final ResourceLocation INTERACT_WITH_CHIMES = register("interact_with_chimes");
    public static final ResourceLocation INTERACT_WITH_XYLOPHONE = register("interact_with_xylophone");
    public static final ResourceLocation INTERACT_WITH_VIBRAPHONE = register("interact_with_vibraphone");
    public static final ResourceLocation INTERACT_WITH_SYNTHESIZER_KEYBOARD = register("interact_with_synthesizer_keyboard");
    public static final ResourceLocation INTERACT_WITH_GUZHENG = register("interact_with_guzheng");

    private static ResourceLocation register(String key) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, key);
        Registry.register(BuiltInRegistries.CUSTOM_STAT, key , id);
        Stats.CUSTOM.get(id, StatFormatter.DEFAULT);
        return id;
    }

    public static void init() {
    }
}