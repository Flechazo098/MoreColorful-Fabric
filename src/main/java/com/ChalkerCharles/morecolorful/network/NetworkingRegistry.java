package com.ChalkerCharles.morecolorful.network;

import com.ChalkerCharles.morecolorful.network.packets.*;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;

public class NetworkingRegistry {
    private void registerPacketTypes () {
        PayloadTypeRegistry.playC2S().register(NotePlayingPacket.TYPE, NotePlayingPacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(PlayingScreenPacket.TYPE, PlayingScreenPacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(InstrumentPressingPacket.TYPE, InstrumentPressingPacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(InstrumentTickingPacket.TYPE, InstrumentTickingPacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(DrumSetPacket.TYPE, DrumSetPacket.STREAM_CODEC);

        PayloadTypeRegistry.playS2C().register(PlayingScreenPacket.TYPE, PlayingScreenPacket.STREAM_CODEC);
        PayloadTypeRegistry.playS2C().register(InstrumentPressingPacket.TYPE, InstrumentPressingPacket.STREAM_CODEC);
        PayloadTypeRegistry.playS2C().register(InstrumentTickingPacket.TYPE, InstrumentTickingPacket.STREAM_CODEC);
        PayloadTypeRegistry.playS2C().register(DrumSetPacket.TYPE, DrumSetPacket.STREAM_CODEC);
        PayloadTypeRegistry.playS2C().register(ThermalUpdatePacket.TYPE, ThermalUpdatePacket.STREAM_CODEC);
        PayloadTypeRegistry.playS2C().register(ThermalRemovalPacket.TYPE, ThermalRemovalPacket.STREAM_CODEC);
    }

    private void registerServerReceivers() {
        ServerPlayNetworking.registerGlobalReceiver(NotePlayingPacket.TYPE,
                (payload, context) -> {
                    FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
                    NotePlayingPacket.STREAM_CODEC.encode(buf, payload);
                    NotePlayingPacket.handleServer(
                            context.server(), context.player(), context.player().connection,
                            buf, context.responseSender());
                });

        ServerPlayNetworking.registerGlobalReceiver(PlayingScreenPacket.TYPE,
                (payload, context) -> {
                    FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
                    PlayingScreenPacket.STREAM_CODEC.encode(buf, payload);
                    PlayingScreenPacket.handleServer(
                            context.server(), context.player(), context.player().connection,
                            buf, context.responseSender());
                });

        ServerPlayNetworking.registerGlobalReceiver(InstrumentPressingPacket.TYPE,
                (payload, context) -> {
                    FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
                    InstrumentPressingPacket.STREAM_CODEC.encode(buf, payload);
                    InstrumentPressingPacket.handleServer(
                            context.server(), context.player(), context.player().connection,
                            buf, context.responseSender());
                });

        ServerPlayNetworking.registerGlobalReceiver(InstrumentTickingPacket.TYPE,
                (payload, context) -> {
                    FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
                    InstrumentTickingPacket.STREAM_CODEC.encode(buf, payload);
                    InstrumentTickingPacket.handleServer(
                            context.server(), context.player(), context.player().connection,
                            buf, context.responseSender());
                });

        ServerPlayNetworking.registerGlobalReceiver(DrumSetPacket.TYPE,
                (payload, context) -> {
                    FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
                    DrumSetPacket.STREAM_CODEC.encode(buf, payload);
                    DrumSetPacket.handleServer(
                            context.server(), context.player(), context.player().connection,
                            buf, context.responseSender());
                });
    }

    private void registerClientReceivers() {
        ClientPlayNetworking.registerGlobalReceiver(PlayingScreenPacket.TYPE,
                (payload, context) -> {
                    FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
                    PlayingScreenPacket.STREAM_CODEC.encode(buf, payload);
                    PlayingScreenPacket.handleClient(
                            context.client(), context.client().getConnection(),
                            buf, context.responseSender());
                });

        ClientPlayNetworking.registerGlobalReceiver(InstrumentPressingPacket.TYPE,
                (payload, context) -> {
                    FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
                    InstrumentPressingPacket.STREAM_CODEC.encode(buf, payload);
                    InstrumentPressingPacket.handleClient(
                            context.client(), context.client().getConnection(),
                            buf, context.responseSender());
                });

        ClientPlayNetworking.registerGlobalReceiver(InstrumentTickingPacket.TYPE,
                (payload, context) -> {
                    FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
                    InstrumentTickingPacket.STREAM_CODEC.encode(buf, payload);
                    InstrumentTickingPacket.handleClient(
                            context.client(), context.client().getConnection(),
                            buf, context.responseSender());
                });

        ClientPlayNetworking.registerGlobalReceiver(DrumSetPacket.TYPE,
                (payload, context) -> {
                    FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
                    DrumSetPacket.STREAM_CODEC.encode(buf, payload);
                    DrumSetPacket.handleClient(
                            context.client(), context.client().getConnection(),
                            buf, context.responseSender());
                });

        ClientPlayNetworking.registerGlobalReceiver(ThermalUpdatePacket.TYPE,
                (payload, context) -> {
                    FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
                    ThermalUpdatePacket.STREAM_CODEC.encode(buf, payload);
                    ThermalUpdatePacket.handleClient(
                            context.client(), context.client().getConnection(),
                            buf, context.responseSender());
                });

        ClientPlayNetworking.registerGlobalReceiver(ThermalRemovalPacket.TYPE,
                (payload, context) -> {
                    FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
                    ThermalRemovalPacket.STREAM_CODEC.encode(buf, payload);
                    ThermalRemovalPacket.handleClient(
                            context.client(), context.client().getConnection(),
                            buf, context.responseSender());
                });
    }

    public void register () {
        registerPacketTypes();
        registerClientReceivers();
    }
}