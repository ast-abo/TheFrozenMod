package TheFrozenMod.item.custom;

import TheFrozenMod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;
import java.util.Objects;


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


            if (Screen.hasShiftDown()) {
                world.setBlockState(context.getBlockPos(), Blocks.ICE.getDefaultState());
            } else {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.getOrDefault(clickedBlock, Blocks.ICE).getDefaultState());
            }

            context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> Objects.requireNonNull(context.getPlayer()).sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

            world.playSound(null, context.getBlockPos(), SoundEvents.ENTITY_PLAYER_HURT_FREEZE, SoundCategory.BLOCKS);
        }

        return ActionResult.SUCCESS;
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.thefrozenmod.frozenite_chisel.shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.thefrozenmod.frozenite_chisel"));
        }
        super.appendTooltip(stack, context, tooltip, options);
    }
}

