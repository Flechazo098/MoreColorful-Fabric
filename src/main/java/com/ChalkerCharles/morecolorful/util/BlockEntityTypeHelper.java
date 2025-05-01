package com.ChalkerCharles.morecolorful.util;

import com.ChalkerCharles.morecolorful.mixin.accessor.BlockEntityTypeAccessorMixin;
import net.minecraft.Util;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/**
 * 工具类，用于安全地向BlockEntityType添加新的方块
 */
public class BlockEntityTypeHelper {
    private static final Function<BlockEntityType<?>, ? extends Class<?>> COMMON_SUPER_CLASS_CACHE =
            Util.memoize(BlockEntityTypeHelper::getCommonSuperClassForExistingValidBlocks);

    /**
     * 向指定的BlockEntityType添加方块
     * @param blockEntityType 要修改的BlockEntityType
     * @param blocksToAdd 要添加的方块
     */
    public static void addValidBlocks(BlockEntityType<?> blockEntityType, Block... blocksToAdd) {
        if (blocksToAdd.length == 0) {
            return;
        }

        Set<Block> currentValidBlocks = new HashSet<>(((BlockEntityTypeAccessorMixin)blockEntityType).getValidBlocks());
        Class<?> commonSuperClass = COMMON_SUPER_CLASS_CACHE.apply(blockEntityType);

        for (Block block : blocksToAdd) {
            addValidBlock(block, commonSuperClass, currentValidBlocks);
        }

        // 使用Mixin访问器设置validBlocks字段
        ((BlockEntityTypeAccessorMixin) blockEntityType).setValidBlocks(currentValidBlocks);
    }

    private static void addValidBlock(Block block, @Nullable Class<?> baseClass, Set<Block> currentValidBlocks) {
        if (baseClass == null || baseClass.isAssignableFrom(block.getClass())) {
            currentValidBlocks.add(block);
        } else {
            throw new IllegalArgumentException("给定的方块 " + block + " 不是现有有效方块的共同超类 " + baseClass + " 的子类");
        }
    }

    @Nullable
    private static Class<?> getCommonSuperClassForExistingValidBlocks(BlockEntityType<?> blockEntityType) {
        Set<Block> validBlocks = ((BlockEntityTypeAccessorMixin)blockEntityType).getValidBlocks();
        Class<?> calculatedBaseClass = null;

        for (Block existingBlock : validBlocks) {
            if (calculatedBaseClass != null) {
                calculatedBaseClass = findClosestCommonSuper(calculatedBaseClass, existingBlock.getClass());
            } else {
                calculatedBaseClass = existingBlock.getClass();
            }
        }

        return calculatedBaseClass;
    }


    private static Class<?> findClosestCommonSuper(Class<?> superClass, Class<?> childClass) {
        while (!superClass.isAssignableFrom(childClass)) {
            superClass = superClass.getSuperclass();
        }
        return superClass;
    }
}