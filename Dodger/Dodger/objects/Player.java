package objects;

import core.Handler;

import java.awt.*;

import static Game.DodgerGame.WIDTH;


/**
 * Created by Dany on 28.07.2017.
 */
public class Player extends GameObject{
    private Handler handler;
    private int width;
    private int height;
    public static int lifes = 5;
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        this.handler = handler;
        width = 30;
        height = 30;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(this.x,this.y,width,height);

    }

    @Override
    public void tick() {
    x +=xSpeed;
    collision();
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = this.handler.objects.get(i);
            if (tempObj.getID() == ID.Enemy && tempObj.getBounds().intersects(new Rectangle(this.getX(), this.getY(), this.width, this.height).getBounds())) {
                handler.removeObject(tempObj);
                lifes--;
            }
        }

        if (x >= WIDTH-width) x-=xSpeed;
        if (x <= 0) x=0;
        }


    @Override
    public Rectangle getBounds() {
        return new Rectangle(this.x,this.y,this.width,this.height);
    }
}
