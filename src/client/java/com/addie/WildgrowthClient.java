package com.addie;

import com.addie.particles.CustomSnowflakeParticle;
import com.addie.util.ClientColors;
import com.addie.core.WildgrowthBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.render.RenderLayer;

import static com.addie.Wildgrowth.FIREFLY;
import static com.addie.Wildgrowth.SNOWFLAKE;

public class WildgrowthClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
        BlockRenderLayerMapRegister();
        ClientColors.registerLeafLitterColor();
        ClientColors.registerSnowyGrassColor();
        registerParticlesClient();
    }

    public static void BlockRenderLayerMapRegister() {
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.SHORT_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.TALL_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.LEAF_LITTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.SNOWY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.SNOWFLAKES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.SNOWY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.SNOWY_SHORT_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.WILDFLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildgrowthBlocks.FIREFLY_BUSH, RenderLayer.getCutout());
    }


    public void registerParticlesClient() {
        ParticleFactoryRegistry.getInstance().register(SNOWFLAKE, CustomSnowflakeParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FIREFLY, EndRodParticle.Factory::new);
    }

}