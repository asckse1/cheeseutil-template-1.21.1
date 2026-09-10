package net.teamcheese.cheeseutil.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.teamcheese.cheeseutil.CheeseUtil;
import net.teamcheese.cheeseutil.blocks.ModBlocks;
import net.teamcheese.cheeseutil.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CheeseUtil.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MOSSY_IRON_ORE.get());
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MOSSY_IRON_ORE.get());
        tag(BlockTags.DAMPENS_VIBRATIONS)
                .add(ModBlocks.MOSSY_IRON_ORE.get());
        tag(BlockTags.FALL_DAMAGE_RESETTING)
                .add(ModBlocks.MOSSY_IRON_ORE.get());
        tag(ModTags.Blocks.MOSS_BLOCKS)
                .add(ModBlocks.BLUE_MOSS_BLOCK.get())
                .add(ModBlocks.YELLOW_MOSS_BLOCK.get())
                .add(ModBlocks.RED_MOSS_BLOCK.get())
                .add(ModBlocks.CHARRED_MOSS_BLOCK.get());
        tag(ModTags.Blocks.ORES)
                .add(Blocks.IRON_ORE);
    }
}
