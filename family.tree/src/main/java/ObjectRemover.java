import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ObjectRemover extends JPanel{
    JComboBox p1 = new JComboBox();
    JComboBox p2 = new JComboBox();
    JButton done = new JButton("Delete Person");
    JButton reload = new JButton("Delete Line");
    JLabel p1Label = new JLabel("People");
    JLabel p2Label = new JLabel("Lines");
    Tree t;
    public ObjectRemover(Tree t) throws IOException {
        this.t = t;
        setLayout(null);
        setSize(3944,2462);
        setFocusable(true);
        p1Label.setSize(100,20);
        p1Label.setLocation(100,80);
        p1Label.setFont(new Font("Arial", Font.PLAIN, 16));
        p2Label.setSize(100,20);
        p2Label.setLocation(100,120);
        p2Label.setFont(new Font("Arial", Font.PLAIN, 16));
        add(p1Label);
        add(p2Label);
        for(Person p : t.m.people){
            p1.addItem(p.getName());

        }
        for(Line l : t.m.lines){
            p2.addItem(l.getName());

        }
        p1.setLocation(100,100);
        p1.setSize(150,20);
        add(p1);
        p2.setLocation(100,140);
        p2.setSize(150,20);
        add(p2);
        done.setLocation(250,80);
        done.setSize(100,40);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < t.m.people.size(); ++i) {
                    if (p1.getSelectedItem().equals(t.m.people.get(i).getName())) {
                        System.out.println((new File("people\\" + t.m.people.get(i).getName() + ".json")));
                        System.out.println((new File("people\\" + t.m.people.get(i).getName() + ".json")).delete());
                        p1.removeItem(t.m.people.get(i).getName());
                        t.m.people.remove(t.m.people.get(i));


                    }
                }
            }
        });
        add(done);
        reload.setLocation(250,120);
        reload.setSize(100,40);
        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                for(int i = 0; i < t.m.lines.size(); ++i) {
                    if (p2.getSelectedItem().equals(t.m.lines.get(i).getName())) {
                        System.out.println((new File("lines\\" + t.m.lines.get(i).getName() + ".json")));
                        System.out.println((new File("lines\\" + t.m.lines.get(i).getName() + ".json")).delete());
                        p2.removeItem(t.m.lines.get(i).getName());
                        t.m.lines.remove(t.m.lines.get(i));


                    }
                }
            }
        });
        add(reload);
    }
}
