package com.ChalkerCharles.morecolorful.common.loot;

import com.ChalkerCharles.morecolorful.Config;
import com.ChalkerCharles.morecolorful.MoreColorful;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class LootTableModifier {
    // 修正原版考古战利品表ID（1.21版本实际路径）
    private static final ResourceLocation TRAIL_RUINS_LOOT_TABLE =
            ResourceLocation.fromNamespaceAndPath("minecraft", "archaeology/trail_ruins_common");

    // 自定义附加战利品表路径
    private static final ResourceLocation CUSTOM_LOOT_TABLE =
            ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "archaeology/trail_ruins_common_add");

    public static void register() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            // 仅处理目标战利品表且配置启用时
            if (TRAIL_RUINS_LOOT_TABLE.equals(id) && Config.isArchaeologyLootsEnabled()) {
                // 创建引用自定义表的条目
                LootTableEntry.Builder tableEntry = LootTableEntry.lootTableReference(CUSTOM_LOOT_TABLE)
                        .setWeight(1); // 设置条目权重

                // 构建新战利品池
                LootPool.Builder additionalPool = LootPool.lootPool()
                        .name("morecolorful_additional_loot") // 可选命名
                        .rolls(ConstantValue.exactly(1))        // 固定执行1次
                        .add(tableEntry);                      // 添加条目

                // 追加到原表
                tableBuilder.pool(additionalPool.build());
            }
        });
    }
}