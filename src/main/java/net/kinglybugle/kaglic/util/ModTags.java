package net.kinglybugle.kaglic.util;

import net.kinglybugle.kaglic.Kaglic;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {


        public static final TagKey<Block> ENERGY_BLOCK = tag("energy_block");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Kaglic.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> PLASTIC_ITEM = tag("plastic_item");
        public static final TagKey<Item> DYE_ITEM = tag("dye_item");


        private static TagKey<Item> tag(String name) {

            return ItemTags.create(new ResourceLocation(Kaglic.MOD_ID, name));
        }
    }
}