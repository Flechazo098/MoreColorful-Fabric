package com.ChalkerCharles.morecolorful.common.loot;
import com.ChalkerCharles.morecolorful.Config;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class ModLootTableModifier {
    private static final ResourceLocation TARGET_TABLE = ResourceLocation.withDefaultNamespace("archaeology/trail_ruins_common");

    private ModLootTableModifier () {
    }

    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            // 仅处理目标战利品表且配置启用时
            if (key.location().equals(TARGET_TABLE) && Config.isArchaeologyLootsEnabled()) {
                // 创建引用自定义表的条目
                LootPoolSingletonContainer.Builder<?> tableEntry = NestedLootTable.lootTableReference(ModLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON_ADD)
                        .setWeight(1);

                // 构建新战利品池
                LootPool.Builder additionalPool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))// 固定执行1次
                        .add(tableEntry);// 添加条目

                // 追加到原表
                tableBuilder.pool(additionalPool.build());
            }
        });
    }
}