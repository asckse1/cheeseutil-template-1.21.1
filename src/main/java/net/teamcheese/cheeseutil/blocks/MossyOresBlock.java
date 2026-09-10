package net.teamcheese.cheeseutil.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.teamcheese.cheeseutil.CheeseUtil;
import net.teamcheese.cheeseutil.util.ModTags;
import org.apache.commons.logging.Log;

import java.util.ArrayList;
import java.util.List;

import static net.teamcheese.cheeseutil.util.StringUtils.getBlockFromString;


public class MossyOresBlock extends MossyGrowthBlock {

    public MossyOresBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos pos, BlockState state) {
        BlockPos min = new BlockPos(pos.getX()-(randomSource.nextIntBetweenInclusive(1,4)) , pos.getY()-1, pos.getZ() - randomSource.nextIntBetweenInclusive(1,4));
        BlockPos max = new BlockPos(pos.getX()+randomSource.nextIntBetweenInclusive(1,4), pos.getY()+1, pos.getZ()+randomSource.nextIntBetweenInclusive(1,4));


        for (BlockPos changedBlock : BlockPos.betweenClosed(min, max)) {

            // Hopefully this is abstracted now.

           BlockState changedBlockState = level.getBlockState(changedBlock);
            List<Block> ores = new ArrayList<>();
            ores.add(Blocks.IRON_ORE);
            ores.add(Blocks.DIAMOND_ORE);
            if (changedBlockState.is(ModTags.Blocks.ORES)) {


                Block changedBlockBlockClass = changedBlockState.getBlock();
                String ID = changedBlockBlockClass.getDescriptionId();
                String targetID = ID.replace("block.minecraft.", "mossy_");
                Block TargetBlock = getBlockFromString("cheeseutil:" + targetID);
                CheeseUtil.LOGGER.debug("SC STM003 {}", targetID);
                BlockState targetState = TargetBlock.defaultBlockState();
                level.setBlock(
                        changedBlock,
                        targetState,
                        Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE

                );
            }
        }

        super.performBonemeal(level, randomSource, pos, state);
    }
}
