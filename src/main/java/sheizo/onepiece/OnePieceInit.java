package sheizo.onepiece;

import sheizo.onepiece.item.ModArmorAttributes;
import sheizo.onepiece.item.ModItemGroups;
import sheizo.onepiece.item.ModItemInit;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OnePieceInit implements ModInitializer {

	public static final String MOD_ID = "one_piece";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("one_piece");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItemGroups.initialize();
		ModItemInit.initialize();
		ModArmorAttributes.initialize();

		LOGGER.info("Hello Fabric world!");
	}
}