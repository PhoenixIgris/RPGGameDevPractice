package com.company.igris.items;

import com.company.igris.Handler;
import com.company.igris.grfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Items {
    // Handler

    public static Items[] items = new Items[256];
    public static Items woodItem = new Items(Assets.wood, "Wood", 0);
    public static Items rockItem = new Items(Assets.rock, "Rock", 1);

    // Class

    public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32, PICKED_UP = -1;

    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id;
protected  Rectangle bounds;
    protected int x, y, count;

    public Items(BufferedImage texture, String name, int id){
        this.texture = texture;
        this.name = name;
        this.id = id;
        count = 1;
bounds= new Rectangle(x,y,ITEMWIDTH,ITEMHEIGHT);
        items[id] = this;
    }

    public void tick(){
if(handler.getWorld().getEntityManager().getPlayer().getCollisionBound(0f,0f).intersects(bounds)){
    count=PICKED_UP;
}
    }

    public void render(Graphics2D g2){
        if(handler == null)
            return;
        render(g2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
    }

    public void render(Graphics2D g2, int x, int y){
        g2.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
    }

    public Items createNew(int x, int y){
        Items i = new Items(texture, name, id);
        i.setPosition(x, y);
        return i;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
        bounds.x=x;
        bounds.y=y;
    }

    // Getters and Setters

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }



}
