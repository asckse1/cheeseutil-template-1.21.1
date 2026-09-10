package net.teamcheese.cheeseutil.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.teamcheese.cheeseutil.CheeseUtil;
import net.teamcheese.cheeseutil.items.custom.FuelItem;
import net.teamcheese.cheeseutil.items.custom.GrowthCatalystItem;
import net.teamcheese.cheeseutil.items.custom.DimensionalBookItem;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamcheese.cheeseutil.items.custom.DimensionalPotionItem;

import java.util.List;


public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CheeseUtil.MODID);


    public static final DeferredItem<Item> BLACK_MOSS_CULTURE = ITEMS.register("charred_moss_culture",
            () -> new FuelItem(new Item.Properties(), 800)

    );
    public static final DeferredItem<Item> BLUE_MOSS_CULTURE = ITEMS.register( "blue_moss_culture",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RED_MOSS_CULTURE = ITEMS.register( "red_moss_culture",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_MOSS_CULTURE = ITEMS.register( "yellow_moss_culture",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLAIN_MOSS_CULTURE = ITEMS.register( "moss_culture",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STONE_CULTURING_KNIFE = ITEMS.register( "stone_culturing_knife",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MOSSY_IRON = ITEMS.register( "mossy_iron",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_MOSSY_IRON = ITEMS.register("raw_mossy_iron",
            () -> new Item(new Item.Properties()));




    public static final DeferredItem<Item> NETHER_BOOK = ITEMS.register("nether_grimoire",
            () -> new DimensionalBookItem(new Item.Properties(), "minecraft", "nether") {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.cheeseutil.nyxpot"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }

            }  );
    public static final DeferredItem<Item> NYX_BREW = ITEMS.register("nyx_brew",
            () -> new DimensionalPotionItem(new Item.Properties(), "twilightforest", "twilight_forest"){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.cheeseutil.nyxpot"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }



    });


    public static final DeferredItem<Item> RED_MOSS_BOWL = ITEMS.register("red_moss_bowl",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RedMossBowl)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.cheeseutil.mossbowl"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }
            );
    public static final DeferredItem<Item> BLUE_MOSS_BOWL = ITEMS.register("blue_moss_bowl",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BlueMossBowl)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.cheeseutil.mossbowl"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }
    );

    public static final DeferredItem<Item> GROWTH_CATALYST = ITEMS.register("moss_growth_catalyst",
            () -> new GrowthCatalystItem(new Item.Properties()));

    public static void register(IEventBus eventBus){
       ITEMS.register(eventBus);

   }    // BlockItems


}
