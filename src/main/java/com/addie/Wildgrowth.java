package com.addie;

import com.addie.core.WildgrowthBlocks;
import com.addie.core.WildgrowthItemGroups;
import com.addie.core.WildgrowthItems;
import dev.amble.lib.container.RegistryContainer;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Wildgrowth implements ModInitializer {
	public static final String MOD_ID = "wildgrowth";
    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
	//public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        RegistryContainer.register(WildgrowthBlocks.class, MOD_ID);
        RegistryContainer.register(WildgrowthItemGroups.class, MOD_ID);
        RegistryContainer.register(WildgrowthItems.class, MOD_ID);
        registerParticles();
	}




    public static final DefaultParticleType SNOWFLAKE = FabricParticleTypes.simple();
    public static final DefaultParticleType FIREFLY = FabricParticleTypes.simple();


    public void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, id("snowflake"), SNOWFLAKE);
        Registry.register(Registries.PARTICLE_TYPE, id("firefly"), FIREFLY);
    }

}