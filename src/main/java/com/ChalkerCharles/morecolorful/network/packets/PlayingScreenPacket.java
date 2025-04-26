package com.ChalkerCharles.morecolorful.network.packets;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.attachment.ModDataAttachments;
import com.ChalkerCharles.morecolorful.common.item.musical_instruments.InstrumentsType;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.BlockPos;
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

public record PlayingScreenPacket(InstrumentsType pType, BlockPos pos, int id, boolean isOpen) implements CustomPacketPayload {

    public PlayingScreenPacket() {
        this(InstrumentsType.HARP, DEFAULT_POS, 0, false);
    }

    private static final BlockPos DEFAULT_POS = new BlockPos(0, -2048, 0);

    public static final ResourceLocation TYPE_ID = ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing_screen_event");
    public static final Type<PlayingScreenPacket> TYPE = CustomPacketPayload.createType(TYPE_ID.toString());

    public static final StreamCodec<FriendlyByteBuf, PlayingScreenPacket> STREAM_CODEC = StreamCodec.ofMember(
            (PlayingScreenPacket packet, FriendlyByteBuf buf) -> {
                InstrumentsType.STREAM_CODEC.encode(buf, packet.pType());
                BlockPos.STREAM_CODEC.encode(buf, packet.pos());
                buf.writeInt(packet.id());
                buf.writeBoolean(packet.isOpen());
            },
            (FriendlyByteBuf buf) -> {
                InstrumentsType pType = InstrumentsType.STREAM_CODEC.decode(buf);
                BlockPos pos = BlockPos.STREAM_CODEC.decode(buf);
                int id = buf.readInt();
                boolean isOpen = buf.readBoolean();
                return new PlayingScreenPacket(pType, pos, id, isOpen);
            }
    );

    @Override
    @NotNull
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleClient(Minecraft client, ClientPacketListener handler, FriendlyByteBuf buf, PacketSender responseSender) {
        PlayingScreenPacket packet = STREAM_CODEC.decode(buf);
        client.execute(() -> {
            if (client.level != null) {
                Entity entity = client.level.getEntity(packet.id());
                if (entity instanceof Player) {
                    entity.setAttached(ModDataAttachments.PLAYING_SCREEN_DATA, packet);
                }
            }
        });
    }

    public static void handleServer(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
        PlayingScreenPacket packet = STREAM_CODEC.decode(buf);
        server.execute(() -> {
            Entity entity = player.level().getEntity(packet.id());
            if (entity instanceof Player targetPlayer) {
                targetPlayer.setAttached(ModDataAttachments.PLAYING_SCREEN_DATA, packet);
                for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
                    ServerPlayNetworking.send(serverPlayer, packet);
                }
                if (!packet.isOpen()) {
                    targetPlayer.stopUsingItem();
                    targetPlayer.setAttached(ModDataAttachments.IS_PLAYING_INSTRUMENT, false);
                    InstrumentPressingPacket pressingPacket = new InstrumentPressingPacket(packet.id(), false);
                    for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
                        ServerPlayNetworking.send(serverPlayer, pressingPacket);
                    }
                }
            }
        });
    }
}