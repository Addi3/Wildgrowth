package com.addie.core.Blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FernBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class CactusFlowerBlock extends FernBlock {

    public CactusFlowerBlock(Settings settings) {
        super(settings);
    }

    private static final TagKey<Block> PLACEABLE_ON =
            TagKey.of(Registries.BLOCK.getKey(), new Identifier("wildgrowth", "cactus_flower_placeable")
            );


    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(PLACEABLE_ON);
    }
}
