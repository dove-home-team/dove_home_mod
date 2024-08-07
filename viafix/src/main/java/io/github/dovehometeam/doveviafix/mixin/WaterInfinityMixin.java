package io.github.dovehometeam.doveviafix.mixin;

import io.github.dovehometeam.doveviafix.config.ViaFixConfig;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.WaterFluid;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WaterFluid.class)
@Debug(export = true)
public class WaterInfinityMixin {
    @Inject(method = "canConvertToSource", at = @At("HEAD"), cancellable = true)
    private void canConvertToSource(Level pLevel, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(!ViaFixConfig.noInfiniteWaterBoolean);
    }
}
