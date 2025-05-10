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
package com.ChalkerCharles.morecolorful.util.mixin;

import com.mojang.math.Transformation;
import org.joml.Vector3f;

public interface TransformationExtensions {
    /**
     * Apply this transformation to a different origin.
     * Can be used for switching between coordinate systems.
     * Parameter is relative to the current origin.
     */
    default Transformation applyOrigin(Vector3f origin) {
        throw new RuntimeException("this should be overridden via mixin. what?");
    }

    default boolean isIdentity() {
        return this.equals(Transformation.identity());
    }
}
