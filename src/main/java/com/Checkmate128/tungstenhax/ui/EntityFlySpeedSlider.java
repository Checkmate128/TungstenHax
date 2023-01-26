package com.Checkmate128.tungstenhax.ui;

import com.Checkmate128.tungstenhax.TungstenHaxMod;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.text.Text;

import java.text.DecimalFormat;

public class EntityFlySpeedSlider extends SliderWidget {

    private DecimalFormat df = new DecimalFormat("0.0");
    public EntityFlySpeedSlider(int x, int y, int width, int height, Text text, double value) {
        super(x, y, width, height, text, value);
        this.setMessage(Text.of("Speed: " + df.format(TungstenHaxMod.entityFlySpeed)));
        this.value = (TungstenHaxMod.entityFlySpeed - 1) / 4;
    }

    @Override
    protected void updateMessage() {
        this.setMessage(Text.of("Speed: " + df.format(this.value * 4 + 1)));
    }

    @Override
    protected void applyValue() {
        TungstenHaxMod.entityFlySpeed = this.value * 4 + 1;
    }
}
