package TheFrozenMod.datagen;

import TheFrozenMod.block.ModBlocks;
import TheFrozenMod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleState(ModBlocks.FROZENITE_BLOCK);
        blockStateModelGenerator.registerSimpleState(ModBlocks.FROZENITE_GRASS);
        blockStateModelGenerator.registerSimpleState(ModBlocks.FROZENITE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FROZENITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROZENITE_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_CUBES, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_FROZENITE, Models.GENERATED);
    }
}
