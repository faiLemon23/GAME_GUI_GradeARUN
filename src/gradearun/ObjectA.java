package gradearun;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ObjectA extends JPanel implements MouseListener, MouseMotionListener {

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
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
    
    int d = 1;
    private int x;
    private int y;
    private int dx;
    private final int WIDTH = 20;
    int score;
    ObjectF f1;
    ObjectF f2;
    Player player;
    int positionX = 0;
    int positionY = 0;
    int size = 0;
    BufferedImage image;
    BufferedImage image1;
    private boolean GameOver;
    StartGame s;
    
    ObjectA(int x, int y, int Level, Player p, ObjectF F1, ObjectF F2) throws IOException {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.f1 = F1;
        this.f2 = F2;
        this.GameOver = false;
        this.x = x;
        this.y = y;
        this.dx = -Level;
        this.player = p;
        this.image1 = ImageIO.read(new File(".\\src\\resources\\Dead__007.png"));
        this.image = ImageIO.read(new File(".\\src\\resources\\A.png"));
    }
    
    public void draw(Graphics2D g2d) {
        if (player.dead) {
            
            Font myFont = new Font("Courier New", 1, 17);
            g2d.setFont(myFont);
            
            if (score < 9&&score > 0) {
                g2d.drawString("YOU DEAD", 240, 100);
                g2d.drawImage(image1, 230, 50, 99, 150, null);
                g2d.setColor(Color.white);
                g2d.drawString("YOUR GRADE IS [F]", 210, 220);
                g2d.setColor(Color.red);
                myFont = new Font("Courier New", 1, size+36);
                g2d.setFont(myFont);
                g2d.drawString("RESTART", positionX+195, positionY+63);
                
            } else if (score < 18&&score >= 9) {
                g2d.drawString("YOU DEAD", 240, 100);
                g2d.drawImage(image1, 230, 50, 99, 150, null);
                g2d.setColor(Color.white);
                g2d.drawString("YOUR GRADE IS [D]", 210, 220);
                myFont = new Font("Courier New", 1, size+36);
                g2d.setFont(myFont);
                g2d.drawString("RESTART", positionX+195, positionY+63);
            } else if (score < 27&& score >=18) {
                g2d.drawString("YOU DEAD", 240, 100);
                g2d.drawImage(image1, 230, 50, 99, 150, null);
                g2d.setColor(Color.white);
                g2d.drawString("YOUR GRADE IS [C]", 210, 220);
                myFont = new Font("Courier New", 1, size+36);
                g2d.setFont(myFont);
                g2d.drawString("RESTART", positionX+195, positionY+63);
            } else if (score < 36&&score >=27) {
                g2d.drawString("YOU DEAD", 240, 100);
                g2d.drawImage(image1, 230, 50, 99, 150, null);
                g2d.setColor(Color.white);
                g2d.drawString("YOUR GRADE IS [B]", 210, 220);
                myFont = new Font("Courier New", 1, size+36);
                g2d.setFont(myFont);
                g2d.drawString("RESTART", positionX+195, positionY+63);
            } else {
                g2d.drawString("YOU WIN", 240, 100);
                g2d.drawImage(image1, 230, 50, 99, 150, null);
                g2d.setColor(Color.yellow);
                g2d.drawString("YOUR GRADE IS [A]", 195, 220);
                myFont = new Font("Courier New", 1, size+36);
                g2d.setFont(myFont);
                g2d.drawString("RESTART", positionX+202, positionY+63);
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException bug) {
                Thread.currentThread().interrupt();
                System.out.println(bug);
            }
        }
        
        g2d.setColor(Color.yellow);
        
        g2d.drawImage(image, x, y, 20, 20, null);
        g2d.setColor(Color.white);
        
        g2d.drawLine(getX(), y, getX() + 20, y);
        g2d.drawLine(getX(), y + 20, getX() + 20, y + 20);
        g2d.drawLine(getX(), y, getX(), y + 20);
        g2d.drawLine(getX() + 20, y, getX() + 20, y + 20);
        
    }
    
    public void hit() {
        
        if (player.getX() + 33 >= this.getX() && player.getX() + 33 <= this.getX() + WIDTH && player.jump == false) {
            this.setX(550);
            System.out.println(++score);
            try {
                
                URL sound = null;
                
                try {
                    sound = new URL("http://codeskulptor-demos.commondatastorage.googleapis.com/GalaxyInvaders/pause.wav");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Clip clip = AudioSystem.getClip();
                AudioInputStream audioinput = null;
                try {
                    
                    audioinput = AudioSystem.getAudioInputStream(sound);
                    clip.open(audioinput);
                    
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                clip.loop(0);
                
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        if (player.getX() + 33 >= this.getX() && player.getX() + 33 <= this.getX() + WIDTH && player.getY() + 50 >= this.y && player.jump) {
            this.setX(550);
            System.out.println(++score);
            try {
                
                URL sound = null;
                
                try {
                    sound = new URL("http://codeskulptor-demos.commondatastorage.googleapis.com/GalaxyInvaders/pause.wav");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Clip clip = AudioSystem.getClip();
                AudioInputStream audioinput = null;
                try {
                    
                    audioinput = AudioSystem.getAudioInputStream(sound);
                    clip.open(audioinput);
                    
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                clip.loop(0);
                
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        if (player.getX() >= this.getX() && player.getX() <= this.getX() + WIDTH && player.getY() + 50 >= this.y && player.falling) {
            this.setX(550);
            System.out.println(++score);
            try {
                
                URL sound = null;
                
                try {
                    sound = new URL("http://codeskulptor-demos.commondatastorage.googleapis.com/GalaxyInvaders/pause.wav");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Clip clip = AudioSystem.getClip();
                AudioInputStream audioinput = null;
                try {
                    
                    audioinput = AudioSystem.getAudioInputStream(sound);
                    clip.open(audioinput);
                    
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                clip.loop(0);
                
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
    }
    
    public void move() {
        
        if (player.dead) {
            dx = 0;
            player.setYspeed(0);
            System.out.println("Player is dead");
            
        } else {
            
            if (getX() > -50) {
                this.setX(this.getX() + dx);
            } else {
                this.setX(500);
                
            }
        }
        
    }
    
    public void update() {
        move();
        hit();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if ((e.getX() >= 197 && e.getX() <= 342) && (e.getY() >= 41 && e.getY() <= 63)) {
            score = 0;
            player.dead = false;
            f1.setX(330);
            f2.setX(530);
            dx = -5;
            f1.setDx(-5);
            f2.setDx(-5);
            player.setYspeed(10);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
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
        if ((e.getX() >= 197 && e.getX() <= 342) && (e.getY() >= 41 && e.getY() <= 63)) {
            size = -4;
            positionY = -4;
            positionX = 19;
            
        }else{
            size = 4;
            positionY = 4;
            positionX = 10;
        }
    }
}
