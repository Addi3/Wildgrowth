package com.addie.core;

import com.addie.Wildgrowth;
import dev.amble.lib.container.impl.ItemGroupContainer;
import dev.amble.lib.itemgroup.AItemGroup;
import net.minecraft.item.ItemStack;

public class WildgrowthItemGroups implements ItemGroupContainer {

    public static final AItemGroup MAIN = AItemGroup.builder(Wildgrowth.id("item_group"))
            .icon(() -> new ItemStack(WildgrowthBlocks.SHORT_DRY_GRASS.asItem()))
            .build();
}
