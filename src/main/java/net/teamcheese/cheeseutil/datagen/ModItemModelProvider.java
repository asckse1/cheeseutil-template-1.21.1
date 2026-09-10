package net.teamcheese.cheeseutil.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.teamcheese.cheeseutil.CheeseUtil;
import net.teamcheese.cheeseutil.items.ModItems;


public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CheeseUtil.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    basicItem(ModItems.BLUE_MOSS_CULTURE.get());
    basicItem(ModItems.BLACK_MOSS_CULTURE.get());
    basicItem(ModItems.BLUE_MOSS_BOWL.get());
    basicItem(ModItems.STONE_CULTURING_KNIFE.get());
    basicItem(ModItems.GROWTH_CATALYST.get());
    basicItem(ModItems.MOSSY_IRON.get());
    basicItem(ModItems.NYX_BREW.get());
    basicItem(ModItems.NETHER_BOOK.get());
    basicItem(ModItems.PLAIN_MOSS_CULTURE.get());
    basicItem(ModItems.RED_MOSS_BOWL.get());
    basicItem(ModItems.RED_MOSS_CULTURE.get());
    basicItem(ModItems.YELLOW_MOSS_CULTURE.get());

    }
}
