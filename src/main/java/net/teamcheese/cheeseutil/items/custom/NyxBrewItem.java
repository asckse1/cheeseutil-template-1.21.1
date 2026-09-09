package net.teamcheese.cheeseutil.items.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;
import net.teamcheese.cheeseutil.DimUtils;

import static net.minecraft.world.level.Level.NETHER;
import static net.minecraft.world.level.Level.OVERWORLD;
import static net.teamcheese.cheeseutil.DimUtils.findSafePosition;
import static net.teamcheese.cheeseutil.DimUtils.sendToDim;

public class NyxBrewItem extends PotionItem {
    public NyxBrewItem(Properties properties) {
        super(properties);
    }
    public static final ResourceKey<Level> twilightForest = ResourceKey.create(
            Registries.DIMENSION,
            ResourceLocation.fromNamespaceAndPath("twilightforest", "twilight_forest")
            );

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
            player.sendSystemMessage(Component.translatable("net.teamcheese.cheeseutils.nyx_message_enter"));
            if(player instanceof ServerPlayer) {
                ServerPlayer user = (ServerPlayer) player;
                ServerLevel targetDim = user.server.getLevel(twilightForest);
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
