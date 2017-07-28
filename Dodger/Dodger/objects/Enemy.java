package objects;

import core.Handler;

import java.awt.*;
import java.util.Random;

import static Game.DodgerGame.HEIGHT;
import static Game.DodgerGame.WIDTH;


public class Enemy extends GameObject {
    private Handler handler;
    private Random rnd = new Random();
    private int width;
    private int height;
    private int x, y;
    private double ySpeed;
    public static int score = 0;


    public Enemy(int x, int y,int width,int height,double ySpeed,ID id, Handler handler) {
        super(x, y, id, handler);
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.ySpeed = ySpeed;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
         g.fillRect(this.x,this.y,this.width,this.height);

         g.setColor(Color.white);
         g.drawRect(this.x,this.y,this.width,this.height);

         g.setColor(Color.RED);
         g.drawRect(1,HEIGHT - (HEIGHT/8) + 30,WIDTH,10);
    }

    @Override
    public void tick() {
    this.y+=ySpeed;
    avoided();

    }


    private  void avoided() {

        for (int i = 0; i < handler.objects.size(); i++) {
                GameObject tempObj = this.handler.objects.get(i);
                if (tempObj.getID() == ID.Enemy && tempObj.getBounds().intersects(new Rectangle(1,HEIGHT - (HEIGHT/8) + 30,WIDTH,10).getBounds())){
                    handler.removeObject(tempObj);
                    score++;
                }


        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }
}
