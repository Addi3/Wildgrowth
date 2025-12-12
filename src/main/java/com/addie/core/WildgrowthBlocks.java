package com.addie.core;

import com.addie.core.Blocks.DryGrassBlock;
import com.addie.core.Blocks.LeafLitterBlock;
import com.addie.core.Blocks.SnowFlakesBlock;
import dev.amble.lib.block.ABlockSettings;
import dev.amble.lib.container.impl.BlockContainer;
import dev.amble.lib.datagen.util.NoBlockDrop;
import dev.amble.lib.datagen.util.NoEnglish;
import dev.amble.lib.item.AItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FernBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

public class WildgrowthBlocks extends BlockContainer {

    // 1.21.5 backport stuff
    @NoEnglish
    @NoBlockDrop
    public static final Block SHORT_DRY_GRASS = new DryGrassBlock(ABlockSettings.create().itemSettings(new AItemSettings()
            .group(WildgrowthItemGroups.MAIN))
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
                    .group(WildgrowthItemGroups.MAIN))
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
                    .group(WildgrowthItemGroups.MAIN))
            .replaceable()
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .pistonBehavior(PistonBehavior.DESTROY)
            .mapColor(MapColor.BROWN)
    );

    @NoEnglish
    @NoBlockDrop
    public static final Block BUSH = new FernBlock(ABlockSettings.create().itemSettings(new AItemSettings()
                    .group(WildgrowthItemGroups.MAIN))
            .replaceable()
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY)
            .mapColor(MapColor.DARK_GREEN)
    );


    // New stuff
    @NoEnglish
    @NoBlockDrop
    public static final Block SNOWY_GRASS = new FernBlock(ABlockSettings.create().itemSettings(new AItemSettings()
                    .group(WildgrowthItemGroups.MAIN))
            .replaceable()
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY)
            .mapColor(MapColor.DARK_GREEN)
    );
    @NoEnglish
    @NoBlockDrop
    public static final Block SNOWY_SHORT_GRASS = new FernBlock(ABlockSettings.create().itemSettings(new AItemSettings()
                    .group(WildgrowthItemGroups.MAIN))
            .replaceable()
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY)
            .mapColor(MapColor.DARK_GREEN)
    );

    @NoEnglish
    @NoBlockDrop
    public static final Block SNOWY_BUSH = new FernBlock(ABlockSettings.create().itemSettings(new AItemSettings()
                    .group(WildgrowthItemGroups.MAIN))
            .replaceable()
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY)
            .mapColor(MapColor.DARK_GREEN)
    );

    @NoEnglish
    @NoBlockDrop
    public static final Block SNOWFLAKES = new SnowFlakesBlock(ABlockSettings.create().itemSettings(new AItemSettings()
                    .group(WildgrowthItemGroups.MAIN))
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.SNOW)
            .pistonBehavior(PistonBehavior.DESTROY)
    );


}
