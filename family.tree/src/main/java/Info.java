import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Info extends BufferedImage {
    BufferedImage profile;
    BufferedImage background = ImageIO.read(new File("gfx\\background.png"));
    BufferedImage back = ImageIO.read(new File("gfx\\back.png"));
    Person infoAbout;

    public Info(int width, int height, int imageType, Person infoAbout) throws IOException {
        super(width, height, imageType);
        this.infoAbout = infoAbout;
        Graphics g = getGraphics();
        g.drawImage(background,0,0,null);
        g.setColor(Color.WHITE);
        g.fillRect(100,100,getWidth()-100,getHeight()-100);
        profile = ImageIO.read(infoAbout.getImage());
        g.drawImage(profile,110,110, 150, 200, null);
        g.drawImage(back,700,110,null);
        g.setFont(new Font("Arial", Font.PLAIN, 26));
        g.setColor(Color.BLACK);
        g.drawString(infoAbout.getName(),270, 130);
        if(infoAbout.getDod() == null){
            g.drawString(infoAbout.getDob(),270, 180);
        }
        else{
            g.drawString(infoAbout.getDob() + " - " + infoAbout.getDod(),270, 180);
        }
        g.setFont(new Font("Arial", Font.PLAIN, 13));
    }

}
