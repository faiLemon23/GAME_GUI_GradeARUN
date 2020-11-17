package gradearun;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author USER
 */
public class ObjectF {


    public int getDx() {
        return dx;
    }


    public void setDx(int dx) {
        this.dx = dx;
    }

    private int x;
    private int y;
    private int dx;
    private final int WIDTH = 30;
    private final int HIGTH = 40;
    Player player;
    BufferedImage image;
    private boolean GameOver;

    ObjectF(int x, int y, int Level, Player p) throws IOException {

        this.GameOver = false;
        this.x = x;
        this.y = y;
        this.dx = -Level;
        this.player = p;
        this.image = ImageIO.read(new File(".\\src\\resources\\unnamed.png"));
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.red);

        g2d.drawImage(image, getX(), getY(), 30, 40, null);
        g2d.drawLine(getX(), getY(), getX() + 30, getY());
        g2d.drawLine(getX(), getY() + 35, getX() + 30, getY() + 35);
        g2d.drawLine(getX(), getY(), getX(), getY() + 35);
        g2d.drawLine(getX() + 30, getY(), getX() + 30, getY() + 35);
           try {
                Thread.sleep(5);
            } catch (InterruptedException bug) {
                Thread.currentThread().interrupt();
                System.out.println(bug);
            }
    }

    public void hit() {

        if (player.getX() + 33 >= this.getX() && player.getX() + 33 <= this.getX() + 30 && player.jump == false) {
            player.dead = true;
//            System.out.println("Dead loop_1");

        }
        if (player.getX() + 33 >= this.getX() && player.getX() + 33 <= this.getX() + 30 && player.getY() + 50 >= this.getY() && player.jump) {
            player.dead = true;
//            System.out.println("Dead_Loop_2");
        }
        if (player.getX() >= this.getX() && player.getX() <= this.getX() + 30 && player.getY() + 50 >= this.getY() && player.falling) {
            player.dead = true;
//            System.out.println("Dead_Loop_3");
        }

    }

    public void move() {

        if (player.dead) {
            setDx(0);
            player.setYspeed(0);
//            System.out.println("Player is dead");
        } else {

            if (getX() > -50) {
                this.setX(this.getX() + getDx());
            } else {
                this.setX(500);

            }
        }

    }

    public void update() {
        move();
        hit();
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

}
