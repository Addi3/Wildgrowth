package com.addie;

import com.addie.core.WildgrowthBlocks;
import com.addie.core.WildgrowthItemGroups;
import com.addie.core.WildgrowthItems;
import com.addie.datagenproviders.WildgrowthRecipeProvider;
import dev.amble.lib.datagen.lang.AmbleLanguageProvider;
import dev.amble.lib.datagen.lang.LanguageType;
import dev.amble.lib.datagen.model.AmbleModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;

import static net.minecraft.data.server.recipe.RecipeProvider.conditionsFromItem;
import static net.minecraft.data.server.recipe.RecipeProvider.hasItem;

public class WildgrowthDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        FabricDataGenerator.Pack pack = gen.createPack();


        genLang(pack);
        genModels(pack);
        generateRecipes(pack);

    }

    private void genModels(FabricDataGenerator.Pack pack) {
        pack.addProvider(((output, registriesFuture) -> {
            AmbleModelProvider provider = new AmbleModelProvider(output);
            provider.withItems(WildgrowthItems.class);
            return provider;
        }));

    }
        private void genLang (FabricDataGenerator.Pack pack){
            genEnglish(pack);
        }

        private void genEnglish (FabricDataGenerator.Pack pack){
            pack.addProvider((((output, registriesFuture) -> {
                AmbleLanguageProvider provider = new AmbleLanguageProvider(output, LanguageType.EN_US);

                // ItemGroups
                provider.addTranslation(WildgrowthItemGroups.MAIN,"Wild Growth");

                //Blocks
                provider.addTranslation(WildgrowthBlocks.SHORT_DRY_GRASS,"Short Dry Grass");
                provider.addTranslation(WildgrowthBlocks.TALL_DRY_GRASS,"Tall Dry Grass");
                provider.addTranslation(WildgrowthBlocks.LEAF_LITTER,"Leaf Litter");
                provider.addTranslation(WildgrowthBlocks.SNOWFLAKES,"Snow Flakes");
                provider.addTranslation(WildgrowthBlocks.SNOWY_GRASS,"Snowy Grass");
                provider.addTranslation(WildgrowthBlocks.BUSH,"Bush");
                provider.addTranslation(WildgrowthBlocks.SNOWY_BUSH,"Snowy Bush");
                provider.addTranslation(WildgrowthBlocks.SNOWY_SHORT_GRASS,"Snowy Short Grass");
                provider.addTranslation(WildgrowthBlocks.WILDFLOWERS,"Wildflowers");
                provider.addTranslation(WildgrowthBlocks.FIREFLY_BUSH,"Firefly Bush");

                return provider;
            })));
        }

    public void generateRecipes(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> {
            WildgrowthRecipeProvider provider = new WildgrowthRecipeProvider(output);

            provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, WildgrowthBlocks.SNOWY_GRASS, 1)
                    .group("snowy_plants")
                    .pattern("S")
                    .pattern("G")
                    .input('G', Blocks.GRASS)
                    .input('S', WildgrowthBlocks.SNOWFLAKES)
                    .criterion(hasItem(Blocks.GRASS), conditionsFromItem(Blocks.GRASS))
                    .criterion(hasItem(WildgrowthBlocks.SNOWFLAKES), conditionsFromItem(WildgrowthBlocks.SNOWFLAKES)));

            provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, WildgrowthBlocks.SNOWY_SHORT_GRASS, 1)
                    .group("snowy_plants")
                    .pattern("S")
                    .pattern("G")
                    .input('G', WildgrowthBlocks.SHORT_DRY_GRASS)
                    .input('S', WildgrowthBlocks.SNOWFLAKES)
                    .criterion(hasItem(WildgrowthBlocks.SHORT_DRY_GRASS), conditionsFromItem(WildgrowthBlocks.SHORT_DRY_GRASS))
                    .criterion(hasItem(WildgrowthBlocks.SNOWFLAKES), conditionsFromItem(WildgrowthBlocks.SNOWFLAKES)));

            provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, WildgrowthBlocks.SNOWY_BUSH, 1)
                    .group("snowy_plants")
                    .pattern("S")
                    .pattern("G")
                    .input('G', WildgrowthBlocks.BUSH)
                    .input('S', WildgrowthBlocks.SNOWFLAKES)
                    .criterion(hasItem(WildgrowthBlocks.BUSH), conditionsFromItem(WildgrowthBlocks.BUSH))
                    .criterion(hasItem(WildgrowthBlocks.SNOWFLAKES), conditionsFromItem(WildgrowthBlocks.SNOWFLAKES)));



            return provider;

        })));
    }
    }
