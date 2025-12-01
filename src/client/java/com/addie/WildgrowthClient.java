package com.addie;

import com.addie.core.WildGrowthBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class WildgrowthClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
        BlockRenderLayerMapRegister();
	}

    public static void BlockRenderLayerMapRegister() {
        BlockRenderLayerMap.INSTANCE.putBlock(WildGrowthBlocks.SHORT_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildGrowthBlocks.TALL_DRY_GRASS, RenderLayer.getCutout());
    }
}