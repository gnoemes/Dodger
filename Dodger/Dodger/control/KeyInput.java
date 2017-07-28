package control;

import core.Handler;
import objects.GameObject;
import objects.ID;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Dany on 28.07.2017.
 */
public class KeyInput implements KeyListener {
    private Handler handler;

    public KeyInput(Handler handler) {this.handler = handler;}

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = this.handler.objects.get(i);
            if (tempObj.getID() == ID.Player) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {tempObj.setXSpeed(1 * 2);}
                if (e.getKeyCode() == KeyEvent.VK_LEFT ) {tempObj.setXSpeed(-1 * 1.2 );}

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = this.handler.objects.get(i);
            if (tempObj.getID() == ID.Player) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {tempObj.setXSpeed(0);}
                if (e.getKeyCode() == KeyEvent.VK_LEFT ) {tempObj.setXSpeed(0);}
            }
        }
    }
}
