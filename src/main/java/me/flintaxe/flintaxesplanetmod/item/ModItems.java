package me.flintaxe.flintaxesplanetmod.item;

import me.flintaxe.flintaxesplanetmod.FlintaxesPlanetMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FlintaxesPlanetMod.MOD_ID);

    public static final DeferredItem<Item> JEREMEJEVITE = ITEMS.register("jeremejevite",
            () -> new Item(new Item.Properties()));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
