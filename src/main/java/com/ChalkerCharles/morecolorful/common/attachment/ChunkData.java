package com.ChalkerCharles.morecolorful.common.attachment;

import com.ChalkerCharles.morecolorful.Config;
import com.ChalkerCharles.morecolorful.common.level.LevelThermalEngine;
import com.ChalkerCharles.morecolorful.common.level.ModChunkStatus;
import com.ChalkerCharles.morecolorful.util.mixin.ChunkLevelGetter;
import com.ChalkerCharles.morecolorful.util.mixin.IChunkSourceExtension;
import com.ChalkerCharles.morecolorful.util.mixin.IProtoChunkExtension;
import net.fabricmc.fabric.api.attachment.v1.AttachmentTarget;
import net.minecraft.core.SectionPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkSource;
import net.minecraft.world.level.chunk.DataLayer;
import net.minecraft.world.level.chunk.ProtoChunk;
import net.minecraft.world.level.chunk.status.ChunkStatus;

/**
 * Stores per-chunk metadata used by the thermal system.
 * This class is attached to each chunk via the Fabric attachment API,
 * and handles serialization/deserialization of thermal data layers.
 *
 * This includes managing per-section block temperature data
 * and whether a chunk has been properly thermal-initialized.
 */
public final class ChunkData {
    private final ChunkAccess chunk;
    private volatile boolean isThermalOn;

    /**
     * Default constructor for deserialization.
     */
    public ChunkData() {
        this.chunk = null;
    }

    /**
     * Constructs ChunkData with the associated chunk.
     *
     * @param holder the chunk holding this attachment
     */
    public ChunkData(AttachmentTarget holder) {
        this.chunk = (ChunkAccess) holder;
    }

    /**
     * Gets the attached ChunkData from a chunk.
     *
     * @param chunk the chunk to access
     * @return the attached ChunkData
     */
    private static ChunkData get(ChunkAccess chunk) {
        return chunk.getAttached(ModDataAttachments.CHUNK_DATA);
    }

    /**
     * Checks if the chunk has completed thermal initialization.
     *
     * @param chunk the chunk to check
     * @return true if thermal is correct
     */
    public static boolean isThermalCorrect(ChunkAccess chunk) {
        ChunkData chunkData = get(chunk);
        return chunkData != null && chunkData.isThermalOn;
    }

    /**
     * Sets the thermal correctness flag.
     *
     * @param correct true if thermal is initialized
     */
    private void setThermalCorrect(boolean correct) {
        this.isThermalOn = correct;
        this.chunk.setUnsaved(true);
    }

    /**
     * Sets whether the chunk is thermally initialized.
     *
     * @param chunk the target chunk
     * @param correct true if initialized
     */
    public static void setThermalCorrect(ChunkAccess chunk, boolean correct) {
        ChunkData chunkData = get(chunk);
        if (chunkData != null) {
            chunkData.setThermalCorrect(correct);
        }
    }

    /**
     * Serializes the thermal metadata and data layers into NBT.
     *
     * @return a CompoundTag containing the data
     */
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        if (!Config.isThermalSystemEnabled() || this.chunk == null) return nbt;

        ListTag temperatures = new ListTag();
        ServerLevel level = (ServerLevel) ((ChunkLevelGetter) this.chunk).moreColorful_Fabric$getLevel();
        ChunkPos chunkpos = this.chunk.getPos();

        nbt.putString("status", BuiltInRegistries.CHUNK_STATUS.getKey(this.chunk.getPersistedStatus()).toString());

        if (level != null) {
            LevelThermalEngine thermalEngine = ((IChunkSourceExtension) level.getChunkSource()).moreColorful$getThermalEngine();
            for (int i = thermalEngine.getMinThermalSection(); i < thermalEngine.getMaxThermalSection(); i++) {
                DataLayer dataLayer = thermalEngine.getLayerListener().getDataLayerData(SectionPos.of(chunkpos, i));
                if (dataLayer != null) {
                    CompoundTag compoundTag = new CompoundTag();
                    if (!dataLayer.isEmpty()) {
                        compoundTag.putByteArray("temperature", dataLayer.getData());
                    }
                    if (!compoundTag.isEmpty()) {
                        compoundTag.putByte("Y", (byte) i);
                        temperatures.add(compoundTag);
                    }
                }
            }
        }

        nbt.put("blockTemperatures", temperatures);
        if (this.isThermalOn) {
            nbt.putBoolean("isThermalOn", true);
        }
        return nbt;
    }

    /**
     * Deserializes the thermal data from NBT and re-applies it to the thermal system.
     *
     * @param nbt the serialized chunk data
     */
    public void deserializeNBT(CompoundTag nbt) {
        if (!Config.isThermalSystemEnabled() || this.chunk == null) return;

        ServerLevel level = (ServerLevel) ((ChunkLevelGetter) this.chunk).moreColorful_Fabric$getLevel();
        ChunkPos chunkpos = this.chunk.getPos();

        if (level != null) {
            ChunkSource chunksource = level.getChunkSource();
            LevelThermalEngine thermalEngine = ((IChunkSourceExtension) chunksource).moreColorful$getThermalEngine();
            ListTag temperatures = nbt.getList("blockTemperatures", Tag.TAG_COMPOUND);

            boolean flag = false;
            for (int i = 0; i < temperatures.size(); i++) {
                CompoundTag compoundTag = temperatures.getCompound(i);
                int y = compoundTag.getByte("Y");
                boolean flag1 = compoundTag.contains("temperature", Tag.TAG_BYTE_ARRAY);
                if (flag1) {
                    if (!flag) {
                        thermalEngine.retainData(chunkpos, true);
                        flag = true;
                    }
                    thermalEngine.queueSectionData(SectionPos.of(chunkpos, y), new DataLayer(compoundTag.getByteArray("temperature")));
                }
            }

            if (this.chunk instanceof ProtoChunk protoChunk) {
                ChunkStatus chunkstatus = ChunkStatus.byName(nbt.getString("status"));
                if (chunkstatus.isOrAfter(ModChunkStatus.INITIALIZE_THERMAL)) {
                    ((IProtoChunkExtension) protoChunk).moreColorful$setThermalEngine(thermalEngine);
                }
            }
        }

        boolean flag = nbt.getBoolean("isThermalOn");
        this.setThermalCorrect(flag);
    }
}
