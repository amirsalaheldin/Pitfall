package com.demoversion.pitfall.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.demoversion.pitfall.MainGame;
import com.demoversion.pitfall.Screens.GameOverScreen;
import com.demoversion.pitfall.Screens.MainMenu;
import com.demoversion.pitfall.Tools.GameManager;



public class Hud implements Disposable {

    public Stage stage;
    private Viewport viewport;

    private float timeCount;


    private Label countdownLabel;
    private static Label scoreLabel;
    private Label timeLabel;
    private static Label levelLabel;
    private Label worldLabel;
    private Label harryLabel;
    private Label lifeNameLabel;
    private static Label lifeLabel;

    private ImageButton pauseBtn, resumeBtn, quiteBtn;
    private Image pausePanel;
    private MainGame game;

    public Hud(MainGame game){
        this.game = game;

        if (GameManager.getInstance().gameStartedFromMainMenu) {
            GameManager.getInstance().gameStartedFromMainMenu = false;
            GameManager.getInstance().lifeScore = 3;
            GameManager.getInstance().score = 0;
            GameManager.getInstance().diamondCount = 0;
            GameManager.getInstance().time = 300;
            GameManager.getInstance().lvl =1 ;
            timeCount = 0;

        }
        viewport = new FitViewport(MainGame.V_WIDTH, MainGame.V_Height, new OrthographicCamera());
        stage = new Stage(viewport, game.batch);

        Gdx.input.setInputProcessor(stage);
        createBtnAndAddListener();

        Table table = new Table();
        table.top();
        table.setFillParent(true);


        countdownLabel = new Label(String.format("%03d", GameManager.getInstance().time),
                new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%05d", GameManager.getInstance().score),
                new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lifeLabel = new Label(String.format("%01d", GameManager.getInstance().lifeScore),
                new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label("TiME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        levelLabel = new Label(String.valueOf(GameManager.getInstance().lvl), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        worldLabel = new Label("Level", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        harryLabel = new Label("Score", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lifeNameLabel = new Label("Life", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(lifeNameLabel).expandX().padTop(10);
        table.add(harryLabel).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.row();
        table.add(lifeLabel).expandX();
        table.add(scoreLabel).expandX();
        table.add(levelLabel).expandX();
        table.add(countdownLabel).expandX();

        stage.addActor(table);
        stage.addActor(pauseBtn);
    }

    public void update(float dt){
        timeCount += dt;
        if (timeCount > 1){
            GameManager.getInstance().time --  ;
            countdownLabel.setText(String.format("%03d", GameManager.getInstance().time));
            timeCount = 0;
        }
        if (GameManager.getInstance().time == 0){
            GameManager.getInstance().stopBackgroundMusic();
            game.setScreen(new GameOverScreen(game));

        }
    }

    public static void addScore(){
        GameManager.getInstance().score += 100;
        scoreLabel.setText(String.format("%05d", GameManager.getInstance().score));
    }


    public static void Level1(){
        GameManager.getInstance().lvl = 1;
        levelLabel.setText(String.format("%01d", GameManager.getInstance().lvl));
    }
    public static void Level2(){
        GameManager.getInstance().lvl = 2;
        levelLabel.setText(String.format("%01d", GameManager.getInstance().lvl));
    }
    public static void Level3(){
        GameManager.getInstance().lvl = 3;
        levelLabel.setText(String.format("%01d", GameManager.getInstance().lvl));
    }

    private void createBtnAndAddListener() {
        pauseBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/Pause.png"))));
        pauseBtn.setPosition(20, 100, Align.center);

        pauseBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                GameManager.getInstance().isPaused = true;
                GameManager.getInstance().pauseBackgroundMusic();
                createPausePanel();



            }
        });
    }

    private void createPausePanel() {

        pausePanel = new Image(new Texture("Buttons/Paused.png"));
        resumeBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/Resume.png"))));
        quiteBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/Quit 2.png"))));
        pausePanel.setPosition(MainGame.V_WIDTH / 2f, MainGame.V_Height / 2f, Align.center);
        resumeBtn.setPosition(MainGame.V_WIDTH / 2f, MainGame.V_Height / 2f + 50,Align.center);
        quiteBtn.setPosition(MainGame.V_WIDTH / 2f, MainGame.V_Height / 2f - 80,Align.center);
        stage.addActor(pausePanel);
        stage.addActor(resumeBtn);
        stage.addActor(quiteBtn);

        resumeBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                GameManager.getInstance().isPaused = false;
                GameManager.getInstance().playBackgroundMusic();
                removePausePanel();

            }
        });

        quiteBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
                ifQuitGame();

            }
        });


    }
    private void removePausePanel(){
        pausePanel.remove();
        resumeBtn.remove();
        quiteBtn.remove();
    }


    public static void removeScore(){
        GameManager.getInstance().score -= 75;
        scoreLabel.setText(String.format("%05d", GameManager.getInstance().score));
    }

    public static void removeLife() {
        GameManager.getInstance().lifeScore -= 1;
        if (GameManager.getInstance().lifeScore > 0) {
            lifeLabel.setText(String.format("%01d", GameManager.getInstance().lifeScore));
        }
    }



    public static void incrementDiamondCounter(){
        GameManager.getInstance().diamondCount ++;
    }

    private void ifQuitGame(){
        GameManager.getInstance().lastPositionx = 70;
        GameManager.getInstance().lastPositiony =700;
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
