package com.ChalkerCharles.morecolorful.network.packets;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.item.musical_instruments.InstrumentsType;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public record NotePlayingPacket(InstrumentsType pType, BlockPos pos, int keyId, boolean isBlock) implements CustomPacketPayload {

    public static final ResourceLocation TYPE_ID = ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "note_playing");
    public static final Type<NotePlayingPacket> TYPE = CustomPacketPayload.createType(MoreColorful.MODID + "note_playing");

    public static final StreamCodec<FriendlyByteBuf, NotePlayingPacket> STREAM_CODEC = StreamCodec.ofMember(
            (NotePlayingPacket packet, FriendlyByteBuf buf) -> {
                InstrumentsType.STREAM_CODEC.encode(buf, packet.pType());
                BlockPos.STREAM_CODEC.encode(buf, packet.pos());
                buf.writeInt(packet.keyId());
                buf.writeBoolean(packet.isBlock());
            },
            (FriendlyByteBuf buf) -> {
                InstrumentsType pType = InstrumentsType.STREAM_CODEC.decode(buf);
                BlockPos pos = BlockPos.STREAM_CODEC.decode(buf);
                int keyId = buf.readInt();
                boolean isBlock = buf.readBoolean();
                return new NotePlayingPacket(pType, pos, keyId, isBlock);
            }
    );

    @Override
    @NotNull
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleServer(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
        NotePlayingPacket packet = STREAM_CODEC.decode(buf);
        server.execute(() -> {
            InstrumentsType pType = packet.pType();
            BlockPos pos = packet.pos();
            int keyId = packet.keyId();
            int pitchId = keyId - 12;
            boolean isBlock = packet.isBlock();
            double random = 2 * (Math.random() - Math.random());
            double random1 = 2 * (Math.random() - Math.random());
            Level level = player.level();

            if (level instanceof ServerLevel serverLevel) {
                if (isBlock) {
                    serverLevel.playSound(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, pType.getSoundEvent().value(), SoundSource.RECORDS, 3.0F, (float) Math.pow(2, ((double) pitchId / 12)));
                    serverLevel.sendParticles(ParticleTypes.NOTE, pos.getX() + 0.5 + random, pos.getY() + 2.2, pos.getZ() + 0.5 + random1, 0, keyId / 24.0, 0.0, 0.0, 1.0); // 调整粒子参数顺序
                    serverLevel.gameEvent(player, GameEvent.INSTRUMENT_PLAY, pos);
                } else {
                    serverLevel.playSound(null, player.getX(), player.getY(), player.getZ(), pType.getSoundEvent().value(), SoundSource.RECORDS, 3.0F, (float) Math.pow(2, ((double) pitchId / 12)));
                    serverLevel.sendParticles(ParticleTypes.NOTE, player.getX() + random, player.getY() + 2.2, player.getZ() + random1, 0, keyId / 24.0, 0.0, 0.0, 1.0); // 调整粒子参数顺序
                    serverLevel.gameEvent(player, GameEvent.INSTRUMENT_PLAY, player.position());
                }
            }
        });
    }
}