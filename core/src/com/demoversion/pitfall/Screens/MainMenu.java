package com.demoversion.pitfall.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.demoversion.pitfall.MainGame;
import com.demoversion.pitfall.MainMenu.MainMenuButtons;
import com.demoversion.pitfall.Tools.GameManager;



public class MainMenu implements Screen {

    private MainGame game;
    private OrthographicCamera mainCamera;
    private Viewport gamePort;
    private Texture background;
    private MainMenuButtons buttons;


    public MainMenu(MainGame game){

        this.game = game;
        mainCamera = new OrthographicCamera(MainGame.V_WIDTH,MainGame.V_Height);
        mainCamera.position.set(MainGame.V_WIDTH/2f,MainGame.V_Height/2f,0);

        gamePort = new FillViewport(MainGame.V_WIDTH,MainGame.V_Height,mainCamera);

        background = new Texture("Main Menu Backgrounds/background1.png");



        buttons = new MainMenuButtons(game);
        GameManager.getInstance().playIntroMusic();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(background,0,0,mainCamera.viewportWidth,mainCamera.viewportHeight);
        game.batch.end();

        game.batch.setProjectionMatrix(buttons.getStage().getCamera().combined);
        buttons.getStage().draw();


    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        buttons.getStage().dispose();

    }
}
