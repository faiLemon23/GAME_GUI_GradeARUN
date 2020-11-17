package gradearun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Game extends JPanel implements ActionListener {
//  total Game
    Player player;
    Map map;
    Timer loop;
    ObjectF objectF;
    ObjectF objectF2;
    ObjectA objectA[] = new ObjectA[10];
    int score;
    int Level = 5;
    StartGame stg;
  
    Game() throws IOException {

        System.out.println("done");

        loop = new Timer(1, this);
        loop.start();

        player = new Player(50, 240);
        objectF = new ObjectF(330, 260, Level, player); // x // y // level
        objectF2 = new ObjectF(530, 260, Level, player);
        objectA[0] = new ObjectA(120, 230, Level, player,objectF,objectF2);
        map = new Map(objectA[0]);
        addMouseListener(objectA[0]);
        addMouseMotionListener(objectA[0]);
        addKeyListener(player);
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        map.drawP(g2d);
        player.drawP(g2d);
        objectF.draw(g2d);
        objectF2.draw(g2d);
        objectA[0].draw(g2d);
        
        g2d.setColor(Color.black);
        Font myFont = new Font("Courier New", 1, 17);
        g2d.setFont(myFont);
        g2d.drawString("Score : " + score, 10, 15);
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LevelChapter();
        player.update();
        map.update();
        objectA[0].update();
//
        objectF.update();
        objectF2.update();

        repaint();

    }

    public void LevelChapter() {
        score = objectA[0].score;

        if (score >= 9) {
            Level = 50;
        }

    }

}
