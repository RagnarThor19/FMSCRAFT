package net.ragnar.fms_craft.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.ragnar.fms_craft.FMSmod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_RONITE_TOOL = tag("needs_ronite_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(FMSmod.MOD_ID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(FMSmod.MOD_ID, name));
        }
    }
}
