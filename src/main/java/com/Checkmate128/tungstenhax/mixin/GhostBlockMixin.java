package com.Checkmate128.tungstenhax.mixin;

import com.Checkmate128.tungstenhax.TungstenHaxMod;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayNetworkHandler.class)
public class GhostBlockMixin {
    @Inject(method = "sendPacket", at = @At("HEAD"), cancellable = true)
    private void send(Packet<?> packet, CallbackInfo ci) {
        if(TungstenHaxMod.ghostBlocksEnabled && packet instanceof PlayerInteractBlockC2SPacket) {
            ci.cancel();
        }
    }
}
