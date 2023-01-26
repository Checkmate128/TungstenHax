package com.Checkmate128.tungstenhax.ui;

import com.Checkmate128.tungstenhax.TungstenHaxMod;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.text.Text;

import java.text.DecimalFormat;

public class SpeedHackSlider extends SliderWidget {

    private DecimalFormat df = new DecimalFormat("0.0");
    public SpeedHackSlider(int x, int y, int width, int height, Text text, double value) {
        super(x, y, width, height, text, value);
        this.setMessage(Text.of("Speed: " + df.format(TungstenHaxMod.playerSpeed)));
        this.value = (TungstenHaxMod.playerSpeed - 1) / 2;
    }

    @Override
    protected void updateMessage() {
        this.setMessage(Text.of("Speed: " + df.format(this.value * 2 + 1)));
    }

    @Override
    protected void applyValue() {
        TungstenHaxMod.playerSpeed = this.value * 2 + 1;
    }
}
