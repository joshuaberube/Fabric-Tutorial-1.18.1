package net.jabinator1.tutorialmod.block;

import java.util.List;

import javax.annotation.Nullable;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.jabinator1.tutorialmod.TutorialMod;
import net.jabinator1.tutorialmod.block.custom.ModDoorBlock;
import net.jabinator1.tutorialmod.block.custom.ModPressurePlateBlock;
import net.jabinator1.tutorialmod.block.custom.ModStairsBlock;
import net.jabinator1.tutorialmod.block.custom.ModStoneButtonBlock;
import net.jabinator1.tutorialmod.block.custom.ModTrapdoorBlock;
import net.jabinator1.tutorialmod.block.custom.SpeedyBlock;
import net.jabinator1.tutorialmod.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.Material;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModBlocks {
  public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block", new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.MYTHRIL, "block.tutorialmod.mythril_block.tooltip");
  public static final Block RAW_MYTHRIL_BLOCK = registerBlock("raw_mythril_block", new Block(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.MYTHRIL);
  public static final Block MYTHRIL_ORE = registerBlock("mythril_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()), ModItemGroup.MYTHRIL);
  public static final Block DEEPSLATE_MYTHRIL_ORE = registerBlock("deepslate_mythril_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(5f).requiresTool()), ModItemGroup.MYTHRIL);
  public static final Block NETHERRACK_MYTHRIL_ORE = registerBlock("netherrack_mythril_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()), ModItemGroup.MYTHRIL);

  public static final Block SPEEDY_BLOCK = registerBlock("speedy_block", new SpeedyBlock(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()), ModItemGroup.MYTHRIL);
  
  public static final Block MYTHRIL_BUTTON = registerBlock("mythril_button", new ModStoneButtonBlock(FabricBlockSettings.of(Material.METAL).strength(4.5f).requiresTool().noCollision()), ModItemGroup.MYTHRIL);
  public static final Block MYTHRIL_PRESSURE_PLATE = registerBlock("mythril_pressure_plate", new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.METAL).strength(4.5f).requiresTool()), ModItemGroup.MYTHRIL);
  public static final Block MYTHRIL_FENCE = registerBlock("mythril_fence", new FenceBlock(FabricBlockSettings.of(Material.METAL).strength(4.5f).requiresTool()), ModItemGroup.MYTHRIL);
  public static final Block MYTHRIL_FENCE_GATE = registerBlock("mythril_fence_gate", new FenceGateBlock(FabricBlockSettings.of(Material.METAL).strength(4.5f).requiresTool()), ModItemGroup.MYTHRIL);
  public static final Block MYTHRIL_WALL = registerBlock("mythril_wall", new WallBlock(FabricBlockSettings.of(Material.METAL).strength(4.5f).requiresTool()), ModItemGroup.MYTHRIL);

  public static final Block MYTHRIL_SLAB = registerBlock("mythril_slab", new SlabBlock(FabricBlockSettings.of(Material.METAL).strength(4.5f).requiresTool()), ModItemGroup.MYTHRIL);
  public static final Block MYTHRIL_STAIRS = registerBlock("mythril_stairs", new ModStairsBlock(ModBlocks.MYTHRIL_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL).strength(4.5f).requiresTool()), ModItemGroup.MYTHRIL);
  public static final Block KAUPEN_DOOR = registerBlock("kaupen_door", new ModDoorBlock(FabricBlockSettings.of(Material.WOOD).strength(4.5f).nonOpaque()), ModItemGroup.MYTHRIL);
  public static final Block KAUPEN_TRAPDOOR = registerBlock("kaupen_trapdoor", new ModTrapdoorBlock(FabricBlockSettings.of(Material.WOOD).strength(4.5f).nonOpaque()), ModItemGroup.MYTHRIL);

  // overwrites the other functions, allowing you to have them both (this is called overloading. Java is stupid and doesn't have optional params)
  private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
    registerBlockItem(name, block, group, tooltipKey);
    return Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
  }

  private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
    return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name), 
      new BlockItem(block, new FabricItemSettings().group(group)) {
        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
          tooltip.add(new TranslatableText(tooltipKey));
        }
      }
    );
  }

  private static Block registerBlock(String name, Block block, ItemGroup group) {
    registerBlockItem(name, block, group);
    return Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
  }

  private static Item registerBlockItem(String name, Block block, ItemGroup group) {
    return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(group)));
  }
  
  public static void registerModBlocks() {
    TutorialMod.LOGGER.info("Registering ModBlocks for " + TutorialMod.MOD_ID);
  }
}
