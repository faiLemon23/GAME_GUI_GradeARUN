package gradearun;

import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Map {

    BufferedImage background[] = new BufferedImage[7];

    private int x1 = 0;
    private int x2 = 548;
    private int d = 1;
    private int d2 = 1;
    int sp = 1;

    ObjectA thisscore;

    Map(ObjectA score) throws IOException {
        this.thisscore = score;

        //bg 0-8
        this.background[1] = ImageIO.read(new File(".\\src\\resources\\background.png"));
        this.background[2] = ImageIO.read(new File(".\\src\\resources\\background.png"));
        //bg 9 - 26
        this.background[3] = ImageIO.read(new File(".\\src\\resources\\bgNight.png"));
        this.background[4] = ImageIO.read(new File(".\\src\\resources\\bgNight.png"));

        //27-45
        this.background[5] = ImageIO.read(new File(".\\src\\resources\\4U.png"));
        this.background[6] = ImageIO.read(new File(".\\src\\resources\\4U.png"));
    }

    public void update() {

        if (x1 < -548) {
            x1 = 548;
        }
        if (x1 > 0) {
            d = -1;
        }
        if (d == -1) {
            x1 -= sp;
        } else {
            x1 += sp;
        }

        if (x2 < -548) {
            x2 = 548;
        }
        if (x2 < 0) {
            d2 = -1;
        }
        if (d == -1) {
            x2 -= sp;
        } else {
            x2 += sp;
        }

    }

    public void drawP(Graphics2D g2d) {
        System.out.println(thisscore.score);

        if (thisscore.score >= 0 && thisscore.score < 9) {
            g2d.drawImage(background[1], x1, 0, 550, 300, null);
            g2d.drawImage(background[2], x2, 0, 550, 300, null);
        }
        if (thisscore.score >= 9 && thisscore.score < 27) {

            g2d.drawImage(background[3], x1, 0, 550, 350, null);
            g2d.drawImage(background[4], x2, 0, 550, 350, null);
        }
        if (thisscore.score >= 27 && thisscore.score < 46) {

            g2d.drawImage(background[5], x1, 0, 550, 350, null);
            g2d.drawImage(background[6], x2, 0, 550, 350, null);
        }
     try {
                Thread.sleep(1);
            } catch (InterruptedException bug) {
                Thread.currentThread().interrupt();
                System.out.println(bug);
            }
    }
}
