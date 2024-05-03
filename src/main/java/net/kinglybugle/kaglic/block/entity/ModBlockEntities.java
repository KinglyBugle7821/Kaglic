package net.kinglybugle.kaglic.block.entity;

import net.kinglybugle.kaglic.Kaglic;
import net.kinglybugle.kaglic.block.ModBlocks;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Kaglic.MOD_ID);

    public static final RegistryObject<BlockEntityType<InjectionMoldingMachineBlockEntity>> INJECTION_MOLDING_BE =
            BLOCK_ENTITIES.register("injection_molding_be", () ->
                    BlockEntityType.Builder.of(InjectionMoldingMachineBlockEntity::new,
                            ModBlocks.INJECTION_MOLDING_MACHINE.get()).build(null));
    public static final RegistryObject<BlockEntityType<CoalGeneratorBlockEntity>> COAL_GENERATOR_BE =
            BLOCK_ENTITIES.register("coal_generator_be", () ->
                    BlockEntityType.Builder.of(CoalGeneratorBlockEntity::new,
                            ModBlocks.COAL_GENERATOR.get()).build(null));


    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }

}
