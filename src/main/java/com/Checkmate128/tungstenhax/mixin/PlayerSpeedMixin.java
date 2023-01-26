package com.Checkmate128.tungstenhax.mixin;

import com.Checkmate128.tungstenhax.TungstenHaxMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerSpeedMixin {
    private MinecraftClient client = MinecraftClient.getInstance();
    private int flyCheckBypassCounter = 20;

    @Inject(method = "tick", at = @At("TAIL"))
    private void tick(CallbackInfo ci) {
        if(TungstenHaxMod.playerSpeedEnabled && client.player != null) {
            Vec3d oldVelocity = client.player.getVelocity();
            double yVelocity = oldVelocity.getY();

            if(client.player.isOnGround()) {
                if(client.options.forwardKey.isPressed()) {
                    oldVelocity = client.player.getRotationVector().multiply(TungstenHaxMod.playerSpeed);
                    oldVelocity = new Vec3d(oldVelocity.x, 0.0, oldVelocity.z);
                    Vec3d newVelocity = oldVelocity.normalize().multiply(TungstenHaxMod.playerSpeed * 0.2);
                    newVelocity = new Vec3d(newVelocity.x, yVelocity, newVelocity.z);
                    client.player.setVelocity(newVelocity);
                } else {
                    client.player.setVelocity(0.0, yVelocity, 0.0);
                }
            }

        }
    }
}
