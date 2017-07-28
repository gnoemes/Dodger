package core;


import Game.DodgerGame;
import javax.swing.*;

/**
 * Created by Dany on 28.07.2017.
 */
public class Window extends JPanel {
private JFrame frame;


    public Window(String name, int width, int height, DodgerGame dodgerGame) {
    frame = new JFrame(name);
    frame.setSize(width,height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.add(dodgerGame);
    frame.setVisible(true);
    dodgerGame.start();
    }
}
