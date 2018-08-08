import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PeopleMaker extends JPanel{
    JTextField name = new JTextField();
    JTextField dob = new JTextField();
    JTextField dod = new JTextField();
    JTextArea info = new JTextArea();
    JComboBox profile = new JComboBox();
    JButton done = new JButton("Create");
    JLabel nLabel = new JLabel("Name");
    JLabel dbLabel = new JLabel("Date of Birth");
    JLabel ddLabel = new JLabel("Date of Death (Optional)");
    JLabel pLabel = new JLabel("Image");
    JLabel iLabel = new JLabel("Info");
    Tree t;
    public PeopleMaker(Tree t) throws IOException {
        this.t = t;
        setLayout(null);
        setSize(3944,2462);
        setFocusable(true);
        nLabel.setSize(50,20);
        nLabel.setVisible(true);
        nLabel.setLocation(100,80);
        nLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        pLabel.setSize(50,20);
        pLabel.setVisible(true);
        pLabel.setLocation(300,80);
        pLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        dbLabel.setSize(150,20);
        dbLabel.setVisible(true);
        dbLabel.setLocation(100,120);
        dbLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        ddLabel.setSize(200,20);
        ddLabel.setVisible(true);
        ddLabel.setLocation(100,160);
        ddLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        iLabel.setSize(200,20);
        iLabel.setVisible(true);
        iLabel.setLocation(470,180);
        iLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        info.setBackground(new Color(225,225,225));
        info.setFont(new Font("Arial", Font.PLAIN, 16));
        info.setFocusable(true);
        info.setLocation(470,200);
        info.setSize(450,450);
        name.setFocusable(true);
        name.setLocation(100,100);
        name.setSize(150,20);
        add(name);
        dob.setFocusable(true);
        dob.setLocation(100,140);
        dob.setSize(150,20);
        add(dob);
        dod.setFocusable(true);
        dod.setLocation(100,180);
        dod.setSize(150,20);
        add(dod);
        add(nLabel);
        add(dbLabel);
        add(ddLabel);
        add(pLabel);
        add(iLabel);
        add(info);
        for(File f : (new File("gfx")).listFiles()){
            profile.addItem(f);
        }
        profile.setLocation(300,100);
        profile.setSize(150,20);
        add(profile);
        done.setLocation(100,250);
        done.setSize(350,50);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dod.getText().equals("")) {
                    Person p = new Person(name.getText(),dob.getText(),info.getText(),(File)profile.getSelectedItem());
                    t.m.people.add(p);
                }
                else{
                    Person p = new Person(name.getText(),dob.getText(),dod.getText(),info.getText(),(File)profile.getSelectedItem());
                    t.m.people.add(p);
                }
            }
        });
        add(done);
    }
}
