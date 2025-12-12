package com.addie.core.Blocks;

import com.addie.Wildgrowth;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SnowFlakesBlock extends Block {

    public static final DirectionProperty FACING = Properties.FACING;

    private static final VoxelShape SHAPE_DOWN = Block.createCuboidShape(0, 0, 0, 16, 1, 16);
    private static final VoxelShape SHAPE_UP = Block.createCuboidShape(0, 15, 0, 16, 16, 16);
    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(0, 0, 0, 16, 16, 1);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(0, 0, 15, 16, 16, 16);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(0, 0, 0, 1, 16, 16);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(15, 0, 0, 16, 16, 16);

    public SnowFlakesBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.UP));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getSide().getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case DOWN -> SHAPE_DOWN;
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_UP;
        };
    }

    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (!world.isClient) return;

        DefaultParticleType[] particles = new DefaultParticleType[] {
                Wildgrowth.SNOWFLAKE,
        };

        double radius = 15.0;

        for (DefaultParticleType particle : particles) {
            int count = 1 + random.nextInt(3);
            for (int i = 0; i < count; i++) {
                double x = pos.getX() + 0.5 + (random.nextDouble() * 2 - 1) * radius;
                double y = pos.getY() + 7;
                double z = pos.getZ() + 0.5 + (random.nextDouble() * 2 - 1) * radius;

                double velX = 0;
                double velY = -0.03 - random.nextDouble() * 0.02;
                double velZ = 0;

                world.addParticle(particle, x, y, z, velX, velY, velZ);
            }
        }
    }

}
