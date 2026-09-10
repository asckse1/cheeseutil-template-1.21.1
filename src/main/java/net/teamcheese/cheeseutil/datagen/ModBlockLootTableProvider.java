package net.teamcheese.cheeseutil.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.LootNumberProviderType;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.teamcheese.cheeseutil.CheeseUtil;
import net.teamcheese.cheeseutil.blocks.ModBlocks;
import net.teamcheese.cheeseutil.items.ModItems;
import net.teamcheese.cheeseutil.util.ModTags;
import org.apache.commons.lang3.RandomUtils;
import org.jline.utils.Log;

import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class ModBlockLootTableProvider extends BlockLootSubProvider {


    public ModBlockLootTableProvider( HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }
    public LootTable.Builder createRedstoneLikeOre(Block block, Item result, float minCount, float maxCount ){

            HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
            return this.createSilkTouchDispatchTable(block,
                    (LootPoolEntryContainer.Builder)this.applyExplosionDecay(
                            block,
                            LootItem.lootTableItem(result)
                            .apply(
                                    SetItemCountFunction.setCount(
                                            UniformGenerator.between(minCount, maxCount)))
                            .apply(
                                    ApplyBonusCount.addUniformBonusCount(
                                            registrylookup.getOrThrow(Enchantments.FORTUNE)))));

    }
    public int MossMult(LootContext lootContext){
        int count = RandomUtils.nextInt(3,7);
        return count;

    }
    public Item mossBlockIDSanitizer(Block mossBlock){
        String blockID = BuiltInRegistries.BLOCK.getKey(mossBlock).toString();

        blockID.replace("_block","_culture");
        Log.debug("(STM001) (FC: MBS001) The string was reduced to:" +blockID.toString());
        Item result = BuiltInRegistries.ITEM.get(
                ResourceLocation.parse(blockID.toString()));
        blockID.toString();
        return result;
    }


    @Override
    protected void generate() {
        var mossBlocksTag = BuiltInRegistries.BLOCK.getTag(ModTags.Blocks.MOSS_BLOCKS);
        var blockLookup = this.registries.lookupOrThrow(net.minecraft.core.registries.Registries.BLOCK);
        dropSelf(ModBlocks.BLUE_MOSSY_GROWTH.get());
        dropSelf(ModBlocks.CHARRED_MOSSY_GROWTH.get());
        dropSelf(ModBlocks.YELLOW_MOSSY_GROWTH.get());
        dropSelf(ModBlocks.RED_MOSSY_GROWTH.get());
        dropSelf(ModBlocks.YELLOW_MOSS_CARPET.get());
        dropSelf(ModBlocks.BLUE_MOSS_CARPET.get());
        dropSelf(ModBlocks.RED_MOSS_CARPET.get());
        dropSelf(ModBlocks.CHARRED_MOSS_CARPET.get());
        dropSelf(ModBlocks.RAW_MOSSY_IRON_BLOCK.get());
        add(ModBlocks.CHARRED_MOSS_BLOCK.get(),
          block -> createRedstoneLikeOre(block, ModItems.BLACK_MOSS_CULTURE.get(),2.0F, 6.0F)


        );
        add(ModBlocks.YELLOW_MOSS_BLOCK.get(),
                block -> createRedstoneLikeOre(block, ModItems.YELLOW_MOSS_CULTURE.get(),2.0F, 6.0F)
        );
        add(ModBlocks.BLUE_MOSS_BLOCK.get(),
                block ->
                        createRedstoneLikeOre(block, ModItems.BLUE_MOSS_CULTURE.get(),2.0F, 6.0F)

        );
        add(ModBlocks.RED_MOSS_BLOCK.get(),
                block ->
                        createRedstoneLikeOre(block, ModItems.BLUE_MOSS_CULTURE.get(),2.0F, 6.0F)
        );
        add(ModBlocks.MOSSY_IRON_ORE.get(),
                block ->
                        createOreDrop(block, ModItems.RAW_MOSSY_IRON.get()));





        }




    @Override
    protected Iterable<Block> getKnownBlocks() {

        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals(CheeseUtil.MODID))
                .collect(Collectors.toList());
    }

}
