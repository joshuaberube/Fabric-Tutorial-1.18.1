package net.jabinator1.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.jabinator1.tutorialmod.block.ModBlocks;
import net.jabinator1.tutorialmod.item.ModItems;
import net.jabinator1.tutorialmod.util.ModRegistries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModStuffs();
	}
}
