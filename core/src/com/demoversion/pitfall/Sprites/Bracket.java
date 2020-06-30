package com.demoversion.pitfall.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.demoversion.pitfall.MainGame;

import java.beans.VetoableChangeListener;



public class Bracket extends Sprite {

    private World world;
    public   Body body;
    private FixtureDef fixtureDef;
    private Fixture fixture;

    public Bracket(World world,Float x, Float y){
        super(new Texture("bracket.png"));
        this.world = world;

        setBounds(x,y, 60/MainGame.PPM, 30 / MainGame.PPM);

        defineBracket();


    }

    public void update(){
        setPosition(body.getPosition().x - getWidth() /2,
                body.getPosition().y - getHeight() /2 - 0.02f);

    }




    public void defineBracket(){

        BodyDef bdef = new BodyDef();
        bdef.position.set(getX() / MainGame.PPM , getY()/ MainGame.PPM);

        bdef.type = BodyDef.BodyType.KinematicBody;
        body = world.createBody(bdef);

        fixtureDef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        shape.setAsBox(30/MainGame.PPM, 15/ MainGame.PPM);

        fixtureDef.shape = shape;
        fixtureDef.density = 0f;
        fixtureDef.friction = 1f;
        fixtureDef.filter.categoryBits = MainGame.Ladder;
        fixtureDef.filter.maskBits = MainGame.defualt | MainGame.player ;

        fixture = body.createFixture(fixtureDef);
        fixture.setUserData("bracket");

    }
    public void fixture (String string){
        fixture.setUserData(string);

    }


}
