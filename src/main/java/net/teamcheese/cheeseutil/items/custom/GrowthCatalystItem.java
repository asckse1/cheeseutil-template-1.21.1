package net.teamcheese.cheeseutil.items.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
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
import org.slf4j.LoggerFactory;


public class GrowthCatalystItem extends Item
{
    public static final TagKey<Block> MOSS_BLOCKS = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(CheeseUtil.MODID, "moss_block")

    );
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(GrowthCatalystItem.class);

    public GrowthCatalystItem(Properties properties) {
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
        log.debug(clickedName + " is the name of the clicked block : Search Code (GC001)");
        if(clickedState.is(MOSS_BLOCKS)){
            switch (clickedName){
                case("cheeseutil:charred_moss_block"):
                    level.setBlock(clickedBlockPos, ModBlocks.CHARRED_MOSSY_GROWTH.get().defaultBlockState(), Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE);
                    catalyst.consume(1, player);
                    break;
                case("cheeseutil:yellow_moss_block"):
                    level.setBlock(clickedBlockPos, ModBlocks.YELLOW_MOSSY_GROWTH.get().defaultBlockState(), Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE);
                    catalyst.consume(1, player);
                    break;
                case("cheeseutil:red_moss_block"):

                    log.debug("Not Yet Implemented. SearchCode (NYI001) - ITEM/FEATURE: RED_MOSSY_GROWTH_CONVERSION");
                    break;
                case("cheeseutil:blue_moss_block"):
                    log.debug("Not Yet Implemented. SearchCode (NYI001) - ITEM/FEATURE: BLUE_MOSSY_GROWTH_CONVERSION");
                    break;
                default:
                    log.debug("Not Yet Implemented. SearchCode (NYI001) || POTENTIALLY: Not a valid target for this feature (FC: MGC001) -=- TARGET:" + clickedName);
                    break;
            }



        }
        return super.useOn(context);
    }
}
