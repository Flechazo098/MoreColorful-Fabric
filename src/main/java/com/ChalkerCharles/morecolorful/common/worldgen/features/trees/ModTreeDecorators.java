package com.ChalkerCharles.morecolorful.common.worldgen.features.trees;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.common.worldgen.features.trees.treedecorators.WillowBranchesDecorator;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class ModTreeDecorators {
    public static final TreeDecoratorType<WillowBranchesDecorator> WILLOW_BRANCHES_DECORATOR =
            register("willow_branches_decorator", new TreeDecoratorType<>(WillowBranchesDecorator.CODEC));

    private static <P extends TreeDecoratorType<?>> P register(String name, P decoratorType) {
        return Registry.register(BuiltInRegistries.TREE_DECORATOR_TYPE, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, name), decoratorType);
    }

    public static void init() {
    }
}