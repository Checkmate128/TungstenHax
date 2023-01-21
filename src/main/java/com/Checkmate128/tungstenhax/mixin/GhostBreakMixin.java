package com.Checkmate128.tungstenhax.mixin;

import com.Checkmate128.tungstenhax.TungstenHaxMod;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class GhostBreakMixin {
    @Inject(method = "sendPacket", at = @At("HEAD"), cancellable = true)
    private void send(Packet<?> packet, CallbackInfo ci) {
        if(TungstenHaxMod.ghostBreakEnabled && packet instanceof PlayerActionC2SPacket) {
            if(((PlayerActionC2SPacket) packet).getAction() == PlayerActionC2SPacket.Action.STOP_DESTROY_BLOCK || ((PlayerActionC2SPacket) packet).getAction() == PlayerActionC2SPacket.Action.START_DESTROY_BLOCK) {
                ci.cancel();
            }
        }
    }
}
