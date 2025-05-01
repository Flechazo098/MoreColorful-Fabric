package com.ChalkerCharles.morecolorful.common.attachment;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.network.packets.DrumSetPacket;
import com.ChalkerCharles.morecolorful.network.packets.PlayingScreenPacket;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ModDataAttachments {
    public static final AttachmentType<Boolean> IS_PLAYING_INSTRUMENT = AttachmentRegistry.createDefaulted(
            ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "is_playing_instrument"),
            () -> false);

    public static final AttachmentType<PlayingScreenPacket> PLAYING_SCREEN_DATA = AttachmentRegistry.createDefaulted(
            ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing_screen_data"),
            PlayingScreenPacket::new);

    public static final AttachmentType<Float> PLAYING_SCREEN_TICK = AttachmentRegistry.createDefaulted(
            ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing_screen_tick"),
            () -> 0F);

    public static final AttachmentType<DrumSetPacket> DRUM_SET_DATA = AttachmentRegistry.createDefaulted(
            ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "drum_set_data"),
            DrumSetPacket::new);

    public static final AttachmentType<ChunkData> CHUNK_DATA = AttachmentRegistry.<ChunkData>builder()
            .initializer(ChunkData::new)
            .buildAndRegister(ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "chunk_data"));
    public static void setDrumSetData(Entity entity, DrumSetPacket packet) {
        entity.setAttached(DRUM_SET_DATA, packet);
    }
    public static boolean isPlayingInstrument(LivingEntity entity) {
        return Boolean.TRUE.equals(entity.getAttached(IS_PLAYING_INSTRUMENT));
    }

    public static void setPlayingInstrument(LivingEntity entity, boolean playing) {
        entity.setAttached(IS_PLAYING_INSTRUMENT, playing);
    }

    public static void init () {
    }
}