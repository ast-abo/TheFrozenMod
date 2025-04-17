package iceman.thefrozenmod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class customtooltip extends Item {
    public customtooltip(Settings settings) {
        super(settings);
    }


    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.thefrozenmod.suspicious_substance").formatted(Formatting.GOLD));
    }
}
