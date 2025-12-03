package com.addie;

import com.addie.core.WildGrowthBlocks;
import com.addie.core.WildGrowthItemGroups;
import dev.amble.lib.datagen.lang.AmbleLanguageProvider;
import dev.amble.lib.datagen.lang.LanguageType;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class WildgrowthDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        FabricDataGenerator.Pack pack = gen.createPack();


        genLang(pack);

    }
        private void genLang (FabricDataGenerator.Pack pack){
            genEnglish(pack);
        }

        private void genEnglish (FabricDataGenerator.Pack pack){
            pack.addProvider((((output, registriesFuture) -> {
                AmbleLanguageProvider provider = new AmbleLanguageProvider(output, LanguageType.EN_US);

                // ItemGroups
                provider.addTranslation(WildGrowthItemGroups.MAIN,"Wild Growth");

                //Blocks
                provider.addTranslation(WildGrowthBlocks.SHORT_DRY_GRASS,"Short Dry Grass");
                provider.addTranslation(WildGrowthBlocks.TALL_DRY_GRASS,"Tall Dry Grass");
                provider.addTranslation(WildGrowthBlocks.LEAF_LITTER,"Leaf Litter");

                return provider;
            })));
        }
    }
