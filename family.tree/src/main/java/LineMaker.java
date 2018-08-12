import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LineMaker extends JPanel{
    JComboBox p1 = new JComboBox();
    JComboBox p2 = new JComboBox();
    JComboBox p3 = new JComboBox();
    JButton done = new JButton("Create");
    JButton reload = new JButton("Reload People");
    JLabel p1Label = new JLabel("Person 1");
    JLabel p2Label = new JLabel("Person 2");
    JLabel p3Label = new JLabel("Person 3 (Optional)");
    Tree t;
    public LineMaker(Tree t) throws IOException {
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
        p3Label.setSize(100,20);
        p3Label.setLocation(100,160);
        p3Label.setFont(new Font("Arial", Font.PLAIN, 16));
        add(p1Label);
        add(p2Label);
        add(p3Label);
        p3.addItem("No third person");
        for(Person p : t.m.people){
            p1.addItem(p.getName());
            p2.addItem(p.getName());
            p3.addItem(p.getName());

        }
        p1.setLocation(100,100);
        p1.setSize(150,20);
        add(p1);
        p2.setLocation(100,140);
        p2.setSize(150,20);
        add(p2);
        p3.setLocation(100,180);
        p3.setSize(150,20);
        add(p3);
        done.setLocation(100,250);
        done.setSize(350,50);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(p3.getSelectedItem().equals("No third person")) {
                    Line l = new Line((String)p1.getSelectedItem(),(String)p2.getSelectedItem());
                    t.m.lines.add(l);
                }
                else{
                    Line l = new Line((String)p1.getSelectedItem(),(String)p2.getSelectedItem(),(String)p3.getSelectedItem());
                    t.m.lines.add(l);
                }
            }
        });
        add(done);
        reload.setLocation(500,80);
        reload.setSize(220,220);
        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                p1.removeAllItems();
                p2.removeAllItems();
                p3.removeAllItems();
                p3.addItem("No third person");
                for(Person p : t.m.people){
                    p1.addItem(p.getName());
                    p2.addItem(p.getName());
                    p3.addItem(p.getName());

                }
            }
        });
        add(reload);
    }
}
