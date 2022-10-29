package com.Checkmate128.tungstenhax.mixin;

import com.Checkmate128.tungstenhax.TungstenHaxMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class RobotModeMixin {
    MinecraftClient client = MinecraftClient.getInstance();

    @Inject(method = "tick", at = @At("TAIL"))
    private void tick(CallbackInfo ci) {
        if(client.player != null && TungstenHaxMod.robotModeEnabled) {
            int x = (int)(Math.round(client.player.getX() * 100));
            int z = (int)(Math.round(client.player.getZ() * 100));
            client.player.setPos((double)(x) / 100, client.player.getY(), (double)(z) / 100);
            long testX = ((long) (client.player.getPos().x * 1000)) % 10;
            long testZ = ((long) (client.player.getPos().z * 1000)) % 10;
        }
    }
}
