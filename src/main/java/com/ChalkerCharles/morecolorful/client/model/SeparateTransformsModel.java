package com.ChalkerCharles.morecolorful.client.model;

import com.ChalkerCharles.morecolorful.client.model.geometry.IGeometryLoader;
import com.ChalkerCharles.morecolorful.client.model.geometry.IUnbakedGeometry;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.Set;
import java.util.Collections;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/**
 * A model composed of multiple sub-models which are picked based on the {@link ItemDisplayContext} being used.
 */
public class SeparateTransformsModel implements IUnbakedGeometry<SeparateTransformsModel> {
    private final BlockModel baseModel;
    private final ImmutableMap<ItemDisplayContext, BlockModel> perspectives;

    public SeparateTransformsModel(BlockModel baseModel, ImmutableMap<ItemDisplayContext, BlockModel> perspectives) {
        this.baseModel = baseModel;
        this.perspectives = perspectives;
    }

    @Override
    public BakedModel bake(BlockModel context, ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter,
                           ModelState modelState, ItemOverrides overrides,ResourceLocation resourceLocation, boolean isGui3d) {
        return new Baked(
                context.hasAmbientOcclusion(), isGui3d, context.getGuiLight().lightLikeBlock(),
                spriteGetter.apply(context.getMaterial("particle")), overrides,
                baseModel.bake(baker, baseModel, spriteGetter, modelState, context.getGuiLight().lightLikeBlock()),
                ImmutableMap.copyOf(Maps.transformValues(perspectives, value -> value.bake(baker, value, spriteGetter, modelState, value.getGuiLight().lightLikeBlock()))));
    }


    @Override
    public void resolveParents(Function<ResourceLocation, UnbakedModel> modelGetter, BlockModel context) {
        baseModel.resolveParents(modelGetter);
        perspectives.values().forEach(model -> model.resolveParents(modelGetter));
    }

    @Override
    public Set<String> getConfigurableComponentNames() {
        return Collections.emptySet();
    }

    public static class Baked implements BakedModel, TransformTypeDependentItemBakedModel {
        private final boolean isAmbientOcclusion;
        private final boolean isGui3d;
        private final boolean isSideLit;
        private final TextureAtlasSprite particle;
        private final ItemOverrides overrides;
        private final BakedModel baseModel;
        private final ImmutableMap<ItemDisplayContext, BakedModel> perspectives;

        public Baked(boolean isAmbientOcclusion, boolean isGui3d, boolean isSideLit, TextureAtlasSprite particle, 
                    ItemOverrides overrides, BakedModel baseModel, ImmutableMap<ItemDisplayContext, BakedModel> perspectives) {
            this.isAmbientOcclusion = isAmbientOcclusion;
            this.isGui3d = isGui3d;
            this.isSideLit = isSideLit;
            this.particle = particle;
            this.overrides = overrides;
            this.baseModel = baseModel;
            this.perspectives = perspectives;
        }

        @Override
        public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, RandomSource rand) {
            return baseModel.getQuads(state, side, rand);
        }

        @Override
        public boolean useAmbientOcclusion() {
            return isAmbientOcclusion;
        }

        @Override
        public boolean isGui3d() {
            return isGui3d;
        }

        @Override
        public boolean usesBlockLight() {
            return isSideLit;
        }

        @Override
        public boolean isCustomRenderer() {
            return false;
        }

        @Override
        public TextureAtlasSprite getParticleIcon() {
            return particle;
        }

        @Override
        public ItemOverrides getOverrides() {
            return overrides;
        }

        @Override
        public ItemTransforms getTransforms() {
            return ItemTransforms.NO_TRANSFORMS;
        }

        @Override
        public BakedModel applyTransform(ItemDisplayContext context, PoseStack poseStack, boolean leftHand, DefaultTransform defaultTransform) {
            if (perspectives.containsKey(context)) {
                BakedModel p = perspectives.get(context);
                // 手动应用变换
                p.getTransforms().getTransform(context).apply(leftHand, poseStack);
                return p;
            }
            defaultTransform.apply(baseModel);
            return baseModel;
        }
    }

    public static final class Loader implements IGeometryLoader<SeparateTransformsModel> {
        public static final Loader INSTANCE = new Loader();

        private Loader() {}

        @Override
        public SeparateTransformsModel read(JsonObject jsonObject, JsonDeserializationContext deserializationContext) throws JsonParseException {
            BlockModel baseModel = deserializationContext.deserialize(GsonHelper.getAsJsonObject(jsonObject, "base"), BlockModel.class);

            JsonObject perspectiveData = GsonHelper.getAsJsonObject(jsonObject, "perspectives");

            Map<ItemDisplayContext, BlockModel> perspectives = new HashMap<>();
            for (ItemDisplayContext transform : ItemDisplayContext.values()) {
                if (perspectiveData.has(transform.getSerializedName())) {
                    BlockModel perspectiveModel = deserializationContext.deserialize(GsonHelper.getAsJsonObject(perspectiveData, transform.getSerializedName()), BlockModel.class);
                    perspectives.put(transform, perspectiveModel);
                }
            }

            return new SeparateTransformsModel(baseModel, ImmutableMap.copyOf(perspectives));
        }
    }
}