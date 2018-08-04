import com.google.gson.*;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static ArrayList<Person> people = new ArrayList<Person>();
    public static ArrayList<Line> lines = new ArrayList<Line>();
    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void readAll() throws FileNotFoundException {

        File fo = new File("people");
        File[] folder = fo.listFiles();
        for(File f : folder){
            FileReader fr = new FileReader(f);
            Person p = gson.fromJson(fr,Person.class);
            //System.out.println(t.getSt());
        }
    }
    public static void createJson(Person p) throws IOException {
        FileWriter fw = new FileWriter("people\\" + p.getName() + ".json");
        fw.write(gson.toJson(p));
        fw.close();
    }
    public static void main(String args[]) throws IOException {
        //createJson(new Person("Example",new Date(01-01-1970)))
        Tree t = new Tree();
        // for (Person p : people) {
      //  createJson(lm);
            //}

        JFrame j = new JFrame();

        j.setSize(600,450);
        j.setVisible(true);
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.add(t);

    }
}
