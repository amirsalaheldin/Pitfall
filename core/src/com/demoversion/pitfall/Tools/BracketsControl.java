
package com.demoversion.pitfall.Tools;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.demoversion.pitfall.Sprites.Bracket;

public class BracketsControl {

    private Bracket[] bracketX = new Bracket[9];
    private Bracket[] bracketY = new Bracket[8];
    private Bracket bracketYFirst;
    private Bracket bracketYSecond;
    private boolean[] turnBracketX = new boolean[9];

    private boolean[] turnBracketY = new boolean[8];

    private Boolean BY= false;
    private Boolean BY2= false;
    private Boolean BMove= false;
    private Boolean BMove2= false;

    private Vector2[] vBracketX = new Vector2[9];

    private Vector2[] vBracketY = new Vector2[8];
    private Vector2 vBracketYFirst;
    private Vector2 vBracketYSecond;


    public void createBrackets(World world){
        for (int i =0; i<9; i++){
            vBracketX[i] = new Vector2(-1,0);
        }


        for (int i=0; i<8; i++){
            vBracketY[i] = new Vector2(0,-1);
        }


        vBracketYFirst = new Vector2(0,0);
        vBracketYSecond = new Vector2(0,0);

        bracketX[0] = new Bracket(world,11400f,285f);
        bracketX[1] = new Bracket(world,11300f,606f);
        bracketX[2] = new Bracket(world,12000f,350f);
        bracketX[3] = new Bracket(world,12000f,540f);
        bracketX[4] = new Bracket(world,12700f,600f);
        bracketX[5] = new Bracket(world,12800f,400f);
        bracketX[6] = new Bracket(world,13000f,200f);
        bracketX[7] = new Bracket(world,14000f,160f);
        bracketX[8] = new Bracket(world,14100f,400f);

        bracketY[0] = new Bracket(world,15650f,300f);
        bracketY[1] = new Bracket(world,15780f,400f);
        bracketY[2] = new Bracket(world,15900f,400f);
        bracketY[3] = new Bracket(world,16000f,400f);
        bracketY[4] = new Bracket(world,16150f,400f);
        bracketY[5] = new Bracket(world,16290f,400f);
        bracketY[6] = new Bracket(world,16430f,400f);
        bracketY[7] = new Bracket(world,16555f,400f);

        bracketYFirst = new Bracket(world,515f,300f);
        bracketYSecond = new Bracket(world,9880f,270f);
        bracketYSecond.fixture("bracket2");
    }

    public void setBMove(Boolean BMove) {
        this.BMove = BMove;
    }

