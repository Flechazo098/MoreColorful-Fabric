package com.ChalkerCharles.morecolorful.client;

import com.ChalkerCharles.morecolorful.client.gui.PlayingScreen;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class ModKeyMapping {
    private static final String CATEGORY = "key.categories.morecolorful.morecolorful";

    public static final KeyMapping OCTAVE_TOGGLE = new KeyMapping(
            "key.morecolorful.octave_toggle",
            GLFW.GLFW_KEY_L,
            CATEGORY
    );

    public static final KeyMapping DEBUG_TEXT_SCROLL_DOWN = new KeyMapping(
            "key.morecolorful.debug_text_scroll_down",
            GLFW.GLFW_KEY_DOWN,
            CATEGORY
    );

    public static final KeyMapping DEBUG_TEXT_SCROLL_UP = new KeyMapping(
            "key.morecolorful.debug_text_scroll_up",
            GLFW.GLFW_KEY_UP,
            CATEGORY
    );

    public static void init() {
        KeyBindingHelper.registerKeyBinding(OCTAVE_TOGGLE);
        KeyBindingHelper.registerKeyBinding(DEBUG_TEXT_SCROLL_DOWN);
        KeyBindingHelper.registerKeyBinding(DEBUG_TEXT_SCROLL_UP);
    }

    public static boolean isPlayingScreenActive() {
        return Minecraft.getInstance().screen instanceof PlayingScreen;
    }

    public static boolean isDebugScreenActive() {
        return Minecraft.getInstance().getDebugOverlay().showDebugScreen();
    }
}