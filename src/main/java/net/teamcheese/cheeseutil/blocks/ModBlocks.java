package net.teamcheese.cheeseutil.blocks;

import net.minecraft.world.level.block.*;
import net.teamcheese.cheeseutil.CheeseUtil;
import net.teamcheese.cheeseutil.items.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamcheese.cheeseutil.util.ModTags;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CheeseUtil.MODID);

    public static final DeferredBlock<Block> YELLOW_MOSS_BLOCK = registerBlock("yellow_moss_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak()

    ));
    public static final DeferredBlock<CarpetBlock> YELLOW_MOSS_CARPET = registerBlock("yellow_moss_carpet",
            () -> new CarpetBlock(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak().noCollission()));

    public static final DeferredBlock<Block> WHITE_MOSS_BLOCK = registerBlock("white_moss_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak()

            ));
    public static final DeferredBlock<CarpetBlock> WHITE_MOSS_CARPER = registerBlock("white_moss_carpet",
            () -> new CarpetBlock(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak().noCollission()

    ));
    public static final DeferredBlock<Block> BLUE_MOSS_BLOCK = registerBlock("blue_moss_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak()

    ));
    public static final DeferredBlock<CarpetBlock> BLUE_MOSS_CARPET = registerBlock("blue_moss_carpet",
            () -> new CarpetBlock(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak().noCollission()

    ));
    public static final DeferredBlock<Block> RED_MOSS_BLOCK = registerBlock("red_moss_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak()

    ));
    public static final DeferredBlock<CarpetBlock> RED_MOSS_CARPET = registerBlock("red_moss_carpet",
            () -> new CarpetBlock(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak().noCollission()

    ));
    public static final DeferredBlock<Block> CHARRED_MOSS_BLOCK = registerBlock("charred_moss_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak())
            );
    public static final DeferredBlock<CarpetBlock> CHARRED_MOSS_CARPET = registerBlock("charred_moss_carpet",
            () -> new CarpetBlock(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak().noCollission())
            );
    public static final DeferredBlock<Block> MOSSY_IRON_ORE = registerBlock("mossy_iron_ore",
            () -> new MossyOresBlock(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST))
            );
    public static final DeferredBlock<SlabBlock> MOSS_SLAB = registerBlock("moss_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_BLOCK))
            );

    // Complex Blocks go below

    public static final DeferredBlock<Block> YELLOW_MOSSY_GROWTH = registerBlock("yellow_mossy_growth",
            () -> new MossyGrowthBlock(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak()));
    public static final DeferredBlock<Block> WHITE_MOSSY_GROWTH = registerBlock("white_mossy_growth",
            () -> new MossyGrowthBlock(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak()));
    public static final DeferredBlock<Block> BLUE_MOSSY_GROWTH = registerBlock("blue_mossy_growth",
            () -> new MossyGrowthBlock(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak()));
    public static final DeferredBlock<Block> RED_MOSSY_GROWTH = registerBlock("red_mossy_growth",
            () -> new MossyGrowthBlock(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak()));
    public static final DeferredBlock<Block> PLAIN_MOSSY_GROWTH = registerBlock(
            "plain_mossy_growth",
            () -> new MossyGrowthBlock(BlockBehaviour.Properties.of().sound(SoundType.MOSS))

    );




    public static final DeferredBlock<Block> CHARRED_MOSSY_GROWTH = registerBlock("charred_mossy_growth",
            () -> new MossyGrowthBlock(BlockBehaviour.Properties.of().sound(SoundType.MOSS).instabreak()));
    public static final DeferredBlock<Block> RAW_MOSSY_IRON_BLOCK = registerBlock("raw_mossy_iron_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST)
            ));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
            DeferredBlock<T> toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn);
            return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){

            ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }

    public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);


    }

}
