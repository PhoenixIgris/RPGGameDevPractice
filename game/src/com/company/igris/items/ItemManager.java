package com.company.igris.items;


    import com.company.igris.Handler;

    import java.awt.*;
    import java.util.ArrayList;
import java.util.Iterator;

    public class ItemManager {

        private Handler handler;
        private ArrayList<Items> items;

        public ItemManager(Handler handler){
            this.handler = handler;
            items = new ArrayList<Items>();
        }

        public void tick(){
            Iterator<Items> it = items.iterator();
            while(it.hasNext()){
                Items i = it.next();
                i.tick();
                if(i.getCount() == Items.PICKED_UP)
                    it.remove();
            }
        }

        public void render(Graphics2D g){
            for(Items i : items)
                i.render(g);
        }

        public void addItem(Items i){
            i.setHandler(handler);
            items.add(i);
        }

        // Getters and Setters

        public Handler getHandler() {
            return handler;
        }

        public void setHandler(Handler handler) {
            this.handler = handler;
        }

    }

