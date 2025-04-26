package com.ChalkerCharles.morecolorful.common.level;

import com.ChalkerCharles.morecolorful.Config;
import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.attachment.ChunkData;
import com.ChalkerCharles.morecolorful.mixin.accessor.IChunkStatusMixin;
import com.ChalkerCharles.morecolorful.util.mixin.IProtoChunkExtension;
import com.ChalkerCharles.morecolorful.util.mixin.IWorldGenContextExtension;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.GenerationChunkHolder;
import net.minecraft.util.StaticCache2D;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.chunk.status.ChunkStep;
import net.minecraft.world.level.chunk.status.ChunkType;
import net.minecraft.world.level.chunk.status.WorldGenContext;
import net.minecraft.core.Registry;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModChunkStatus {
    public static final ChunkStatus INITIALIZE_THERMAL = registerChunkStatus("initialize_thermal", create(ChunkStatus.SPAWN));
    public static final ChunkStatus THERMAL = registerChunkStatus("thermal", create(INITIALIZE_THERMAL));

    private static ChunkStatus create(@Nullable ChunkStatus parent) {
        return IChunkStatusMixin.create(parent, ChunkStatus.FINAL_HEIGHTMAPS, ChunkType.PROTOCHUNK);
    }

    private static ChunkStatus registerChunkStatus(String name, ChunkStatus status) {
        return Registry.register(Registries.CHUNK_STATUS, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, name), status);
    }

    private static boolean isThermalized(ChunkAccess chunk) {
        return chunk.getPersistedStatus().isOrAfter(THERMAL) && ChunkData.isThermalCorrect(chunk);
    }

    public static CompletableFuture<ChunkAccess> initializeThermal(WorldGenContext worldGenContext, ChunkStep ignoredStep, StaticCache2D<GenerationChunkHolder> ignoredCache, ChunkAccess chunk) {
        ThreadedLevelThermalEngine thermalEngine = ((IWorldGenContextExtension) (Object) worldGenContext).moreColorful$getThermalEngine();
        ((IProtoChunkExtension) chunk).moreColorful$setThermalEngine(thermalEngine);
        boolean flag = isThermalized(chunk);
        return thermalEngine.initializeThermal(chunk, flag);
    }

    public static CompletableFuture<ChunkAccess> thermal(WorldGenContext worldGenContext, ChunkStep ignoredStep, StaticCache2D<GenerationChunkHolder> ignoredCache, ChunkAccess chunk) {
        boolean flag = isThermalized(chunk);
        return ((IWorldGenContextExtension) (Object) worldGenContext).moreColorful$getThermalEngine().thermalChunk(chunk, flag);
    }

    public static void modifyFullStatus() {
        if (Config.isThermalSystemEnabled()) {
            ((IChunkStatusMixin) ChunkStatus.FULL).setParent(THERMAL);
            ((IChunkStatusMixin) ChunkStatus.FULL).setIndex(ChunkStatus.FULL.getIndex() + 2);
        }
    }

}
