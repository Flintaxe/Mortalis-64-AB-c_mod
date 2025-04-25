package me.flintaxe.flintaxesplanetmod.block;

import me.flintaxe.flintaxesplanetmod.FlintaxesPlanetMod;
import me.flintaxe.flintaxesplanetmod.block.custom.AurelicSand;
import me.flintaxe.flintaxesplanetmod.block.custom.DevitalisBricksCarved;
import me.flintaxe.flintaxesplanetmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FlintaxesPlanetMod.MOD_ID);

    public static final DeferredBlock<Block> AURELIC_SAND = registerBlock("aurelic_sand",
            () -> new AurelicSand(BlockBehaviour.Properties.of()
                    .strength(0.5f)
                    .sound(SoundType.SAND)
                    .instrument(NoteBlockInstrument.SNARE)
            ));

    public static final DeferredBlock<Block> DEVITALIS_STONE = registerBlock("devitalis_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.BASEDRUM)
            ));

    public static final DeferredBlock<Block> DEVITALIS_BRICKS = registerBlock("devitalis_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> DEVITALIS_BRICKS_CRACKED = registerBlock("devitalis_bricks_cracked",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> DEVITALIS_BRICKS_CARVED = registerBlock("devitalis_bricks_carved",
            () -> new DevitalisBricksCarved(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<StairBlock> DEVITALIS_BRICKS_STAIRS = registerBlock("devitalis_bricks_stairs",
            () -> new StairBlock(ModBlocks.DEVITALIS_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<SlabBlock> DEVITALIS_BRICKS_SLAB = registerBlock("devitalis_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<WallBlock> DEVITALIS_BRICKS_WALL = registerBlock("devitalis_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
            ));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
