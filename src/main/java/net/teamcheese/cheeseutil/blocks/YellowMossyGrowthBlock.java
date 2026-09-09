package net.teamcheese.cheeseutil.blocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.block.Block;



public class YellowMossyGrowthBlock extends Block implements BonemealableBlock
{



    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.tick(state, level, pos, random);
    }



    public YellowMossyGrowthBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return level.getBlockState(pos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }


// This is such a stupid implementation but its 3am and i worked a double today. I'll fix it later by implementing an actual mapcodec for this block. Also needs air above.
    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {


        BlockPos min = new BlockPos(pos.getX()-(random.nextIntBetweenInclusive(1,4)) , pos.getY()-1, pos.getZ() - random.nextIntBetweenInclusive(1,4));
        BlockPos max = new BlockPos(pos.getX()+random.nextIntBetweenInclusive(1,4), pos.getY()+1, pos.getZ()+random.nextIntBetweenInclusive(1,4));

        for (BlockPos changedBlock : BlockPos.betweenClosed(min, max)) {
            BlockState changedBlockState = level.getBlockState(changedBlock);
            if(changedBlockState.is(Blocks.STONE)){
            level.setBlock(
                    changedBlock,
                    state,
                    Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE
            );
        }}
    }

    @Override
    public BonemealableBlock.Type getType() {
        return BonemealableBlock.Type.NEIGHBOR_SPREADER;
    }
}
