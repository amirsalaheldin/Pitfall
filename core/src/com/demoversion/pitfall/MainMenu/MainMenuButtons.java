package com.demoversion.pitfall.MainMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.demoversion.pitfall.MainGame;
import com.demoversion.pitfall.Screens.Highscore;
import com.demoversion.pitfall.Screens.InstructionScrn;
import com.demoversion.pitfall.Screens.PlayScreen;
import com.demoversion.pitfall.Tools.GameManager;


public class MainMenuButtons {

    private MainGame game;
    private Stage stage;  // a stage is kinda like a screen, where u put ur buttons inside of it and we can draw that by using the stage
    private Viewport gamePort;

    private ImageButton startBtn;
    private ImageButton highscoreBtn;
    private ImageButton instructionsBtn;
    private ImageButton exitBtn;



    public MainMenuButtons(MainGame game) {
        this.game = game;

        gamePort = new FitViewport(MainGame.V_WIDTH, MainGame.V_Height, new OrthographicCamera());
        // we need our viewport in order to create our stage, we need the sprite batch and the viewport
        stage = new Stage(gamePort, game.batch);

        Gdx.input.setInputProcessor(stage);  // in order to interact with the buttons we set the input processor to be a stage
        createAndPositionButtons();
        addAllListeners();

        stage.addActor(startBtn);
        stage.addActor(highscoreBtn);
        stage.addActor(instructionsBtn);
        stage.addActor(exitBtn);

        stage.addAction(Actions.fadeOut(1f));


    }

    private void createAndPositionButtons() {

        startBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/StartButton.png"))));
        highscoreBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/HighscoreButton.png"))));
        instructionsBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/InstuctionsButton.png"))));
        exitBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/ExitButton.png"))));


        startBtn.setPosition(MainGame.V_WIDTH / 2 , MainGame.V_Height / 2 + 100, Align.center);
        highscoreBtn.setPosition(MainGame.V_WIDTH / 2 , MainGame.V_Height / 2 ,Align.center);
        instructionsBtn.setPosition(MainGame.V_WIDTH / 2, MainGame.V_Height / 2 - 100,Align.center);
        exitBtn.setPosition(MainGame.V_WIDTH / 2 , MainGame.V_Height / 2 - 200,Align.center);
    }

    private void addAllListeners() {

        startBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameManager.getInstance().gameStartedFromMainMenu = true;
                game.setScreen(new PlayScreen(game));
                stage.dispose();
                GameManager.getInstance().stopIntroMusic();

            }
        });
        highscoreBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new Highscore(game));
                stage.dispose();
                GameManager.getInstance().stopIntroMusic();

            }
        });
        instructionsBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new InstructionScrn(game));
                stage.dispose();
                GameManager.getInstance().stopIntroMusic();

            }
        });
        exitBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
                stage.dispose();
                GameManager.getInstance().stopIntroMusic();

            }
        });


    }


    public Stage getStage() { // to access our stage, in order to draw everything that we put inside of it
        return this.stage;
    }


}