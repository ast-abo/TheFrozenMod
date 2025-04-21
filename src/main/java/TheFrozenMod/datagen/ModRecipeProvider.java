package TheFrozenMod.datagen;

import TheFrozenMod.block.ModBlocks;
import TheFrozenMod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> FROZENITE_SMELTABLES = List.of(
                ModItems.RAW_FROZENITE,
                ModBlocks.FROZENITE_ORE
        );

        offerSmelting(recipeExporter, FROZENITE_SMELTABLES, RecipeCategory.MISC, ModItems.FROZENITE, 0.25f, 200, "frozenite");
        offerBlasting(recipeExporter, FROZENITE_SMELTABLES, RecipeCategory.MISC, ModItems.FROZENITE, 0.25f, 100, "frozenite");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.FROZENITE, RecipeCategory.DECORATIONS, ModBlocks.FROZENITE_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FROZENITE_CHISEL)
                .pattern(" F")
                .pattern("S ")
                .input('F', ModItems.FROZENITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RAW_FROZENITE), conditionsFromItem(ModItems.RAW_FROZENITE))
                .offerTo(recipeExporter);
    }
}
