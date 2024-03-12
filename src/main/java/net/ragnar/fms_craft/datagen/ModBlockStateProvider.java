package net.ragnar.fms_craft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.ragnar.fms_craft.FMSmod;
import net.ragnar.fms_craft.block.ModBlocks;
import net.ragnar.fms_craft.block.custom.KraekiberCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FMSmod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RAW_RONGEM_BLOCK);
        blockWithItem(ModBlocks.RONGEM_BLOCK);
        blockWithItem(ModBlocks.RONITE_BLOCK);

        makeKraekiberCrop((CropBlock) ModBlocks.KRAEKIBER_CROP.get(), "kraekiber_stage", "kraekiber_stage");

        simpleBlockWithItem(ModBlocks.LUPINA.get(), models().cross(blockTexture(ModBlocks.LUPINA.get()).getPath(),
                blockTexture(ModBlocks.LUPINA.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_LUPINA.get(), models().singleTexture("potted_lupina", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.LUPINA.get())).renderType("cutout"));
    }

    public void makeKraekiberCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> kraekiberStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] kraekiberStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((KraekiberCropBlock) block).getAgeProperty()),
                new ResourceLocation(FMSmod.MOD_ID, "block/" + textureName + state.getValue(((KraekiberCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
