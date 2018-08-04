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
    BufferedImage bImage = new BufferedImage(1280, 1280,BufferedImage.TYPE_INT_RGB);

    public Tree() {
        setVisible(true);
        setSize(600,450);
        setFocusable(true);
        addMouseMotionListener(this);

        try {
            bi = ImageIO.read(new File("gfx/background.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        /*Person person = new Person("ExampleHobby","01.01-1970","01.01-2050","Example",new File("gfx/url.jpg"));
        Person pperson = new Person("ExampleRobbie","01.01.1970","Example",new File("gfx/url.jpg"));
        Person ppperson = new Person("ExampleBobbie","01.01.1970", "Example",new File("gfx/url.jpg"));
        Person pppperson = new Person("ExampleTobbie","01.01.1970", "Example",new File("gfx/url.jpg"));

        m.people.add(person);
        m.people.add(pperson);
        m.people.add(ppperson);
        m.people.add(pppperson);
        */
    }

    public void paint(Graphics g){
        Graphics b = bImage.getGraphics();
        b.drawImage(bi,0,0,null);
        b.setColor(Color.BLACK);
        b.setFont(new Font("Arial", Font.PLAIN, 10));
        for(Line l : m.lines){
            for(Person p : m.people){
                if(p.getName().equals(l.getP1name())){
                    for(Person p1 : m.people){
                        if(p1.getName().equals(l.getP2name())){
                            if(l.getP3name() == null) {
                                b.drawLine(p.x + 18, p.y + 25, p1.x + 18, p1.y + 25);
                            }
                            else{
                                for (Person p2 : m.people) {
                                    if(p2.getName().equals(l.getP3name())) {
                                        b.drawLine(p.x + 18, p.y + 25, p1.x + 18, p1.y + 25);
                                        b.drawLine((p.x + p1.x + 36) / 2, (p.y + p1.y + 50) / 2, p2.x + 18, p2.y + 25);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for(Person p : m.people){
            try {
                //System.out.println(p.getImage());
                BufferedImage oo = ImageIO.read(p.getImage());
                b.drawImage(oo,p.x,p.y,37,50,null);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
