package gradearun;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StartGame extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    JFrame f;
    BufferedImage bg;
    int size = 36;
    int y = 0;
    Random r = new Random();
    int d = 1;
    int ran;
    BufferedImage image;

    public StartGame() throws IOException {
        this.image = ImageIO.read(new File(".\\src\\resources\\A.png"));
        bg = ImageIO.read(new File(".\\src\\resources\\4U.png"));
        addMouseListener(this);
        addMouseMotionListener(this);
        new Timer(100, this).start();
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        g.drawImage(bg, 0, 0, null);
        g.setFont(new Font("Anton", Font.BOLD, 40));
        g.setColor(Color.black);
        g.drawString("Grade A", 190, 112);
        if (ran % 4 == 0) {
            g.setColor(Color.yellow);
        } else if (ran % 4 == 1) {
            g.setColor(Color.orange);
        } else if (ran % 4 == 2) {
            g.setColor(Color.red);
        } else if (ran % 4 == 3) {
            g.setColor(Color.PINK);
        }
//            g.setColor(Color.red);
        g.drawString("Grade A", 195, 112);
        g.setFont(new Font("Anton", Font.BOLD, 36 - y));
        g.setColor(Color.black);
        g.drawString("Run!!!", 222 + y, 155 + y);
        if (y == 0) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.YELLOW);
        }
        g.drawString("Run!!!", 226 + y, 155 + y);
             try {
                Thread.sleep(10);
            } catch (InterruptedException bug) {
                Thread.currentThread().interrupt();
                System.out.println(bug);
            }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
            ran = r.nextInt(4) + 1;
            repaint();
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        System.out.println(e.getX()+","+e.getY());
        if ((e.getX() >= 212 && e.getX() <= 313) && (e.getY() >= 127 && e.getY() <= 153)) {
            try {
               
                f = new JFrame("Game running");
                f.setSize(550, 340);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                f.add(new Game());
                f.setLocationRelativeTo(null);
                f.setIconImage(image);
                 
            } catch (IOException ex) {
                Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if ((e.getX() >= 212 && e.getX() <= 313) && (e.getY() >= 127 && e.getY() <= 153)) {
            y = 4;
        } else {
            y = 0;
        }
        repaint();
    }

}
