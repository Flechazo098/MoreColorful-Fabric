package com.ChalkerCharles.morecolorful.client.model;

import com.ChalkerCharles.morecolorful.MoreColorful;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class ModModelLayers {

    public static final ModelLayerLocation RIDE_CYMBAL = register("ride_cymbal");
    public static final ModelLayerLocation CRASH_CYMBAL = register("crash_cymbal");
    public static final ModelLayerLocation DRUM_SET_RIDE = register("drum_set_ride");
    public static final ModelLayerLocation DRUM_SET_CRASH = register("drum_set_crash");

    private static ModelLayerLocation register(String pPath) {
        return register(pPath, "main");
    }
    @SuppressWarnings("SameParameterValue")
    private static ModelLayerLocation register(String pPath, String pModel) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, pPath), pModel);
    }
}
