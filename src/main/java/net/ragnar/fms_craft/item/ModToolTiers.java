package net.ragnar.fms_craft.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.ragnar.fms_craft.FMSmod;
import net.ragnar.fms_craft.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier RONITE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2200, 30f, 1f, 20,
                    ModTags.Blocks.NEEDS_RONITE_TOOL, () -> Ingredient.of(ModItems.RONGEM.get())),
            new ResourceLocation(FMSmod.MOD_ID, "ronite"), List.of(Tiers.NETHERITE), List.of());
}
