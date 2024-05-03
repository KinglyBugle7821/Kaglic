package net.kinglybugle.kaglic.item;

import net.kinglybugle.kaglic.Kaglic;
import net.kinglybugle.kaglic.fluid.ModFluids;
import net.kinglybugle.kaglic.item.custom.BarkSpud;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Kaglic.MOD_ID); // creates the registries for ONLY items

    public static  final RegistryObject<Item> BARK_SPUD = ITEMS.register( "bark_spud",
            () -> new BarkSpud(new Item.Properties().stacksTo(1).durability(127)));

    public static final RegistryObject<Item> RESIN_BALL = ITEMS.register("resin_ball",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASH_DUST = ITEMS.register("ash_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLASTIC_SHEET = ITEMS.register("plastic_sheet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WHITE_PLASTIC_SHEET = ITEMS.register("white_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RED_PLASTIC_SHEET = ITEMS.register("red_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORANGE_PLASTIC_SHEET = ITEMS.register("orange_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PINK_PLASTIC_SHEET = ITEMS.register("pink_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YELLOW_PLASTIC_SHEET = ITEMS.register("yellow_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIME_PLASTIC_SHEET = ITEMS.register("lime_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GREEN_PLASTIC_SHEET = ITEMS.register("green_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_BLUE_PLASTIC_SHEET = ITEMS.register("light_blue_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CYAN_PLASTIC_SHEET = ITEMS.register("cyan_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLUE_PLASTIC_SHEET = ITEMS.register("blue_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGENTA_PLASTIC_SHEET = ITEMS.register("magenta_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PURPLE_PLASTIC_SHEET = ITEMS.register("purple_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BROWN_PLASTIC_SHEET = ITEMS.register("brown_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRAY_PLASTIC_SHEET = ITEMS.register("gray_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_GRAY_PLASTIC_SHEET = ITEMS.register("light_gray_plastic_sheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLACK_PLASTIC_SHEET = ITEMS.register("black_plastic_sheet",
            () -> new Item(new Item.Properties()));

    // Adds another item
    public static  final RegistryObject<Item> CRUDE_OIL_BUCKET = ITEMS.register( "crude_oil_bucket",
            () -> new BucketItem(ModFluids.SOURCE_CRUDE_OIL, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
