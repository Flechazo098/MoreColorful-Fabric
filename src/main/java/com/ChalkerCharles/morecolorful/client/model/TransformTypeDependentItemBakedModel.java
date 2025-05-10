/**
 * TransformTypeDependentItemBakedModel.java
 *
 * Part of Porting Lib: A collection of utilities for porting mods from Forge to Fabric.
 *
 * This interface defines a contract for item models that require custom transformations
 * based on the display context (e.g., first-person, third-person, GUI) and whether the item
 * is held in the left or right hand. It also provides a static utility method to unwrap
 * Fabric renderer model wrappers and conditionally apply these context-dependent transforms.
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

import net.fabricmc.fabric.api.renderer.v1.model.WrapperBakedModel;

import org.jetbrains.annotations.ApiStatus.OverrideOnly;
import org.jetbrains.annotations.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;

public interface TransformTypeDependentItemBakedModel {
    /**
     * Applies a transform for the given {@link ItemDisplayContext} and {@code leftHand}, and
     * returns the model to be rendered.
     * {@link #maybeApplyTransform(BakedModel, ItemDisplayContext, PoseStack, boolean, DefaultTransform)} should always be used, do not call directly.
     * @param leftHand true if this item is being rendered in the player's left hand
     * @param defaultTransform a callback which will apply the vanilla transformation on
     */
    @OverrideOnly
    BakedModel applyTransform(ItemDisplayContext context, PoseStack poseStack, boolean leftHand, DefaultTransform defaultTransform);

    /**
     * Attempt to apply a custom transform from the given model, unwrapping wrappers if needed.
     * Does nothing if not a {@link TransformTypeDependentItemBakedModel}.
     * @return null if no transformation occurred, otherwise the transformed model
     */
    @Nullable
    static BakedModel maybeApplyTransform(BakedModel model, ItemDisplayContext context, PoseStack poseStack, boolean leftHand, DefaultTransform defaultTransform) {
        if (model instanceof TransformTypeDependentItemBakedModel transformer)
            return transformer.applyTransform(context, poseStack, leftHand, defaultTransform);

        BakedModel wrapped = model;
        while (wrapped instanceof WrapperBakedModel wrapper) {
            wrapped = wrapper.getWrappedModel();
            if (wrapped == null) {
                return null;
            } else if (wrapped instanceof TransformTypeDependentItemBakedModel transformer) {
                return transformer.applyTransform(context, poseStack, leftHand, defaultTransform);
            }
        }

        return null;
    }

    @FunctionalInterface
    interface DefaultTransform {
        void apply(BakedModel model);
    }
}