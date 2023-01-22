package com.Checkmate128.tungstenhax.screens;

import com.Checkmate128.tungstenhax.TungstenHaxMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.text.Text;

public class MainHacksScreen extends Screen {
    public MainHacksScreen(Text title) {
        super(title);
        MinecraftClient client = MinecraftClient.getInstance();
        super.init();
    }

    private Text getAutoFishText() {
        if(TungstenHaxMod.autoFishingEnabled) {
            return Text.of("Auto Fishing: On");
        } else {
            return Text.of("Auto Fishing: Off");
        }
    }

    private Text getEntityFlyText() {
        if(TungstenHaxMod.entityFlyEnabled) {
            return Text.of("Entity Fly: On");
        } else {
            return Text.of("Entity Fly: Off");
        }
    }

    private Text getPlayerFlyText() {
        if(TungstenHaxMod.playerFlyEnabled) {
            return Text.of("Player Fly: On");
        } else {
            return Text.of("Player Fly: Off");
        }
    }

    private Text getInfiniteJumpText() {
        if(TungstenHaxMod.infiniteJumpEnabled) {
            return Text.of("∞ Jumps: On");
        } else {
            return Text.of("∞ Jumps: Off");
        }
    }

    private Text getNoFallDamageText() {
        if(TungstenHaxMod.noFallDamageEnabled) {
            return Text.of("No Fall Damage: On");
        } else {
            return Text.of("No Fall Damage: Off");
        }
    }

    private Text getXRAYText() {
        if(TungstenHaxMod.xrayEnabled) {
            return Text.of("XRAY: On");
        } else {
            return Text.of("XRAY: Off");
        }
    }

    private Text getFullBrightText() {
        if(TungstenHaxMod.fullBrightEnabled) {
            return Text.of("Full Bright: On");
        } else {
            return Text.of("Full Bright: Off");
        }
    }

    private Text getGhostBlockText() {
        if(TungstenHaxMod.ghostBlocksEnabled) {
            return Text.of("Ghost Blocks: On");
        } else {
            return Text.of("Ghost Blocks: Off");
        }
    }

    private Text getGhostBreakText() {
        if(TungstenHaxMod.ghostBreakEnabled) {
            return Text.of("Ghost Break: On");
        } else {
            return Text.of("Ghost Break: Off");
        }
    }

    private Text getAdBlockText() {
        if(TungstenHaxMod.adBlockEnabled) {
            return Text.of("AdBlock: On");
        } else {
            return Text.of("AdBlock: Off");
        }
    }

    private Text getRobotModeText() {
        if(TungstenHaxMod.robotModeEnabled) {
            return Text.of("Robot Mode: On");
        } else {
            return Text.of("Robot Mode: Off");
        }
    }

    @Override
    public void init() {
        this.addDrawableChild(new ButtonWidget(0, 0, 100, 20, getAutoFishText(), (button) -> {
            TungstenHaxMod.autoFishingEnabled = !TungstenHaxMod.autoFishingEnabled;
            button.setMessage(getAutoFishText());
        }));
        this.addDrawableChild(new ButtonWidget(0, 20, 100, 20, getEntityFlyText(), (button) -> {
            TungstenHaxMod.entityFlyEnabled = !TungstenHaxMod.entityFlyEnabled;
            button.setMessage(getEntityFlyText());
        }));
        this.addDrawableChild(new ButtonWidget(0, 40, 100, 20, getPlayerFlyText(), (button) -> {
            TungstenHaxMod.playerFlyEnabled = !TungstenHaxMod.playerFlyEnabled;
            button.setMessage(getPlayerFlyText());
        }));
        this.addDrawableChild(new ButtonWidget(0, 60, 100, 20, getInfiniteJumpText(), (button) -> {
            TungstenHaxMod.infiniteJumpEnabled = !TungstenHaxMod.infiniteJumpEnabled;
            button.setMessage(getInfiniteJumpText());
        }));
        this.addDrawableChild(new ButtonWidget(0, 80, 100, 20, getNoFallDamageText(), (button) -> {
            TungstenHaxMod.noFallDamageEnabled = !TungstenHaxMod.noFallDamageEnabled;
            button.setMessage(getNoFallDamageText());
        }));
        this.addDrawableChild(new ButtonWidget(0, 100, 100, 20, getXRAYText(), (button) -> {
            TungstenHaxMod.xrayEnabled = !TungstenHaxMod.xrayEnabled;
            button.setMessage(getXRAYText());
            MinecraftClient.getInstance().worldRenderer.reload();
            MinecraftClient.getInstance().chunkCullingEnabled = !TungstenHaxMod.xrayEnabled;
        }));
        this.addDrawableChild(new ButtonWidget(0, 120, 100, 20, getFullBrightText(), (button) -> {
            TungstenHaxMod.fullBrightEnabled = !TungstenHaxMod.fullBrightEnabled;
            button.setMessage(getFullBrightText());
            if(TungstenHaxMod.fullBrightEnabled) {
                MinecraftClient.getInstance().options.gamma = 16.0;
            } else {
                MinecraftClient.getInstance().options.gamma = 1.0;
            }
        }));
        this.addDrawableChild(new ButtonWidget(0, 140, 100, 20, getGhostBlockText(), (button) -> {
            TungstenHaxMod.ghostBlocksEnabled = !TungstenHaxMod.ghostBlocksEnabled;
            button.setMessage(getGhostBlockText());
        }));
        this.addDrawableChild(new ButtonWidget(0, 160, 100, 20, getGhostBreakText(), (button) -> {
            TungstenHaxMod.ghostBreakEnabled = !TungstenHaxMod.ghostBreakEnabled;
            button.setMessage(getGhostBreakText());
        }));
        this.addDrawableChild(new ButtonWidget(0, 180, 100, 20, getAdBlockText(), (button) -> {
            TungstenHaxMod.adBlockEnabled = !TungstenHaxMod.adBlockEnabled;
            button.setMessage(getAdBlockText());
        }));
        this.addDrawableChild(new ButtonWidget(0, 200, 100, 20, getRobotModeText(), (button) -> {
            TungstenHaxMod.robotModeEnabled = !TungstenHaxMod.robotModeEnabled;
            button.setMessage(getRobotModeText());
        }));
    }
}
