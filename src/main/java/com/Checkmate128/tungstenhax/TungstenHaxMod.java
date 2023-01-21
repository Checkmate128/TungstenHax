package com.Checkmate128.tungstenhax;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TungstenHaxMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("TungstenHax");

	public static boolean autoFishingEnabled = false;
	public static int autoFishingRecastDelay = 80;
	public static int autoFishingDelayRandomization = 20;
	public static boolean entityFlyEnabled = false;
	public static boolean playerFlyEnabled = false;
	public static boolean infiniteJumpEnabled = false;
	public static boolean noFallDamageEnabled = false;
	public static boolean xrayEnabled = false;
	public static boolean fullBrightEnabled = false;
	public static boolean ghostBlocksEnabled = false;

	public static boolean ghostBreakEnabled = false;
	public static boolean adBlockEnabled = true;
	public static boolean robotModeEnabled = false;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Tungsten Hax On!");
	}
}
