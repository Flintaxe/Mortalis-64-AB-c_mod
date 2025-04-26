package me.flintaxe.flintaxesplanetmod.datagen;

import me.flintaxe.flintaxesplanetmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.io.Serial;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.AURELIC_SAND.get());
        dropSelf(ModBlocks.DEVITALIS_BRICKS.get());
        dropSelf(ModBlocks.DEVITALIS_BRICKS_CARVED.get());
        dropSelf(ModBlocks.DEVITALIS_BRICKS_CRACKED.get());
        dropSelf(ModBlocks.DEVITALIS_STONE.get());
        dropSelf(ModBlocks.DEVITALIS_BRICKS_SLAB.get());
        dropSelf(ModBlocks.DEVITALIS_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.DEVITALIS_BRICKS_WALL.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
