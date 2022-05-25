package com.company.igris.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private  boolean[] keys;
    public boolean up, down, left,right;
    public boolean aUp, aDown, aLeft,aRight;
    public KeyManager(){
        keys= new boolean[256];

    }
    public void tick(){
        aUp = keys[KeyEvent.VK_W];
        aDown = keys[KeyEvent.VK_S];
        aLeft = keys[KeyEvent.VK_A];
        aLeft = keys[KeyEvent.VK_D];

        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode()<0 || keyEvent.getKeyCode()>=keys.length){
return;        }
        keys[keyEvent.getKeyCode()]=true;
        System.out.println("presseds");
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode()<0 || keyEvent.getKeyCode()>=keys.length){
            return;        }
        keys[keyEvent.getKeyCode()]=false;
    }
}
