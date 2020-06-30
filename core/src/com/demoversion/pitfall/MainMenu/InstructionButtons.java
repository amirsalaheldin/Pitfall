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



public class InstructionButtons {

    private MainGame game;
    private Stage stage;
    private Viewport gamePort;


    private ImageButton backButton;


    public InstructionButtons(MainGame game){
        this.game=game;

        gamePort = new FitViewport(MainGame.V_WIDTH,MainGame.V_Height,
                new OrthographicCamera());

        stage = new Stage(gamePort,game.batch);
        Gdx.input.setInputProcessor(stage);
        createAndPositionUIElements();
        stage.addActor(backButton);




    }
    private void createAndPositionUIElements(){

        backButton = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/mainMenu_button.png"))));

        backButton.setPosition(20,20, Align.bottomLeft);


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
