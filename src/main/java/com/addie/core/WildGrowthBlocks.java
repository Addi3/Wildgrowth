package com.addie.core;

import com.addie.core.Blocks.DryGrassBlock;
import com.addie.core.Blocks.LeafLitterBlock;
import dev.amble.lib.block.ABlockSettings;
import dev.amble.lib.container.impl.BlockContainer;
import dev.amble.lib.datagen.util.NoBlockDrop;
import dev.amble.lib.datagen.util.NoEnglish;
import dev.amble.lib.item.AItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

public class WildGrowthBlocks extends BlockContainer {

    // Plants
    @NoEnglish
    @NoBlockDrop
    public static final Block SHORT_DRY_GRASS = new DryGrassBlock(ABlockSettings.create().itemSettings(new AItemSettings()
            .group(WildGrowthItemGroups.MAIN))
            .replaceable()
            .noCollision()
            .offset(AbstractBlock.OffsetType.XZ)
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .pistonBehavior(PistonBehavior.DESTROY)
    );

    @NoEnglish
    @NoBlockDrop
    public static final Block TALL_DRY_GRASS = new DryGrassBlock(ABlockSettings.create().itemSettings(new AItemSettings()
                    .group(WildGrowthItemGroups.MAIN))
            .replaceable()
            .noCollision()
            .offset(AbstractBlock.OffsetType.XZ)
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .pistonBehavior(PistonBehavior.DESTROY)
    );

    @NoEnglish
    @NoBlockDrop
    public static final Block LEAF_LITTER = new LeafLitterBlock(ABlockSettings.create().itemSettings(new AItemSettings()
                    .group(WildGrowthItemGroups.MAIN))
            .replaceable()
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .pistonBehavior(PistonBehavior.DESTROY)
            .mapColor(MapColor.BROWN)
    );


}
