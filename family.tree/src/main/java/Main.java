import com.google.gson.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Date;

import static java.nio.file.Files.delete;


public class Main {
    public static ArrayList<Person> people = new ArrayList<Person>();
    public static ArrayList<Line> lines = new ArrayList<Line>();
    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static JFrame j = new JFrame();
    public static JFrame jfs = new JFrame();
    public static JTabbedPane jtp = new JTabbedPane();


    public static void readAll() throws IOException {

        File fo = new File("people");
        File fu = new File("lines");
        File[] folder = fo.listFiles();
        File[] flolder = fu.listFiles();
        for(File f : folder){
            FileReader fr = new FileReader(f);
            Person p = gson.fromJson(fr,Person.class);
            people.add(p);
            System.out.println(p.getName());
            fr.close();
        }
        for(File f : flolder){
            FileReader fr = new FileReader(f);
            Line l = gson.fromJson(fr,Line.class);
            lines.add(l);
            System.out.println(l.getName());
            fr.close();
        }
    }
    public static void createJson(Person p) throws IOException {
        FileWriter fw = new FileWriter("people\\" + p.getName() + ".json");
        fw.write(gson.toJson(p));
        fw.close();
    }
    public static void createJsonLine(Line l) throws IOException {
        FileWriter fw = new FileWriter("lines\\" + l.getName() + ".json");
        fw.write(gson.toJson(l));
        fw.close();
    }
    public static void main(String args[]) throws IOException {
        Main main = new Main();
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }
        //Person p = new Person("Example",new Date(01-01-1970)))
        Tree t = new Tree();
        readAll();
        PeopleMaker pm = new PeopleMaker(t);
        LineMaker lm = new LineMaker(t);
        ObjectRemover or = new ObjectRemover(t);
        j.setVisible(true);
        jfs.setVisible(false);
        t.repaint();
        j.add(jtp);
        jfs.remove(jtp);

        jtp.addTab("Tree",t);
        jtp.addTab("Add a Person",pm);
        jtp.addTab("Add a Line",lm);
        jtp.addTab("Remove an Object",or);
        j.setFocusable(true);
        j.setSize(1280,720);
        j.setResizable(false);
        jfs.setResizable(false);
        jfs.setUndecorated(true);
        jfs.setExtendedState(JFrame.MAXIMIZED_BOTH);
        j.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        j.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                for (Person p : people) {
                    try {
                        createJson(p);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                for (Line l : lines) {
                    try {
                        createJsonLine(l);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                    System.exit(0);
                }
        });

    }


}
