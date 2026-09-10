package net.teamcheese.cheeseutil.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class MossyGrowthBlock extends Block implements BonemealableBlock  {

    public MossyGrowthBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos pos, BlockState state) {


        BlockPos min = new BlockPos(pos.getX()-(randomSource.nextIntBetweenInclusive(1,4)) , pos.getY()-1, pos.getZ() - randomSource.nextIntBetweenInclusive(1,4));
        BlockPos max = new BlockPos(pos.getX()+randomSource.nextIntBetweenInclusive(1,4), pos.getY()+1, pos.getZ()+randomSource.nextIntBetweenInclusive(1,4));

        for (BlockPos changedBlock : BlockPos.betweenClosed(min, max)) {
            BlockState changedBlockState = level.getBlockState(changedBlock);
            if(changedBlockState.is(Blocks.STONE)){
                level.setBlock(
                        changedBlock,
                        state,
                        Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE
                );

            if(changedBlockState.is(Blocks.IRON_ORE))  {
                level.setBlock(
                        changedBlock,
                        ModBlocks.MOSSY_IRON_ORE.get().defaultBlockState(),
                        Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE

                );
            }
            }
        }

    }
}
