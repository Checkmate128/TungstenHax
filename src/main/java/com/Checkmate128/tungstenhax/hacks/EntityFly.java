package com.Checkmate128.tungstenhax.hacks;

import com.Checkmate128.tungstenhax.TungstenHaxMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class EntityFly {
    public void tick(MinecraftClient client) {
        if(client.player != null && client.player.hasVehicle()) {
            Entity vehicle = client.player.getVehicle();
            Vec3d velocity = vehicle.getVelocity();
            double yVelocity = 0.0;
            if(client.options.jumpKey.isPressed()) {
                yVelocity = 2.0;
            }
            vehicle.setVelocity(velocity.x, yVelocity, velocity.z);
            TungstenHaxMod.LOGGER.debug("Flying with velocity " + yVelocity);
        }
    }
}
