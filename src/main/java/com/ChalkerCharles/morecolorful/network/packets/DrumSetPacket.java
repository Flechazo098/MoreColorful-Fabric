package com.ChalkerCharles.morecolorful.network.packets;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.attachment.ModDataAttachments;
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

public class DrumSetPacket implements CustomPacketPayload {
    private static final BlockPos DEFAULT_POS = new BlockPos(0, -2048, 0);
    public static final ResourceLocation TYPE_ID = ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "drum_set_event");
    public static final Type<DrumSetPacket> TYPE = CustomPacketPayload.createType(MoreColorful.MODID + "drum_set_event");
    public static final StreamCodec<FriendlyByteBuf, DrumSetPacket> STREAM_CODEC = StreamCodec.ofMember(DrumSetPacket::write, DrumSetPacket::read);

    private final boolean isPressingBassDrum;
    private final boolean isPressingHat;
    private final boolean isPressingRide;
    private final boolean isPressingCrash;
    private final BlockPos pos;
    private final int id;


    public DrumSetPacket(boolean isPressingBassDrum, boolean isPressingHat, boolean isPressingRide, boolean isPressingCrash, BlockPos pos, int id) {
        this.isPressingBassDrum = isPressingBassDrum;
        this.isPressingHat = isPressingHat;
        this.isPressingRide = isPressingRide;
        this.isPressingCrash = isPressingCrash;
        this.pos = pos;
        this.id = id;
    }

    public DrumSetPacket() {
        this(false, false, false, false, DEFAULT_POS, 0);
    }

    // 从缓冲区读取数据
    public static DrumSetPacket read(FriendlyByteBuf buf) {
        boolean isPressingBassDrum = buf.readBoolean();
        boolean isPressingHat = buf.readBoolean();
        boolean isPressingRide = buf.readBoolean();
        boolean isPressingCrash = buf.readBoolean();
        BlockPos pos = buf.readBlockPos();
        int id = buf.readInt();
        return new DrumSetPacket(isPressingBassDrum, isPressingHat, isPressingRide, isPressingCrash, pos, id);
    }

    // 将数据写入缓冲区
    public void write(FriendlyByteBuf buf) {
        buf.writeBoolean(isPressingBassDrum);
        buf.writeBoolean(isPressingHat);
        buf.writeBoolean(isPressingRide);
        buf.writeBoolean(isPressingCrash);
        buf.writeBlockPos(pos);
        buf.writeInt(id);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // 客户端处理逻辑
    public static void handleClient(Minecraft client, ClientPacketListener handler, FriendlyByteBuf buf, PacketSender responseSender) {
        DrumSetPacket packet = read(buf);
        client.execute(() -> {
            if (client.level != null) {
                Entity entity = client.level.getEntity(packet.id);
                if (entity instanceof Player) {
                    ModDataAttachments.setDrumSetData(entity, packet);
                }
            }
        });
    }

    // 服务端处理逻辑
    public static void handleServer(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
        DrumSetPacket packet = read(buf);
        server.execute(() -> {
            Entity entity = player.level().getEntity(packet.id);
            if (entity instanceof Player) {
                ModDataAttachments.setDrumSetData(entity, packet);
                // 向所有玩家广播
                for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
                    ServerPlayNetworking.send(serverPlayer, packet);
                }
            }
        });
    }

    // Getter方法
    public boolean isPressingBassDrum() {
        return isPressingBassDrum;
    }

    public boolean isPressingHat() {
        return isPressingHat;
    }

    public boolean isPressingRide() {
        return isPressingRide;
    }

    public boolean isPressingCrash() {
        return isPressingCrash;
    }

    public BlockPos pos() {
        return pos;
    }

    public int id() {
        return id;
    }
}