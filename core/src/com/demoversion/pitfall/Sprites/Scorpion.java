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
import com.demoversion.pitfall.Tools.ControllCreatures;


public class Scorpion extends Sprite {

    public enum State{STANDING, RUNNING};
    public State cuurentState;
    public State previousState;
    public World world;
    public Body body;
    private TextureRegion scorpioStand;


    private Animation<TextureRegion> scorpioRun;
    private float stateTimer;
    private boolean runningRight;

    public Scorpion(World world, ControllCreatures screen, Float x, Float y){
        super(screen.getAtlasS().findRegion("spider_walk2"));
        this.world = world;
        cuurentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        runningRight = true;
        setPosition(x,y);

        Array<TextureRegion> frames = new Array<TextureRegion>();
        for(int i = 0; i <= 2; i++)
            frames.add(new TextureRegion(getTexture(), i * 77, 0 , 77, 53));
        scorpioRun = new Animation<TextureRegion>(0.1f, frames);
        frames.clear();


        scorpioStand = new TextureRegion(getTexture(), 0,0,77,53);
        defineScorpion();
        setBounds(0,0, 77/MainGame.PPM, 53/ MainGame.PPM);
        setRegion(scorpioStand);

    }


    public void update(float dt){
        setPosition(body.getPosition().x - getWidth() /2,
                body.getPosition().y - getHeight() /2 );
        setRegion(getFrame(dt));
    }

    public TextureRegion getFrame(float dt){
        cuurentState = getState();

        TextureRegion region;
        switch (cuurentState){
            case RUNNING:
                region = scorpioRun.getKeyFrame(stateTimer, true);
                break;
            case STANDING:
            default:
                region = scorpioStand;
                break;

        }

        if((body.getLinearVelocity().x > 0 || !runningRight) && !region.isFlipX()){
            region.flip(true, false);
            runningRight = false;
        }
        else if((body.getLinearVelocity().x < 0 || runningRight) && region.isFlipX()){
            region.flip(true, false);
            runningRight = true;
        }

        stateTimer = cuurentState == previousState ? stateTimer + dt : 0;
        previousState = cuurentState;
        return region;
    }

    public State getState(){
         if(body.getLinearVelocity().x != 0)
            return State.RUNNING;
        else
            return State.STANDING;
    }

    public void defineScorpion(){

        BodyDef bdef = new BodyDef();
        bdef.position.set(getX() / MainGame.PPM , getY() / MainGame.PPM);

        bdef.type = BodyDef.BodyType.KinematicBody;
        body = world.createBody(bdef);


        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        shape.setAsBox(34/MainGame.PPM, 20 / MainGame.PPM);

        fixtureDef.shape = shape;
        fixtureDef.density = 0f;
        fixtureDef.friction = 1f;
        fixtureDef.filter.categoryBits = MainGame.SCORPION;
        fixtureDef.filter.maskBits = MainGame.defualt | MainGame.player;



        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData("scorpion");

    }



}
