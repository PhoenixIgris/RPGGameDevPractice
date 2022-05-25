package com.company.igris;

import com.company.igris.grfx.GameCamera;
import com.company.igris.input.KeyManager;
import com.company.igris.input.MouseManager;
import com.company.igris.worlds.World;

public class Handler {
     private Game game;
     private World world;

     public Handler(Game game){
         this.game=game;
     }

    public Game getGame() {
        return game;
    }
    public GameCamera getGameCamera(){
         return  game.getGameCamera();

    }
    public KeyManager getKeyManager(){
         return game.getKeyManager();
    }
    public int getWidth(){
         return game.getWidth();
    }
    public int getHeight(){
         return game.getHeight();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
    public MouseManager getMouseManager(){
         return game.getMouseManager();
    }
}
