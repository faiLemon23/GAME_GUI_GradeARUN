package gradearun;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.*;

/**
 *
 * @author USER
 */
public class Player implements KeyListener {

    public void setYspeed(int yspeed) {
        this.yspeed = yspeed;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }
    private int m;
    private int x;
    private int y;
    private int yspeed;
    private int counter;
    private int counter2;
    boolean dead = false;
    boolean jump = false;
    boolean falling = false;

    BufferedImage image[] = new BufferedImage[22];

    Player(int x, int y) throws IOException {

        this.yspeed = 10;
        this.x = x;
        this.y = y;

        this.image[1] = ImageIO.read(new File(".\\src\\resources\\Run__000.png"));
        this.image[2] = ImageIO.read(new File(".\\src\\resources\\Run__001.png"));
        this.image[3] = ImageIO.read(new File(".\\src\\resources\\Run__002.png"));
        this.image[4] = ImageIO.read(new File(".\\src\\resources\\Run__003.png"));
        this.image[5] = ImageIO.read(new File(".\\src\\resources\\Run__004.png"));
        this.image[6] = ImageIO.read(new File(".\\src\\resources\\Run__005.png"));
        this.image[7] = ImageIO.read(new File(".\\src\\resources\\Run__006.png"));
        this.image[8] = ImageIO.read(new File(".\\src\\resources\\Run__007.png"));
        this.image[9] = ImageIO.read(new File(".\\src\\resources\\Run__008.png"));
        this.image[10] = ImageIO.read(new File(".\\src\\resources\\Run__009.png"));

        this.image[11] = ImageIO.read(new File(".\\src\\resources\\Jump__000.png"));
        this.image[12] = ImageIO.read(new File(".\\src\\resources\\Jump__001.png"));
        this.image[13] = ImageIO.read(new File(".\\src\\resources\\Jump__002.png"));
        this.image[14] = ImageIO.read(new File(".\\src\\resources\\Jump__003.png"));
        this.image[15] = ImageIO.read(new File(".\\src\\resources\\Jump__004.png"));
        this.image[16] = ImageIO.read(new File(".\\src\\resources\\Jump__005.png"));
        this.image[17] = ImageIO.read(new File(".\\src\\resources\\Jump__006.png"));
        this.image[18] = ImageIO.read(new File(".\\src\\resources\\Jump__007.png"));
        this.image[19] = ImageIO.read(new File(".\\src\\resources\\Jump__008.png"));
        this.image[20] = ImageIO.read(new File(".\\src\\resources\\Jump__009.png"));
        this.image[21] = ImageIO.read(new File(".\\src\\resources\\Dead__007.png"));
    }

    public void run() {

        counter++;
        System.out.println("count: "+counter);
        if (counter >= 22) {
            counter = 0;
            System.out.println("true");
        }
        switch (counter) {

            case 2:

                m = 1;
                break;

            case 4:

                m = 2;
                break;
            case 6:

                m = 3;
                break;
            case 8:

                m = 4;
                break;
            case 10:

                m = 5;
                break;
            case 12:

                m = 6;
                break;
            case 14:

                m = 7;
                break;
            case 16:

                m = 8;
                break;
            case 18:

                m = 9;
                break;
            case 20:

                m = 10;
                break;
        }

    }

    public void update() {

        if (jump) {
            jump1();
        } else {
            run();
        }

    }

    public void drawP(Graphics2D g2d) {
        if (dead == true) {
            m = 21;
        }
        g2d.drawImage(image[m], getX(), getY(), 33, 50, null);
        g2d.setColor(Color.WHITE);

        //scale
        g2d.drawLine(getX(), getY(), getX() + 33, getY());
        g2d.drawLine(getX(), getY() + 50, getX() + 33, getY() + 50);
        g2d.drawLine(getX(), getY(), getX(), getY() + 50);
        g2d.drawLine(getX() + 33, getY(), getX() + 33, getY() + 50);
        //scale
        try {
            Thread.sleep(1);
        } catch (InterruptedException bug) {
            Thread.currentThread().interrupt();
            System.out.println(bug);
        }
    }

    public void jump1() {
        counter2++;

        if (counter2 >= 22) {
            counter2 = 0;
        }
        switch (counter2) {

            case 2: {

            }
            m = 11;
            break;

            case 4:

                m = 12;
                break;
            case 6:

                m = 13;
                break;
            case 8:

                m = 14;
                break;
            case 10:

                m = 15;
                break;
            case 12:

                m = 16;
                break;
            case 14:

                m = 17;
                break;
            case 16:

                m = 18;
                break;
            case 18:

                m = 19;
                break;
            case 20:

                m = 20;
                break;
        }
        if (falling && getY() >= 240) {
            falling = false;
            jump = false;
            setYspeed(10);

        }
        if (getY() <= 100) {
            falling = true;

        }

        if (jump) {
            y = getY() - yspeed;
            if (getY() < 100 || getY() > 240) {
                setYspeed(yspeed * -1);
            }
        }
        if (yspeed == -10) {
            setYspeed(yspeed - 2);

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            jump = true;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
