package com.company.igris.worlds;

import com.company.igris.Handler;
import com.company.igris.entities.EntityManager;
import com.company.igris.entities.creatures.Player;
import com.company.igris.entities.statics.Rock;
import com.company.igris.entities.statics.Tree;
import com.company.igris.items.ItemManager;
import com.company.igris.tiles.Tile;
import com.company.igris.utils.Utils;

import java.awt.*;

public class World {
    private int width, height, spawnX, spawnY;
    private Handler handler;
    private int[][] tiles;

    //Entities
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

//Item
    private ItemManager itemManager;

    public World(Handler handler, String path) {
        this.handler = handler;
        entityManager=new EntityManager(handler,new Player(handler,100,100));
        itemManager=new ItemManager(handler);
        entityManager.addEntity(new Tree(handler,100,250));
        entityManager.addEntity(new Rock(handler,100,450));



        loadWorld(path);

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);

    }

    public void tick() {
        itemManager.tick();
        entityManager.tick();

    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void render(Graphics2D g2) {
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TITLE_HEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TITLE_HEIGHT + 1);
        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g2, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TITLE_HEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        //item
        itemManager.render(g2);
        //entities
        entityManager.render(g2);


    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.grasstile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null)
            return Tile.dirttile;
        return t;
    }

    private void loadWorld(String path) {
        String file = Utils.loadFIleAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
