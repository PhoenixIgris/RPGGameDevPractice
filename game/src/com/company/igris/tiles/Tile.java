package com.company.igris.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    //STATIC STUFF HERE
    public static Tile[] tiles=new Tile[256];
    public static Tile grasstile=new GrassTile(0);
    public static Tile dirttile=new DirtTile(1);
    public static Tile rocktile=new RockTile(2);


    //CLASS
public static final int TILE_WIDTH= 70, TITLE_HEIGHT=70;
    protected BufferedImage texture;
    protected  final int id;
//CONSTRUCTOR
    public Tile(BufferedImage texture,int id){
        this.texture=texture;
        this.id=id;
   tiles[id]=this;


    }

    public void tick(){

    }
    public void render(Graphics2D g2, int x, int y){

        g2.drawImage(texture,x,y,TILE_WIDTH,TITLE_HEIGHT,null);
    }
    public boolean isSolid(){

        return false;
    }
    public  int getId(){

        return id;
    }
}
