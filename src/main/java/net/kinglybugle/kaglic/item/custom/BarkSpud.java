package net.kinglybugle.kaglic.item.custom;

import net.kinglybugle.kaglic.block.ModBlocks;
import net.kinglybugle.kaglic.block.custom.ModFlammableRotatedPillarBlock;
import net.kinglybugle.kaglic.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BarkSpud extends Item {


    public BarkSpud(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level world = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        BlockState clickedBlock = world.getBlockState(pos);

        ItemStack heldItem = pContext.getItemInHand();
        Player pPlayer = pContext.getPlayer();
        Item barkSpudItem = ModItems.BARK_SPUD.get();

        if (heldItem.getItem() == barkSpudItem) {
            if (clickedBlock.is(Blocks.OAK_LOG)) {
                world.setBlock(pos, ModBlocks.SEMI_STRIPPED_OAK_LOG.get().withPropertiesOf(clickedBlock), 512);
                heldItem.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pContext.getHand()));
            }
            else if (clickedBlock.is(Blocks.DARK_OAK_LOG)) {
                world.setBlock(pos, ModBlocks.SEMI_STRIPPED_DARK_OAK_LOG.get().withPropertiesOf(clickedBlock), 512);
                heldItem.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pContext.getHand()));
            }
            else if (clickedBlock.is(Blocks.ACACIA_LOG)) {
                world.setBlock(pos, ModBlocks.SEMI_STRIPPED_ACACIA_LOG.get().withPropertiesOf(clickedBlock), 512);
                heldItem.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pContext.getHand()));
            }
            else if (clickedBlock.is(Blocks.JUNGLE_LOG)) {
                world.setBlock(pos, ModBlocks.SEMI_STRIPPED_JUNGlE_LOG.get().withPropertiesOf(clickedBlock), 512);
                heldItem.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pContext.getHand()));
            }
            else if (clickedBlock.is(Blocks.BIRCH_LOG)) {
                world.setBlock(pos, ModBlocks.SEMI_STRIPPED_BIRCH_LOG.get().withPropertiesOf(clickedBlock), 512);
                heldItem.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pContext.getHand()));
            }
            else if (clickedBlock.is(Blocks.SPRUCE_LOG)) {
                world.setBlock(pos, ModBlocks.SEMI_STRIPPED_SPRUCE_LOG.get().withPropertiesOf(clickedBlock), 512);
                heldItem.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pContext.getHand()));
            }
            else if (clickedBlock.is(Blocks.CHERRY_LOG)) {
                world.setBlock(pos, ModBlocks.SEMI_STRIPPED_CHERRY_LOG.get().withPropertiesOf(clickedBlock), 512);
                heldItem.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pContext.getHand()));
            }
            else if (clickedBlock.is(Blocks.MANGROVE_LOG)) {
                world.setBlock(pos, ModBlocks.SEMI_STRIPPED_MANGROVE_LOG.get().withPropertiesOf(clickedBlock), 512);
                heldItem.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pContext.getHand()));
            }
        }
        return InteractionResult.SUCCESS;
    }
}
