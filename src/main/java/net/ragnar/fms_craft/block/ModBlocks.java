package net.ragnar.fms_craft.block;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ragnar.fms_craft.FMSmod;
import net.ragnar.fms_craft.block.custom.KraekiberCropBlock;
import net.ragnar.fms_craft.item.ModItems;
import net.minecraft.world.level.block.FlowerBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FMSmod.MOD_ID);

    public static final RegistryObject<Block> RONGEM_BLOCK = registerBlock("rongem_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).sound(SoundType.AMETHYST).lightLevel((p_50755_) -> {
                return 14;
            })));

    public static final RegistryObject<Block> RAW_RONGEM_BLOCK = registerBlock("raw_rongem_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST).lightLevel((p_50755_) -> {
                return 7;
            })));

    public static final RegistryObject<Block> RONITE_BLOCK = registerBlock("ronite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST).lightLevel((p_50755_) -> {
                        return 20;
                    })));

    public static final RegistryObject<Block> KRAEKIBER_CROP = BLOCKS.register("kraekiber_crop",
            () -> new KraekiberCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> LUPINA = registerBlock("lupina",
            () -> new FlowerBlock(MobEffects.WEAKNESS, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    
    public static final RegistryObject<Block> POTTED_LUPINA = BLOCKS.register("potted_lupina",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.LUPINA,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
