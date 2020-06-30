package com.demoversion.pitfall.MainMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.demoversion.pitfall.MainGame;
import com.demoversion.pitfall.Screens.MainMenu;
import com.demoversion.pitfall.Screens.PlayScreen;
import com.demoversion.pitfall.Tools.GameManager;



public class GameOverButtons {

    private MainGame game;
    private Stage stage;
    private Viewport gamePort;

    private ImageButton playAgainBtn;
    private ImageButton mainMenuBtn;




    public GameOverButtons(MainGame game) {
        this.game = game;

        gamePort = new FitViewport(MainGame.V_WIDTH, MainGame.V_Height, new OrthographicCamera());
        stage = new Stage(gamePort, game.batch);

        Gdx.input.setInputProcessor(stage);
        createAndPositionButtons();
        addAllListeners();

        stage.addActor(playAgainBtn);
        stage.addActor(mainMenuBtn);





    }

    private void createAndPositionButtons() {

        playAgainBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/playagain_button.png"))));
        mainMenuBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/mainMenu_button.png"))));


        playAgainBtn.setPosition(MainGame.V_WIDTH / 2 + 300 , MainGame.V_Height / 2 - 300, Align.center);
        mainMenuBtn.setPosition(MainGame.V_WIDTH / 2 -300, MainGame.V_Height / 2 - 300,Align.center);


    }

    private void addAllListeners() {

        playAgainBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameManager.getInstance().gameStartedFromMainMenu = true;
                game.setScreen(new PlayScreen(game));
                stage.dispose();
                GameManager.getInstance().stopGameOverMusic();


            }
        });

        mainMenuBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
                stage.dispose();
                GameManager.getInstance().stopGameOverMusic();

            }
        });
    }

    public Stage getStage() { // to access our stage, in order to draw everything that we put inside of it
        return this.stage;
    }


}