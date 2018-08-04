import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Tree extends JPanel implements MouseMotionListener{
    int x = 0;
    int y = 0;
    Main m;
    Person placeHolder;
    BufferedImage bi;
    BufferedImage oo;
    BufferedImage bImage = new BufferedImage(1280, 1280,BufferedImage.TYPE_INT_RGB);

    public Tree() {
        setVisible(true);
        setSize(600,450);
        setFocusable(true);
        addMouseMotionListener(this);

        try {
            bi = ImageIO.read(new File("gfx/background.png"));
            oo = ImageIO.read(new File("gfx/url.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Person person = new Person("Example","01.01-1970","01.01-2050","Example",oo);
        Person pperson = new Person("ExampleRobbie","01.01.1970","Example",oo);
        Person ppperson = new Person("ExampleBobbie","01.01.1970", "Example",oo);
        Person pppperson = new Person("ExampleTobbie","01.01.1970", "Example",oo);
        Line line = new Line(person,pperson,ppperson);
        Line lline = new Line(pppperson,pperson);
        m.people.add(person);
        m.people.add(pperson);
        m.people.add(ppperson);
        m.people.add(pppperson);
        m.lines.add(line);
        m.lines.add(lline);
    }

    public void paint(Graphics g){
        Graphics b = bImage.getGraphics();
        b.drawImage(bi,0,0,null);
        b.setColor(Color.BLACK);
        b.setFont(new Font("Arial", Font.PLAIN, 10));
        for(Line l : m.lines){
            if(l.getP3() == null) {
                b.drawLine(l.getP1().x + 18, l.getP1().y + 25, l.getP2().x + 18, l.getP2().y + 25);
            }
            else{
                b.drawLine(l.getP1().x + 18, l.getP1().y + 25, l.getP2().x + 18, l.getP2().y + 25);
                b.drawLine((l.getP1().x + l.getP2().x + 36)/2,(l.getP1().y + l.getP2().y + 50)/2,l.getP3().x+18,l.getP3().y+25);
            }
        }
        for(Person p : m.people){
            b.drawImage(p.getImage(),p.x,p.y,37,50,null);
            if(p.getDod() == null){
                b.drawString( p.getName(),p.x-15,p.y+58);
                b.drawString(""+p.getDob(),p.x-15,p.y+68);
            }
            else{
                b.drawString( p.getName(),p.x-15,p.y+58);
                b.drawString(""+p.getDob()+" - "+p.getDod(),p.x-20,p.y+68);

            }
        }
        g.drawImage(bImage,x,y,null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        for(Person p : m.people){
            if(e.getX() > p.x && e.getX() < p.x+37 && e.getY() > p.y && e.getY() < p.y+50) {
                placeHolder = p;
                break;
            }
            else{
                placeHolder = null;
            }
        }

        if(placeHolder != null){
            placeHolder.x = e.getX() - 18;
            placeHolder.y = e.getY() - 25;
        }
        /*else{
            x = 2*e.getX()-x;
            y = 2*e.getY()-y;
        }*/

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
