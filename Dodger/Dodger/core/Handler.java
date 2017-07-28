package core;




import objects.GameObject;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dany on 28.07.2017.
 */
public class Handler {
    public List<GameObject> objects = new LinkedList();
    public Handler(){}


    public void tick() {
        for(int i = 0; i < this.objects.size(); ++i) {
            GameObject tempObj = this.objects.get(i);
            tempObj.tick();
        }
    }
    public void render(Graphics g) {

        for(int i = 0; i < this.objects.size(); ++i) {
            GameObject tempObj = this.objects.get(i);
            tempObj.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }
}

