package net.ragnar.fms_craft.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ragnar.fms_craft.FMSmod;
import net.ragnar.fms_craft.block.ModBlocks;
import net.ragnar.fms_craft.item.custom.BluntItem;
import net.ragnar.fms_craft.item.custom.JointItem;
import net.ragnar.fms_craft.item.custom.ModArmorItem;
import net.ragnar.fms_craft.sound.ModSounds;

import java.awt.event.ItemEvent;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FMSmod.MOD_ID);

    public static final RegistryObject<Item> RONGEM = ITEMS.register("rongem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_RONGEM = ITEMS.register("raw_rongem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RONGEM_STICK = ITEMS.register("rongem_stick",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> RONITE_SWORD = ITEMS.register("ronite_sword",
            () -> new SwordItem(ModToolTiers.RONITE, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> RONITE_PICKAXE = ITEMS.register("ronite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RONITE, 2, 1, new Item.Properties()));
    public static final RegistryObject<Item> RONITE_AXE = ITEMS.register("ronite_axe",
            () -> new AxeItem(ModToolTiers.RONITE, 8, 1, new Item.Properties()));
    public static final RegistryObject<Item> RONITE_SHOVEL = ITEMS.register("ronite_shovel",
            () -> new ShovelItem(ModToolTiers.RONITE, 2, 1, new Item.Properties()));
    public static final RegistryObject<Item> RONITE_HOE = ITEMS.register("ronite_hoe",
            () -> new HoeItem(ModToolTiers.RONITE, 4, 10, new Item.Properties()));

    public static final RegistryObject<Item> RONITE_INGOT = ITEMS.register("ronite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RONITE_HELMET = ITEMS.register("ronite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.RONITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RONITE_CHESTPLATE = ITEMS.register("ronite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RONITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RONITE_LEGGINGS = ITEMS.register("ronite_leggings",
            () -> new ArmorItem(ModArmorMaterials.RONITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RONITE_BOOTS = ITEMS.register("ronite_boots",
            () -> new ArmorItem(ModArmorMaterials.RONITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> CHEESEBURGER = ITEMS.register("cheeseburger",
            () -> new Item(new Item.Properties().food(ModFoods.CHEESEBURGER)));

    public static final RegistryObject<Item> KRAEKIBER = ITEMS.register("kraekiber",
            () -> new Item(new Item.Properties().food(ModFoods.KRAEKIBER)));

    public static final RegistryObject<Item> JOINT = ITEMS.register("joint",
            () -> new JointItem(new Item.Properties().food(ModFoods.JOINT)));
    public static final RegistryObject<Item> BLUNT_ITEM = ITEMS.register("blunt",
            () -> new BluntItem(new Item.Properties().durability(1)));

    public static final RegistryObject<Item> KRAEKIBER_SEEDS = ITEMS.register("kraekiber_seeds",
            () -> new ItemNameBlockItem(ModBlocks.KRAEKIBER_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> FORTIES_CLUB = ITEMS.register("forties_club",
            () -> new RecordItem(6, ModSounds.FORTIES_CLUB, new Item.Properties(). stacksTo(1), 2840));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
