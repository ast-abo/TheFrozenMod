package iceman.thefrozenmod.client;

import iceman.thefrozenmod.modItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.text.Text;

public class thefrozenmodClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (!itemStack.isOf(modItems.SUSPICIOUS_SUBSTANCE)) {
                return;
            }
            list.add(Text.translatable("item.thefrozenmod.suspicious_substance.tooltip"));
        });
    }
}
