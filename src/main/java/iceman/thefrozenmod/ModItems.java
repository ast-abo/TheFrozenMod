package iceman.thefrozenmod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static Item COOL_ITEM = registerItem("cool_item", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(thefrozenmod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        thefrozenmod.LOGGER.info("Registering Mod Items for" + thefrozenmod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.COOL_ITEM);
        });
    }
}


