package net.kinglybugle.kaglic.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.kinglybugle.kaglic.Kaglic;
import net.kinglybugle.kaglic.block.ModBlocks;
import net.kinglybugle.kaglic.recipe.InjectionMoldingRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class InjectionMoldingCategory implements IRecipeCategory<InjectionMoldingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Kaglic.MOD_ID, "injection_molding");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Kaglic.MOD_ID,
            "textures/gui/container/injection_molding_machine_gui.png");

    public static final RecipeType<InjectionMoldingRecipe> INJECTION_MOLDING_TYPE =
            new RecipeType<>(UID, InjectionMoldingRecipe.class);
    private final IDrawable background;
    private  final IDrawable icon;

    public InjectionMoldingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0,0,176,83);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.INJECTION_MOLDING_MACHINE.get()));
    }

    @Override
    public RecipeType<InjectionMoldingRecipe> getRecipeType() {
        return INJECTION_MOLDING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.kaglic.injection_molding_machine");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, InjectionMoldingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 17).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 17).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 62, 59).addItemStack(recipe.getResultItem(null));


    }
}
