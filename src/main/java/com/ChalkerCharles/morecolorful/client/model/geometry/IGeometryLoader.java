/**
 * IGeometryLoader.java
 *
 * Part of Porting Lib: A collection of utilities for porting mods from Forge to Fabric.
 *
 * This interface defines a loader for custom {@linkplain IUnbakedGeometry model geometries}.
 * Implementations should parse their JSON geometry definitions and return an instance
 * of the corresponding unbaked geometry type.
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
package com.ChalkerCharles.morecolorful.client.model.geometry;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public interface IGeometryLoader<T extends IUnbakedGeometry<T>> {
    /**
     * Read and construct an unbaked geometry instance from the provided JSON.
     *
     * @param jsonObject            the JSON definition of the geometry
     * @param deserializationContext context for nested deserialization
     * @return a new geometry instance of type T
     * @throws JsonParseException if the JSON is invalid or missing required fields
     */
    T read(JsonObject jsonObject, JsonDeserializationContext deserializationContext) throws JsonParseException;
}
