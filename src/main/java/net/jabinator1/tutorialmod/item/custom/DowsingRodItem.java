package net.jabinator1.tutorialmod.item.custom;

import java.util.List;

import net.jabinator1.tutorialmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DowsingRodItem extends Item {
  public DowsingRodItem(Settings settings) {
    super(settings);
  }
  
  @Override
  public ActionResult useOnBlock(ItemUsageContext context) {

    if (context.getWorld().isClient()) {
      BlockPos positionClicked = context.getBlockPos();
      PlayerEntity player = context.getPlayer();
      boolean foundBlock = false;

      for (int i = 0; i <= positionClicked.getY(); i++) {
        Block blockBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();

        if (isValuableBlock(blockBelow)) {
          outputValuableCoordinates(positionClicked.down(i), player, blockBelow);
          foundBlock = true;
          break;
        }
      }

      if (!foundBlock) {
        player.sendMessage(new TranslatableText("item.tutorialmod.dowsing_rod.no_valuables"), false);
      }
    }

    context.getStack().damage(1, context.getPlayer(), (player) -> player.sendToolBreakStatus(player.getActiveHand()));
    
    return super.useOnBlock(context);
  }

  @Override
  public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
    if (Screen.hasShiftDown()) {
      tooltip.add(new TranslatableText("item.tutorialmod.dowsing_rod.tooltip.shift"));
    } else {
      tooltip.add(new TranslatableText("item.tutorialmod.dowsing_rod.tooltip"));
    }

    super.appendTooltip(stack, world, tooltip, context);
  }

  private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block blockBelow) {
    player.sendMessage(new LiteralText("Found " + blockBelow.asItem().getName().getString() + " at (" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), false);
  }

  private boolean isValuableBlock(Block block) {
    return ModTags.Blocks.DOWSING_ROD_DETECTABLE_BLOCKS.contains(block);
  }
}