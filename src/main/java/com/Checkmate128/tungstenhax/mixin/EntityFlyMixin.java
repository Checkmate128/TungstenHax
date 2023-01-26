package com.Checkmate128.tungstenhax.mixin;

import com.Checkmate128.tungstenhax.TungstenHaxMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class EntityFlyMixin {
    private MinecraftClient client = MinecraftClient.getInstance();
    private int flyCheckBypassCounter = 20;

    @Inject(method = "tick", at = @At("TAIL"))
    private void tick(CallbackInfo ci) {
        if (client.player != null && client.player.hasVehicle() && TungstenHaxMod.entityFlyEnabled) {
            Entity vehicle = client.player.getVehicle();
            Vec3d velocity = vehicle.getVelocity();
            velocity = velocity.normalize();
            double yVelocity = 0.0;
            if (client.options.jumpKey.isPressed()) {
                yVelocity += TungstenHaxMod.entityFlySpeed;
            }

            if(flyCheckBypassCounter == 0) {
                flyCheckBypassCounter = 20;
                yVelocity = -0.04;
            }

            if(!vehicle.isOnGround()) {
                if (client.options.forwardKey.isPressed()) {
                    Vec3d newVelocity = vehicle.getVelocity();
                    newVelocity = new Vec3d(velocity.x, 0, velocity.z);
                    newVelocity = newVelocity.normalize().multiply(TungstenHaxMod.entityFlySpeed);
                    vehicle.setVelocity(newVelocity.x, yVelocity, newVelocity.z);
                } else {
                    vehicle.setVelocity(0, yVelocity, 0);
                }
            } else {
                vehicle.setVelocity(velocity.x, yVelocity, velocity.z);
            }

            if(flyCheckBypassCounter > -1) {
                flyCheckBypassCounter--;
            }
        }
    }
}
