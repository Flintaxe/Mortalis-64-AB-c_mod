package me.flintaxe.flintaxesplanetmod.datagen;

import me.flintaxe.flintaxesplanetmod.FlintaxesPlanetMod;
import me.flintaxe.flintaxesplanetmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FlintaxesPlanetMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.JEREMEJEVITE.get());
    }
}
