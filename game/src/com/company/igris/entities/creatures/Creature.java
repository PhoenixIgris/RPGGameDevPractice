package com.company.igris.entities.creatures;

import com.company.igris.Handler;
import com.company.igris.entities.Entity;
import com.company.igris.tiles.Tile;

public abstract class Creature extends Entity {

    protected float speed;
    protected float xMove, yMove;


    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64;
    public static final int DEFAULT_CREATURE_HEIGHT = 64;


    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);

        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;


    }

    public void move() {
        if (!checkEntityCollision(xMove, 0f)) {
            moveX();
        }
        if (!checkEntityCollision(0f, yMove)) {
            moveY();
        }

    }

    public void moveX() {
        if (xMove > 0) {//move right
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            if (((!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TITLE_HEIGHT))) && (!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TITLE_HEIGHT))) {
                x += xMove;
            } else {
                x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
            }
        } else if (xMove < 0) {//move left
            int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
            if (((!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TITLE_HEIGHT))) && (!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TITLE_HEIGHT))) {
                x += xMove;
            } else {
                x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
            }
        }
    }

    public void moveY() {
        if (yMove < 0) {//move right
            int ty = (int) (y + yMove + bounds.y) / Tile.TITLE_HEIGHT;
            if (((!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty))) && (!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty))) {
                y += yMove;
            } else {
                y = ty * Tile.TITLE_HEIGHT + Tile.TITLE_HEIGHT - bounds.y;
            }
        } else if (yMove > 0) {//move left
            int ty = (int) (y + yMove + bounds.x + bounds.height) / Tile.TITLE_HEIGHT;
            if (((!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty))) &&
                    (!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty))) {
                y += yMove;
            } else {
                y = ty * Tile.TITLE_HEIGHT - bounds.y - bounds.height - 1;
            }

        }
    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }


    ///getter aand setters

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }


}
