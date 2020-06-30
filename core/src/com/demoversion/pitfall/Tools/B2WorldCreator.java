package com.demoversion.pitfall.Tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.demoversion.pitfall.MainGame;



public class B2WorldCreator {

    public B2WorldCreator(World world, TiledMap map){
        CreateGround(map,world);
        CreateWater(map,world);
        CreateEND2(map,world);
        CreatePits(map,world);
          CreateEnd(map,world);
          CreateFixer(map,world);
          CreateWaterFX(map,world);
          CreateGroundFixer(map,world);


    }

    public void CreateGround(TiledMap map,World world){
        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;


        for(MapObject object : map.getLayers().get(2).getObjects().
                getByType(RectangleMapObject.class)){

            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rect.getX() + rect.getWidth() /2) / MainGame.PPM,
                    (rect.getY() + rect.getHeight() /2) / MainGame.PPM);

            body = world.createBody(bodyDef);

            shape.setAsBox((rect.getWidth() /2) / MainGame.PPM,
                    (rect.getHeight() / 2) / MainGame.PPM);

            fixtureDef.shape = shape;

            fixtureDef.filter.categoryBits = MainGame.ground;

            Fixture fixture = body.createFixture(fixtureDef);
            fixture.setUserData("ground");

        }

    }


    public void CreateWater(TiledMap map,World world){
        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;


        for(MapObject object : map.getLayers().get(3).getObjects().
                getByType(RectangleMapObject.class)){

            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rect.getX() + rect.getWidth() /2) / MainGame.PPM,
                    (rect.getY() + rect.getHeight() /2) / MainGame.PPM);

            body = world.createBody(bodyDef);

            shape.setAsBox((rect.getWidth() /2) / MainGame.PPM,
                    (rect.getHeight() / 2) / MainGame.PPM);

            fixtureDef.shape = shape;

            fixtureDef.filter.categoryBits = MainGame.water;

            Fixture fixture = body.createFixture(fixtureDef);
            fixture.setUserData("water");
            fixture.setSensor(true);

        }
    }

    public void CreatePits(TiledMap map,World world){
        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;


        for(MapObject object : map.getLayers().get(1).getObjects().
                getByType(RectangleMapObject.class)){

            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rect.getX() + rect.getWidth() /2) / MainGame.PPM,
                    (rect.getY() + rect.getHeight() /2) / MainGame.PPM);

            body = world.createBody(bodyDef);

            shape.setAsBox((rect.getWidth() /2) / MainGame.PPM,
                    (rect.getHeight() / 2) / MainGame.PPM);

            fixtureDef.shape = shape;

            fixtureDef.filter.categoryBits = MainGame.pits;

            Fixture fixture = body.createFixture(fixtureDef);
            fixture.setUserData("pits");
            fixture.setSensor(true);

        }
    }

    public void CreateEnd(TiledMap map,World world){
        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;

        for(MapObject object : map.getLayers().get(0).getObjects().
                getByType(RectangleMapObject.class)){

            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rect.getX() + rect.getWidth() /2) / MainGame.PPM,
                    (rect.getY() + rect.getHeight() /2) / MainGame.PPM);

            body = world.createBody(bodyDef);

            shape.setAsBox((rect.getWidth() /2) / MainGame.PPM,
                    (rect.getHeight() / 2) / MainGame.PPM);

            fixtureDef.shape = shape;

            fixtureDef.filter.categoryBits = MainGame.end;

            Fixture fixture = body.createFixture(fixtureDef);
            fixture.setUserData("end");
            fixture.setSensor(true);

        }
    }


    public void CreateFixer(TiledMap map,World world){
        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;

        for(MapObject object : map.getLayers().get(4).getObjects().
                getByType(RectangleMapObject.class)){

            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rect.getX() + rect.getWidth() /2) / MainGame.PPM,
                    (rect.getY() + rect.getHeight() /2) / MainGame.PPM);

            body = world.createBody(bodyDef);

            shape.setAsBox((rect.getWidth() /2) / MainGame.PPM,
                    (rect.getHeight() / 2) / MainGame.PPM);

            fixtureDef.shape = shape;

            fixtureDef.filter.categoryBits = MainGame.fixer;

            Fixture fixture = body.createFixture(fixtureDef);
            fixture.setUserData("fixer");
            fixture.setSensor(true);

        }
    }
    public void CreateWaterFX(TiledMap map,World world){
        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;

        for(MapObject object : map.getLayers().get(5).getObjects().
                getByType(RectangleMapObject.class)){

            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rect.getX() + rect.getWidth() /2) / MainGame.PPM,
                    (rect.getY() + rect.getHeight() /2) / MainGame.PPM);

            body = world.createBody(bodyDef);

            shape.setAsBox((rect.getWidth() /2) / MainGame.PPM,
                    (rect.getHeight() / 2) / MainGame.PPM);

            fixtureDef.shape = shape;

            fixtureDef.filter.categoryBits = MainGame.WFX;

            Fixture fixture = body.createFixture(fixtureDef);
            fixture.setUserData("WFX");


        }
    }
    public void CreateGroundFixer(TiledMap map,World world){
        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;

        for(MapObject object : map.getLayers().get(6).getObjects().
                getByType(RectangleMapObject.class)){

            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rect.getX() + rect.getWidth() /2) / MainGame.PPM,
                    (rect.getY() + rect.getHeight() /2) / MainGame.PPM);

            body = world.createBody(bodyDef);

            shape.setAsBox((rect.getWidth() /2) / MainGame.PPM,
                    (rect.getHeight() / 2) / MainGame.PPM);

            fixtureDef.shape = shape;

            Fixture fixture = body.createFixture(fixtureDef);
            fixture.setUserData("GFX");


        }
    }
    public void CreateEND2(TiledMap map,World world){
        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;

        for(MapObject object : map.getLayers().get(7).getObjects().
                getByType(RectangleMapObject.class)){

            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rect.getX() + rect.getWidth() /2) / MainGame.PPM,
                    (rect.getY() + rect.getHeight() /2) / MainGame.PPM);

            body = world.createBody(bodyDef);

            shape.setAsBox((rect.getWidth() /2) / MainGame.PPM,
                    (rect.getHeight() / 2) / MainGame.PPM);

            fixtureDef.shape = shape;

            fixtureDef.filter.categoryBits = MainGame.END2;

            Fixture fixture = body.createFixture(fixtureDef);
            fixture.setUserData("END2");
            fixture.setSensor(true);


        }
    }

    }


