package net.teamcheese.cheeseutil;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;



public class DimUtils {

    public static BlockPos findSafePosition(ServerLevel level, ServerPlayer player) {

        double xPos = player.getX();
        double yPos = player.getY();
        double zPos = player.getZ();
        BlockPos targetPos = new BlockPos((int)xPos, 70, (int)zPos);
        for ( double xCheck = xPos -30; xCheck <= xPos +30; xCheck ++){
            for(double yCheck = yPos -30; yCheck <= yPos + 30; yCheck++){
                for(double zCheck = zPos -30; zCheck <= zPos +30 ; zCheck++){
                    BlockPos bottomHalf = new BlockPos((int) xCheck, (int) yCheck, (int) zCheck);
                    BlockPos topHalf = new BlockPos((int) xCheck, (int) yCheck + 1, (int) zCheck);
                    BlockPos beneathPlayer = new BlockPos((int) xCheck, (int) yCheck -1, (int) zCheck);
                    BlockState topHalfState = level.getBlockState(topHalf);
                    BlockState bottomHalfState = level.getBlockState(bottomHalf);
                    BlockState beneathPlayerState = level.getBlockState(beneathPlayer);
                    // Now how... brain... pain... its 3am...
                    // Following will determine whether or topHalf and bottomHalf are air.
                    // and then also hopefully determine that beneathPlayer is a solid non-harmful block?
                    boolean beneathPlayerSolid = !beneathPlayerState.isAir() && beneathPlayerState.isFaceSturdy(level, beneathPlayer, Direction.UP);
                    boolean canPlayerBreath = topHalfState.isAir() && bottomHalfState.isAir();
                    if (canPlayerBreath && beneathPlayerSolid) {
                    targetPos = new BlockPos((int) xCheck, (int) yCheck, (int) zCheck);
                    return(targetPos);
                    }



                }

            }

        }


        return targetPos;
    }

    public static void sendToDim(ServerPlayer player, ServerLevel level, BlockPos targetBlock){
        Vec3 targetPosition = new Vec3(targetBlock.getX(), targetBlock.getY(), targetBlock.getZ());
            DimensionTransition dimTransition = new DimensionTransition(
                level,
                targetPosition,
                player.getDeltaMovement(),
                player.getYRot(),
                player.getXRot(),
                DimensionTransition.PLAY_PORTAL_SOUND


                );

         player.changeDimension(dimTransition);

    }
}
