package iceman.thefrozenmod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class thefrozenmod implements ModInitializer {

    public static final String MOD_ID = "thefrozenmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        modItems.initialize();
    }
}
 