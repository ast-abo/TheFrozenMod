package TheFrozenMod.item;

import TheFrozenMod.TheFrozenMod;
import TheFrozenMod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup FROZEN_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheFrozenMod.MOD_ID, "frozenite_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.FROZENITE))
                    .displayName(Text.translatable("itemgroup.thefrozenmod.frozenite_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.FROZENITE);
                        entries.add(ModItems.RAW_FROZENITE);
                        entries.add(ModItems.FROZENITE_CHISEL);
                    })
                    .build());
    public static final ItemGroup FROZEN_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheFrozenMod.MOD_ID, "frozenite_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.FROZENITE_BLOCK))
                    .displayName(Text.translatable("itemgroup.thefrozenmod.frozenite_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.FROZENITE_GRASS);
                        entries.add(ModBlocks.FROZENITE_BLOCK);
                        entries.add(ModBlocks.FROZENITE_ORE);
                    })
                    .build());


    public static void registerItemGroups() {
        TheFrozenMod.LOGGER.info("Registering Item Groups for " + TheFrozenMod.MOD_ID);
    }
}
