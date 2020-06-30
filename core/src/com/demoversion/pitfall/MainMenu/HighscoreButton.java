package com.demoversion.pitfall.MainMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.demoversion.pitfall.MainGame;
import com.demoversion.pitfall.Scenes.Hud;
import com.demoversion.pitfall.Screens.MainMenu;
import com.demoversion.pitfall.Tools.GameManager;



public class HighscoreButton {

    private MainGame game;
    private Stage stage;
    private Viewport gamePort;


    private Label treasureLabel,treasure;
    private Label scoreLabel,score;

    private ImageButton backButton;


    public HighscoreButton(MainGame game) {
        this.game = game;
        gamePort = new FitViewport(MainGame.V_WIDTH,MainGame.V_Height,
                new OrthographicCamera());

        stage = new Stage(gamePort,game.batch);
        Gdx.input.setInputProcessor(stage);
        createAndPositionUIElements();
        stage.addActor(backButton);
        stage.addActor(scoreLabel);
        stage.addActor(treasureLabel);
        stage.addActor(score);
        stage.addActor(treasure);


    }

    private void createAndPositionUIElements(){

        backButton = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/mainMenu_button.png"))));
        final FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Font/blow.ttf"));

        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size =50;

        BitmapFont treasureFont = generator.generateFont(parameter);
        BitmapFont scoreFont = generator.generateFont(parameter);

        BitmapFont treFont = generator.generateFont(parameter);
        BitmapFont scoFont = generator.generateFont(parameter);


        scoreLabel = new Label(String.valueOf(GameManager.getInstance().gameData.getHighscore()),
                new Label.LabelStyle(scoreFont, Color.GOLD));
        score = new Label("Score      : ", new Label.LabelStyle(scoreFont, Color.PURPLE));

        treasureLabel = new Label(String.valueOf(GameManager.getInstance().gameData.getDiamondHighscore()),
                new Label.LabelStyle(scoreFont, Color.GOLD));
        treasure = new Label("Treasures  : ", new Label.LabelStyle(scoreFont, Color.PURPLE));



        backButton.setPosition(20,20, Align.bottomLeft);
        scoreLabel.setPosition(MainGame.V_WIDTH/2f-50,MainGame.V_Height/2+50);
        score.setPosition(MainGame.V_WIDTH/2f-500,MainGame.V_Height/2+50);

        treasureLabel.setPosition(MainGame.V_WIDTH/2f-40,MainGame.V_Height/2-40);
        treasure.setPosition(MainGame.V_WIDTH/2f-500,MainGame.V_Height/2-40);



        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
            }
        });

    }
    public Stage getStage() {
        return this.stage;
    }

}
