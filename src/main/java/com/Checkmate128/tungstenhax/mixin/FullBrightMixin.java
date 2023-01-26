package com.Checkmate128.tungstenhax.mixin;

import com.Checkmate128.tungstenhax.TungstenHaxMod;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(SimpleOption.DoubleSliderCallbacks.class)
public class FullBrightMixin {

    @Inject(method = "validate(Ljava/lang/Double;)Ljava/util/Optional;", at = @At("RETURN"), cancellable = true)
    public void removeValidation(Double double_, CallbackInfoReturnable<Optional<Double>> cir) {
        if(TungstenHaxMod.fullBrightEnabled) {
            if(double_ == 16.0) {
                cir.setReturnValue(Optional.of(16.0));
            }
        }
    }

}
