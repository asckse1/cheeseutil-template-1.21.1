package net.teamcheese.cheeseutil.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties RedMossBowl = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5f).effect(
            () -> new MobEffectInstance(
                    MobEffects.REGENERATION,
                    400,
                    2
            ), 1.0f).usingConvertsTo(Items.BOWL).build();
    public static final FoodProperties BlueMossBowl = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5f).effect(
            () -> new MobEffectInstance(
                    MobEffects.WATER_BREATHING,
                    1400,
                    1
            )
            , 1.0f).usingConvertsTo(Items.BOWL).build();


}
