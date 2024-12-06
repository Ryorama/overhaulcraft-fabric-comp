package com.ryorama.tstpcontent.init;

import com.ryorama.tstpcontent.TstpContentFabric;
import com.ryorama.tstpcontent.block.HamsterWheelGeneratorBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.PushReaction;

public class OverhaulCraftBlocks {
    public static final Block HAMSTER_WHEEL_GENERATOR = registerBlockWithoutBlockItem("hamster_wheel_generator", new HamsterWheelGeneratorBlock(FabricBlockSettings.create().strength(0.6F).noOcclusion().isSuffocating((state, world, pos) -> false).pushReaction(PushReaction.IGNORE)));

    @SuppressWarnings("all")
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(TstpContentFabric.MOD_ID, name), block);
    }
}
