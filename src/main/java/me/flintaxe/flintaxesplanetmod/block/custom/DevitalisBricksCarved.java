package me.flintaxe.flintaxesplanetmod.block.custom;

import me.flintaxe.flintaxesplanetmod.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class DevitalisBricksCarved extends Block {
    public DevitalisBricksCarved(Properties properties){
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            if (stack.getItem() == ModItems.JEREMEJEVITE.get()) {
                level.playSound(
                        null,
                        pos,
                        SoundEvents.AMETHYST_BLOCK_CHIME,
                        SoundSource.BLOCKS,
                        1.2F,
                        1.0F
                );
                return ItemInteractionResult.SUCCESS;
            }

        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.flintaxesplanetmod.devitalis_bricks_carved"));
        } else {
            tooltipComponents.add((Component.translatable("tooltip.flintaxesplanetmod.press_shift")));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
