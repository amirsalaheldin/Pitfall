package com.demoversion.pitfall.Tools;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.demoversion.pitfall.Sprites.Bats;
import com.demoversion.pitfall.Sprites.Birds;
import com.demoversion.pitfall.Sprites.Eels;
import com.demoversion.pitfall.Sprites.Scorpion;



public class ControllCreatures  {

    private TextureAtlas atlasS;
    private TextureAtlas atlasBats;
    private TextureAtlas atlasBirds;
    private TextureAtlas atlasEels;

    private Scorpion[] scorpions = new Scorpion[21] ;
    private boolean[] turnS = new boolean[21];
    private Vector2[] vS = new Vector2[21];

    private Eels[] eels = new Eels[2];
    private boolean[] turnEel = new boolean[2];
    private Vector2[] vEels = new Vector2[2];

    private Birds[] bird = new Birds[11];
    private boolean[] turnBird = new boolean[11];
    private Vector2[] vBird = new Vector2[11];
    private Bats[] bats = new Bats[4];
    private boolean[] turnBat = new boolean[4];
    private Vector2[] vBats = new Vector2[4];


    public void createUnites(World world){

        atlasS = new TextureAtlas("Scorpion/Scorpion.pack");
        atlasBirds = new TextureAtlas("Bird/Bird.pack");
        atlasBats = new TextureAtlas("Bat/Bats.pack");
        atlasEels = new TextureAtlas("Eel/Eel.pack");

        //Velocity for Eels
        for (int i =0; i<2; i++){
            vEels[i] = new Vector2(-1,0);
        }

        //Velocity for Bats

        for (int i = 0; i< 4; i++){
            vBats[i]  = new Vector2(-1,0);
        }


        //Velocity for Birds
        for (int i =0; i<11; i++){
            vBird[i]  = new Vector2(0,-1);
        }

        //Velocity for Scorpions
        for (int i=0; i<21; i++){
            vS[i] = new Vector2(-1,0);
        }


        eels[0] = new Eels(world,this,1800f,100f);
        eels[1] = new Eels(world,this,5500f,300f);

        bats[0] = new Bats(world,this,1800f,800f);
        bats[1] = new Bats(world,this,7500f,430f);
        bats[2] = new Bats(world,this,15700f,160f);
        bats[3] = new Bats(world,this,22222f,216f);


        bird[0] = new Birds(world,this,1000f,600f);
        bird[1] = new Birds(world,this,11800f,500f);
        bird[2] = new Birds(world,this,15320f,500f);
        bird[3] = new Birds(world,this,19300f,450f);
        bird[4] = new Birds(world,this,25000f,310f);
        bird[5] = new Birds(world,this,25100f,360f);
        bird[6] = new Birds(world,this,25200f,410f);
        bird[7] = new Birds(world,this,25300f,460f);
        bird[8] = new Birds(world,this,25400f,510f);
        bird[9] = new Birds(world,this,25500f,560f);
        bird[10] = new Birds(world,this,25600f,610f);

        scorpions[0]   = new Scorpion(world,this,300f,  280f);
        scorpions[1]  = new Scorpion(world,this,4700f,  90f);
        scorpions[2]  = new Scorpion(world,this,7500f, 220f);
        scorpions[3] = new Scorpion(world,this,7908f, 220f);
        scorpions[4] = new Scorpion(world,this,8400f, 220f);
        scorpions[5] = new Scorpion(world,this,8750f, 220f);
        scorpions[6]  = new Scorpion(world,this,9450f, 670f);
        scorpions[7]  = new Scorpion(world,this,8200f, 470f);
        scorpions[8]  = new Scorpion(world,this,10800f,155f);
        scorpions[9]  = new Scorpion(world,this,11400f,155f);
        scorpions[10] = new Scorpion(world,this,14900f,155f);
        scorpions[11] = new Scorpion(world,this,14800f,670f);
        scorpions[12] = new Scorpion(world,this,19100f,340f);
        scorpions[13] = new Scorpion(world,this,19500f,340f);
        scorpions[14] = new Scorpion(world,this,20700f,88f);
        scorpions[15] = new Scorpion(world,this,21500f,350f);
        scorpions[16] = new Scorpion(world,this,21000f,600f);
        scorpions[17] = new Scorpion(world,this,22600f,88f);
        scorpions[18] = new Scorpion(world,this,23000f,600f);
        scorpions[19] = new Scorpion(world,this,24300f,350f);
        scorpions[20] = new Scorpion(world,this,24300f,88f);

    }

