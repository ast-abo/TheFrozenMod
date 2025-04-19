package iceman.thefrozenmod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class modItems {
    // Items
    public static Item register(String name, @NotNull Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(thefrozenmod.MOD_ID, name));
        
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);


        return item;
    }

    private static ConsumableComponent ConstructConsumableComponent(RegistryEntry<StatusEffect> Effect) {
        return ConsumableComponents.food()
                .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(Effect, 6 * 20, 1), 1.0f))
                .build();
    }

    private static FoodComponent ConstructFoodComponent() {
        return new FoodComponent.Builder()
                .alwaysEdible()
                .build();
    }

    private static void AddItemToGroup(RegistryKey<ItemGroup> ItemGroup, Item modItem) {
        ItemGroupEvents.modifyEntriesEvent(ItemGroup)
                .register((itemGroup) -> itemGroup.add(modItem));
    }

    public static final Item SUSPICIOUS_SUBSTANCE = register(
            "suspicious_substance",
            Item::new,
            new Item.Settings().food(ConstructFoodComponent(), ConstructConsumableComponent((RegistryEntry<StatusEffect>) StatusEffects.BLINDNESS))
    );

    // Items


    public static void initialize() {
        AddItemToGroup(ItemGroups.INGREDIENTS, modItems.SUSPICIOUS_SUBSTANCE);
    }
}


