package net.teamcheese.cheeseutil.items.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.teamcheese.cheeseutil.CheeseUtil;
import net.teamcheese.cheeseutil.blocks.ModBlocks;
import net.teamcheese.cheeseutil.items.ModItems;
import net.teamcheese.cheeseutil.util.ModTags;

public class CulturingKnife extends Item {

    public CulturingKnife(Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 1;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return super.getUseAnimation(stack);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        ItemStack catalyst = context.getItemInHand();
        ItemStack droppedItem;
        BlockPos clickedBlockPos = context.getClickedPos();
        BlockState clickedState = level.getBlockState(clickedBlockPos);
        Player player = context.getPlayer();
        Block clickedBlock = clickedState.getBlock();
        String clickedName = BuiltInRegistries.BLOCK.getKey(clickedBlock).toString();
        CheeseUtil.LOGGER.debug(clickedName + " is the name of the clicked block : Search Code (GC001)");
            switch (clickedName){
                case("cheeseutil:charred_mossy_growth"):
                    level.setBlock(context.getClickedPos(), Blocks.AIR.defaultBlockState(), Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE);
                    droppedItem = new ItemStack(ModBlocks.CHARRED_MOSS_BLOCK.asItem(), 1);
                    ItemEntity droppedItemEntity = new ItemEntity(level, context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), droppedItem);
                    level.addFreshEntity(droppedItemEntity);
                    break;
                case("cheeseutil:yellow_moss_block"):

                    level.setBlock(context.getClickedPos(), Blocks.AIR.defaultBlockState(), Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE);
                    droppedItem = new ItemStack(ModBlocks.YELLOW_MOSS_BLOCK.asItem(), 1);
                    droppedItemEntity = new ItemEntity(level, context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), droppedItem);
                    level.addFreshEntity(droppedItemEntity);
                    break;
                case("cheeseutil:red_mossy_growth"):

                    level.setBlock(context.getClickedPos(), Blocks.AIR.defaultBlockState(), Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE);
                    droppedItem = new ItemStack(ModBlocks.RED_MOSS_BLOCK.asItem(), 1);
                    droppedItemEntity = new ItemEntity(level, context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), droppedItem);
                    level.addFreshEntity(droppedItemEntity);
                    break;
                case("cheeseutil:blue_mossy_growth"):

                    level.setBlock(context.getClickedPos(), Blocks.AIR.defaultBlockState(), Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE);
                    droppedItem = new ItemStack(ModBlocks.BLUE_MOSS_BLOCK.asItem(), 1);
                    droppedItemEntity = new ItemEntity(level, context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), droppedItem);
                    level.addFreshEntity(droppedItemEntity);
                    break;

                case("cheeseutil:white_mossy_growth"):

                    level.setBlock(context.getClickedPos(), Blocks.AIR.defaultBlockState(), Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE);
                    droppedItem = new ItemStack(ModBlocks.WHITE_MOSS_BLOCK.asItem(), 1);
                    droppedItemEntity = new ItemEntity(level, context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), droppedItem);
                    level.addFreshEntity(droppedItemEntity);
                    break;
                default:
                    CheeseUtil.LOGGER.debug("Not Yet Implemented. SearchCode (NYI001) || POTENTIALLY: Not a valid target for this feature (FC: MGC001) -=- TARGET:" + clickedName);
                    break;
            }




        return super.useOn(context);
    }
}