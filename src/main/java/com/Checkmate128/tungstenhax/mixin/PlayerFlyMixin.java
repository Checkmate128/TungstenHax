package com.Checkmate128.tungstenhax.mixin;

import com.Checkmate128.tungstenhax.TungstenHaxMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerFlyMixin {
    private MinecraftClient client = MinecraftClient.getInstance();
    private int flyCheckBypassCounter = 20;

    @Inject(method = "tick", at = @At("TAIL"))
    private void tick(CallbackInfo ci) {
        if(TungstenHaxMod.playerFlyEnabled && client.player != null) {
            Vec3d oldVelocity = client.player.getVelocity();
            double yVelocity = 0;
            Vec3d velocity = oldVelocity.normalize();
            if(client.options.jumpKey.isPressed()) {
                yVelocity += 0.5;
            }
            if(client.options.sneakKey.isPressed()) {
                yVelocity -= 0.5;
            }

            if(flyCheckBypassCounter == 0) {
                flyCheckBypassCounter = 20;
                yVelocity = -0.04;
            }

            if(!client.player.isOnGround()) {
                if (client.options.forwardKey.isPressed() && !client.options.backKey.isPressed()) {
                    client.player.setVelocity(client.player.getRotationVector().multiply(2));
                    client.player.setVelocity(client.player.getVelocity().x, yVelocity, client.player.getVelocity().z);
                } else if(client.options.backKey.isPressed()) {
                    client.player.setVelocity(client.player.getRotationVector().multiply(-2));
                    client.player.setVelocity(client.player.getVelocity().x, yVelocity, client.player.getVelocity().z);
                } else {
                    client.player.setVelocity(0, yVelocity, 0);
                }
            } else {
                if(client.options.jumpKey.isPressed()) {
                    client.player.setVelocity(velocity.x * 2, yVelocity, velocity.z * 2);
                }
            }

            if(flyCheckBypassCounter > -1) {
                flyCheckBypassCounter--;
            }
        }
    }
}
