package net.teamcheese.cheeseutil.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.teamcheese.cheeseutil.CheeseUtil;
import net.teamcheese.cheeseutil.blocks.ModBlocks;
import net.teamcheese.cheeseutil.items.ModItems;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModItemRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> MOSSY_IRON_SMELTABLES = new ArrayList<ItemLike>();
        MOSSY_IRON_SMELTABLES.addAll(List.of(ModItems.RAW_MOSSY_IRON, ModBlocks.MOSSY_IRON_ORE));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_MOSS_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.BLUE_MOSS_CULTURE.asItem())
                .unlockedBy("has_bonemeal", has(Items.BONE_MEAL)).
                save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_MOSS_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.RED_MOSS_CULTURE.asItem())
                .unlockedBy("has_bonemeal", has(Items.BONE_MEAL)).
                save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YELLOW_MOSS_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.YELLOW_MOSS_CULTURE.asItem())
                .unlockedBy("has_bonemeal", has(Items.BONE_MEAL)).
                save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHARRED_MOSS_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.BLACK_MOSS_CULTURE.asItem())
                .unlockedBy("has_bonemeal", has(Items.BONE_MEAL)).
                save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_CULTURING_KNIFE.get())
                .pattern("  M")
                .pattern(" M ")
                .pattern("S  ")
                .define('M', ModItems.MOSSY_IRON.asItem())
                .define('S', Items.STICK.asItem())
                .unlockedBy("has_mossy_iron", has(ModItems.MOSSY_IRON)).
                save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GROWTH_CATALYST.get())
                .pattern(" M ")
                .pattern("BWB")
                .pattern(" B ")
                .define('M', ModItems.PLAIN_MOSS_CULTURE.asItem())
                .define('W', Items.WATER_BUCKET.asItem())
                .define('B', Items.BONE_MEAL.asItem())
                .unlockedBy("has_moss", has(ModItems.PLAIN_MOSS_CULTURE)).
                save(recipeOutput);
        oreSmelting(recipeOutput, MOSSY_IRON_SMELTABLES, RecipeCategory.MISC, ModItems.MOSSY_IRON.get(),0.25f, 200, "mossy_iron_smelting");
        oreBlasting(recipeOutput, MOSSY_IRON_SMELTABLES, RecipeCategory.MISC, ModItems.MOSSY_IRON.get(),0.25f, 200, "mossy_iron_blasting");

    }
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike presult, float pExperience, int pCookingTime, String pGroup){
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, presult, pExperience, pCookingTime, pGroup, "from_smelting");

    }
    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike presult, float pExperience, int pCookingTime, String pGroup){
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, presult, pExperience, pCookingTime, pGroup, "from_blasting");

    }
    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                                List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {

        for(ItemLike itemLike : pIngredients){
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(recipeOutput, CheeseUtil.MODID +":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemLike));
        }
    }
}