    public void movement(Float delta){

        for (int i=0; i<21; i++){
            scorpions[i].update(delta);
        }

        for (int i =0; i< 2; i++){
            eels[i].update(delta);
        }

        for (int i =0; i<11; i++){
            bird[i].update(delta);
        }

        for (int i =0; i< 4; i++){
            bats[i].update(delta);
        }


        //Scorpions
        //Scorpion1
        if (scorpions[0].body.getPosition().x <= 2.0){
            turnS[0]= false;
        }else if (scorpions[0].body.getPosition().x >= 6.0){
            turnS[0]= true;
        }
        if (turnS[0]){
            vS[0].x= -1;
        }else {
            vS[0].x= 1;
        }
        //Scorpion2
        if (scorpions[1].body.getPosition().x <= 46.400){
            turnS[1]= false;
        }else if (scorpions[1].body.getPosition().x >= 49.000){
            turnS[1]= true;
        }
        if (turnS[1]){
            vS[1].x= -1;
        }else {
            vS[1].x= 1;
        }
        //Scorpion3
        if (scorpions[2].body.getPosition().x <= 74.900){
            turnS[2]= false;
        }else if (scorpions[2].body.getPosition().x >= 76.000){
            turnS[2]= true;
        }
        if (turnS[2]){
            vS[2].x= -1;
        }else {
            vS[2].x= 1;
        }
        //Scorpion4
        if (scorpions[3].body.getPosition().x <= 79.0){
            turnS[3]= false;
        }else if (scorpions[3].body.getPosition().x >= 82.000){
            turnS[3]= true;
        }
        if (turnS[3]){
            vS[3].x= -1;
        }else {
            vS[3].x= 1;
        }
        //Scorpion5
        if (scorpions[4].body.getPosition().x <= 84.0){
            turnS[4]= false;
        }else if (scorpions[4].body.getPosition().x >= 85.100){
            turnS[4]= true;
        }
        if (turnS[4]){
            vS[4].x= -1;
        }else {
            vS[4].x= 1;
        } //Scorpion6
        if (scorpions[5].body.getPosition().x <= 87.300){
            turnS[5]= false;
        }else if (scorpions[5].body.getPosition().x >= 88.400){
            turnS[5]= true;
        }
        if (turnS[5]){
            vS[5].x= -1;
        }else {
            vS[5].x= 1;
        }
        //Scorpion7
        if (scorpions[6].body.getPosition().x <= 94.400){
            turnS[6]= false;
        }else if (scorpions[6].body.getPosition().x >= 95.300){
            turnS[6]= true;
        }
        if (turnS[6]){
            vS[6].x= -1;
        }else {
            vS[6].x= 1;
        } //Scorpion8
        if (scorpions[7].body.getPosition().x <= 80.194){
            turnS[7]= false;
        }else if (scorpions[7].body.getPosition().x >= 83.645){
            turnS[7]= true;
        }
        if (turnS[7]){
            vS[7].x= -1;
        }else {
            vS[7].x= 1;
        } //Scorpion9
        if (scorpions[8].body.getPosition().x <= 106.50){
            turnS[8]= false;
        }else if (scorpions[8].body.getPosition().x >= 111.15){
            turnS[8]= true;
        }
        if (turnS[8]){
            vS[8].x= -1;
        }else {
            vS[8].x= 1;
        }
        //Scorpion10
        if (scorpions[9].body.getPosition().x <= 113.00){
            turnS[9]= false;
        }else if (scorpions[9].body.getPosition().x >= 116.00){
            turnS[9]= true;
        }
        if (turnS[9]){
            vS[9].x= -1;
        }else {
            vS[9].x= 1;
        } //Scorpion11
        if (scorpions[10].body.getPosition().x <= 145.70){
            turnS[10]= false;
        }else if (scorpions[10].body.getPosition().x >= 154.60){
            turnS[10]= true;
        }
        if (turnS[10]){
            vS[10].x= -1;
        }else {
            vS[10].x= 1;
        } //Scorpion12
        if (scorpions[11].body.getPosition().x <= 146.00){
            turnS[11]= false;
        }else if (scorpions[11].body.getPosition().x >= 149.50){
            turnS[11]= true;
        }
        if (turnS[11]){
            vS[11].x= -1;
        }else {
            vS[11].x= 1;
        }//Scorpion13
        if (scorpions[12].body.getPosition().x <= 190.30){
            turnS[12]= false;
        }else if (scorpions[12].body.getPosition().x >= 192.30){
            turnS[12]= true;
        }
        if (turnS[12]){
            vS[12].x= -1;
        }else {
            vS[12].x= 1;
        }//Scorpion14
        if (scorpions[13].body.getPosition().x <= 194.70){
            turnS[13]= false;
        }else if (scorpions[13].body.getPosition().x >= 196.20){
            turnS[13]= true;
        }
        if (turnS[13]){
            vS[13].x= -1;
        }else {
            vS[13].x= 1;
        }//Scorpion15
        if (scorpions[14].body.getPosition().x <= 203.00){
            turnS[14]= false;
        }else if (scorpions[14].body.getPosition().x >= 214.00){
            turnS[14] = true;
        }
        if (turnS[14]){
            vS[14].x= -1;
        }else {
            vS[14].x= 1;
        }//Scorpion16
        if (scorpions[15].body.getPosition().x <= 205.00){
            turnS[15]= false;
        }else if (scorpions[15].body.getPosition().x >= 222.00){
            turnS[15]= true;
        }
        if (turnS[15]){
            vS[15].x= -1;
        }else {
            vS[15].x= 1;
        }//Scorpion17
        if (scorpions[16].body.getPosition().x <= 207.50){
            turnS[16]= false;
        }else if (scorpions[16].body.getPosition().x >= 214.80){
            turnS[16]= true;
        }
        if (turnS[16]){
            vS[16].x= -1;
        }else {
            vS[16].x= 1;
        }//Scorpion18
        if (scorpions[17].body.getPosition().x <= 216.00){
            turnS[17]= false;
        }else if (scorpions[17].body.getPosition().x >= 238.00){
            turnS[17]= true;
        }
        if (turnS[17]){
            vS[17].x= -1;
        }else {
            vS[17].x= 1;
        }//Scorpion19
        if (scorpions[18].body.getPosition().x <= 227.50){
            turnS[18]= false;
        }else if (scorpions[18].body.getPosition().x >= 236.00){
            turnS[18]= true;
        }
        if (turnS[18]){
            vS[18].x= -1;
        }else {
            vS[18].x= 1;
        }//Scorpion20
        if (scorpions[19].body.getPosition().x <= 240.00){
            turnS[19]= false;
        }else if (scorpions[19].body.getPosition().x >= 244.86){
            turnS[19]= true;
        }
        if (turnS[19]){
            vS[19].x= -1;
        }else {
            vS[19].x= 1;
        }//Scorpion21
        if (scorpions[20].body.getPosition().x <= 240.00){
            turnS[20]= false;
        }else if (scorpions[20].body.getPosition().x >= 246.50){
            turnS[20]= true;
        }
        if (turnS[20]){
            vS[20].x= -1;
        }else {
            vS[20].x= 1;
        }


        //bird
        if (bird[0].body.getPosition().y <= 4.0){
            turnBird[0]= false;
        }else if (bird[0].body.getPosition().y >= 7.0){
            turnBird[0]= true;
        }
        if (turnBird[0]){
            vBird[0].y= -1;
        }else {
            vBird[0].y= 1;
        }  //bird1
        if (bird[1].body.getPosition().y <= 1.80){
            turnBird[1]= false;
        }else if (bird[1].body.getPosition().y >= 7.20){
            turnBird[1]= true;
        }
        if (turnBird[1]){
            vBird[1].y= -1;
        }else {
            vBird[1].y= 1;
        }  //bird2
        if (bird[2].body.getPosition().y <= 4.00){
            turnBird[2]= false;
        }else if (bird[2].body.getPosition().y >= 7.10){
            turnBird[2]= true;
        }
        if (turnBird[2]){
            vBird[2].y= 0.8f;
        }else {
            vBird[2].y= 0.8f;
        }  //bird3
        if (bird[3].body.getPosition().y <= 4.00){
            turnBird[3]= false;
        }else if (bird[3].body.getPosition().y >= 5.70){
            turnBird[3]= true;
        }
        if (turnBird[3]){
            vBird[3].y= -0.8f;
        }else {
            vBird[3].y= 0.8f;
        } //bird4
        if (bird[4].body.getPosition().y <= 3.00){
            turnBird[4]= false;
        }else if (bird[4].body.getPosition().y >= 6.70){
            turnBird[4]= true;
        }
        if (turnBird[4]){
            vBird[4].y= -0.8f;
        }else {
            vBird[4].y= 0.8f;
        }//bird5
        if (bird[5].body.getPosition().y <= 3.00){
            turnBird[5]= false;
        }else if (bird[5].body.getPosition().y >= 6.70){
            turnBird[5]= true;
        }
        if (turnBird[5]){
            vBird[5].y= -0.8f;
        }else {
            vBird[5].y= 0.8f;
        }//bird6
        if (bird[6].body.getPosition().y <= 3.00){
            turnBird[6]= false;
        }else if (bird[6].body.getPosition().y >= 6.70){
            turnBird[6]= true;
        }
        if (turnBird[6]){
            vBird[6].y= -0.8f;
        }else {
            vBird[6].y= 0.8f;
        }//bird7
        if (bird[7].body.getPosition().y <= 3.00){
            turnBird[7] = false;
        }else if (bird[7].body.getPosition().y >= 6.70){
            turnBird[7] = true;
        }
        if (turnBird[7]){
            vBird[7].y= -0.8f;
        }else {
            vBird[7].y= 0.8f;
        }//bird8
        if (bird[8].body.getPosition().y <= 3.00){
            turnBird[8]= false;
        }else if (bird[8].body.getPosition().y >= 6.70){
            turnBird[8] = true;
        }
        if (turnBird[8]){
            vBird[8].y= -0.8f;
        }else {
            vBird[8].y= 0.8f;
        }//bird9
        if (bird[9].body.getPosition().y <= 3.00){
            turnBird[9]= false;
        }else if (bird[9].body.getPosition().y >= 6.70){
            turnBird[9] = true;
        }
        if (turnBird[9]){
            vBird[9].y= -0.8f;
        }else {
            vBird[9].y= 0.8f;
        }//bird10
        if (bird[10].body.getPosition().y <= 3.00){
            turnBird[10]= false;
        }else if (bird[10].body.getPosition().y >= 6.70){
            turnBird[10]= true;
        }
        if (turnBird[10]){
            vBird[10].y= -0.8f;
        }else {
            vBird[10].y= 0.8f;
        }

        //bats
        if (bats[0].body.getPosition().x <= 2.0){
            turnBat[0]= false;
        }else if (bats[0].body.getPosition().x >= 18.0){
            turnBat[0]= true;
        }
        if (turnBat[0]){
            vBats[0].x= -1;
        }else {
            vBats[0].x= 1;
        }
        //bats1
        if (bats[1].body.getPosition().x <= 69.0){
            turnBat[1]= false;
        }else if (bats[1].body.getPosition().x >= 79.0){
            turnBat[1]= true;
        }
        if (turnBat[1]){
            vBats[1].x= -2;
        }else {
            vBats[1].x= 2;
        }
        //bats2
        if (bats[2].body.getPosition().x <= 155.00){
            turnBat[2]= false;
        }else if (bats[2].body.getPosition().x >= 165.00){
            turnBat[2]= true;
        }
        if (turnBat[2]){
            vBats[2].x= -3;
        }else {
            vBats[2].x= 3;
        }
        //bats3
        if (bats[3].body.getPosition().x <= 216.10){
            turnBat[3]= false;
        }else if (bats[3].body.getPosition().x >= 246.50){
            turnBat[3]= true;
        }
        if (turnBat[3]){
            vBats[3].x= -4;
        }else {
            vBats[3].x= 4;
        }

        //eels
        //eel 1
        if (eels[0].body.getPosition().x <= 18.0){
            turnEel[0]= false;
        }else if (eels[0].body.getPosition().x >= 26.0){
            turnEel[0]= true;
        }
        if (turnEel[0]){
            vEels[0].x= -1;
        }else {
            vEels[0].x= 1;
        }
        //eel 2
        if (eels[1].body.getPosition().x <= 50.87){
            turnEel[1]= false;
        }else if (eels[1].body.getPosition().x >= 62.510){
            turnEel[1]= true;
        }
        if (turnEel[1]){
            vEels[1].x= -1;
        }else {
            vEels[1].x= 1;
        }
        // to move each creature with its own velocity
        for (int i =0; i< 21; i++){
            scorpions[i].body.setLinearVelocity(vS[i]);
        }

        for (int i =0; i< 4; i++){
            bats[i].body.setLinearVelocity(vBats[i]);
        }

        for (int i =0; i< 11; i++){
            bird[i].body.setLinearVelocity(vBird[i]);
        }

        for (int i=0; i<2; i++){
            eels[i].body.setLinearVelocity(vEels[i]);
        }

    }

    public void draw(SpriteBatch batch){

        for (int i = 0; i<21; i++){
            scorpions[i].draw(batch);
        }

        for (int i = 0; i < 4; i++){
            bats[i].draw(batch);
        }

        for (int i = 0; i < 11; i++){
            bird[i].draw(batch);
        }

        for (int i = 0; i<2; i++){
            eels[i].draw(batch);
        }

    }

    public TextureAtlas getAtlasS() {
        return atlasS;
    }

    public TextureAtlas getAtlasBats() {
        return atlasBats;
    }

    public TextureAtlas getAtlasBirds() {
        return atlasBirds;
    }

    public TextureAtlas getAtlasEels() {
        return atlasEels;
    }

}
