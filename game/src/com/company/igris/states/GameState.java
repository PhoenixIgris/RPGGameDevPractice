package com.company.igris.states;

import com.company.igris.Handler;
import com.company.igris.worlds.World;

import java.awt.*;

public class GameState extends State {


    private World world;



    public GameState(Handler handler){
        super(handler);
        world= new  World(handler,"game/res/worlds/world1");
        handler.setWorld(world);


//handler.getGameCamera().move(0,0);
    }
    @Override
    public void tick() {
        world.tick();




    }

    @Override
    public void render(Graphics2D g2) {
        world.render(g2);


    }
}
