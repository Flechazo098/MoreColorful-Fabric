package com.ChalkerCharles.morecolorful.network.packets;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.level.LevelThermalEngine;
import com.ChalkerCharles.morecolorful.util.mixin.ILevelExtension;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.SectionPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import org.jetbrains.annotations.NotNull;

public record ThermalRemovalPacket(ChunkPos pos) implements CustomPacketPayload {

    public static final ResourceLocation TYPE_ID = ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "thermal_removal");
    public static final Type<ThermalRemovalPacket> TYPE = CustomPacketPayload.createType(TYPE_ID.toString());

    public static final StreamCodec<FriendlyByteBuf, ThermalRemovalPacket> STREAM_CODEC = StreamCodec.of(
            (FriendlyByteBuf buf, ThermalRemovalPacket packet) -> {
                buf.writeInt(packet.pos().x);
                buf.writeInt(packet.pos().z);
            },
            (FriendlyByteBuf buf) -> {
                int x = buf.readInt();
                int z = buf.readInt();
                return new ThermalRemovalPacket(new ChunkPos(x, z));
            }
    );

    @Override
    @NotNull
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleClient(Minecraft client, ClientPacketListener handler, FriendlyByteBuf buf, PacketSender responseSender) {
        ThermalRemovalPacket packet = STREAM_CODEC.decode(buf);
        client.execute(() -> {
            ClientLevel level = client.level;
            if (level != null) {
                queueThermalRemoval(packet.pos(), level);
            }
        });
    }

    private static void queueThermalRemoval(ChunkPos pos, ClientLevel level) {
        ((ILevelExtension) level).moreColorful$queueThermalUpdate(() -> {
            LevelThermalEngine thermalEngine = ((ILevelExtension) level).moreColorful$getThermalEngine();
            thermalEngine.setThermalEnabled(pos, false);

            int minSection = thermalEngine.getMinThermalSection();
            int maxSection = thermalEngine.getMaxThermalSection();
            for (int i = minSection; i < maxSection; i++) {
                SectionPos sectionpos = SectionPos.of(pos, i);
                thermalEngine.queueSectionData(sectionpos, null);
            }

            int levelMinSection = level.getMinSection();
            int levelMaxSection = level.getMaxSection();
            for (int j = levelMinSection; j < levelMaxSection; j++) {
                thermalEngine.updateSectionStatus(SectionPos.of(pos, j), true);
            }
        });
    }
}