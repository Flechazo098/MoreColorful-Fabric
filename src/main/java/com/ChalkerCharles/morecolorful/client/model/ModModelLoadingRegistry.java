/**
 * PortingLibModelLoadingRegistry.java
 *
 * Part of Porting Lib: A collection of utilities for porting mods from Forge to Fabric.
 *
 * This enum serves as the central registry for custom model loaders. It implements
 * Fabric's `ModelLoadingPlugin` to hook into the model loading process and provides
 * utilities to fetch raw model JSON resources and delegate parsing to registered
 * `ModelLoader` instances.
 *
 * Porting Lib License:
 * Porting Lib: A collection of utilities for porting mods from Forge to Fabric.
 *
 * Copyright (C) The Fabricators of Create
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * Contact: create-fabric@protonmail.com
 */
package com.ChalkerCharles.morecolorful.client.model;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.renderer.v1.material.RenderMaterial;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum ModModelLoadingRegistry implements ModelLoadingPlugin {
    INSTANCE;

    /** Map of model ID → custom ModelLoader implementation */
    public static final Map<ResourceLocation, ModelLoader> LOADERS = new HashMap<>();

    /** GSON instance for block model parsing, with custom RenderMaterial deserializer registered */
    public static final Gson GSON = BlockModel.GSON
            .newBuilder()
            .registerTypeAdapter(RenderMaterial.class, new RenderMaterialDeserializer())
            .create();

    @Override
    public void onInitializeModelLoader(Context ctx) {
        // Register custom loaders here, e.g.:
        // LOADERS.put(new ResourceLocation("modid", "your_model"), new YourModelLoader());
    }

    /**
     * Retrieve a reader for the raw JSON of the model at the given resource location.
     * Converts from model ID (namespace:path) to JSON file path under assets.
     *
     * @param location resource location of the model (e.g. "minecraft:block/stone")
     * @return BufferedReader for the model JSON file
     * @throws IOException           on I/O errors reading the resource
     * @throws FileNotFoundException if the model JSON file cannot be found
     */
    public static BufferedReader getModelJson(ResourceLocation location) throws IOException {
        ResourceLocation file = ResourceLocation.fromNamespaceAndPath(
                location.getNamespace(),
                "models/" + location.getPath() + ".json"
        );
        Optional<Resource> resource = Minecraft.getInstance()
                .getResourceManager()
                .getResource(file);

        return resource
                .orElseThrow(() -> new FileNotFoundException(file.toString()))
                .openAsReader();
    }
}
