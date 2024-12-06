package com.ryorama.tstpcontent.init;

import com.ryorama.tstpcontent.TstpContentFabric;
import com.ryorama.tstpcontent.entity.block.HamsterWheelGeneratorBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class OverhaulCraftBlockEntities {

    public static final BlockEntityType<HamsterWheelGeneratorBlockEntity> HAMSTER_WHEEL_GENERATOR = register("hamster_wheel", FabricBlockEntityTypeBuilder.create(HamsterWheelGeneratorBlockEntity::new, OverhaulCraftBlocks.HAMSTER_WHEEL_GENERATOR).build(null));
    public static <T extends BlockEntityType<?>> T register(String name, T blockEntityType) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(TstpContentFabric.MOD_ID, name), blockEntityType);
    }
}
