package net.ragnar.fms_craft.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import net.ragnar.fms_craft.block.ModBlocks;
import net.ragnar.fms_craft.block.custom.KraekiberCropBlock;
import net.ragnar.fms_craft.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.RONGEM_BLOCK.get());
        this.dropSelf(ModBlocks.RONITE_BLOCK.get());
        this.add(ModBlocks.RAW_RONGEM_BLOCK.get(),
                block -> createOreDrop(ModBlocks.RAW_RONGEM_BLOCK.get(), ModItems.RAW_RONGEM.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.KRAEKIBER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(KraekiberCropBlock.AGE, 5));

        this.add(ModBlocks.KRAEKIBER_CROP.get(), createCropDrops(ModBlocks.KRAEKIBER_CROP.get(), ModItems.KRAEKIBER.get(),
                ModItems.KRAEKIBER_SEEDS.get(), lootitemcondition$builder));

        this.dropSelf(ModBlocks.LUPINA.get());
        this.add(ModBlocks.POTTED_LUPINA.get(), createPotFlowerItemTable(ModBlocks.LUPINA.get()));

    }

    protected LootTable.Builder createOreDrop(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)this
                .applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
