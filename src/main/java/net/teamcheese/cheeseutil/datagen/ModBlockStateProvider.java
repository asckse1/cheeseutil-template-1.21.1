package net.teamcheese.cheeseutil.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.teamcheese.cheeseutil.CheeseUtil;
import net.teamcheese.cheeseutil.blocks.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CheeseUtil.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        //blocks
    blockWithItem(ModBlocks.BLUE_MOSS_BLOCK);
    blockWithItem(ModBlocks.CHARRED_MOSS_BLOCK);
    blockWithItem(ModBlocks.RED_MOSS_BLOCK);
    blockWithItem(ModBlocks.YELLOW_MOSS_BLOCK);
    //carpets
    blockWithItem(ModBlocks.BLUE_MOSS_CARPET);
    blockWithItem(ModBlocks.RED_MOSS_CARPET);
    blockWithItem(ModBlocks.CHARRED_MOSS_CARPET);
    blockWithItem(ModBlocks.YELLOW_MOSS_CARPET);
    //growths
    blockWithItem(ModBlocks.YELLOW_MOSSY_GROWTH);
    blockWithItem(ModBlocks.RED_MOSSY_GROWTH);
    blockWithItem(ModBlocks.CHARRED_MOSSY_GROWTH);
    blockWithItem(ModBlocks.BLUE_MOSSY_GROWTH);
    }
    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(Blocks.STRUCTURE_BLOCK));

    }
}
