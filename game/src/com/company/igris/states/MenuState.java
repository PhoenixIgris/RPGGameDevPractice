package com.company.igris.states;

import com.company.igris.Game;
import com.company.igris.Handler;
import com.company.igris.grfx.Assets;
import com.company.igris.ui.ClickListener;
import com.company.igris.ui.UIImageButton;
import com.company.igris.ui.UIManager;

import java.awt.*;

public class MenuState extends State {
private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager=new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));

    }

    @Override
    public void tick() {
uiManager.tick();

    }

    @Override
    public void render(Graphics2D g2) {
uiManager.render(g2);
    }
}
