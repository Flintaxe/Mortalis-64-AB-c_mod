package me.flintaxe.flintaxesplanetmod.item;

import me.flintaxe.flintaxesplanetmod.FlintaxesPlanetMod;
import me.flintaxe.flintaxesplanetmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FlintaxesPlanetMod.MOD_ID);

    public static final Supplier<CreativeModeTab> FLINTAXES_PLANET_TAB = CREATIVE_MODE_TAB.register("flintaxes_planet_tab",
            () -> CreativeModeTab.builder()
                    .icon( () -> new ItemStack(ModBlocks.AURELIC_SAND.get()))
                    .title(Component.translatable("creativetab.flintaxesplanetmod.flintaxes_planet_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.AURELIC_SAND);
                        output.accept(ModBlocks.DEVITALIS_STONE);
                        output.accept(ModBlocks.DEVITALIS_BRICKS);
                        output.accept(ModBlocks.DEVITALIS_BRICKS_CRACKED);
                        output.accept(ModBlocks.DEVITALIS_BRICKS_CARVED);

                        output.accept(ModBlocks.DEVITALIS_BRICKS_STAIRS);
                        output.accept(ModBlocks.DEVITALIS_BRICKS_SLAB);
                        output.accept(ModBlocks.DEVITALIS_BRICKS_WALL);

                        output.accept(ModItems.JEREMEJEVITE);
                    }).build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
