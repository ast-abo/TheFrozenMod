package TheFrozenMod.item.custom;

import TheFrozenMod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;


public class FrozeniteChiselItem extends Item {
    public static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.GRASS_BLOCK, ModBlocks.FROZENITE_GRASS
            );

    public FrozeniteChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(!world.isClient()) {
            world.setBlockState(context.getBlockPos(), CHISEL_MAP.getOrDefault(clickedBlock, Blocks.ICE).getDefaultState());

            context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

            world.playSound(null, context.getBlockPos(), SoundEvents.ENTITY_PLAYER_HURT_FREEZE, SoundCategory.BLOCKS);
        }

        return ActionResult.SUCCESS;
    }
}

