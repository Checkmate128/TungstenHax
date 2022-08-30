package com.Checkmate128.tungstenhax.hacks;

import com.Checkmate128.tungstenhax.TungstenHaxMod;

import java.util.Random;

public class AutoFishHelper {
    private static int recastTimer = 0;

    private static Random rand = new Random();

    public static boolean shouldRecast() {
        return recastTimer == 0;
    }

    public static void resetRecastTimer() {
        recastTimer = TungstenHaxMod.autoFishingRecastDelay + rand.nextInt(-TungstenHaxMod.autoFishingDelayRandomization, TungstenHaxMod.autoFishingDelayRandomization);
    }

    public static void tick() {
        if(recastTimer > -1) {
            recastTimer--;
        }
    }
}
