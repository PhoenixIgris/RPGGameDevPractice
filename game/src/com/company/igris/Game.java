package com.company.igris;

import com.company.igris.display.Display;
import com.company.igris.grfx.Assets;
import com.company.igris.grfx.GameCamera;
import com.company.igris.grfx.ImageLoader;
import com.company.igris.grfx.SpriteSheet;
import com.company.igris.input.KeyManager;
import com.company.igris.input.MouseManager;
import com.company.igris.states.GameState;
import com.company.igris.states.MenuState;
import com.company.igris.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

public class Game implements Runnable{
    private Display display;
    private int width, height;

    private  Thread thread;
    private boolean running=false;

    public String title;
    private BufferStrategy bs;
    private Graphics2D g2;

    //States
    public State gameState;
    public State menuState;

    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;
// Camera
    private GameCamera gameCamera;
    //handler
    private Handler handler;

    public Game(String title, int width, int height){
        this.width=width;
        this.height=height;
        this.title=title;
        keyManager = new KeyManager();
        mouseManager= new MouseManager();

    }
    public synchronized  void start(){
        if (running)
            return;
        running=true;
        thread =new Thread(this);
        thread.start();

    }
    public synchronized void stop(){
        if (!running)
            return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
private void init(){
        display= new Display(title, width,height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
    display.getFrame().addMouseMotionListener(mouseManager);
    display.getCanvas().addMouseListener(mouseManager);
    display.getCanvas().addMouseMotionListener(mouseManager);
    Assets.init();

    handler=new Handler(this);
    gameCamera =new GameCamera(handler,0,0);

    gameState =new  GameState(handler);

    menuState =new MenuState(handler);
    State.setState(menuState);


}
   private void render(){
        bs= display.getCanvas().getBufferStrategy();
        if(bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g2= (Graphics2D) bs.getDrawGraphics();
       //Clear Screen
       g2.clearRect(0,0,width,height);
        // draw here
       if (State.getState() != null){
           State.getState().render(g2);
       }
       //end drawing!
       bs.show();
       g2.dispose();

    }
    int x=0;
    private void  tick(){
keyManager.tick();
        if (State.getState() != null){
            State.getState().tick();
        }
    }

    @Override
    public void run() {
         init();

        int fps=60;//fps=frames per second or ticks per second
        double timePerTick=1000000000/fps;
        double delta =0;
        long now;
        long lastTime=System.nanoTime();
        long timer =0;
        int ticks=0;



        while (running){
            now=System.nanoTime();
            delta+=(now -lastTime)/timePerTick;
            timer += now - lastTime;
            lastTime=now;
            if (delta>=1) {
                tick();
                render();
                ticks++;
                delta--;

            }
            if (timer>=1000000000) {
                System.out.println("ticks"+ticks);
                ticks=0;
                timer=0;

            }
        }
        stop();
    }
    public KeyManager getKeyManager(){
        return keyManager;
    }
    public MouseManager getMouseManager(){
        return mouseManager;
    }

    public int getWidth() {
        return width;
    }



    public int getHeight() {
        return height;
    }



    public GameCamera getGameCamera(){
        return gameCamera;
    }
}
