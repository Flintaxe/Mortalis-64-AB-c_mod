package me.flintaxe.flintaxesplanetmod.datagen;

import me.flintaxe.flintaxesplanetmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEVITALIS_BRICKS.get(), 4)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.DEVITALIS_STONE.get())
                .group("devitalis_bricks")
                .unlockedBy("has_devitalis_stone", has(ModBlocks.DEVITALIS_STONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEVITALIS_BRICKS_SLAB.get(), 6)
                .pattern("###")
                .define('#', ModBlocks.DEVITALIS_BRICKS.get())
                .group("devitalis_bricks")
                .unlockedBy("has_devitalis_bricks", has(ModBlocks.DEVITALIS_BRICKS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEVITALIS_BRICKS_CARVED.get())
                .pattern("#")
                .pattern("#")
                .define('#', ModBlocks.DEVITALIS_BRICKS_SLAB.get())
                .group("devitalis_bricks")
                .unlockedBy("has_devitalis_slab", has(ModBlocks.DEVITALIS_BRICKS_SLAB))
                .save(recipeOutput);

        stairBuilder(ModBlocks.DEVITALIS_BRICKS_STAIRS.get(), Ingredient.of(ModBlocks.DEVITALIS_BRICKS))
                .group("devitalis_bricks")
                .unlockedBy("has_devitalis_bricks", has(ModBlocks.DEVITALIS_BRICKS))
                .save(recipeOutput);

        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEVITALIS_BRICKS_WALL.get(), ModBlocks.DEVITALIS_BRICKS.get());

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.DEVITALIS_BRICKS.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.DEVITALIS_BRICKS_CRACKED.get(),
                        0.1f,
                        200
                )
                .group("devitalis_bricks")
                .unlockedBy("has_stone", has(ModBlocks.DEVITALIS_STONE))
                .save(recipeOutput,  ResourceLocation.fromNamespaceAndPath("flintaxesplanetmod", "manual_smelting_stone_to_bricks"));
    }
}
