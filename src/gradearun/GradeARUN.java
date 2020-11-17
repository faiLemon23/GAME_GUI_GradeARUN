
package gradearun;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFrame;

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
class isPanel extends JPanel{
    BufferedImage image;
    isPanel() throws IOException{
        this.image = ImageIO.read(new File(".\\src\\resources\\A.png"));
    }
}
class JFramenaja extends JFrame {
// Frame
    

    JFramenaja() throws IOException {

        
        this.add(new isPanel());
        this.add(new StartGame());
        this.setTitle("GradeA RUN!!!");
//        this.setIconImage(image);
    }

}

public class GradeARUN {

    public static void main(String[] args) throws IOException {

        JFramenaja f = new JFramenaja();
        f.setSize(550, 340);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

}
