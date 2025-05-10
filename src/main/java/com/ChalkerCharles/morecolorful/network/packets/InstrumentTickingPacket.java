package com.ChalkerCharles.morecolorful.network.packets;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.attachment.ModDataAttachments;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public record InstrumentTickingPacket(float tick, int id) implements CustomPacketPayload {

    public static final ResourceLocation TYPE_ID = ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "tick");
    public static final Type<InstrumentTickingPacket> TYPE = CustomPacketPayload.createType(MoreColorful.MODID + "tick");

    public static final StreamCodec<FriendlyByteBuf, InstrumentTickingPacket> STREAM_CODEC = StreamCodec.ofMember(
            (InstrumentTickingPacket packet, FriendlyByteBuf buf) -> {
                buf.writeFloat(packet.tick());
                buf.writeInt(packet.id());
            },
            (FriendlyByteBuf buf) -> new InstrumentTickingPacket(buf.readFloat(), buf.readInt())
    );

    @Override
    @NotNull
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleClient(Minecraft client, ClientPacketListener handler, FriendlyByteBuf buf, PacketSender responseSender) {
        InstrumentTickingPacket packet = STREAM_CODEC.decode(buf);
        client.execute(() -> {
            if (client.level != null) {
                Entity entity = client.level.getEntity(packet.id());
                if (entity instanceof Player) {
                    entity.setAttached(ModDataAttachments.PLAYING_SCREEN_TICK, packet.tick());
                }
            }
        });
    }

    public static void handleServer(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
        InstrumentTickingPacket packet = STREAM_CODEC.decode(buf);
        server.execute(() -> {
            Entity entity = player.level().getEntity(packet.id());
            if (entity instanceof Player) {
                entity.setAttached(ModDataAttachments.PLAYING_SCREEN_TICK, packet.tick());
                for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
                    ServerPlayNetworking.send(serverPlayer, packet);
                }
            }
        });
    }
}