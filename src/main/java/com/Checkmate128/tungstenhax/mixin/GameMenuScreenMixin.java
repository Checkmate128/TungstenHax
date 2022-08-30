package com.Checkmate128.tungstenhax.mixin;

import com.Checkmate128.tungstenhax.screens.MainHacksScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin extends Screen {
    protected GameMenuScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "initWidgets", at = @At("HEAD"))
    private void initWidgets(CallbackInfo ci) {
        this.addDrawableChild(new ButtonWidget(20, this.height - 40, 100, 20, Text.of("Tungsten Hax"), (button) -> {
            MinecraftClient.getInstance().setScreen(new MainHacksScreen(Text.of("Tungsten Hacks")));
        }));
    }
}
