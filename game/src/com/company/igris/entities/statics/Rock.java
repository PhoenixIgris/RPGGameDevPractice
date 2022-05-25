package com.company.igris.entities.statics;

import com.company.igris.Handler;
import com.company.igris.grfx.Assets;
import com.company.igris.items.Items;
import com.company.igris.tiles.Tile;

import java.awt.*;

public class Rock extends StaticEntity{
    public Rock(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TITLE_HEIGHT);
        bounds.x=3;
        bounds.y=(int) (height/2f);
        bounds.width=width-6;
        bounds.height=(int) (height- height/2f);

    }
    @Override
    public void tick() {

    }


    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(Assets.rock,(int) (x-handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()),width,height,null);

    }

    @Override
    public void die() {
        handler.getWorld().getItemManager().addItem(Items.rockItem.createNew((int)x,(int)y));
    }
}
