package net.teamcheese.cheeseutil.items.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.teamcheese.cheeseutil.DimUtils;

import static net.minecraft.world.level.Level.*;
import static net.teamcheese.cheeseutil.DimUtils.*;

public class NetherBookItem extends Item {
    public NetherBookItem(Properties properties) {
        super(properties);
    }







    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 20;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if(!level.isClientSide){
            if(livingEntity instanceof ServerPlayer){

                ServerPlayer bookUser = (ServerPlayer) livingEntity;

                ServerLevel nether = bookUser.server.getLevel(NETHER);
                if(bookUser.serverLevel() != nether){
                    BlockPos targetBlock = findSafePosition(nether, bookUser);
                    DimUtils.sendToDim(bookUser,nether,targetBlock);



                } else {
                    ServerLevel overworld = bookUser.server.getLevel(OVERWORLD);
                    BlockPos targetBlock = findSafePosition(overworld, bookUser);
                    DimUtils.sendToDim(bookUser,overworld,targetBlock);

                    }


        }


    }
        return super.finishUsingItem(stack, level, livingEntity);
    }


}
