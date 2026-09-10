package net.teamcheese.cheeseutil.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.teamcheese.cheeseutil.blocks.ModBlocks;
import net.teamcheese.cheeseutil.items.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModItemRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

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
    }
}
