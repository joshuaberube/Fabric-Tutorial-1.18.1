package net.jabinator1.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jabinator1.tutorialmod.TutorialMod;
import net.jabinator1.tutorialmod.item.custom.DowsingRodItem;
import net.jabinator1.tutorialmod.item.custom.ModAxeItem;
import net.jabinator1.tutorialmod.item.custom.ModHoeItem;
import net.jabinator1.tutorialmod.item.custom.ModpickaxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_NUGGET = registerItem("mythril_nugget", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item RAW_MYTHRIL = registerItem("raw_mythril", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    // fuel
    public static final Item LILAC_FLOWER_BULB = registerItem("lilac_flower_bulb", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    
    // food 
    public static final Item GRAPE = registerItem("grape", new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL).food(ModFoodComponents.GRAPE)));

    // custom items
    public static final Item DOWSING_ROD = registerItem("dowsing_rod", new DowsingRodItem(new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxCount(1)));
    public static final Item MYTHRIL_SWORD = registerItem("mythril_sword", new SwordItem(ModToolMaterials.MYTHRIL, 1, 2f, new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_AXE = registerItem("mythril_axe", new ModAxeItem(ModToolMaterials.MYTHRIL, 3, 1f, new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_HOE = registerItem("mythril_hoe", new ModHoeItem(ModToolMaterials.MYTHRIL, 0, 0f, new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_SHOVEL = registerItem("mythril_shovel", new ShovelItem(ModToolMaterials.MYTHRIL, 1, 1f, new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    public static final Item MYTHRIL_PICKAXE = registerItem("mythril_pickaxe", new ModpickaxeItem(ModToolMaterials.MYTHRIL, 1, 0f, new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);
    }
}
