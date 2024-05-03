package net.kinglybugle.kaglic.datagen;

import net.kinglybugle.kaglic.Kaglic;
import net.kinglybugle.kaglic.block.ModBlocks;
import net.kinglybugle.kaglic.item.ModItems;
import net.kinglybugle.kaglic.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Kaglic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.SEMI_STRIPPED_OAK_LOG.get().asItem())
                .add(ModBlocks.SEMI_STRIPPED_DARK_OAK_LOG.get().asItem())
                .add(ModBlocks.SEMI_STRIPPED_ACACIA_LOG.get().asItem())
                .add(ModBlocks.SEMI_STRIPPED_CHERRY_LOG.get().asItem())
                .add(ModBlocks.SEMI_STRIPPED_BIRCH_LOG.get().asItem())
                .add(ModBlocks.SEMI_STRIPPED_JUNGlE_LOG.get().asItem())
                .add(ModBlocks.SEMI_STRIPPED_SPRUCE_LOG.get().asItem())
                .add(ModBlocks.SEMI_STRIPPED_MANGROVE_LOG.get().asItem());
        this.tag(ModTags.Items.PLASTIC_ITEM)
                .add(ModItems.PLASTIC_SHEET.get())
                .add(ModItems.WHITE_PLASTIC_SHEET.get())
                .add(ModItems.RED_PLASTIC_SHEET.get())
                .add(ModItems.ORANGE_PLASTIC_SHEET.get())
                .add(ModItems.PINK_PLASTIC_SHEET.get())
                .add(ModItems.YELLOW_PLASTIC_SHEET.get())
                .add(ModItems.LIME_PLASTIC_SHEET.get())
                .add(ModItems.GREEN_PLASTIC_SHEET.get())
                .add(ModItems.LIGHT_BLUE_PLASTIC_SHEET.get())
                .add(ModItems.CYAN_PLASTIC_SHEET.get())
                .add(ModItems.BLUE_PLASTIC_SHEET.get())
                .add(ModItems.MAGENTA_PLASTIC_SHEET.get())
                .add(ModItems.PURPLE_PLASTIC_SHEET.get())
                .add(ModItems.BROWN_PLASTIC_SHEET.get())
                .add(ModItems.GRAY_PLASTIC_SHEET.get())
                .add(ModItems.LIGHT_GRAY_PLASTIC_SHEET.get())
                .add(ModItems.BLACK_PLASTIC_SHEET.get());
        this.tag(ModTags.Items.DYE_ITEM)
                .add(Items.COAL)
                .add(Items.WHITE_DYE)
                .add(Items.RED_DYE)
                .add(Items.ORANGE_DYE)
                .add(Items.PINK_DYE)
                .add(Items.YELLOW_DYE)
                .add(Items.LIME_DYE)
                .add(Items.GREEN_DYE)
                .add(Items.LIGHT_BLUE_DYE)
                .add(Items.CYAN_DYE)
                .add(Items.BLUE_DYE)
                .add(Items.MAGENTA_DYE)
                .add(Items.PURPLE_DYE)
                .add(Items.BROWN_DYE)
                .add(Items.GRAY_DYE)
                .add(Items.LIGHT_GRAY_DYE)
                .add(Items.BLACK_DYE);
    }
}
