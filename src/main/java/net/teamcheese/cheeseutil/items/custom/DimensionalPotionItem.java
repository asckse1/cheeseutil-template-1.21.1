package net.teamcheese.cheeseutil.items.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.teamcheese.cheeseutil.DimUtils;

import static net.minecraft.world.level.Level.OVERWORLD;
import static net.teamcheese.cheeseutil.DimUtils.findSafePosition;
import static net.teamcheese.cheeseutil.DimUtils.sendToDim;

public class DimensionalPotionItem extends PotionItem {

    public String dimNamespace = "minecraft";
    public String dimPath = "overworld";
    public ResourceKey<Level> dimensionKey;
    public DimensionalPotionItem(Properties properties, String dimNamespace, String dimPath) {
        super(properties);
        this.dimNamespace = dimNamespace;
        this.dimPath = dimPath;
        this.dimensionKey = ResourceKey.create(
                Registries.DIMENSION,
                ResourceLocation.fromNamespaceAndPath(dimNamespace, dimPath)
        );

    }


    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 32;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        Player player = entityLiving instanceof Player ? (Player)entityLiving : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
        }

        if (!level.isClientSide) {
            entityLiving.addEffect( new MobEffectInstance(
                    MobEffects.BLINDNESS,
                    20,

                    1

            ));
            entityLiving.addEffect( new MobEffectInstance(
                    MobEffects.DAMAGE_RESISTANCE,
                    200,

                    50

            ));
            player.sendSystemMessage(Component.translatable("net.teamcheese.cheeseutils.nyx_message_enter"));
            if(player instanceof ServerPlayer) {
                ServerPlayer user = (ServerPlayer) player;
                ServerLevel targetDim = user.server.getLevel(dimensionKey);
                if (user.serverLevel() != targetDim) {
                    BlockPos targetBlock = findSafePosition(targetDim, user);
                    sendToDim(user, targetDim, targetBlock);


                } else {
                    targetDim = user.server.getLevel(OVERWORLD);
                    BlockPos targetBlock = findSafePosition(targetDim, user);
                    DimUtils.sendToDim(user, targetDim, targetBlock);

                }
            }


        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            stack.consume(1, player);
        }

        if (player == null || !player.hasInfiniteMaterials()) {
            if (stack.isEmpty()) {
                return new ItemStack(Items.GLASS_BOTTLE);
            }

            if (player != null) {
                player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
            }
        }

        entityLiving.gameEvent(GameEvent.DRINK);
        return stack;

    }
}
