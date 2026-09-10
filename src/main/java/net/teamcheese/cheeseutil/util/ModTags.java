package net.teamcheese.cheeseutil.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.teamcheese.cheeseutil.CheeseUtil;

public class ModTags {
    public static class Blocks{

        public static final TagKey<Block> MOSS_BLOCKS = createTag("moss_block");
        public static final TagKey<Block> MOSSY_GROWTHS = createTag("moss_growths");
        public static final TagKey<Block> ORES = createTag("ores");
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CheeseUtil.MODID, name));
        }
    }
    public static class Items{
        public static final TagKey<Item> MOSS_CULTURES = createTag("moss_cultures");
        private static TagKey<Item> createTag(String name) {
           return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CheeseUtil.MODID, name));
        }

    }
}
