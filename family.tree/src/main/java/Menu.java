import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu implements MouseListener{
    Tree t;
    BufferedImage edit,view;
    public Menu(Tree t) {
        this.t = t;
        try {
            edit = ImageIO.read(new File("gfx\\viewBtn.png"));
            view = ImageIO.read(new File("gfx\\editBtn.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paint(Graphics g){
        if(t.mode == Mode.Edit){
            g.setColor(Color.blue);
           // g.fillRect(0,0,t.getWidth(),100);
            g.drawImage(edit,5,5,t);
        }
        else if(t.mode == Mode.View){
            g.drawImage(view,5,5,t);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX() > 5 && e.getX() < 55 && e.getY() > 5 && e.getY() < 30){
            System.out.println("yes");
            if(t.mode == Mode.Edit) {
                //t.name.setVisible(true);
                t.mode = Mode.View;

            }
            else if(t.mode == Mode.View){
               // t.name.setVisible(false);
                t.mode = Mode.Edit;
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
