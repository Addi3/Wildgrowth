package com.addie.core.Blocks;

import com.addie.Wildgrowth;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FernBlock;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.random.Random;

public class FireflyBushBlock extends FernBlock {

    public FireflyBushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        DefaultParticleType particle = Wildgrowth.FIREFLY;
        long timeOfDay = world.getTimeOfDay() % 24000;

        if (timeOfDay >= 13000 && timeOfDay <= 23000) {
            double radius = 5.0;

            int count = 5 + random.nextInt(6);
            for (int i = 0; i < count; i++) {
                double x = pos.getX() + 0.5 + (random.nextDouble() * 2 - 1) * radius;
                double y = pos.getY() + 0.5 + (random.nextDouble() * 2 - 1) * radius;
                double z = pos.getZ() + 0.5 + (random.nextDouble() * 2 - 1) * radius;
                double velocityX = random.nextGaussian() * 0.005;
                double velocityY = random.nextGaussian() * 0.005;
                double velocityZ = random.nextGaussian() * 0.005;

                if (random.nextInt(5) == 0) {
                    world.addParticle(particle, x, y, z, velocityX, velocityY, velocityZ);
                }
            }
        }
    }
}
