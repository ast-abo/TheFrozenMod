package TheFrozenMod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IceBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FrozenBlock extends IceBlock {
    private final Block DefualtBlock;

    public FrozenBlock(Settings settings, Block DefualtBlock) {
        super(settings);
        this.DefualtBlock = DefualtBlock;
    }

    public BlockState getMeltState() {
        return this.DefualtBlock.getDefaultState();
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.BLOCK, pos) > 11 - state.getOpacity(world, pos)) {
            this.melt(state, world, pos);
        }
    }

    @Override
    protected void melt(BlockState state, World world, BlockPos pos) {
        if (world.getDimension().ultrawarm()) {
            world.removeBlock(pos, false);
        } else {
            world.setBlockState(pos, getMeltState());
            world.updateNeighbor(pos, getMeltState().getBlock(), pos);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        super.appendTooltip(stack, context, tooltip, options);
    }
}
