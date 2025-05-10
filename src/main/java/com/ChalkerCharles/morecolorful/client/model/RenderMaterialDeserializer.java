/**
 * RenderMaterialDeserializer.java
 *
 * Part of Porting Lib: A collection of utilities for porting mods from Forge to Fabric.
 *
 * This class implements a custom GSON deserializer for Fabric Renderer
 * `RenderMaterial`. It reads JSON definitions of render material properties
 * (blend modes, color index disabling, diffuse/AO toggles, emissiveness)
 * and applies them per-sprite-index via the Fabric Rendering API’s MaterialFinder.
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

import java.lang.reflect.Type;
import java.util.function.BiConsumer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.material.MaterialFinder;
import net.fabricmc.fabric.api.renderer.v1.material.RenderMaterial;

public class RenderMaterialDeserializer implements JsonDeserializer<RenderMaterial> {
    @Override
    public RenderMaterial deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Renderer renderer = RendererAccess.INSTANCE.getRenderer();
        if (renderer == null)
            throw new JsonParseException("The Fabric Rendering API is not available. If you have Sodium, install Indium!");

        MaterialFinder finder = renderer.materialFinder();
        JsonObject obj = json.getAsJsonObject();

//        forEachSpriteIndex(obj, "blendMode", (idx, elt) ->
//                finder.blendMode(idx,
//                        BlendMode.fromRenderLayer(
//                                RenderTypeUtil.get(ResourceLocation.parse(elt.getAsString()))
//                        )
//                )
//        );
        forEachSpriteIndex(obj, "disableColorIndex", (idx, elt) ->
                finder.disableColorIndex(idx, elt.getAsBoolean())
        );
        forEachSpriteIndex(obj, "disableDiffuse", (idx, elt) ->
                finder.disableDiffuse(idx, elt.getAsBoolean())
        );
        forEachSpriteIndex(obj, "disableAo", (idx, elt) ->
                finder.disableAo(idx, elt.getAsBoolean())
        );
        forEachSpriteIndex(obj, "emissive", (idx, elt) ->
                finder.emissive(idx, elt.getAsBoolean())
        );

        return finder.find();
    }

    private void forEachSpriteIndex(JsonObject obj, String key, BiConsumer<Integer, JsonElement> matFunc) {
        if (obj.has(key)) {
            JsonArray array = obj.getAsJsonArray(key);
            for (int i = 0; i < array.size(); i++) {
                matFunc.accept(i, array.get(i));
            }
        }
    }
}
