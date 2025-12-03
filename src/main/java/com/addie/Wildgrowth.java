package com.addie;

import com.addie.core.WildGrowthBlocks;
import com.addie.core.WildGrowthItemGroups;
import dev.amble.lib.container.RegistryContainer;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

public class Wildgrowth implements ModInitializer {
	public static final String MOD_ID = "wildgrowth";
    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
	//public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        RegistryContainer.register(WildGrowthBlocks.class, MOD_ID);
        RegistryContainer.register(WildGrowthItemGroups.class, MOD_ID);
	}
}