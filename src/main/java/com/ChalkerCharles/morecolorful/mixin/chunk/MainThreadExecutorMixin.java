package com.ChalkerCharles.morecolorful.mixin.chunk;

import com.ChalkerCharles.morecolorful.Config;
import com.ChalkerCharles.morecolorful.common.level.ThreadedLevelThermalEngine;
import com.ChalkerCharles.morecolorful.util.mixin.IChunkSourceExtension;
import net.minecraft.server.level.ServerChunkCache;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ServerChunkCache.MainThreadExecutor.class)
public abstract class MainThreadExecutorMixin {

    @Shadow
    @Final
    ServerChunkCache field_18810;

    @Inject(method = "pollTask()Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ThreadedLevelLightEngine;tryScheduleUpdate()V", shift = At.Shift.AFTER))
    private void pollTask(CallbackInfoReturnable<Boolean> cir) {
        if (Config.isThermalSystemEnabled()) {
            ServerChunkCache cache = this.field_18810;
            ((ThreadedLevelThermalEngine) ((IChunkSourceExtension) cache).moreColorful$getThermalEngine()).tryScheduleUpdate();
        }
    }
}