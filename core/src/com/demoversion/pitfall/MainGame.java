package com.demoversion.pitfall;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.demoversion.pitfall.Screens.MainMenu;
import com.demoversion.pitfall.Tools.GameManager;

public class MainGame extends Game {

    public static final int V_WIDTH  = 1920;
    public static final int V_Height = 1080;
    public static final float PPM     = 100;
    public static final short defualt   = 1;
    public static final short remove    = 0;
    public static final short coins    = 10;
    public static final short SCORPION = 12;
    public static final short BAT      = 14;
    public static final short BIRD     = 16;
    public static final short EEL      = 18;
    public static final short end      = 20;
    public static final short Ladder    = 6;
    public static final short water     = 8;
    public static final short player    = 2;
    public static final short fixer    = 22;
    public static final short pits      = 8;
    public static final short ground    = 4;
    public static final short WFX      = 24;
    public static final short FIN      = 25;
    public static final short END2     = 26;


    public SpriteBatch batch;


    @Override
    public void create() {
        batch = new SpriteBatch();
        GameManager.getInstance().initializeGameData();
        setScreen(new MainMenu(this));
    }

    @Override
    public void render() {
        super.render();
    }

}