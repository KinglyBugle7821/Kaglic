package net.kinglybugle.kaglic.datagen;

import net.kinglybugle.kaglic.Kaglic;
import net.kinglybugle.kaglic.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Kaglic.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
//        blockWithItem(ModBlocks.RONALDO_BLOCK);
        axisBlock(((RotatedPillarBlock) ModBlocks.SEMI_STRIPPED_OAK_LOG.get()), blockTexture(ModBlocks.SEMI_STRIPPED_OAK_LOG.get()),
                new ResourceLocation(Kaglic.MOD_ID, "block/semi_stripped_oak_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.SEMI_STRIPPED_DARK_OAK_LOG.get()), blockTexture(ModBlocks.SEMI_STRIPPED_DARK_OAK_LOG.get()),
                new ResourceLocation(Kaglic.MOD_ID, "block/semi_stripped_dark_oak_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.SEMI_STRIPPED_ACACIA_LOG.get()), blockTexture(ModBlocks.SEMI_STRIPPED_ACACIA_LOG.get()),
                new ResourceLocation(Kaglic.MOD_ID, "block/semi_stripped_acacia_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.SEMI_STRIPPED_CHERRY_LOG.get()), blockTexture(ModBlocks.SEMI_STRIPPED_CHERRY_LOG.get()),
                new ResourceLocation(Kaglic.MOD_ID, "block/semi_stripped_cherry_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.SEMI_STRIPPED_BIRCH_LOG.get()), blockTexture(ModBlocks.SEMI_STRIPPED_BIRCH_LOG.get()),
                new ResourceLocation(Kaglic.MOD_ID, "block/semi_stripped_birch_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.SEMI_STRIPPED_JUNGlE_LOG.get()), blockTexture(ModBlocks.SEMI_STRIPPED_JUNGlE_LOG.get()),
                new ResourceLocation(Kaglic.MOD_ID, "block/semi_stripped_jungle_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.SEMI_STRIPPED_SPRUCE_LOG.get()), blockTexture(ModBlocks.SEMI_STRIPPED_SPRUCE_LOG.get()),
                new ResourceLocation(Kaglic.MOD_ID, "block/semi_stripped_spruce_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.SEMI_STRIPPED_MANGROVE_LOG.get()), blockTexture(ModBlocks.SEMI_STRIPPED_MANGROVE_LOG.get()),
                new ResourceLocation(Kaglic.MOD_ID, "block/semi_stripped_mangrove_log_top"));

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}