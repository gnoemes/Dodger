package Game;
import control.KeyInput;
import core.*;
import core.Window;
import objects.Enemy;
import objects.ID;
import objects.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

import static objects.Enemy.score;
import static objects.Player.lifes;

/**
 * Created by Dany on 28.07.2017.
 */
public class DodgerGame extends  Canvas implements Runnable {
    public static final int WIDTH = 480;
    public static final int HEIGHT = 720;
    private Thread thread;
    private boolean running = false;
    private Handler handler = new Handler();
    private Random rnd = new Random();
    private String scorePoints = "0";
    private String lifePoints = "5";
    public static boolean isAlive = true;;


    public DodgerGame(String name) {
        new Window(name, WIDTH, HEIGHT, this);
        handler.addObject(new Player(WIDTH/2,HEIGHT - (HEIGHT/8), ID.Player,handler));
        addKeyListener(new KeyInput(this.handler));
    }

    @Override
    public void run() {
    requestFocus();
    long lastTime = System.nanoTime();
    double amountOfTicks = 60.0D;
    double ns = 1.0E9D / amountOfTicks;
    double delta = 0.0D;
    long timer = System.currentTimeMillis();
    int frames = 0;
    int updates = 0;
        while (running) {
            scorePoints = String.valueOf(score);
            lifePoints = String.valueOf(lifes);
            if (lifes == 0) isAlive = false;
             long timeNow = System.nanoTime();
             delta+=(timeNow - lastTime) / ns ;
            delta += (double)(timeNow - lastTime) / ns;
            if (isAlive)
            for(lastTime = timeNow; delta >= 1.0D; --delta) {
                this.tick();
            }
            if (running)
                render();
            int r = rnd.nextInt(1000)+350;
            if (isAlive)
            if (System.currentTimeMillis() - timer >= r){
                int spawnCount = rnd.nextInt(4)+1;
                for (int i = 0; i < spawnCount; i++) {
                    int a = rnd.nextInt(40)+1;
                    handler.addObject(new Enemy(rnd.nextInt(WIDTH - 10),0, a, a,(rnd.nextInt(3)+2),ID.Enemy,handler));
                }

                timer+=r;
            }


    }

    }

    private void tick() {
        this.handler.tick();
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null)
            createBufferStrategy(3);
        else {
            Graphics g = bs.getDrawGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, WIDTH,HEIGHT);


            g.setColor(Color.white);
            g.drawString("SCORE:",1,HEIGHT - (HEIGHT/8) + 55 );
            g.drawString("LIFES:", WIDTH - 70,HEIGHT - (HEIGHT/8) + 55  );
            g.drawString(scorePoints,50,HEIGHT - (HEIGHT/8) + 55 );
            g.drawString(lifePoints,WIDTH - 30,HEIGHT - (HEIGHT/8) + 55 );
            if (!isAlive) {
                g.setColor(Color.gray);
                g.fillRect(150,330,160,50);
                g.setColor(Color.white);
                g.drawString("YOU LOSE", WIDTH / 2 - 40, HEIGHT / 2);
//                g.drawString("PRESS R TO RESTART", WIDTH / 2 - 75, HEIGHT / 2 + 20);
            }
            this.handler.render(g);

            g.dispose();
            bs.show();
        }

    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public void stop() {
       try {
           thread.join();
           running = false;
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       thread = new Thread(this);
       thread.start();
    }





    public static void main(String[] args) {
    new DodgerGame("Dodger");
    }
}
