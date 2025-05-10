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

import java.util.Set;
import java.util.function.Function;

import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;

/**
 * General interface for any model that can be baked, superset of vanilla {@link UnbakedModel}.
 * <p>
 * Instances of this class ar usually created via {@link IGeometryLoader}.
 *
 * @see IGeometryLoader
 * @see BlockModel
 */
public interface IUnbakedGeometry<T extends IUnbakedGeometry<T>> {
    BakedModel bake(
            BlockModel context, ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter,
            ModelState modelState, ItemOverrides overrides, ResourceLocation modelLocation, boolean isGui3d
    );

    /**
     * Resolve parents of nested {@link BlockModel}s which are later used in
     * {@link IUnbakedGeometry#bake(BlockModel, ModelBaker, Function, ModelState, ItemOverrides, ResourceLocation, boolean)}
     * via {@link BlockModel#resolveParents(Function)}
     */
    default void resolveParents(Function<ResourceLocation, UnbakedModel> modelGetter, BlockModel context) {

    }

    /**
     * {@return a set of all the components whose visibility may be configured via {@link BlockModel}}
     */
    default Set<String> getConfigurableComponentNames() {
        return Set.of();
    }
}