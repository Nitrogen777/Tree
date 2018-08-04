import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

public class Person {
    Tree t;
    private String name;
    private String dob;
    private String dod;
    int x = 282;
    int y = 150;
    private String info;
    private BufferedImage image;

    public Person(String name, String dob, String info, BufferedImage image) {
        this.name = name;
        this.dob = dob;
        this.info = info;
        this.image = image;
    }

    public Person(String name, String dob, String dod, String info,BufferedImage image) {
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.info = info;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }



    public String getDod() {
        return dod;
    }

    public void setDod(String dod) {
        this.dod = dod;
    }

    @Override
    public String toString() {
        return "Person{" +
                "t=" + t +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", dod=" + dod +
                ", x=" + x +
                ", y=" + y +
                ", info='" + info + '\'' +
                ", image=" + image +
                '}';
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
