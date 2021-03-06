package com.demoversion.pitfall.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.demoversion.pitfall.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = MainGame.V_WIDTH;
		config.height = MainGame.V_Height;
		config.fullscreen = true;
		new LwjglApplication(new MainGame(), config);
	}
}
