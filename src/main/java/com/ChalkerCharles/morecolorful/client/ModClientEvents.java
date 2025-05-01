package com.ChalkerCharles.morecolorful.client;

import com.ChalkerCharles.morecolorful.Config;
import com.ChalkerCharles.morecolorful.util.mixin.ILevelExtension;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.DebugScreenOverlay;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Environment(EnvType.CLIENT)
public final class ModClientEvents {
    private static int removedLines = 0;

    public static void init() {
        // 注册客户端 tick 事件
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            DebugScreenOverlay debugScreenOverlay = client.getDebugOverlay();
            boolean isDebugScreenOn = debugScreenOverlay.showDebugScreen();
            while (isDebugScreenOn && ModKeyMapping.DEBUG_TEXT_SCROLL_DOWN.consumeClick()) {
                removedLines = Math.max(0, removedLines - 1);
            }
            while (isDebugScreenOn && ModKeyMapping.DEBUG_TEXT_SCROLL_UP.consumeClick()) {
                removedLines = Math.min(removedLines + 1, 20);
            }
        });
    }

    // 这个方法将被 Mixin 调用，用于修改调试文本
    public static void modifyDebugText(List<String> left, List<String> right) {
        Minecraft minecraft = Minecraft.getInstance();
        BlockPos blockpos = Objects.requireNonNull(minecraft.getCameraEntity()).blockPosition();
        List<String> addLeft = new ArrayList<>();

        if (minecraft.level != null && Config.isThermalSystemEnabled()) {
            int temperature = ((ILevelExtension) minecraft.level).moreColorful$getTemperature(blockpos);
            addLeft.add("Block Temperature: " + temperature);
        }

        if (!addLeft.isEmpty()) {
            addLeft.addFirst(ChatFormatting.GREEN + "[More Colorful]");
            addLeft.addFirst("");
        }
        left.addAll(addLeft);

        left.subList(0, Math.max(0, Math.min(removedLines, left.size() - 20))).clear();
        right.subList(0, Math.max(0, Math.min(removedLines, right.size() - 20))).clear();
    }
}