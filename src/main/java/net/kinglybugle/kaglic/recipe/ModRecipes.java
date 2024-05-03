package net.kinglybugle.kaglic.recipe;

import net.kinglybugle.kaglic.Kaglic;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Kaglic.MOD_ID);

    public static final RegistryObject<RecipeSerializer<InjectionMoldingRecipe>> INJECTION_MOLDING_SERIALIZER =
            SERIALIZERS.register("injection_molding", () -> InjectionMoldingRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<CoalGeneratorRecipe>> COAL_GENERATOR_SERIALIZER =
            SERIALIZERS.register("coal_generator", () -> CoalGeneratorRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
