package com.addie.util;

import com.addie.core.WildgrowthBlocks;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.color.world.BiomeColors;

@Environment(EnvType.CLIENT)
public class ClientColors {

    private static final int DARK_BROWN = 0x4B2F26;
    private static final int LIGHT_BROWN = 0xB9945B;

    public static void registerLeafLitterColor() {
        ColorProviderRegistry.BLOCK.register(
                (state, world, pos, tintIndex) -> {
                    if (world != null && pos != null) {
                        int biomeColor = BiomeColors.getGrassColor(world, pos);
                        float factor = getColorBrightnessFactor(biomeColor);
                        return blendColors(DARK_BROWN, LIGHT_BROWN, factor);
                    } else {
                        return DARK_BROWN;
                    }
                },
                WildgrowthBlocks.LEAF_LITTER
        );
    }

    public static void registerSnowyGrassColor() {
        ColorProviderRegistry.BLOCK.register(
                (state, worldView, pos, tintIndex) -> {
                    if (worldView != null && pos != null) {
                        return BiomeColors.getGrassColor(worldView, pos);
                    } else {
                        return 0x91BD59; // fallback grass color
                    }
                },
                WildgrowthBlocks.SNOWY_GRASS,
                WildgrowthBlocks.BUSH,
                WildgrowthBlocks.SNOWY_BUSH,
                WildgrowthBlocks.SNOWY_SHORT_GRASS
        );
    }



    private static int blendColors(int color1, int color2, float factor) {
        int r1 = (color1 >> 16) & 0xFF;
        int g1 = (color1 >> 8) & 0xFF;
        int b1 = color1 & 0xFF;

        int r2 = (color2 >> 16) & 0xFF;
        int g2 = (color2 >> 8) & 0xFF;
        int b2 = color2 & 0xFF;

        int r = (int) (r1 * (1 - factor) + r2 * factor);
        int g = (int) (g1 * (1 - factor) + g2 * factor);
        int b = (int) (b1 * (1 - factor) + b2 * factor);

        return (r << 16) | (g << 8) | b;
    }


    private static float getColorBrightnessFactor(int color) {
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;

        float brightness = (0.2126f * r + 0.7152f * g + 0.0722f * b) / 255f;

        return brightness;
    }
}
