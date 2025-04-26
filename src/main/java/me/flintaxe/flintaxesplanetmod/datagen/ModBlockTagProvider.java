package me.flintaxe.flintaxesplanetmod.datagen;

import me.flintaxe.flintaxesplanetmod.FlintaxesPlanetMod;
import me.flintaxe.flintaxesplanetmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FlintaxesPlanetMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DEVITALIS_BRICKS.get())
                .add(ModBlocks.DEVITALIS_STONE.get())
                .add(ModBlocks.DEVITALIS_BRICKS_CRACKED.get())
                .add(ModBlocks.DEVITALIS_BRICKS_CARVED.get())
                .add(ModBlocks.DEVITALIS_BRICKS_WALL.get())
                .add(ModBlocks.DEVITALIS_BRICKS_STAIRS.get())
                .add(ModBlocks.DEVITALIS_BRICKS_SLAB.get());

        tag(BlockTags.WALLS)
                .add(ModBlocks.DEVITALIS_BRICKS_WALL.get());

        tag(BlockTags.DEAD_BUSH_MAY_PLACE_ON)
                .add(ModBlocks.AURELIC_SAND.get());
    }
}
