package net.teamcheese.cheeseutil.items.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.teamcheese.cheeseutil.CheeseUtil;
import net.teamcheese.cheeseutil.blocks.ModBlocks;

public class PlainMossCulture extends Item {
    public PlainMossCulture(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        ItemStack catalyst = context.getItemInHand();
        BlockPos clickedBlockPos = context.getClickedPos();
        BlockState clickedState = level.getBlockState(clickedBlockPos);
        Player player = context.getPlayer();
        Block clickedBlock = clickedState.getBlock();
        String clickedName = BuiltInRegistries.BLOCK.getKey(clickedBlock).toString();
        CheeseUtil.LOGGER.debug(clickedName + " is the name of the clicked block : Search Code (GC001)");

        switch (clickedName){
            case("minecraft:iron_ore"):
                level.setBlock(clickedBlockPos, ModBlocks.MOSSY_IRON_ORE.get().defaultBlockState(), Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE);
                catalyst.consume(1, player);
                break;

            default:
                CheeseUtil.LOGGER.debug("Not Yet Implemented. SearchCode (NYI001) || POTENTIALLY: Not a valid target for this feature (FC: MGC001) -=- TARGET:" + clickedName);
                break;
        }




        return super.useOn(context);
    }
}
