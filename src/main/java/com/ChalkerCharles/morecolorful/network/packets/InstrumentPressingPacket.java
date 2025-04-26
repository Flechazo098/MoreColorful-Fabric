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

public record InstrumentPressingPacket(int id, boolean isPressing) implements CustomPacketPayload {
    public static final ResourceLocation TYPE_ID = ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing_screen_closed");
    public static final Type<InstrumentPressingPacket> TYPE = CustomPacketPayload.createType(TYPE_ID.toString());

    public static final StreamCodec<FriendlyByteBuf, InstrumentPressingPacket> STREAM_CODEC = StreamCodec.ofMember(
            (InstrumentPressingPacket packet, FriendlyByteBuf buf) -> {
                buf.writeInt(packet.id());
                buf.writeBoolean(packet.isPressing());
            },
            (FriendlyByteBuf buf) -> new InstrumentPressingPacket(buf.readInt(), buf.readBoolean())
    );

    @Override
    @NotNull
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
    public static void handleClient(Minecraft client, ClientPacketListener handler, FriendlyByteBuf buf, PacketSender responseSender) {
        InstrumentPressingPacket packet = STREAM_CODEC.decode(buf);
        client.execute(() -> {
            if (client.level != null) {
                Entity entity = client.level.getEntity(packet.id());
                if (entity instanceof Player) {
                    entity.setAttached(ModDataAttachments.IS_PLAYING_INSTRUMENT, packet.isPressing());
                }
            }
        });
    }

    public static void handleServer(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
        InstrumentPressingPacket packet = STREAM_CODEC.decode(buf);
        server.execute(() -> {
            Entity entity = player.level().getEntity(packet.id());
            if (entity instanceof Player) {
                entity.setAttached(ModDataAttachments.IS_PLAYING_INSTRUMENT, packet.isPressing());
                for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
                    ServerPlayNetworking.send(serverPlayer, packet);
                }
            }
        });
    }
}