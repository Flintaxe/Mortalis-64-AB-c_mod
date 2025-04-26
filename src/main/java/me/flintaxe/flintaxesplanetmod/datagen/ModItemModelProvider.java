package me.flintaxe.flintaxesplanetmod.datagen;

import me.flintaxe.flintaxesplanetmod.FlintaxesPlanetMod;
import me.flintaxe.flintaxesplanetmod.block.ModBlocks;
import me.flintaxe.flintaxesplanetmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FlintaxesPlanetMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.JEREMEJEVITE.get());

        this.withExistingParent(ModBlocks.DEVITALIS_BRICKS_WALL.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(FlintaxesPlanetMod.MOD_ID, "block/" + ModBlocks.DEVITALIS_BRICKS.getId().getPath()));
    }
}
