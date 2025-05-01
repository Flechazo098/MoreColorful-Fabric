package com.ChalkerCharles.morecolorful.common.level;

import com.ChalkerCharles.morecolorful.Config;
import com.ChalkerCharles.morecolorful.network.packets.ThermalRemovalPacket;
import com.ChalkerCharles.morecolorful.network.packets.ThermalUpdatePacket;
import com.ChalkerCharles.morecolorful.util.mixin.IChunkSourceExtension;
import com.ChalkerCharles.morecolorful.util.mixin.ILevelExtension;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.chunk.LevelChunk;

public final class ModLevelEvents {

    public static void init() {
        ServerChunkEvents.CHUNK_LOAD.register((serverWorld, chunk) -> {
            if (Config.isThermalSystemEnabled()) {
                serverWorld.getPlayers(player -> player.chunkPosition().equals(chunk.getPos())).forEach(player -> sendThermalUpdatePacket(player, chunk));
            }
        });

        ServerChunkEvents.CHUNK_UNLOAD.register((serverWorld, chunk) -> {
            if (Config.isThermalSystemEnabled()) {
                serverWorld.getPlayers(player -> true).forEach(player -> sendThermalRemovalPacket(player, chunk));
            }
        });

        registerClientEvents();
    }

    private static void sendThermalUpdatePacket(ServerPlayer player, LevelChunk chunk) {
        ThermalUpdatePacket packet = new ThermalUpdatePacket(
                chunk.getPos(),
                ((ILevelExtension) player.level()).moreColorful$getThermalEngine(),
                null,
                true
        );
        ServerPlayNetworking.send(player, packet);
    }

    private static void sendThermalRemovalPacket(ServerPlayer player, LevelChunk chunk) {
        ThermalRemovalPacket packet = new ThermalRemovalPacket(chunk.getPos());
        ServerPlayNetworking.send(player, packet);
    }

    @Environment(EnvType.CLIENT)
    private static void registerClientEvents() {
        WorldRenderEvents.END.register(context -> {
            ClientLevel level = Minecraft.getInstance().level;
            if (level == null) return;

            ProfilerFiller profilerfiller = level.getProfiler();
            if (Config.isThermalSystemEnabled()) {
                profilerfiller.popPush("thermal_update_queue");
                ((ILevelExtension) level).moreColorful$pollLightUpdates();
                profilerfiller.popPush("thermal_updates");
                ((IChunkSourceExtension) level.getChunkSource()).moreColorful$getThermalEngine().runThermalUpdates();
            }
        });
    }
}