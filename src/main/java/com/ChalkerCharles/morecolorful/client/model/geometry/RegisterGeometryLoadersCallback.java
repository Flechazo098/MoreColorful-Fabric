/*
 * Part of Porting Lib: A collection of utilities for porting mods from Forge to Fabric.
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

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;


/**
 * Allows users to register their own {@link IGeometryLoader geometry loaders}
 * for use in block/item model JSONs under the "loader" key.
 * <p>
 * This interface mimics Forge's {@code ModelEvent.RegisterGeometryLoaders}
 * and is used during model loading to allow mods to define custom rendering logic.
 */
public interface RegisterGeometryLoadersCallback {
    Event<RegisterGeometryLoadersCallback> EVENT = EventFactory.createArrayBacked(RegisterGeometryLoadersCallback.class, callbacks -> loaders -> {
        for (RegisterGeometryLoadersCallback e : callbacks)
            e.registerGeometryLoaders(loaders);
    });

    void registerGeometryLoaders(Map<ResourceLocation, IGeometryLoader<?>> loaders);
}
