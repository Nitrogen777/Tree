import com.sun.org.apache.xpath.internal.SourceTree;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Button implements MouseListener{
    boolean isFullScreen = false;
    Tree t;
    int x;
    int y;
    BufferedImage ss;
    BufferedImage fs;
    public Button(Tree t) throws IOException {
        this.t = t;
        ss = ImageIO.read(new File("gfx\\largescreen.png"));
        fs = ImageIO.read(new File("gfx\\smolscreen.png"));

    }

    public void paint(Graphics g){
        x = t.getWidth()-133;
        y = t.getHeight()-133;
        if(isFullScreen) {
            g.drawImage(fs,x,y,128,128,t);
        }
        else{
            g.drawImage(ss,x,y,128,128,t);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX() > x && e.getX() < x + 128 && e.getY() > y && e.getY() < y+128){
            if(isFullScreen) {
                isFullScreen = false;

            }
            else{
                isFullScreen = true;
            }
        }
        t.repaint();
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
}
