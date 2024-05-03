package net.kinglybugle.kaglic.datagen;

import net.kinglybugle.kaglic.Kaglic;
import net.kinglybugle.kaglic.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Kaglic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.CRUDE_OIL_BUCKET);

        simpleItem(ModItems.BARK_SPUD);

        simpleItem(ModItems.RESIN_BALL);
        simpleItem(ModItems.ASH_DUST);

        simpleItem(ModItems.PLASTIC_SHEET);
        simpleItem(ModItems.WHITE_PLASTIC_SHEET);
        simpleItem(ModItems.RED_PLASTIC_SHEET);
        simpleItem(ModItems.ORANGE_PLASTIC_SHEET);
        simpleItem(ModItems.PINK_PLASTIC_SHEET);
        simpleItem(ModItems.YELLOW_PLASTIC_SHEET);
        simpleItem(ModItems.LIME_PLASTIC_SHEET);
        simpleItem(ModItems.GREEN_PLASTIC_SHEET);
        simpleItem(ModItems.LIGHT_BLUE_PLASTIC_SHEET);
        simpleItem(ModItems.CYAN_PLASTIC_SHEET);
        simpleItem(ModItems.BLUE_PLASTIC_SHEET);
        simpleItem(ModItems.MAGENTA_PLASTIC_SHEET);
        simpleItem(ModItems.PURPLE_PLASTIC_SHEET);
        simpleItem(ModItems.BROWN_PLASTIC_SHEET);
        simpleItem(ModItems.GRAY_PLASTIC_SHEET);
        simpleItem(ModItems.LIGHT_GRAY_PLASTIC_SHEET);
        simpleItem(ModItems.BLACK_PLASTIC_SHEET);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Kaglic.MOD_ID,"item/" + item.getId().getPath()));
    }
}