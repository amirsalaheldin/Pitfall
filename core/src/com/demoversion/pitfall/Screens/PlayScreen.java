package com.demoversion.pitfall.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.demoversion.pitfall.MainGame;
import com.demoversion.pitfall.Scenes.Hud;
import com.demoversion.pitfall.Tools.*;
import com.demoversion.pitfall.Sprites.Harry;


public class PlayScreen implements Screen,ContactListener {



    private MainGame game;
    private TextureAtlas atlas;
    private ControllCreatures controllCreatures;
    private BracketsControl bracketsControl;
    private boolean isJumping = true;
    private int jumpCounter = 0;
   private CollectablesControl collectables;

    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private Hud hud;
    private Harry player;
    private boolean touchedForFirstTime;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;


    private World world;
    private Box2DDebugRenderer b2dr;

    private Sound soundcoins;
    private Sound soundjump;
    private Vector2 gravity;




    public PlayScreen(MainGame game){
        gravity = new Vector2(0,-10);

        this.game = game;
        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(MainGame.V_WIDTH   / MainGame.PPM ,
                MainGame.V_Height  / MainGame.PPM, gameCam);
        hud = new Hud(game);


        mapLoader = new TmxMapLoader();
        map = mapLoader.load("Screen2/Screen2.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/MainGame.PPM);
        gameCam.position.set(gamePort.getWorldWidth() / 2 -300, gamePort.getWorldHeight() / 2, 0);

        world = new World(gravity, true);


        controllCreatures = new ControllCreatures();
        controllCreatures.createUnites(world);
        bracketsControl = new BracketsControl();
        bracketsControl.createBrackets(world);

        world.setContactListener(this);
        atlas = new TextureAtlas("Harry.pack");

        b2dr = new Box2DDebugRenderer();
        new B2WorldCreator(world, map);

        player = new Harry(world, this);


        collectables = new CollectablesControl(world);

        GameManager.getInstance().playBackgroundMusic();
        soundcoins = Gdx.audio.newSound(Gdx.files.internal("coins.mp3"));
        soundjump = Gdx.audio.newSound(Gdx.files.internal("jump.wav"));
    }


    public TextureAtlas getAtlas(){
        return atlas;
    }


    @Override
    public void show() {

    }

    public void handelInput(){

        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            if (isJumping) {
               jumpCounter++;
               soundjump.play();
               player.body.applyLinearImpulse(new Vector2(0, 4f), player.body.getWorldCenter(), true);

               if (jumpCounter == 2){
                   isJumping=false;
               }
            }
        }
        else player.body.applyLinearImpulse(new Vector2(0, 0), player.body.getWorldCenter(), true);


        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.body.getLinearVelocity().x <= 2)
            player.body.applyLinearImpulse(new Vector2(0.6f, 0), player.body.getWorldCenter(), true);
        else player.body.applyLinearImpulse(new Vector2(0, 0), player.body.getWorldCenter(), true);


        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.body.getLinearVelocity().x >= -2)
            player.body.applyLinearImpulse(new Vector2(-0.6f, 0), player.body.getWorldCenter(), true);
        else player.body.applyLinearImpulse(new Vector2(0, 0), player.body.getWorldCenter(), true);


        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && player.body.getLinearVelocity().x >= -2)
            player.body.applyLinearImpulse(new Vector2(0, -0.1f), player.body.getWorldCenter(), true);

        else player.body.applyLinearImpulse(new Vector2(0, 0), player.body.getWorldCenter(), true);

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
            Gdx.app.exit();

    }
    public void checkForFirstTouch(){
        if (!touchedForFirstTime){
            if (Gdx.input.justTouched()){
                touchedForFirstTime = true;
                GameManager.getInstance().isPaused = false;
            }
        }
    }

    public void playerDied() {

        Hud.removeLife();
        Hud.removeScore();
        GameManager.getInstance().stopBackgroundMusic();

        if (GameManager.getInstance().lifeScore < 3) {

            if (GameManager.getInstance().lvl == 1) {

               playerDiedLv1();
            }
            if (GameManager.getInstance().lvl == 2) {
                playerDiedLv2();
            }
            if (GameManager.getInstance().lvl == 3) {
                playerDiedLv3();
            }
        }

        if (GameManager.getInstance().lifeScore == 0) {
            GameManager.getInstance().checkForHighscore();
            game.setScreen(new GameOverScreen(game));
            GameManager.getInstance().stopBackgroundMusic();
            GameManager.getInstance().lastPositionx = 70f;
            GameManager.getInstance().lastPositiony = 700f;
        }
    }
    private void playerDiedLv1(){
        GameManager.getInstance().time = 300;
        GameManager.getInstance().lastPositionx = 70f;
        GameManager.getInstance().lastPositiony = 700f;
        game.setScreen(new PlayScreen(game));
    }

        private void playerDiedLv2(){
            GameManager.getInstance().time = 200;
            GameManager.getInstance().lastPositionx = 10205f;
            GameManager.getInstance().lastPositiony = 700f;
            game.setScreen(new PlayScreen(game));
        }

    private void playerDiedLv3(){
        GameManager.getInstance().time = 200;
        GameManager.getInstance().lastPositionx = 17243f;
        GameManager.getInstance().lastPositiony = 700f;
        game.setScreen(new PlayScreen(game));
    }



    public void update(float dt){
        checkForFirstTouch();
        if (!GameManager.getInstance().isPaused){
            handelInput();

            world.step(1/60f, 6, 2);

            player.update(dt);

            gameCam.position.x = player.body.getPosition().x;

            gameCam.update();
            renderer.setView(gameCam);

            controllCreatures.movement(dt);
            bracketsControl.movement();
            hud.update(dt);


        }

        if (player.body.getPosition().x < 100.40){
            hud.Level1();
        }if (player.body.getPosition().x > 100.40 & player.body.getPosition().x <172.15){
            hud.Level2();

        }if ( player.body.getPosition().x >172.15){
               hud.Level3();
        }


    }



    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(170/255f, 170/255, 250/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();

//        b2dr.render(world, gameCam.combined);
        game.batch.setProjectionMatrix(gameCam.combined);

        game.batch.begin();
        collectables.DrawCollectables(game.batch);
        player.draw(game.batch);
        bracketsControl.draw(game.batch);
        controllCreatures.draw(game.batch);
        game.batch.end();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
        hud.stage.act();

    }


    @Override
    public void resize(int width, int height) {

        gamePort.update(width, height);

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

        map.dispose();
        renderer.dispose();
        world.dispose();
        b2dr.dispose();
        hud.dispose();

    }

    @Override
    public void beginContact(Contact contact) {
        Fixture f1,f2;

        if (contact.getFixtureA().getUserData() == "harry"){
            f1 = contact.getFixtureA();
            f2 = contact.getFixtureB();
        }else{
            f2 = contact.getFixtureA();
            f1 = contact.getFixtureB();
        }

        if(f1.getUserData() == "harry" && f2.getUserData() == "ground" | f2.getUserData()== "bracket"){
            isJumping = true;
            jumpCounter = 0;
            System.out.println("ground");
        }
        if(f1.getUserData() == "harry" && f2.getUserData() == "water"){
            System.out.println("water");
            player.body.setGravityScale(0);
        }

        if(f1.getUserData() == "harry" && f2.getUserData() == "bird" | f2.getUserData() == "scorpion" | f2.getUserData() == "bat" | f2.getUserData() == "eel"){
            System.out.println("kill");
            playerDied();

        }

        if(f1.getUserData() == "harry" && f2.getUserData() == "pits"){
            System.out.println("pits");
            GameManager.getInstance().stopBackgroundMusic();
            playerDied();
        }

        if(f1.getUserData() == "harry" && f2.getUserData() == "end"){
            System.out.println("end");
            f2.setUserData(".....");

        }

        if(f1.getUserData() == "harry" && f2.getUserData() == "fixer"){
            System.out.println("fixer");
            player.body.setGravityScale(1);
        }

        if(f1.getUserData() == "harry" && f2.getUserData() == "WFX"){
            player.body.setGravityScale(0);
            isJumping = true;
            jumpCounter = 0;
            System.out.println("WFX");
        }

        if(f1.getUserData() == "harry" && f2.getUserData() == "coins"){
            Hud.addScore();
            Hud.incrementDiamondCounter();
            f2.setUserData("Remove");
            System.out.println("coins");
            soundcoins.play();
            collectables.DeleteCollectables();

        }

        if(f1.getUserData() == "harry" && f2.getUserData() == "bracket"){
            System.out.println("bracket");
            isJumping = true;
            jumpCounter = 0;
            bracketsControl.setBMove(true);

        }

        if(f1.getUserData() == "harry" && f2.getUserData() == "bracket2"){
            System.out.println("bracket2");
            bracketsControl.setBMove2(true);


        }
        if(f1.getUserData() == "harry" && f2.getUserData() == "END2"){
            System.out.println("FINAl");
            GameManager.getInstance().stopBackgroundMusic();
            game.setScreen(new Highscore(game));



        }
    }


    @Override
    public void endContact(Contact contact) {


    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}//playScreen
