package net.teamcheese.cheeseutil.items;

import net.teamcheese.cheeseutil.CheeseUtil;
import net.teamcheese.cheeseutil.blocks.ModSimpleBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.network.configuration.CheckExtensibleEnums;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CheeseUtil.MODID);
    public static final Supplier<CreativeModeTab> MOSS_BLOCKS_TAB = CREATIVE_MODE_TAB.register("moss_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModSimpleBlocks.YELLOW_MOSS_BLOCK.get()))
                    .title(Component.translatable("creativetab.cheeseutil.moss_blocks"))
                    .displayItems((parameters, output) ->{
                        output.accept(ModSimpleBlocks.YELLOW_MOSS_BLOCK);
                        output.accept(ModSimpleBlocks.YELLOW_MOSS_CARPET);
                        output.accept(ModSimpleBlocks.RED_MOSS_BLOCK);
                        output.accept(ModSimpleBlocks.RED_MOSS_CARPET);
                        output.accept(ModSimpleBlocks.BLUE_MOSS_BLOCK);
                        output.accept(ModSimpleBlocks.BLUE_MOSS_CARPET);
                        output.accept(ModSimpleBlocks.YELLOW_MOSSY_GROWTH);

    }).build());
    public static final Supplier<CreativeModeTab> MOSS_CULTURES_TAB = CREATIVE_MODE_TAB.register("moss_cultures_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PLAIN_MOSS_CULTURE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CheeseUtil.MODID, "moss_blocks_tab"))
                    .title(Component.translatable("creativetab.cheeseutil.moss_cultures"))
                    .displayItems((parameters, output) ->{
                        output.accept(ModItems.BLUE_MOSS_CULTURE);
                        output.accept(ModItems.RED_MOSS_CULTURE);
                        output.accept(ModItems.YELLOW_MOSS_CULTURE);
                        output.accept(ModItems.PLAIN_MOSS_CULTURE);

    }).build());

    public static final Supplier<CreativeModeTab> CULTURING_TOOLS_TAB = CREATIVE_MODE_TAB.register("moss_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CULTURING_KNIFE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CheeseUtil.MODID, "moss_blocks_tab"),ResourceLocation.fromNamespaceAndPath(CheeseUtil.MODID, "moss_culture_tab"))
                    .title(Component.translatable("creativetab.cheeseutil.moss_tools_tab"))
                    .displayItems((parameters, output) ->{
                        output.accept(ModItems.GROWTH_CATALYST);
                        output.accept(ModItems.CULTURING_KNIFE);
                        output.accept(ModItems.MOSSY_IRON);


    }).build());

    public static final Supplier<CreativeModeTab> GRIMOIRES = CREATIVE_MODE_TAB.register("grimoires_tab",
    () -> CreativeModeTab.builder().icon( () -> new ItemStack(ModItems.NETHER_BOOK.get()))
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CheeseUtil.MODID, "moss_tools_tab"))
            .title(Component.translatable("creativetab.cheeseutil.grimoires_tab"))
            .displayItems((parameters, output) ->{
                output.accept(ModItems.NETHER_BOOK);
                output.accept(ModItems.NYX_BREW);
            })
            .build()

    );
    public static final Supplier<CreativeModeTab> MOSS_BOWLS = CREATIVE_MODE_TAB.register("moss_bowls_tab",
            () -> CreativeModeTab.builder()
                    .icon( () -> new ItemStack(ModItems.RED_MOSS_BOWL.get()))
                    .title(Component.translatable("creativetab.cheeseutil.moss_bowls_tab"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CheeseUtil.MODID, "grimoires_tab"))
                    .displayItems( (parameters, output) ->{
                        output.accept(ModItems.RED_MOSS_BOWL);

            })
                    .build()
            );


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);

    }
}
