package net.jabinator1.tutorialmod.feature;

import java.util.function.Predicate;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jabinator1.tutorialmod.TutorialMod;
import net.jabinator1.tutorialmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.GenerationStep;

public class ModFeatures {
  public static final PlacedFeature OVERWORLD_MYTHRIL_ORE_PLACED_FEATURE = placeOre("mythril_ore", ModBlocks.MYTHRIL_ORE, OreConfiguredFeatures.STONE_ORE_REPLACEABLES, BiomeSelectors.foundInOverworld(), 9, 20, 64);
  public static final PlacedFeature OVERWORLD_DEEPSLATE_MYTHRIL_ORE_PLACED_FEATURE = placeOre("deepslate_mythril_ore", ModBlocks.DEEPSLATE_MYTHRIL_ORE, OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, BiomeSelectors.foundInOverworld(), 9, 20, 0);
  public static final PlacedFeature NETHER_NETHERRACK_MYTHRIL_ORE_PLACED_FEATURE = placeOre("netherrack_mythril_ore", ModBlocks.NETHERRACK_MYTHRIL_ORE, OreConfiguredFeatures.NETHERRACK, BiomeSelectors.foundInTheNether(), 9, 20, 64);





  private static PlacedFeature placeOre(String name, Block block, RuleTest blocksToReplace, Predicate<BiomeSelectionContext> dimension, int vienSize, int veinsPerChunk, int height) {
    Identifier id = new Identifier(TutorialMod.MOD_ID, name);

    PlacedFeature placedFeature = configureOreFeature(blocksToReplace, block, vienSize, id)
      .withPlacement(
        CountPlacementModifier.of(veinsPerChunk),
        SquarePlacementModifier.of(), //spreading horizontally
        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(height))
      );

    Registry.register(BuiltinRegistries.PLACED_FEATURE, id, placedFeature);
    BiomeModifications.addFeature(dimension, GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, id));

    return placedFeature;
  }

  private static ConfiguredFeature<?, ?> configureOreFeature(RuleTest blocksToReplace, Block block, int vienSize, Identifier id) {
    ConfiguredFeature<?, ?> configuredFeature = Feature.ORE.configure(
      new OreFeatureConfig(blocksToReplace, block.getDefaultState(), vienSize)
    );

    return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, configuredFeature);
  }

  public static void registerModFeatures() {
    TutorialMod.LOGGER.info("Registering ModFeatures for " + TutorialMod.MOD_ID);
  }
}
