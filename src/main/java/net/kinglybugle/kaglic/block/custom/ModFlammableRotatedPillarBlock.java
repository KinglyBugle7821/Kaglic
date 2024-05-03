package net.kinglybugle.kaglic.block.custom;

import net.kinglybugle.kaglic.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WallBannerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {

    public int time = 25;
    public static boolean blockChanged = false;

    public ModFlammableRotatedPillarBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        super.tick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {

        BlockState foundBlockNorth = pLevel.getBlockState(new BlockPos(pPos.getX(), pPos.getY(), pPos.getZ() - 1));
        BlockState foundBlockSouth = pLevel.getBlockState(new BlockPos(pPos.getX(), pPos.getY(), pPos.getZ() + 1));
        BlockState foundBlockEast = pLevel.getBlockState(new BlockPos(pPos.getX() + 1, pPos.getY(), pPos.getZ()));
        BlockState foundBlockWest = pLevel.getBlockState(new BlockPos(pPos.getX() - 1, pPos.getY(), pPos.getZ()));

        BlockPos getNorth = new BlockPos(pPos.getX(), pPos.getY(), pPos.getZ() - 1);
        BlockPos getSouth = new BlockPos(pPos.getX(), pPos.getY(), pPos.getZ() + 1);
        BlockPos getWest = new BlockPos(pPos.getX() - 1, pPos.getY(), pPos.getZ());
        BlockPos getEast = new BlockPos(pPos.getX() + 1, pPos.getY(), pPos.getZ());


        BlockState[] foundBlockAround = {foundBlockEast, foundBlockNorth, foundBlockSouth, foundBlockWest};


        time--;
        System.out.println("Random Ticking " + time);
        blockChanged = false;
        if (!pLevel.isClientSide){
            if (time == 0) {

                if (pState.is(ModBlocks.SEMI_STRIPPED_OAK_LOG.get())) {
                    pLevel.setBlockAndUpdate(pPos, Blocks.OAK_LOG.withPropertiesOf(pState));
                    time = 25;
                    blockChanged = true;
                    System.out.println("block changed");

                    if (foundBlockAround[0].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[1].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[2].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[3].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get())) {
                        pLevel.setBlockAndUpdate(getNorth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockNorth));
                        pLevel.setBlockAndUpdate(getSouth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockSouth));
                        pLevel.setBlockAndUpdate(getEast, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockEast));
                        pLevel.setBlockAndUpdate(getWest, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockWest));
                    }
                } else if (pState.is(ModBlocks.SEMI_STRIPPED_DARK_OAK_LOG.get())) {
                    pLevel.setBlockAndUpdate(pPos, Blocks.DARK_OAK_LOG.withPropertiesOf(pState));

                    time = 25;
                    blockChanged = true;
                    System.out.println("block changed");

                    if (foundBlockAround[0].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[1].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[2].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[3].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get())) {
                        pLevel.setBlockAndUpdate(getNorth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockNorth));
                        pLevel.setBlockAndUpdate(getSouth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockSouth));
                        pLevel.setBlockAndUpdate(getEast, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockEast));
                        pLevel.setBlockAndUpdate(getWest, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockWest));
                    }
                } else if (pState.is(ModBlocks.SEMI_STRIPPED_ACACIA_LOG.get())) {
                    pLevel.setBlockAndUpdate(pPos, Blocks.ACACIA_LOG.withPropertiesOf(pState));
                    time = 25;
                    blockChanged = true;
                    System.out.println("block changed");

                    if (foundBlockAround[0].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[1].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[2].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[3].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get())) {
                        pLevel.setBlockAndUpdate(getNorth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockNorth));
                        pLevel.setBlockAndUpdate(getSouth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockSouth));
                        pLevel.setBlockAndUpdate(getEast, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockEast));
                        pLevel.setBlockAndUpdate(getWest, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockWest));
                    }
                } else if (pState.is(ModBlocks.SEMI_STRIPPED_CHERRY_LOG.get())) {
                    pLevel.setBlockAndUpdate(pPos, Blocks.CHERRY_LOG.withPropertiesOf(pState));
                    time = 25;
                    blockChanged = true;
                    System.out.println("block changed");

                    if (foundBlockAround[0].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[1].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[2].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[3].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get())) {
                        pLevel.setBlockAndUpdate(getNorth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockNorth));
                        pLevel.setBlockAndUpdate(getSouth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockSouth));
                        pLevel.setBlockAndUpdate(getEast, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockEast));
                        pLevel.setBlockAndUpdate(getWest, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockWest));
                    }
                } else if (pState.is(ModBlocks.SEMI_STRIPPED_BIRCH_LOG.get())) {
                    pLevel.setBlockAndUpdate(pPos, Blocks.BIRCH_LOG.withPropertiesOf(pState));
                    time = 25;
                    blockChanged = true;
                    System.out.println("block changed");

                    if (foundBlockAround[0].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[1].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[2].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[3].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get())) {
                        pLevel.setBlockAndUpdate(getNorth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockNorth));
                        pLevel.setBlockAndUpdate(getSouth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockSouth));
                        pLevel.setBlockAndUpdate(getEast, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockEast));
                        pLevel.setBlockAndUpdate(getWest, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockWest));
                    }
                } else if (pState.is(ModBlocks.SEMI_STRIPPED_JUNGlE_LOG.get())) {
                    pLevel.setBlockAndUpdate(pPos, Blocks.JUNGLE_LOG.withPropertiesOf(pState));
                    time = 25;
                    blockChanged = true;
                    System.out.println("block changed");

                    if (foundBlockAround[0].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[1].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[2].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[3].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get())) {
                        pLevel.setBlockAndUpdate(getNorth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockNorth));
                        pLevel.setBlockAndUpdate(getSouth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockSouth));
                        pLevel.setBlockAndUpdate(getEast, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockEast));
                        pLevel.setBlockAndUpdate(getWest, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockWest));
                    }
                } else if (pState.is(ModBlocks.SEMI_STRIPPED_SPRUCE_LOG.get())) {
                    pLevel.setBlockAndUpdate(pPos, Blocks.SPRUCE_LOG.withPropertiesOf(pState));
                    time = 25;
                    blockChanged = true;
                    System.out.println("block changed");

                    if (foundBlockAround[0].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[1].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[2].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[3].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get())) {
                        pLevel.setBlockAndUpdate(getNorth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockNorth));
                        pLevel.setBlockAndUpdate(getSouth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockSouth));
                        pLevel.setBlockAndUpdate(getEast, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockEast));
                        pLevel.setBlockAndUpdate(getWest, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockWest));
                    }
                } else if (pState.is(ModBlocks.SEMI_STRIPPED_MANGROVE_LOG.get())) {
                    pLevel.setBlockAndUpdate(pPos, Blocks.MANGROVE_LOG.withPropertiesOf(pState));
                    time = 25;
                    blockChanged = true;
                    System.out.println("block changed");

                    if (foundBlockAround[0].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[1].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[2].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()) ||
                            foundBlockAround[3].is(ModBlocks.RESIN_EXTRACTOR_EMPTY.get())) {
                        pLevel.setBlockAndUpdate(getNorth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockNorth));
                        pLevel.setBlockAndUpdate(getSouth, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockSouth));
                        pLevel.setBlockAndUpdate(getEast, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockEast));
                        pLevel.setBlockAndUpdate(getWest, ModBlocks.RESIN_EXTRACTOR_FULL.get().withPropertiesOf(foundBlockWest));
                    }
                }
                super.randomTick(pState, pLevel, pPos, pRandom);
            }
        }
    }
}