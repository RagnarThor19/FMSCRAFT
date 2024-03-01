package net.ragnar.fms_craft.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ragnar.fms_craft.FMSmod;

import java.awt.event.ItemEvent;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FMSmod.MOD_ID);

    public static final RegistryObject<Item> RONGEM = ITEMS.register("rongem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_RONGEM = ITEMS.register("raw_rongem",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
