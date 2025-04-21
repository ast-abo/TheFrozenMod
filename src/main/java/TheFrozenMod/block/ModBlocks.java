package TheFrozenMod.block;

import TheFrozenMod.TheFrozenMod;
import TheFrozenMod.block.custom.FrozenBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block FROZENITE_BLOCK = registerBlock("frozenite_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            )
    );

    public static final Block FROZENITE_GRASS = registerBlock("frozenite_grass",
            new FrozenBlock(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.GRASS)
                    .requiresTool()
                    .ticksRandomly()
            , Blocks.GRASS_BLOCK)
    );

    public static final Block FROZENITE_ORE = registerBlock("frozenite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), (AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            ))
    );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TheFrozenMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TheFrozenMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TheFrozenMod.LOGGER.info("Registering Mod Blocks for" + TheFrozenMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.FROZENITE_BLOCK);
            entries.add(ModBlocks.FROZENITE_GRASS);
        });
    }
}
