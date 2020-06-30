package com.demoversion.pitfall.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.demoversion.pitfall.MainGame;

import java.beans.VetoableChangeListener;



public class Collectables extends Sprite {

    private World world;
    public   Body body;
    private Fixture fixture;



    public Collectables(World world,Float x, Float y){
        super(new Texture("red.png"));
        this.world = world;

        setBounds(x,y, getWidth()/MainGame.PPM , getHeight() / MainGame.PPM );

        CreateCollectable();

    }

    public void update(){
        setPosition(body.getPosition().x - getWidth() /2,
                body.getPosition().y - getHeight() /2 );

    }


    public Fixture getFixture() {
        return fixture;
    }

    public void CreateCollectable(){

        BodyDef bdef = new BodyDef();
        bdef.position.set(getX() / MainGame.PPM  , getY() / MainGame.PPM );

        bdef.type = BodyDef.BodyType.KinematicBody;
        body = world.createBody(bdef);

        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        shape.setAsBox(20/MainGame.PPM, 21 / MainGame.PPM);

        fixtureDef.shape = shape;
        fixtureDef.density = 0f;
        fixtureDef.friction = 1f;
        fixtureDef.filter.categoryBits = MainGame.coins;
        fixtureDef.filter.maskBits = MainGame.defualt | MainGame.player ;

        fixture = body.createFixture(fixtureDef);
        fixture.setUserData("coins");
        fixture.setSensor(true);

    }

    public void changeFilter(){
        Filter filter = new Filter();
        filter.categoryBits = MainGame.remove;
        fixture.setFilterData(filter);
    }



}
