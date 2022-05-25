package com.company.igris.entities.statics;

import com.company.igris.Handler;
import com.company.igris.grfx.Assets;
import com.company.igris.items.Items;
import com.company.igris.tiles.Tile;

import java.awt.*;

public class Tree extends StaticEntity {
    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TITLE_HEIGHT*2);
        bounds.x=0;
        bounds.y=0;
        bounds.width=32;
        bounds.height=32;

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(Assets.tree,(int) (x-handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()),width,height,null);

    }

    @Override
    public void die() {
handler.getWorld().getItemManager().addItem(Items.woodItem.createNew((int)x,(int)y));
    }
}
