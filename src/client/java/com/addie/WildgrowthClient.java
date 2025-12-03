package com.addie;

import com.addie.util.ClientColors;
import com.addie.core.WildGrowthBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class WildgrowthClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
        BlockRenderLayerMapRegister();
        ClientColors.registerLeafLitterColor();
    }


    public static void BlockRenderLayerMapRegister() {
        BlockRenderLayerMap.INSTANCE.putBlock(WildGrowthBlocks.SHORT_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildGrowthBlocks.TALL_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WildGrowthBlocks.LEAF_LITTER, RenderLayer.getCutout());
    }
}