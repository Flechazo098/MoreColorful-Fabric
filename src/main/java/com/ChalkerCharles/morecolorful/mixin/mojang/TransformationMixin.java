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
package com.ChalkerCharles.morecolorful.mixin.mojang;

import com.ChalkerCharles.morecolorful.util.mixin.TransformationExtensions;
import com.mojang.math.Transformation;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Transformation.class)
public abstract class TransformationMixin implements TransformationExtensions {

    @Shadow
    public abstract Matrix4f getMatrix();

    @Override
    public Transformation applyOrigin(Vector3f origin) {
        if (isIdentity()) return Transformation.identity();

        Matrix4f ret = this.getMatrix();
        Matrix4f tmp = new Matrix4f().translation(origin.x(), origin.y(), origin.z());
        tmp.mul(ret, ret);
        tmp.translation(-origin.x(), -origin.y(), -origin.z());
        ret.mul(tmp);
        return new Transformation(ret);
    }
}
