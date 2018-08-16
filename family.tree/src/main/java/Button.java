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
        ss = ImageIO.read(new File("gfx/largescreen.png"));
        fs = ImageIO.read(new File("gfx/smolscreen.png"));

    }

    public void paint(Graphics g){
        if(isFullScreen) {
            x = t.m.jfs.getWidth()-128-17;
            y = t.m.jfs.getHeight()-128-35;
            g.drawImage(fs,x,y,128,128,t);
        }
        else{
            x = t.m.j.getWidth()-128-17;
            y = t.m.j.getHeight()-128-75;
            g.drawImage(ss,x,y,128,128,t);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX() > x && e.getX() < x + 128 && e.getY() > y && e.getY() < y+128){
            if(isFullScreen) {
                isFullScreen = false;
                t.m.j.setVisible(true);
                t.m.jfs.setVisible(false);
                t.repaint();
                t.m.j.add(t.m.jtp);
                t.m.jfs.remove(t.m.jtp);
            }
            else{
                isFullScreen = true;
                t.m.j.setVisible(false);
                t.m.jfs.setVisible(true);
                t.repaint();
                t.m.jfs.add(t.m.jtp);
                t.m.j.remove(t.m.jtp);


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
