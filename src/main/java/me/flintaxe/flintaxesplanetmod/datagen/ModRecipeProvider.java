package me.flintaxe.flintaxesplanetmod.datagen;

import me.flintaxe.flintaxesplanetmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEVITALIS_BRICKS.get().asItem(), 4)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.DEVITALIS_STONE.get().asItem())
                .unlockedBy("has_devitalis_stone", has(ModBlocks.DEVITALIS_STONE.get().asItem()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEVITALIS_BRICKS_SLAB.get().asItem(), 6)
                .pattern("###")
                .define('#', ModBlocks.DEVITALIS_BRICKS.get().asItem())
                .unlockedBy("has_devitalis_bricks", has(ModBlocks.DEVITALIS_BRICKS.get().asItem()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEVITALIS_BRICKS_CARVED.get().asItem())
                .pattern("#")
                .pattern("#")
                .define('#', ModBlocks.DEVITALIS_BRICKS_SLAB.get().asItem())
                .unlockedBy("has_devitalis_slab", has(ModBlocks.DEVITALIS_BRICKS_SLAB.get().asItem()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEVITALIS_BRICKS_STAIRS.get().asItem(), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ModBlocks.DEVITALIS_BRICKS.get().asItem())
                .unlockedBy("has_devitalis_bricks", has(ModBlocks.DEVITALIS_BRICKS.get().asItem()))
                .save(recipeOutput, "flintaxesplanetmod:devitalis_stairs_left");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEVITALIS_BRICKS_STAIRS.get().asItem(), 4)
                .pattern("  #")
                .pattern(" ##")
                .pattern("###")
                .define('#', ModBlocks.DEVITALIS_BRICKS.get().asItem())
                .unlockedBy("has_devitalis_bricks", has(ModBlocks.DEVITALIS_BRICKS.get().asItem()))
                .save(recipeOutput, "flintaxesplanetmod:devitalis_stairs_right");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEVITALIS_BRICKS_WALL.get().asItem(), 6)
                .pattern("###")
                .pattern("###")
                .define('#', ModBlocks.DEVITALIS_BRICKS.get().asItem())
                .unlockedBy("has_devitalis_bricks", has(ModBlocks.DEVITALIS_BRICKS.get().asItem()))
                .save(recipeOutput);

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.DEVITALIS_STONE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.DEVITALIS_BRICKS.get(),
                        0.1f,
                        200
                )
                .unlockedBy("has_stone", has(ModBlocks.DEVITALIS_STONE.get()))
                .save(recipeOutput,  ResourceLocation.fromNamespaceAndPath("flintaxesplanetmod", "manual_smelting_stone_to_bricks"));
    }
}
