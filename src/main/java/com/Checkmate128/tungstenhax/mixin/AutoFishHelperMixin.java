package com.Checkmate128.tungstenhax.mixin;

import com.Checkmate128.tungstenhax.hacks.AutoFishHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(PlayerEntity.class)
public abstract class AutoFishHelperMixin {
    private MinecraftClient client = MinecraftClient.getInstance();

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        if (client.player != null && ((PlayerEntity)(Object)this).getUuid().equals(client.player.getUuid())) {
            if (AutoFishHelper.shouldRecast() && client.player != null && client.player.isHolding(Items.FISHING_ROD)) {
                client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
            }

            AutoFishHelper.tick();
        }
    }
}
