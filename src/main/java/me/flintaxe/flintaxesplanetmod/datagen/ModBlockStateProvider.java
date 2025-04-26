package me.flintaxe.flintaxesplanetmod.datagen;

import me.flintaxe.flintaxesplanetmod.FlintaxesPlanetMod;
import me.flintaxe.flintaxesplanetmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FlintaxesPlanetMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.AURELIC_SAND.get(), cubeAll(ModBlocks.AURELIC_SAND.get()));
        simpleBlockWithItem(ModBlocks.DEVITALIS_STONE.get(), cubeAll(ModBlocks.DEVITALIS_STONE.get()));
        simpleBlockWithItem(ModBlocks.DEVITALIS_BRICKS.get(), cubeAll(ModBlocks.DEVITALIS_BRICKS.get()));
        simpleBlockWithItem(ModBlocks.DEVITALIS_BRICKS_CRACKED.get(), cubeAll(ModBlocks.DEVITALIS_BRICKS_CRACKED.get()));
        simpleBlockWithItem(ModBlocks.DEVITALIS_BRICKS_CARVED.get(), cubeAll(ModBlocks.DEVITALIS_BRICKS_CARVED.get()));
    }


}
