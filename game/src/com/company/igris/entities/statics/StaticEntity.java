package com.company.igris.entities.statics;

import com.company.igris.Handler;
import com.company.igris.entities.Entity;

public abstract class StaticEntity extends Entity {
    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

}
