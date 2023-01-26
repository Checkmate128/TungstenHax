package com.Checkmate128.tungstenhax.mixin;

import com.Checkmate128.tungstenhax.TungstenHaxMod;
import com.Checkmate128.tungstenhax.hacks.AutoFishHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.Random;

@Mixin(FishingBobberEntity.class)
public abstract class AutoFishMixin {

	@Shadow private boolean caughtFish;
	@Shadow abstract PlayerEntity getPlayerOwner();

	Random rand = new Random();
	private int catchDelay = rand.nextInt(5, 15);

	MinecraftClient client = MinecraftClient.getInstance();

	@Inject(at = @At("TAIL"), method = "tick")
	private void tick(CallbackInfo info) {
		if(catchDelay <= 0 && caughtFish && TungstenHaxMod.autoFishingEnabled && client.player != null && client.player.isHolding(Items.FISHING_ROD) && getPlayerOwner().getUuid().equals(client.player.getUuid())) {
			client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
			catchDelay = rand.nextInt(5, 15);
			AutoFishHelper.resetRecastTimer();
		}

		if(caughtFish && catchDelay > -1) {
			catchDelay--;
		}
	}
}
