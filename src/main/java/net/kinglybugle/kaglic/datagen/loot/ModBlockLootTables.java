package net.kinglybugle.kaglic.datagen.loot;

import net.kinglybugle.kaglic.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SEMI_STRIPPED_OAK_LOG.get());
        this.dropSelf(ModBlocks.SEMI_STRIPPED_DARK_OAK_LOG.get());
        this.dropSelf(ModBlocks.SEMI_STRIPPED_ACACIA_LOG.get());
        this.dropSelf(ModBlocks.SEMI_STRIPPED_CHERRY_LOG.get());
        this.dropSelf(ModBlocks.SEMI_STRIPPED_BIRCH_LOG.get());
        this.dropSelf(ModBlocks.SEMI_STRIPPED_JUNGlE_LOG.get());
        this.dropSelf(ModBlocks.SEMI_STRIPPED_SPRUCE_LOG.get());
        this.dropSelf(ModBlocks.SEMI_STRIPPED_MANGROVE_LOG.get());

        this.dropSelf(ModBlocks.INJECTION_MOLDING_MACHINE.get());
        this.dropSelf(ModBlocks.COAL_GENERATOR.get());

        this.dropSelf(ModBlocks.RESIN_EXTRACTOR_EMPTY.get());

        this.add(ModBlocks.RESIN_EXTRACTOR_FULL.get(),
                block -> createSingleItemTable(ModBlocks.RESIN_EXTRACTOR_EMPTY.get()));
    }

//    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
//        return createSilkTouchDispatchTable(pBlock,
//                this.applyExplosionDecay(pBlock,
//                        LootItem.lootTableItem(item)
//                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
//                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
//    }
    protected LootTable.Builder createSingleItemTable(ItemLike pItem, NumberProvider pCount) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(this.applyExplosionDecay(pItem, LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(pCount)))));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}