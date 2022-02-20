package net.jabinator1.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jabinator1.tutorialmod.TutorialMod;
import net.jabinator1.tutorialmod.item.custom.DowsingRodItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_NUGGET = registerItem("mythril_nugget", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item RAW_MYTHRIL = registerItem("raw_mythril", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item LILAC_FLOWER_BULB = registerItem("lilac_flower_bulb", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    
    public static final Item GRAPE = registerItem("grape", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL).food(ModFoodComponents.GRAPE)));

    public static final Item DOWSING_ROD = registerItem("dowsing_rod", new DowsingRodItem(new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxCount(1)));
    
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);
    }
}