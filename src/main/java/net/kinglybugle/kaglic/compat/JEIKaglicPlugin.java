package net.kinglybugle.kaglic.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.kinglybugle.kaglic.Kaglic;
import net.kinglybugle.kaglic.recipe.InjectionMoldingRecipe;
import net.kinglybugle.kaglic.screen.InjectionMoldingMachineScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import javax.swing.*;
import java.util.List;

@JeiPlugin
public class JEIKaglicPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Kaglic.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new InjectionMoldingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<InjectionMoldingRecipe> moldingRecipes = recipeManager.getAllRecipesFor(InjectionMoldingRecipe.Type.INSTANCE);
        registration.addRecipes(InjectionMoldingCategory.INJECTION_MOLDING_TYPE, moldingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(InjectionMoldingMachineScreen.class, 102, 15,8,30,
                InjectionMoldingCategory.INJECTION_MOLDING_TYPE);
    }
}
