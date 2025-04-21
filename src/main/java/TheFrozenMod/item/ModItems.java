package TheFrozenMod.item;

import TheFrozenMod.TheFrozenMod;
import TheFrozenMod.item.custom.FrozeniteChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static Item FROZENITE = registerItem("frozenite", new Item(new Item.Settings()));
    public static Item RAW_FROZENITE = registerItem("raw_frozenite", new Item(new Item.Settings()));
    public static Item FROZENITE_CHISEL = registerItem("frozenite_chisel", new FrozeniteChiselItem(new Item.Settings()));
    public static Item ICE_CUBES = registerItem("ice_cubes", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TheFrozenMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TheFrozenMod.LOGGER.info("Registering Mod Items for" + TheFrozenMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.RAW_FROZENITE);
            entries.add(ModItems.FROZENITE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(ModItems.ICE_CUBES);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ModItems.FROZENITE_CHISEL);
        });
    }
}


