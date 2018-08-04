import com.google.gson.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static ArrayList<Person> people = new ArrayList<Person>();
    public static ArrayList<Line> lines = new ArrayList<Line>();
    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void readAll() throws FileNotFoundException {

        File fo = new File("people");
        File fu = new File("lines");
        File[] folder = fo.listFiles();
        File[] flolder = fu.listFiles();
        for(File f : folder){
            FileReader fr = new FileReader(f);
            Person p = gson.fromJson(fr,Person.class);
            people.add(p);
        }
        for(File f : flolder){
            FileReader fr = new FileReader(f);
            Line l = gson.fromJson(fr,Line.class);
            lines.add(l);
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
        //Person p = new Person("Example",new Date(01-01-1970)))
        readAll();
        Tree t = new Tree();


        JFrame j = new JFrame();
        JFrame jfs = new JFrame();

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



        while(true){
            if(t.button.isFullScreen){
                j.setVisible(false);
                jfs.setVisible(true);
                t.repaint();
                jfs.add(t);
                j.remove(t);
            }
            else{
                j.setVisible(true);
                jfs.setVisible(false);
                t.repaint();
                j.add(t);
                jfs.remove(t);

            }
        }
    }

}
