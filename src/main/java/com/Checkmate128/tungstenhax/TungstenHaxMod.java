package com.Checkmate128.tungstenhax;

import com.Checkmate128.tungstenhax.ui.MainHacksScreen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.lwjgl.glfw.GLFW;

public class TungstenHaxMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("TungstenHax");

	public static boolean autoFishingEnabled = false;
	public static int autoFishingRecastDelay = 80;
	public static int autoFishingDelayRandomization = 20;
	public static boolean entityFlyEnabled = false;
	public static double entityFlySpeed = 1.0;
	public static boolean playerFlyEnabled = false;
	public static double playerFlySpeed = 1.0;
	public static boolean infiniteJumpEnabled = false;
	public static boolean noFallDamageEnabled = false;
	public static boolean playerSpeedEnabled = false;
	public static double playerSpeed = 1.0;
	public static boolean xrayEnabled = false;
	public static boolean fullBrightEnabled = false;
	public static boolean ghostBlocksEnabled = false;

	public static boolean ghostBreakEnabled = false;
	public static boolean adBlockEnabled = true;
	public static boolean robotModeEnabled = false;

	public static KeyBinding openCheatMenu;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		openCheatMenu = new KeyBinding("Open Cheat Menu", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_BRACKET, "TungstenHax");

		KeyBindingHelper.registerKeyBinding(openCheatMenu);

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (openCheatMenu.wasPressed()) {
				client.setScreen(new MainHacksScreen(Text.of("Tungsten Hax")));
			}
		});
	}
}
