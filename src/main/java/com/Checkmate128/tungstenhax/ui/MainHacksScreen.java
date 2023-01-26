package com.Checkmate128.tungstenhax.ui;

import com.Checkmate128.tungstenhax.TungstenHaxMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
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

    private Text getPlayerSpeedText() {
        if(TungstenHaxMod.playerSpeedEnabled) {
            return Text.of("Player Speed: On");
        } else {
            return Text.of("Player Speed: Off");
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
        this.addDrawableChild(ButtonWidget.builder(getAutoFishText(), (button) -> {
            TungstenHaxMod.autoFishingEnabled = !TungstenHaxMod.autoFishingEnabled;
            button.setMessage(getAutoFishText());
        }).dimensions(0, 0, 100, 20).build());
        this.addDrawableChild(ButtonWidget.builder(getEntityFlyText(), (button) -> {
            TungstenHaxMod.entityFlyEnabled = !TungstenHaxMod.entityFlyEnabled;
            button.setMessage(getEntityFlyText());
        }).dimensions(0, 20, 100, 20).build());
        this.addDrawableChild(new EntityFlySpeedSlider(100, 20, 100, 20, Text.of(""), TungstenHaxMod.entityFlySpeed));
        this.addDrawableChild(ButtonWidget.builder(getPlayerFlyText(), (button) -> {
            TungstenHaxMod.playerFlyEnabled = !TungstenHaxMod.playerFlyEnabled;
            button.setMessage(getPlayerFlyText());
        }).dimensions(0, 40, 100, 20).build());
        this.addDrawableChild(new PlayerFlySpeedSlider(100, 40, 100, 20, Text.of(""), TungstenHaxMod.playerFlySpeed));
        this.addDrawableChild(ButtonWidget.builder(getInfiniteJumpText(), (button) -> {
            TungstenHaxMod.infiniteJumpEnabled = !TungstenHaxMod.infiniteJumpEnabled;
            button.setMessage(getInfiniteJumpText());
        }).dimensions(0, 60, 100, 20).build());
        this.addDrawableChild(ButtonWidget.builder(getNoFallDamageText(), (button) -> {
            TungstenHaxMod.noFallDamageEnabled = !TungstenHaxMod.noFallDamageEnabled;
            button.setMessage(getNoFallDamageText());
        }).dimensions(0, 80, 100, 20).build());
        this.addDrawableChild(ButtonWidget.builder(getPlayerSpeedText(), (button) -> {
            TungstenHaxMod.playerSpeedEnabled = !TungstenHaxMod.playerSpeedEnabled;
            button.setMessage(getPlayerSpeedText());
        }).dimensions(0, 100, 100, 20).build());
        this.addDrawableChild(new SpeedHackSlider(100, 100, 100, 20, Text.of(""), TungstenHaxMod.playerSpeed / 3));
        this.addDrawableChild(ButtonWidget.builder(getXRAYText(), (button) -> {
            TungstenHaxMod.xrayEnabled = !TungstenHaxMod.xrayEnabled;
            button.setMessage(getXRAYText());
            MinecraftClient.getInstance().chunkCullingEnabled = !TungstenHaxMod.xrayEnabled;
            MinecraftClient.getInstance().worldRenderer.reload();
        }).dimensions(0, 120, 100, 20).build());
        this.addDrawableChild(ButtonWidget.builder(getFullBrightText(), (button) -> {
            TungstenHaxMod.fullBrightEnabled = !TungstenHaxMod.fullBrightEnabled;
            button.setMessage(getFullBrightText());
            if(TungstenHaxMod.fullBrightEnabled) {
                client.options.getGamma().setValue(16.0);
            } else {
                client.options.getGamma().setValue(1.0);
            }
        }).dimensions(0, 140, 100, 20).build());
        this.addDrawableChild(ButtonWidget.builder(getGhostBlockText(), (button) -> {
            TungstenHaxMod.ghostBlocksEnabled = !TungstenHaxMod.ghostBlocksEnabled;
            button.setMessage(getGhostBlockText());
        }).dimensions(0, 160, 100, 20).build());
        this.addDrawableChild(ButtonWidget.builder(getGhostBreakText(), (button) -> {
            TungstenHaxMod.ghostBreakEnabled = !TungstenHaxMod.ghostBreakEnabled;
            button.setMessage(getGhostBreakText());
        }).dimensions(0, 180, 100, 20).build());
        this.addDrawableChild(ButtonWidget.builder(getAdBlockText(), (button) -> {
            TungstenHaxMod.adBlockEnabled = !TungstenHaxMod.adBlockEnabled;
            button.setMessage(getAdBlockText());
        }).dimensions(0, 200, 100, 20).build());
        this.addDrawableChild(ButtonWidget.builder(getRobotModeText(), (button) -> {
            TungstenHaxMod.robotModeEnabled = !TungstenHaxMod.robotModeEnabled;
            button.setMessage(getRobotModeText());
        }).dimensions(0, 220, 100, 20).build());
    }
}
