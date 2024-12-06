package com.ryorama.tstpcontent.entity.block;

import com.starfish_studios.hamsters.blocks.HamsterWheelBlock;
import com.starfish_studios.hamsters.registry.HamstersBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import reborncore.common.powerSystem.PowerAcceptorBlockEntity;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class HamsterWheelGeneratorBlockEntity extends PowerAcceptorBlockEntity implements GeoBlockEntity {
    public HamsterWheelGeneratorBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(HamstersBlockEntities.HAMSTER_WHEEL, blockPos, blockState);
    }

    private static final RawAnimation SPIN = RawAnimation.begin().thenLoop("animation.sf_hba.hamster_wheel.spin");
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::controller));
    }

    private <E extends HamsterWheelGeneratorBlockEntity> PlayState controller(final AnimationState<E> event) {

        if (this.level != null && HamsterWheelBlock.isOccupied(this.level, this.getBlockPos())) {
            event.getController().setAnimation(SPIN);
            return PlayState.CONTINUE;
        }

        return PlayState.STOP;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public long getBaseMaxPower() {
        return 0;
    }

    @Override
    public long getBaseMaxOutput() {
        return 30;
    }

    @Override
    public long getBaseMaxInput() {
        return 0;
    }
}
