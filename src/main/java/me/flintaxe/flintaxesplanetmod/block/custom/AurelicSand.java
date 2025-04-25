package me.flintaxe.flintaxesplanetmod.block.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class AurelicSand extends Block {
    public AurelicSand(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.flintaxesplanetmod.aurelic_sand"));
        } else {
            tooltipComponents.add((Component.translatable("tooltip.flintaxesplanetmod.press_shift")));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
