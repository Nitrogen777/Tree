import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Tree extends JPanel implements MouseMotionListener,MouseListener,FocusListener{
    int x = 0;
    int y = 0;
    Button button = new Button(this);
    Main m;
    Menu menu = new Menu(this);
    Person placeHolder;
    BufferedImage bi;

    PointerInfo a = MouseInfo.getPointerInfo();
    Point mouse = a.getLocation();
    JTextArea info = new JTextArea();
    BufferedImage bImage = new BufferedImage(3944,2462,BufferedImage.TYPE_INT_RGB);
    Info learnPerson;
    Mode mode = Mode.View;

    public Tree() throws IOException {
        setLayout(null);

        setSize(3944,2462);
        setFocusable(true);
        addMouseMotionListener(this);
        addMouseListener(button);
        addMouseListener(this);
        addMouseListener(menu);
        info.setFocusable(true);
        info.setBounds(110,330,990,300);
        info.setSize(990,300);
        info.setLocation(110,330);
        info.setVisible(false);
        info.addFocusListener(this);
        add(info);

        setVisible(true);
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

    public void paintComponent(Graphics g){
        super.paintComponent(g);
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
        if(mode == Mode.Learn && learnPerson != null){
        g.drawImage(learnPerson,0,0,null);
        }
        else {
            g.drawImage(bImage, x, y, null);
            menu.paint(g);
        }
        button.paint(g);

    }
    /*public void checkForEntry() {
        a = MouseInfo.getPointerInfo();
        mouse = a.getLocation();
        for (Person p : m.people) {
            if ((int)mouse.getX() > p.x && (int)mouse.getX() < p.x + 37 && (int)mouse.getY() > p.y && (int)mouse.getY() < p.y + 50) {
                this.setCursor(new Cursor(Cursor.HAND_CURSOR));
                //System.out.println("yes");
            } else {
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                //System.out.println(mouse.getX());
            }
        }
    }*/
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
        if(mode == Mode.Edit) {
            if (placeHolder != null) {
                placeHolder.x = e.getX() - 18;
                placeHolder.y = e.getY() - 25;
            }
        /*else{
            x = 2*e.getX()-x;
            y = 2*e.getY()-y;
        }*/

            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(mode == Mode.View) {
            for (Person p : m.people) {
                if (e.getX() > p.x && e.getX() < p.x + 37 && e.getY() > p.y && e.getY() < p.y + 50) {
                    System.out.println("Clicked");
                    try {
                        Info shown = new Info(3944,2462,Info.TYPE_INT_RGB,p);
                        learnPerson = shown;
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    info.setText(p.getInfo());
                    info.setVisible(true);
                    info.setEditable(true);
                    mode = Mode.Learn;
                }
            }
            repaint();
        }
        if(mode == Mode.Learn) {
                if (e.getX() > 700 && e.getX() < 1110 && e.getY() > 110 && e.getY() < 310 + 50) {
                    if (e.getClickCount() == 2){
                        System.out.println("Clicked");
                        learnPerson.infoAbout.setInfo(info.getText());
                        info.setVisible(false);
                        info.setEditable(false);
                        mode = Mode.View;
                    }
            }
            repaint();
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
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        info.grabFocus();
    }
}
