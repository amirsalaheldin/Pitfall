package com.demoversion.pitfall.Tools;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.demoversion.pitfall.MainGame;
import com.demoversion.pitfall.Sprites.Collectables;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class CollectablesControl {
    private World world;
    private ArrayList<Collectables> collectablesArrayList = new ArrayList<Collectables>();


    public CollectablesControl(World world) {
        this.world = world;

        Collectables collectables = new Collectables(world,30f,280f);
        collectablesArrayList.add(collectables);
        Collectables collectables1 = new Collectables(world,100f,280f);
        collectablesArrayList.add(collectables1);
        Collectables collectables2 = new Collectables(world,600F,545f);
        collectablesArrayList.add(collectables2);
        Collectables collectables3 = new Collectables(world,700f,545f);
        collectablesArrayList.add(collectables3);
        Collectables collectables4 = new Collectables(world,900f,545f);
        collectablesArrayList.add(collectables4);
        Collectables collectables5 = new Collectables(world,1111f,545f);
        collectablesArrayList.add(collectables5);
        Collectables collectables6 = new Collectables(world,2175f,545f);
        collectablesArrayList.add(collectables6);
        Collectables collectables7 = new Collectables(world,4960f,100f);
        collectablesArrayList.add(collectables7);
        Collectables collectables8 = new Collectables(world,3805f,220f);
        collectablesArrayList.add(collectables8);
        Collectables collectables9 = new Collectables(world,1200f,300f);
        collectablesArrayList.add(collectables9);
        Collectables collectables0 = new Collectables(world,4830f,420f);
        collectablesArrayList.add(collectables0);
        Collectables collectables11 = new Collectables(world,4030f,720f);
        collectablesArrayList.add(collectables11);
        Collectables collectables12 = new Collectables(world,6200f,250f);
        collectablesArrayList.add(collectables12);
        Collectables collectables13 = new Collectables(world,6200f,350f);
        collectablesArrayList.add(collectables13);
        Collectables collectables14 = new Collectables(world,6200f,450f);
        collectablesArrayList.add(collectables14);
        Collectables collectables15 = new Collectables(world,6200f,150f);
        collectablesArrayList.add(collectables15);
        Collectables collectables16 = new Collectables(world,6200f,50f);
        collectablesArrayList.add(collectables16);
        Collectables collectables17 = new Collectables(world,8070f,225f);
        collectablesArrayList.add(collectables17);
        Collectables collectables18 = new Collectables(world,9000f,287f);
        collectablesArrayList.add(collectables18);
        Collectables collectables19 = new Collectables(world,9540f,680f);
        collectablesArrayList.add(collectables19);
        Collectables collectables20 = new Collectables(world,9690f,480f);
        collectablesArrayList.add(collectables20);
        Collectables collectables21 = new Collectables(world,3400f,280f);
        collectablesArrayList.add(collectables21);
        Collectables collectables22 = new Collectables(world,3300f,280f);
        collectablesArrayList.add(collectables22);
        Collectables collectables23 = new Collectables(world,3200f,280f);
        collectablesArrayList.add(collectables23);
        Collectables collectables24 = new Collectables(world,10080f,165f);
        collectablesArrayList.add(collectables24);
        Collectables collectables25 = new Collectables(world,10140f,165f);
        collectablesArrayList.add(collectables25);
        Collectables collectables26 = new Collectables(world,10404f,165f);
        collectablesArrayList.add(collectables26);
        Collectables collectables27 = new Collectables(world,10854f,165f);
        collectablesArrayList.add(collectables27);
        Collectables collectables28 = new Collectables(world,10911f,165f);
        collectablesArrayList.add(collectables28);
        Collectables collectables29 = new Collectables(world,11430f,165f);
        collectablesArrayList.add(collectables29);
        Collectables collectables30 = new Collectables(world,11493f,165f);
        collectablesArrayList.add(collectables30);
        Collectables collectables31 = new Collectables(world,11556f,165f);
        collectablesArrayList.add(collectables31);
        Collectables collectables32 = new Collectables(world,12510f,165f);
        collectablesArrayList.add(collectables32);
        Collectables collectables33 = new Collectables(world,13533f,165f);
        collectablesArrayList.add(collectables33);
        Collectables collectables34 = new Collectables(world,14940f,165f);
        collectablesArrayList.add(collectables34);
        Collectables collectables35 = new Collectables(world,14940+65f,165f);
        collectablesArrayList.add(collectables35);
        Collectables collectables36 = new Collectables(world,14940+65+65f,165f);
        collectablesArrayList.add(collectables36);
        Collectables collectables37 = new Collectables(world,14940+65+65+65f,165f);
        collectablesArrayList.add(collectables37);
        Collectables collectables38 = new Collectables(world,14940+65+65+65+65f,165f);
        collectablesArrayList.add(collectables38);
        Collectables collectables39 = new Collectables(world,17823f,165f);
        collectablesArrayList.add(collectables39);
        Collectables collectables40 = new Collectables(world,17823+65f,165f);
        collectablesArrayList.add(collectables40);
        Collectables collectables41 = new Collectables(world,17823+65+65f,165f);
        collectablesArrayList.add(collectables41);
        Collectables collectables42 = new Collectables(world,17823+65+65+65f,165f);
        collectablesArrayList.add(collectables42);
        Collectables collectables43 = new Collectables(world,17823+65+65+65+65f,165f);
        collectablesArrayList.add(collectables43);
        Collectables collectables44 = new Collectables(world,18786f,165f);
        collectablesArrayList.add(collectables44);
        Collectables collectables45 = new Collectables(world,16605f,165f);
        collectablesArrayList.add(collectables45);

        Collectables collectables46 = new Collectables(world,11295f,675f);
        collectablesArrayList.add(collectables46);
        Collectables collectables47 = new Collectables(world,11295+65f,675f);
        collectablesArrayList.add(collectables47);
        Collectables collectables48 = new Collectables(world,11295+65+65f,675f);
        collectablesArrayList.add(collectables48);
        Collectables collectables49 = new Collectables(world,11295+65+65+65f,675f);
        collectablesArrayList.add(collectables49);
        Collectables collectables50 = new Collectables(world,11295+65+65+65+65f,675f);
        collectablesArrayList.add(collectables50);
        Collectables collectables51 = new Collectables(world,11295+65+65+65+65+65f,675f);
        collectablesArrayList.add(collectables51);
        Collectables collectables52 = new Collectables(world,11295+65+65+65+65+65+65f,675f);
        collectablesArrayList.add(collectables52);

        Collectables collectables53 = new Collectables(world,13797f,243f);
        collectablesArrayList.add(collectables53);
        Collectables collectables54 = new Collectables(world,13797+65f,243f);
        collectablesArrayList.add(collectables54);
        Collectables collectables55 = new Collectables(world,13797+65+65f,243f);
        collectablesArrayList.add(collectables55);
        Collectables collectables56 = new Collectables(world,13797+65+65+65f,243f);
        collectablesArrayList.add(collectables56);
        Collectables collectables57 = new Collectables(world,13797+65+65+65+65f,243f);
        collectablesArrayList.add(collectables57);

        Collectables collectables58 = new Collectables(world,14751f,675f);
        collectablesArrayList.add(collectables58);
        Collectables collectables59 = new Collectables(world,14751+65f,675f);
        collectablesArrayList.add(collectables59);
        Collectables collectables60 = new Collectables(world,15522f,675f);
        collectablesArrayList.add(collectables60);

        Collectables collectables61 = new Collectables(world,16675f,225f);
        collectablesArrayList.add(collectables61);
        Collectables collectables62 = new Collectables(world,16675+65f,225+65f);
        collectablesArrayList.add(collectables62);
        Collectables collectables63 = new Collectables(world,16675+65+65f,225+65+65f);
        collectablesArrayList.add(collectables63);
        Collectables collectables64 = new Collectables(world,16675+65+65+65f,225+65+65+65f);
        collectablesArrayList.add(collectables64);
        Collectables collectables65 = new Collectables(world,16675+65+65+65+65f,225+65+65+65+65f);
        collectablesArrayList.add(collectables65);
        Collectables collectables66 = new Collectables(world,16675+65+65+65+65+65f,225+65+65+65+65+65f);
        collectablesArrayList.add(collectables66);
        Collectables collectables67 = new Collectables(world,16675+65+65+65+65+65+65f,225+65+65+65+65+65+65f);
        collectablesArrayList.add(collectables67);

        Collectables collectables68 = new Collectables(world,17375f,612f);
        collectablesArrayList.add(collectables68);
        Collectables collectables69 = new Collectables(world,17375f+65f,612-65f);
        collectablesArrayList.add(collectables69);
        Collectables collectables70 = new Collectables(world,17375f+65+65f,612-65-65f);
        collectablesArrayList.add(collectables70);
        Collectables collectables71 = new Collectables(world,17375f+65+65+65f,612-65-65-65f);
        collectablesArrayList.add(collectables71);
        Collectables collectables72 = new Collectables(world,17375f+65+65+65+65f,612-65-65-65-65f);
        collectablesArrayList.add(collectables72);
        Collectables collectables73 = new Collectables(world,17375f+65+65+65+65+65f,612-65-65-65-65-65f);
        collectablesArrayList.add(collectables73);
        Collectables collectables74 = new Collectables(world,17375f+65+65+65+65+65+65f,612-65-65-65-65-65-65f);
        collectablesArrayList.add(collectables74);



        Collectables collectables75 = new Collectables(world,17925f,675f);
        collectablesArrayList.add(collectables75);
        Collectables collectables76 = new Collectables(world,18183f,612f);
        collectablesArrayList.add(collectables76);
        Collectables collectables77 = new Collectables(world,18237f,417f);
        collectablesArrayList.add(collectables77);
        Collectables collectables78 = new Collectables(world,18435f,549f);
        collectablesArrayList.add(collectables78);
        Collectables collectables79 = new Collectables(world,18564f,416f);
        collectablesArrayList.add(collectables79);
        Collectables collectables80 = new Collectables(world,18693f,675f);
        collectablesArrayList.add(collectables80);
        Collectables collectables81 = new Collectables(world,18822f,483f);
        collectablesArrayList.add(collectables81);

        Collectables collectables82 = new Collectables(world,19104f,357f);
        collectablesArrayList.add(collectables82);
        Collectables collectables83 = new Collectables(world,19548f,357f);
        collectablesArrayList.add(collectables83);
        Collectables collectables84 = new Collectables(world,19326f,420f);
        collectablesArrayList.add(collectables84);
        Collectables collectables85 = new Collectables(world,19680f,291f);
        collectablesArrayList.add(collectables85);
        Collectables collectables86 = new Collectables(world,19935f,235f);
        collectablesArrayList.add(collectables86);

        Collectables collectables87 = new Collectables(world,21027f,100f);
        collectablesArrayList.add(collectables87);
        Collectables collectables88 = new Collectables(world,21027+65f,100f);
        collectablesArrayList.add(collectables88);
        Collectables collectables89 = new Collectables(world,21027+65+65f,100f);
        collectablesArrayList.add(collectables89);
        Collectables collectables90 = new Collectables(world,21027f+65+65+65,100f);
        collectablesArrayList.add(collectables90);
        Collectables collectables91 = new Collectables(world,21027+65+65+65+65f,100f);
        collectablesArrayList.add(collectables91);

        Collectables collectables92 = new Collectables(world,21600f,100f);
        collectablesArrayList.add(collectables92);
        Collectables collectables93 = new Collectables(world,21600+65f,100f);
        collectablesArrayList.add(collectables93);
        Collectables collectables94 = new Collectables(world,21600+65+65f,100f);
        collectablesArrayList.add(collectables94);
        Collectables collectables95 = new Collectables(world,21600f+65+65+65,100f);
        collectablesArrayList.add(collectables95);

        Collectables collectables96 = new Collectables(world,23586f,100f);
        collectablesArrayList.add(collectables96);
        Collectables collectables97 = new Collectables(world,23586+65f,100f);
        collectablesArrayList.add(collectables97);
        Collectables collectables98 = new Collectables(world,23586+65+65f,100f);
        collectablesArrayList.add(collectables98);

        Collectables collectables99 = new Collectables(world,24150f,100f);
        collectablesArrayList.add(collectables99);
        Collectables collectables100 = new Collectables(world,24150+65f,100f);
        collectablesArrayList.add(collectables100);
        Collectables collectables101 = new Collectables(world,24150+65+65f,100f);
        collectablesArrayList.add(collectables101);
        Collectables collectables102 = new Collectables(world,24150+65f,100f);
        collectablesArrayList.add(collectables102);
        Collectables collectables103 = new Collectables(world,24150+65+65f,100f);
        collectablesArrayList.add(collectables103);

        Collectables collectables104 = new Collectables(world,24670f,100f);
        collectablesArrayList.add(collectables104);
        Collectables collectables105 = new Collectables(world,24670+65f,100+65f);
        collectablesArrayList.add(collectables105);
        Collectables collectables106 = new Collectables(world,24670+65+65f,100+65+65f);
        collectablesArrayList.add(collectables106);

        Collectables collectables107 = new Collectables(world,21280f,618f);
        collectablesArrayList.add(collectables107);
        Collectables collectables108 = new Collectables(world,21280+65f,618f);
        collectablesArrayList.add(collectables108);
        Collectables collectables109 = new Collectables(world,21280+65+65f,618f);
        collectablesArrayList.add(collectables109);

        Collectables collectables110 = new Collectables(world,22420f,618f);
        collectablesArrayList.add(collectables110);
        Collectables collectables111 = new Collectables(world,22420+65f,618f);
        collectablesArrayList.add(collectables111);
        Collectables collectables112 = new Collectables(world,22420+65+65f,618f);
        collectablesArrayList.add(collectables112);

        Collectables collectables113 = new Collectables(world,22755f,618f);
        collectablesArrayList.add(collectables113);
        Collectables collectables114 = new Collectables(world,22755+65f,618f);
        collectablesArrayList.add(collectables114);
        Collectables collectables115 = new Collectables(world,22755+65+65f,618f);
        collectablesArrayList.add(collectables115);
        Collectables collectables116 = new Collectables(world,22755+65+65+65f,618f);
        collectablesArrayList.add(collectables116);
        Collectables collectables117 = new Collectables(world,22755+65+65+65+65f,618f);
        collectablesArrayList.add(collectables117);

        Collectables collectables118 = new Collectables(world,24162f,618f);
        collectablesArrayList.add(collectables118);
        Collectables collectables119 = new Collectables(world,24162+65f,618f);
        collectablesArrayList.add(collectables119);
        Collectables collectables120 = new Collectables(world,24162+65+65f,618f);
        collectablesArrayList.add(collectables120);

        Collectables collectables121 = new Collectables(world,21924f,350f);
        collectablesArrayList.add(collectables121);
        Collectables collectables122 = new Collectables(world,21924+65f,350f);
        collectablesArrayList.add(collectables122);
        Collectables collectables123 = new Collectables(world,21924+65+65f,350f);
        collectablesArrayList.add(collectables123);

        Collectables collectables124 = new Collectables(world,24100f,350f);
        collectablesArrayList.add(collectables124);
        Collectables collectables125 = new Collectables(world,24100+65f,350f);
        collectablesArrayList.add(collectables125);
        Collectables collectables126 = new Collectables(world,24100+65+65f,350f);
        collectablesArrayList.add(collectables126);

        Collectables collectables127 = new Collectables(world,24600f,612f);
        collectablesArrayList.add(collectables127);
        Collectables collectables128 = new Collectables(world,24600f,612-65f);
        collectablesArrayList.add(collectables128);
        Collectables collectables129 = new Collectables(world,24600f,612-65-65f);
        collectablesArrayList.add(collectables129);
    }

    public void DrawCollectables (SpriteBatch batch){
        for (Collectables c : collectablesArrayList){
            c.update();
            batch.draw(c, c.getX(),c.getY(),c.getWidth(),c.getHeight());
        }
    }

    public void DeleteCollectables(){
        for (int i = 0; i < collectablesArrayList.size(); i++){
            if (collectablesArrayList.get(i).getFixture().getUserData() == "Remove"){
                collectablesArrayList.get(i).changeFilter();
                collectablesArrayList.get(i).getTexture().dispose();
                collectablesArrayList.remove(i);
            }
        }

    }
}
