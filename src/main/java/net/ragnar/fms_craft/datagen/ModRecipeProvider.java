package net.ragnar.fms_craft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.ragnar.fms_craft.FMSmod;
import net.ragnar.fms_craft.block.ModBlocks;
import net.ragnar.fms_craft.item.ModItems;

import java.util.Iterator;
import java.util.List;

public class ModRecipeProvider extends RecipeProvider {

    private static final List<ItemLike> RONGEN_SMELTABLES = List.of(ModItems.RAW_RONGEM.get(), ModBlocks.RAW_RONGEM_BLOCK.get());

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // Here you define the experience and cooking time for each recipe
        float experience = 0.7f; // Experience gained from smelting/blasting
        int smeltingTime = 200;  // Standard smelting time in ticks
        int blastingTime = 100;  // Standard blasting time in ticks

        oreSmelting(recipeOutput, RONGEN_SMELTABLES, RecipeCategory.MISC, ModItems.RONGEM.get(), experience, smeltingTime, "rongem_smelting");
        oreBlasting(recipeOutput, RONGEN_SMELTABLES, RecipeCategory.MISC, ModItems.RONGEM.get(), experience, blastingTime, "rongem_blasting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.RONGEM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RONGEM.get())
                .unlockedBy(getHasName(ModItems.RONGEM.get()), has(ModItems.RONGEM.get()))
                .save(recipeOutput, FMSmod.MOD_ID + ":rongem_block_from_rongem");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.RONITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RONITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.RONITE_INGOT.get()), has(ModItems.RONITE_INGOT.get()))
                .save(recipeOutput, FMSmod.MOD_ID + ":ronite_block_from_ronite");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUNT_ITEM.get())
                .pattern("#$")
                .define('#', Items.GRASS)
                .define('$', Items.PAPER)
                .unlockedBy("has_grass", has(Items.GRASS))
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(recipeOutput, FMSmod.MOD_ID + ":blunt_item");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHEESEBURGER.get())
                .pattern("X")
                .pattern("B")
                .pattern("X")
                .define('X', Items.BREAD)
                .define('B', Items.COOKED_BEEF)
                .unlockedBy("has_bread", has(Items.BREAD))
                .unlockedBy("has_cooked_beef", has(Items.COOKED_BEEF))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RONITE_SWORD.get())
                .pattern("X")
                .pattern("X")
                .pattern("B")
                .define('X', ModItems.RONITE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_ronite_ingot", has(ModItems.RONITE_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RONITE_PICKAXE.get())
                .pattern("XXX")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', ModItems.RONITE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_ronite_ingot", has(ModItems.RONITE_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RONITE_AXE.get())
                .pattern(" XX")
                .pattern(" BX")
                .pattern(" B ")
                .define('X', ModItems.RONITE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_ronite_ingot", has(ModItems.RONITE_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RONITE_SHOVEL.get())
                .pattern(" X ")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', ModItems.RONITE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_ronite_ingot", has(ModItems.RONITE_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RONITE_HOE.get())
                .pattern("XX ")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', ModItems.RONITE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_ronite_ingot", has(ModItems.RONITE_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JOINT.get())
                .pattern("X#$")
                .define('#', Items.GRASS)
                .define('$', Items.PAPER)
                .define('X', Items.WHEAT_SEEDS)
                .unlockedBy("has_grass", has(Items.GRASS))
                .unlockedBy("has_paper", has(Items.PAPER))
                .unlockedBy("has_wheat_seeds", has(Items.WHEAT_SEEDS))
                .save(recipeOutput, FMSmod.MOD_ID + ":joint_item");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RONGEM.get(), 9)
                .requires(ModBlocks.RONGEM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RONGEM_BLOCK.get()), has(ModBlocks.RONGEM_BLOCK.get()))
                .save(recipeOutput, FMSmod.MOD_ID + ":rongem_from_rongem_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RONITE_INGOT.get(), 9)
                .requires(ModBlocks.RONITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RONITE_BLOCK.get()), has(ModBlocks.RONITE_BLOCK.get()))
                .save(recipeOutput, FMSmod.MOD_ID + ":ronite_from_ronite_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RONGEM_STICK.get())
                .pattern("X  ")
                .pattern(" Z ")
                .pattern("  V")
                .define('X', ModBlocks.RONGEM_BLOCK.get())
                .define('Z', Items.STICK)
                .define('V', Blocks.GOLD_BLOCK)
                .unlockedBy("has_rongem_block", has(ModBlocks.RONGEM_BLOCK.get()))
                .unlockedBy("has_gold_block", has(Blocks.GOLD_BLOCK))
                .save(recipeOutput, FMSmod.MOD_ID + "rongem_stick");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RONITE_INGOT.get())
                .pattern("#$#")
                .pattern("$X$")
                .pattern("#$#")
                .define('#', ModItems.RONGEM.get())
                .define('$', Items.DIAMOND)
                .define('X', ModItems.JOINT.get())
                .unlockedBy(getHasName(ModItems.RONGEM.get()), has(ModItems.RONGEM.get()))
                .save(recipeOutput, FMSmod.MOD_ID + "rongem_ingot");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, ingredients, category, result, experience, cookingTime, group, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, ingredients, category, result, experience, cookingTime, group, "_from_blasting");
    }

    private static void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pRecipeOutput, getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }
}
