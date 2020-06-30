
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



public class Birds extends Sprite {

    public enum State {STANDING, RUNNING}

    public State cuurentState;
    public State previousState;
    public World world;
    public Body body;



    private Animation<TextureRegion> birdsRun;
    private float stateTimer;


    public Birds(World world, ControllCreatures screen, Float x, Float y) {
        super(screen.getAtlasBirds().findRegion("wingMan3"));
        this.world = world;
        cuurentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;

        setPosition(x, y);

        Array<TextureRegion> frames = new Array<TextureRegion>();
        for (int i = 0; i <= 2; i++) {
            if (i == 0)
                frames.add(new TextureRegion(getTexture(), 1, 26, 216, 101));
            if (i == 1)
                frames.add(new TextureRegion(getTexture(), 219, 26, 216, 101));
            if (i == 2)
                frames.add(new TextureRegion(getTexture(), 439, 20, 206, 107));
        }
        birdsRun = new Animation<TextureRegion>(0.2f, frames);
        frames.clear();

        defineBirds();
        setBounds(0, 0, 105 / MainGame.PPM, 50 / MainGame.PPM);

    }


    public void update(float dt) {
        setPosition(body.getPosition().x - getWidth() / 2,
                body.getPosition().y - getHeight() / 2);
        setRegion(getFrame(dt));
    }

    public TextureRegion getFrame(float dt) {
        cuurentState = getState();

        TextureRegion region;

        region = birdsRun.getKeyFrame(stateTimer, true);

        stateTimer = cuurentState == previousState ? stateTimer + dt : 0;
        previousState = cuurentState;
        return region;
    }

    public State getState() {
        return State.RUNNING;
    }





    public void defineBirds(){

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
        fixtureDef.filter.categoryBits = MainGame.BIRD;
        fixtureDef.filter.maskBits = MainGame.defualt | MainGame.player;

        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData("bird");
    }
}
