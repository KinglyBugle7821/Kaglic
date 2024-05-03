package net.kinglybugle.kaglic.block.custom;

import net.kinglybugle.kaglic.block.ModBlocks;
import net.kinglybugle.kaglic.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class ResinExtractorBlock extends Block {

    public static final VoxelShape NORTH_AABB = Block.box(4,0,7, 11, 15, 15);
    public static final VoxelShape SOUTH_AABB = Block.box(4,0,0, 11, 7, 9);
    public static final VoxelShape WEST_AABB = Block.box(7,0,4, 15, 7, 11);
    public static final VoxelShape EAST_AABB = Block.box(0,0,4, 8, 7, 11);

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public ResinExtractorBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch ((Direction)pState.getValue(FACING)) {
            case SOUTH:
                return SOUTH_AABB;
            case NORTH:
            default:
                return NORTH_AABB;
            case WEST:
                return WEST_AABB;
            case EAST:
                return EAST_AABB;
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if (pState.is(ModBlocks.RESIN_EXTRACTOR_FULL.get())){
            // Drop an item at the block's position
            ItemStack itemStackToDrop = new ItemStack(ModItems.RESIN_BALL.get());
            ItemEntity itemEntity = new ItemEntity(pLevel, pPos.getX() + 0.5, pPos.getY() + 0.5, pPos.getZ() + 0.5, itemStackToDrop);
            pLevel.addFreshEntity(itemEntity);

            // Replace the block with the empty state
            pLevel.setBlock(pPos, ModBlocks.RESIN_EXTRACTOR_EMPTY.get().withPropertiesOf(pState), 512);
        }

        return InteractionResult.SUCCESS; // Return appropriate result
    }
}
