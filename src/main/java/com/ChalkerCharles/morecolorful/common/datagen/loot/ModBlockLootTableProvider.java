package com.ChalkerCharles.morecolorful.common.datagen.loot;

import com.ChalkerCharles.morecolorful.common.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider  {


    public ModBlockLootTableProvider (FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate () {
// crabapple
        this.dropSelf(ModBlocks.CRABAPPLE_SIGN);
        this.dropOther(ModBlocks.CRABAPPLE_WALL_SIGN, ModBlocks.CRABAPPLE_SIGN);
        this.dropSelf(ModBlocks.CRABAPPLE_HANGING_SIGN);
        this.dropOther(ModBlocks.CRABAPPLE_WALL_HANGING_SIGN, ModBlocks.CRABAPPLE_HANGING_SIGN);

// ebony
        this.dropSelf(ModBlocks.EBONY_SIGN);
        this.dropOther(ModBlocks.EBONY_WALL_SIGN, ModBlocks.EBONY_SIGN);
        this.dropSelf(ModBlocks.EBONY_HANGING_SIGN);
        this.dropOther(ModBlocks.EBONY_WALL_HANGING_SIGN, ModBlocks.EBONY_HANGING_SIGN);

// ginkgo
        this.dropSelf(ModBlocks.GINKGO_SIGN);
        this.dropOther(ModBlocks.GINKGO_WALL_SIGN, ModBlocks.GINKGO_SIGN);
        this.dropSelf(ModBlocks.GINKGO_HANGING_SIGN);
        this.dropOther(ModBlocks.GINKGO_WALL_HANGING_SIGN, ModBlocks.GINKGO_HANGING_SIGN);

// maple
        this.dropSelf(ModBlocks.MAPLE_SIGN);
        this.dropOther(ModBlocks.MAPLE_WALL_SIGN, ModBlocks.MAPLE_SIGN);
        this.dropSelf(ModBlocks.MAPLE_HANGING_SIGN);
        this.dropOther(ModBlocks.MAPLE_WALL_HANGING_SIGN, ModBlocks.MAPLE_HANGING_SIGN);

// frost
        this.dropSelf(ModBlocks.FROST_SIGN);
        this.dropOther(ModBlocks.FROST_WALL_SIGN, ModBlocks.FROST_SIGN);
        this.dropSelf(ModBlocks.FROST_HANGING_SIGN);
        this.dropOther(ModBlocks.FROST_WALL_HANGING_SIGN, ModBlocks.FROST_HANGING_SIGN);

// dawn_redwood
        this.dropSelf(ModBlocks.DAWN_REDWOOD_SIGN);
        this.dropOther(ModBlocks.DAWN_REDWOOD_WALL_SIGN, ModBlocks.DAWN_REDWOOD_SIGN);
        this.dropSelf(ModBlocks.DAWN_REDWOOD_HANGING_SIGN);
        this.dropOther(ModBlocks.DAWN_REDWOOD_WALL_HANGING_SIGN, ModBlocks.DAWN_REDWOOD_HANGING_SIGN);

// jacaranda
        this.dropSelf(ModBlocks.JACARANDA_SIGN);
        this.dropOther(ModBlocks.JACARANDA_WALL_SIGN, ModBlocks.JACARANDA_SIGN);
        this.dropSelf(ModBlocks.JACARANDA_HANGING_SIGN);
        this.dropOther(ModBlocks.JACARANDA_WALL_HANGING_SIGN, ModBlocks.JACARANDA_HANGING_SIGN);

// willow
        this.dropSelf(ModBlocks.WILLOW_SIGN);
        this.dropOther(ModBlocks.WILLOW_WALL_SIGN, ModBlocks.WILLOW_SIGN);
        this.dropSelf(ModBlocks.WILLOW_HANGING_SIGN);
        this.dropOther(ModBlocks.WILLOW_WALL_HANGING_SIGN, ModBlocks.WILLOW_HANGING_SIGN);
    }
}