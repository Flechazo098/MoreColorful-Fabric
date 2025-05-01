package com.ChalkerCharles.morecolorful.mixin;

import com.ChalkerCharles.morecolorful.client.ModClientEvents;
import net.minecraft.client.gui.components.DebugScreenOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.ArrayList;
import java.util.List;

@Mixin(DebugScreenOverlay.class)
public class DebugScreenOverlayMixin {
    @ModifyVariable(method = "getGameInformation", at = @At("RETURN"), ordinal = 0)
    private List<String> modifyLeftText(List<String> list) {
        ModClientEvents.modifyDebugText(list, new ArrayList<>());
        return list;
    }

    @ModifyVariable(method = "getSystemInformation", at = @At("RETURN"), ordinal = 0)
    private List<String> modifyRightText(List<String> list) {
        // 右侧文本只需要应用滚动效果
        List<String> left = new ArrayList<>();
        ModClientEvents.modifyDebugText(left, list);
        return list;
    }
}