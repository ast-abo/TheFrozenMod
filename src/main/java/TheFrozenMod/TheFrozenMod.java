package TheFrozenMod;

import TheFrozenMod.block.ModBlocks;
import TheFrozenMod.item.ModItemGroups;
import TheFrozenMod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheFrozenMod implements ModInitializer {
	public static final String MOD_ID = "thefrozenmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
