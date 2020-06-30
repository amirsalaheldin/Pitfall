package com.demoversion.pitfall.Sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.demoversion.pitfall.MainGame;
import com.demoversion.pitfall.Screens.MainMenu;
import com.demoversion.pitfall.Screens.PlayScreen;
import com.demoversion.pitfall.Tools.GameManager;


public class Harry extends Sprite {

    public enum State{JUMPING, STANDING, RUNNING};
    public State cuurentState;
    public State previousState;
    public World world;
    public Body body;
    private TextureRegion harryStand;



    private Animation<TextureRegion> harryRun;
    private Animation<TextureRegion> harryJump;
    private float stateTimer;
    private boolean runningRight;

    public Harry(World world, PlayScreen screen){
        super(screen.getAtlas().findRegion("Player Idle"));
        this.world = world;
        cuurentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        runningRight = true;

        Array<TextureRegion> frames = new Array<TextureRegion>();
        for(int i = 1; i < 3; i++)
            frames.add(new TextureRegion(getTexture(), i * 80, 0 , 80, 110));
        harryRun = new Animation<TextureRegion>(0.1f, frames);
        frames.clear();

        for (int i = 5; i<6; i++)
            frames.add(new TextureRegion(getTexture(), i * 80, 0 , 80, 110));
        harryJump = new Animation<TextureRegion>(0.1f, frames);



        harryStand = new TextureRegion(getTexture(), 0,0,80,110);
        defineHarry();
        setBounds(0,0, 80/MainGame.PPM, 110 / MainGame.PPM);
        setRegion(harryStand);

    }

    public void update(float dt){
        setPosition(body.getPosition().x - getWidth() /2,
                body.getPosition().y - getHeight() /2 + 0.1f);
        setRegion(getFrame(dt));
    }

    public TextureRegion getFrame(float dt){
        cuurentState = getState();

        TextureRegion region;
        switch (cuurentState){
            case JUMPING:
                region = harryJump.getKeyFrame(stateTimer);
                break;
            case RUNNING:
                region = harryRun.getKeyFrame(stateTimer, true);
                break;
            case STANDING:
                default:
                    region = harryStand;
                    break;
        }

        if((body.getLinearVelocity().x < 0 || !runningRight) && !region.isFlipX()){
            region.flip(true, false);
            runningRight = false;
        }
        else if((body.getLinearVelocity().x > 0 || runningRight) && region.isFlipX()){
            region.flip(true, false);
            runningRight = true;
        }

        stateTimer = cuurentState == previousState ? stateTimer + dt : 0;
        previousState = cuurentState;
        return region;
    }

    public State getState(){
        if(body.getLinearVelocity().y > 0)
            return State.JUMPING;
        else if(body.getLinearVelocity().x != 0)
            return State.RUNNING;
        else
            return State.STANDING;
    }

    public void defineHarry(){

        BodyDef bdef = new BodyDef();
        bdef.position.set(GameManager.getInstance().lastPositionx/ MainGame.PPM , GameManager.getInstance().lastPositiony / MainGame.PPM);

            bdef.type = BodyDef.BodyType.DynamicBody;
               body = world.createBody(bdef);

        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        shape.setAsBox(20/MainGame.PPM, 45 / MainGame.PPM);

        fixtureDef.shape = shape;
        fixtureDef.density = 0f;
        fixtureDef.friction = 1f;
        fixtureDef.filter.categoryBits = MainGame.player;
        fixtureDef.filter.maskBits = MainGame.defualt | MainGame.water | MainGame.coins |
                                 MainGame.SCORPION | MainGame.end | MainGame.ground | MainGame.WFX
                | MainGame.fixer | MainGame.BAT | MainGame.BIRD | MainGame.EEL  | MainGame.FIN |  MainGame.END2;

        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData("harry");



    }


}
