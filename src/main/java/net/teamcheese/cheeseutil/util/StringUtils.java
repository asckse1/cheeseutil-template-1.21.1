package net.teamcheese.cheeseutil.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class StringUtils {
    public static Block getBlockFromString(String blockName){
        ResourceLocation block = ResourceLocation.parse(blockName);
        return BuiltInRegistries.BLOCK.get(block);
    }
}
