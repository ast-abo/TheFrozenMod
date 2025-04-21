package TheFrozenMod.item.custom;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent ICE_CUBES = new FoodComponent.Builder()
            .nutrition(2)
            .saturationModifier(0.13f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200), 1f)
            .build();
}