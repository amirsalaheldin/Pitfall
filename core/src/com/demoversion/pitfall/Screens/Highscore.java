package com.demoversion.pitfall.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.demoversion.pitfall.MainGame;
import com.demoversion.pitfall.MainMenu.HighscoreButton;


public class Highscore implements Screen {

    private MainGame game;
    private Viewport gamePort;
    private OrthographicCamera mainCamera;
    private Texture background;

    private HighscoreButton button;

    public Highscore(MainGame game){
        this.game=game;

        mainCamera = new OrthographicCamera(MainGame.V_WIDTH,MainGame.V_Height);
        mainCamera.position.set(MainGame.V_WIDTH/2f,MainGame.V_Height/2f,0);

        gamePort = new StretchViewport(MainGame.V_WIDTH,MainGame.V_Height,mainCamera);

        background = new Texture("Main Menu Backgrounds/Highscore.png");

        button = new HighscoreButton(game);


    }




    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(background,0,0,mainCamera.viewportWidth,mainCamera.viewportHeight);
        game.batch.end();

        game.batch.setProjectionMatrix(button.getStage().getCamera().combined);
        button.getStage().draw();


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
        button.getStage().dispose();

    }
}
