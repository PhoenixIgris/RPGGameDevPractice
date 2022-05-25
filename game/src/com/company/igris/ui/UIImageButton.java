package com.company.igris.ui;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject{

    private BufferedImage[] images;
    private ClickListener clicker;
    public UIImageButton(float x, float y, int width, int height,BufferedImage[] images,ClickListener clicker) {
        super(x, y, width, height);
        this.images=images;
        this.clicker=clicker;

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics2D g2) {
        if(hovering){
            g2.drawImage(images[1],(int) x,(int) y,width,height,null);
        }else {
            g2.drawImage(images[0], (int) x, (int) y, width, height, null);
        }
    }

    @Override
    public void onClick() {
        clicker.onClick();;


    }
}
