/**
 * ModelLoader.java
 *
 * Part of Porting Lib: A collection of utilities for porting mods from Forge to Fabric.
 *
 * This interface defines a simple contract for loading custom unbaked block/item models
 * from JSON, given a parent `BlockModel`. Implementations should parse the provided JSON
 * and return an appropriate `UnbakedModel` instance for rendering.
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

import com.google.gson.JsonObject;

import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.UnbakedModel;

public interface ModelLoader {
    /**
     * Reads and constructs an unbaked model from the provided JSON object,
     * using the given parent `BlockModel` as context or fallback.
     *
     * @param parent      the parent BlockModel, may be used for inheritance of textures or elements
     * @param jsonObject  the raw JSON definition of the custom model
     * @return an UnbakedModel instance representing the custom model
     */
    UnbakedModel readModel(BlockModel parent, JsonObject jsonObject);
}
