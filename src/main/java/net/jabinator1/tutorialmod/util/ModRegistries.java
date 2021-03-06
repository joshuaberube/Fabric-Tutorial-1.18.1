package net.jabinator1.tutorialmod.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.jabinator1.tutorialmod.TutorialMod;
import net.jabinator1.tutorialmod.item.ModItems;

public class ModRegistries {
  public static void registerModStuffs() {
    registerFuels();
  }

  private static void registerFuels() {
    TutorialMod.LOGGER.info("Registering Fuels for " + TutorialMod.MOD_ID);
    FuelRegistry registry = FuelRegistry.INSTANCE;

    registry.add(ModItems.LILAC_FLOWER_BULB, 200);
  }
}
