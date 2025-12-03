package com.addie;

import com.addie.core.WildgrowthParticles;
import com.addie.util.ClientColors;
import com.addie.core.WildgrowthBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.SnowflakeParticle;
import net.minecraft.client.render.RenderLayer;

public class WildgrowthClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
        BlockRenderLayerMapRegister();
        ClientColors.registerLeafLitterColor();
        ClientColors.registerSnowyGrassColor();

    }

    public static void BlockRenderLayerMapRegister() {
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.SHORT_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.TALL_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.LEAF_LITTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.SNOWY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.SNOWFLAKES, RenderLayer.getCutout());
    }

    public void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(
                WildgrowthParticles.SNOWFLAKE_SMALL,
                SnowflakeParticle.Factory::new
        );
        ParticleFactoryRegistry.getInstance().register(
                WildgrowthParticles.SNOWFLAKE_MEDIUM,
                SnowflakeParticle.Factory::new
        );
        ParticleFactoryRegistry.getInstance().register(
                WildgrowthParticles.SNOWFLAKE_LARGE,
                SnowflakeParticle.Factory::new
        );
    }
}