    public void movement(){
        for (int i=0; i<9; i++){
            bracketX[i].update();
        }


        for (int i=0; i<8; i++){
            bracketY[i].update();
        }


        bracketYFirst.update();
        bracketYSecond.update();

        //BracketX1
        if (bracketX[0].body.getPosition().x <= 112.30){
            turnBracketX[0]= false;
        }else if (bracketX[0].body.getPosition().x >= 116.70){
            turnBracketX[0]= true;
        }
        if (turnBracketX[0]){
            vBracketX[0].x= -1;
        }else {
            vBracketX[0].x= 1;
        }
        //BracketX2
        if (bracketX[1].body.getPosition().x <= 111.60){
            turnBracketX[1]= false;
        }else if (bracketX[1].body.getPosition().x >= 117.20){
            turnBracketX[1]= true;
        }
        if (turnBracketX[1]){
            vBracketX[1].x= -1;
        }else {
            vBracketX[1].x= 1;
        }
        //BracketX3
        if (bracketX[2].body.getPosition().x <= 118.00){
            turnBracketX[2]= false;
        }else if (bracketX[2].body.getPosition().x >= 121.40){
            turnBracketX[2]= true;
        }
        if (turnBracketX[2]){
            vBracketX[2].x= -1;
        }else {
            vBracketX[2].x= 1;
        }
        //BracketX4
        if (bracketX[3].body.getPosition().x <= 119.50){
            turnBracketX[3]= false;
        }else if (bracketX[3].body.getPosition().x >= 123.10){
            turnBracketX[3]= true;
        }
        if (turnBracketX[3]){
            vBracketX[3].x= -1;
        }else {
            vBracketX[3].x= 1;
        }
        //BracketX5
        if (bracketX[4].body.getPosition().x <= 125.10){
            turnBracketX[4]= false;
        }else if (bracketX[4].body.getPosition().x >= 129.0){
            turnBracketX[4]= true;
        }
        if (turnBracketX[4]){
            vBracketX[4].x= -1;
        }else {
            vBracketX[4].x= 1;
        }
        //BracketX6
        if (bracketX[5].body.getPosition().x <= 127.00){
            turnBracketX[5]= false;
        }else if (bracketX[5].body.getPosition().x >= 130.00){
            turnBracketX[5]= true;
        }
        if (turnBracketX[5]){
            vBracketX[5].x= -1;
        }else {
            vBracketX[5].x= 1;
        }
        //BracketX7
        if (bracketX[6].body.getPosition().x <= 125.30){
            turnBracketX[6]= false;
        }else if (bracketX[6].body.getPosition().x >= 134.00){
            turnBracketX[6]= true;
        }
        if (turnBracketX[6]){
            vBracketX[6].x= -1;
        }else {
            vBracketX[6].x= 1;
        }
        //BracketX8
        if (bracketX[7].body.getPosition().x <= 136.00){
            turnBracketX[7]= false;
        }else if (bracketX[7].body.getPosition().x >= 144.80){
            turnBracketX[7]= true;
        }
        if (turnBracketX[7]){
            vBracketX[7].x= -1;
        }else {
            vBracketX[7].x= 1;
        }
        //BracketX9
        if (bracketX[8].body.getPosition().x <= 140.00){
            turnBracketX[8]= false;
        }else if (bracketX[8].body.getPosition().x >= 142.50){
            turnBracketX[8]= true;
        }
        if (turnBracketX[8]){
            vBracketX[8].x= -1;
        }else {
            vBracketX[8].x= 1;
        }

        //BracketY1
        if (bracketY[0].body.getPosition().y <= 1.50){
            turnBracketY[0]= false;
        }else if (bracketY[0].body.getPosition().y >= 5.40){
            turnBracketY[0]= true;
        }
        if (turnBracketY[0]){
            vBracketY[0].y= -1;
        }else {
            vBracketY[0].y= 1;
        }

        //BracketY2
        if (bracketY[1].body.getPosition().y <= 3.50){
            turnBracketY[1] = false;
        }else if (bracketY[1].body.getPosition().y >= 6.00){
            turnBracketY[1]= true;
        }
        if (turnBracketY[1]){
            vBracketY[1].y= -1;
        }else {
            vBracketY[1].y= 1;
        }
        //BracketY3
        if (bracketY[2].body.getPosition().y <= 2.10){
            turnBracketY[2]= false;
        }else if (bracketY[2].body.getPosition().y >= 5.40){
            turnBracketY[2]= true;
        }
        if (turnBracketY[2]){
            vBracketY[2].y= -1;
        }else {
            vBracketY[2].y= 1;
        }
        //BracketY4
        if (bracketY[3].body.getPosition().y <= 3.30){
            turnBracketY[3]= false;
        }else if (bracketY[3].body.getPosition().y >= 6.00){
            turnBracketY[3]= true;
        }
        if (turnBracketY[3]){
            vBracketY[3].y= -1;
        }else {
            vBracketY[3].y= 1;
        }
        //BracketY5
        if (bracketY[4].body.getPosition().y <= 2.77){
            turnBracketY[4]= false;
        }else if (bracketY[4].body.getPosition().y >= 4.72){
            turnBracketY[4] = true;
        }
        if (turnBracketY[4]){
            vBracketY[4].y= -1;
        }else {
            vBracketY[4].y= 1;
        }
        //BracketY6
        if (bracketY[5].body.getPosition().y <= 3.30){
            turnBracketY[5]= false;
        }else if (bracketY[5].body.getPosition().y >= 6.00){
            turnBracketY[5] = true;
        }
        if (turnBracketY[5]){
            vBracketY[5].y= -1;
        }else {
            vBracketY[5].y= 1;
        }
        //BracketY7
        if (bracketY[6].body.getPosition().y <= 2.68){
            turnBracketY[6]= false;
        }else if (bracketY[6].body.getPosition().y >= 4.70){
            turnBracketY[6]= true;
        }
        if (turnBracketY[6]){
            vBracketY[6].y= -1;
        }else {
            vBracketY[6].y= 1;
        }
        //BracketY8
        if (bracketY[7].body.getPosition().y <= 3.45){
            turnBracketY[7]= false;
        }else if (bracketY[7].body.getPosition().y >= 6.00){
            turnBracketY[7]= true;
        }
        if (turnBracketY[7]){
            vBracketY[7].y= -1;
        }else {
            vBracketY[7].y= 1;
        }

        for (int i=0; i<9; i++){
            bracketX[i].body.setLinearVelocity(vBracketX[i]);
        }



        for (int i=0; i<8; i++){
            bracketY[i].body.setLinearVelocity(vBracketY[i]);
        }



        bracketYFirst.body.setLinearVelocity(vBracketYFirst);
        bracketYSecond.body.setLinearVelocity(vBracketYSecond);



        // checking the bracket position
        if (vBracketYFirst.y == 0) {
            if (bracketYFirst.body.getPosition().y > 5) {
                BY = true;

            } else BY = false;
        }

        if (BMove){
            if (BY)
                vBracketYFirst.y = -1;
            else
                vBracketYFirst.y = 1;
        }else
            vBracketYFirst.y = 0;

        if (bracketYFirst.body.getPosition().y > 6.20 | bracketYFirst.body.getPosition().y < 3.0){
            BMove = false;
        }

        // checking the bracket 2 position
        if (vBracketYSecond.y == 0) {
            if (bracketYSecond.body.getPosition().y > 5) {
                BY2 = true;

            } else BY2 = false;
        }

        if (BMove2){
            if (BY2)
                vBracketYSecond.y = -2;
            else
                vBracketYSecond.y = 2;
        }else
            vBracketYSecond.y = 0;

        if (bracketYSecond.body.getPosition().y > 6.20 | bracketYSecond.body.getPosition().y < 3.0){
            BMove2 = false;
        }


    }



    public void setBMove2(Boolean BMove2) {
        this.BMove2 = BMove2;
    }




    public void draw(SpriteBatch batch){

        for (int i=0; i<9; i++){
            bracketX[i].draw(batch);
        }


        for (int i =0; i<8; i++){
            bracketY[i].draw(batch);
        }


        bracketYFirst.draw(batch);
        bracketYSecond.draw(batch);


    }


}
