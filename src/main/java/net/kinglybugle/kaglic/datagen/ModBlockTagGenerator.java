package net.kinglybugle.kaglic.datagen;

import net.kinglybugle.kaglic.Kaglic;
import net.kinglybugle.kaglic.block.ModBlocks;
import net.kinglybugle.kaglic.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Kaglic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RESIN_EXTRACTOR_EMPTY.get(),
                        ModBlocks.RESIN_EXTRACTOR_FULL.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.SEMI_STRIPPED_OAK_LOG.get(),
                        ModBlocks.SEMI_STRIPPED_SPRUCE_LOG.get(),
                        ModBlocks.SEMI_STRIPPED_MANGROVE_LOG.get(),
                        ModBlocks.SEMI_STRIPPED_JUNGlE_LOG.get(),
                        ModBlocks.SEMI_STRIPPED_ACACIA_LOG.get(),
                        ModBlocks.SEMI_STRIPPED_DARK_OAK_LOG.get(),
                        ModBlocks.SEMI_STRIPPED_CHERRY_LOG.get(),
                        ModBlocks.SEMI_STRIPPED_BIRCH_LOG.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL);
//                .add(ModBlocks.RONALDO_BLOCK.get(),
//                        ModBlocks.RONALDO_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(BlockTags.NEEDS_STONE_TOOL);

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.SEMI_STRIPPED_OAK_LOG.get())
                .add(ModBlocks.SEMI_STRIPPED_DARK_OAK_LOG.get())
                .add(ModBlocks.SEMI_STRIPPED_ACACIA_LOG.get())
                .add(ModBlocks.SEMI_STRIPPED_CHERRY_LOG.get())
                .add(ModBlocks.SEMI_STRIPPED_BIRCH_LOG.get())
                .add(ModBlocks.SEMI_STRIPPED_JUNGlE_LOG.get())
                .add(ModBlocks.SEMI_STRIPPED_SPRUCE_LOG.get())
                .add(ModBlocks.SEMI_STRIPPED_MANGROVE_LOG.get());

        this.tag(ModTags.Blocks.ENERGY_BLOCK)
                .add(ModBlocks.COAL_GENERATOR.get())
                .add(ModBlocks.INJECTION_MOLDING_MACHINE.get());


    }
}