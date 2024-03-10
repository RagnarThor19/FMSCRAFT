package net.ragnar.fms_craft.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ragnar.fms_craft.FMSmod;
import net.minecraft.network.chat.Component;
import net.ragnar.fms_craft.block.ModBlocks;


import java.awt.*;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FMSmod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> FMSCRAFT_TAB = CREATIVE_MODE_TABS.register("fmscraft_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RONGEM.get()))
                    .title(Component.translatable("creativetab.fmscraft_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RONGEM.get());
                        pOutput.accept(ModItems.RAW_RONGEM.get());
                        pOutput.accept(ModBlocks.RONGEM_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_RONGEM_BLOCK.get());
                        pOutput.accept(ModItems.BLUNT_ITEM.get());
                        pOutput.accept(ModItems.JOINT.get());
                        pOutput.accept(ModItems.CHEESEBURGER.get());
                        pOutput.accept(ModItems.RONGEM_STICK.get());
                        pOutput.accept(ModItems.RONITE_INGOT.get());
                        pOutput.accept(ModBlocks.RONITE_BLOCK.get());
                        pOutput.accept(ModItems.RONITE_SWORD.get());
                        pOutput.accept(ModItems.RONITE_PICKAXE.get());
                        pOutput.accept(ModItems.RONITE_AXE.get());
                        pOutput.accept(ModItems.RONITE_SHOVEL.get());
                        pOutput.accept(ModItems.RONITE_HOE.get());
                        pOutput.accept(ModItems.RONITE_HELMET.get());
                        pOutput.accept(ModItems.RONITE_CHESTPLATE.get());
                        pOutput.accept(ModItems.RONITE_LEGGINGS.get());
                        pOutput.accept(ModItems.RONITE_BOOTS.get());


                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
