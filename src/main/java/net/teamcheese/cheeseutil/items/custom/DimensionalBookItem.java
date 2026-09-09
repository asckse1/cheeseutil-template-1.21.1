package net.teamcheese.cheeseutil.items.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.teamcheese.cheeseutil.DimUtils;

import static net.minecraft.world.level.Level.*;
import static net.teamcheese.cheeseutil.DimUtils.*;

public class DimensionalBookItem extends Item {
    public String dimNamepsace;
    public String dimPath;
    public ResourceKey dimKey;

    public DimensionalBookItem(Properties properties, String dimNamepsace, String dimPath) {

        super(properties);
        this.dimKey = ResourceKey.create(
                Registries.DIMENSION,
                ResourceLocation.fromNamespaceAndPath(dimNamepsace, dimPath)


        );



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

                ServerLevel targetDim = bookUser.server.getLevel(dimKey);
                if(bookUser.serverLevel() != targetDim){
                    BlockPos targetBlock = findSafePosition(targetDim, bookUser);
                    DimUtils.sendToDim(bookUser,targetDim,targetBlock);



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
