package sample;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Figures{
    Image img;
    ImageView imv;
    FileInputStream file;

    public Figures(Double x,Double y) throws FileNotFoundException {
        img=new Image(new FileInputStream("figure.png"));
        //render the imageView
        imv=new ImageView(img);
        imv.setX(x);imv.setY(y);


    }
    public Figures(double fitHeight,double fitWidth) throws FileNotFoundException {
        img=new Image(new FileInputStream("C:\\Users\\user\\Videos\\QueueSimulator\\src\\sample\\figure.png"));
        //render the imageView
        imv=new ImageView(img);
        imv.setFitHeight(fitHeight);
        imv.setFitWidth(fitWidth);



    }
    ImageView getImv()
    {
        return imv;
    }

    void changeValues(double x,double y)
    {
        imv.setX(x);imv.setY(y);
    }
    void changeX(Double x)
    {
        imv.setX(x);
    }
    void changeY(Double y)
    {
        imv.setY(y);
    }

    void setGlow(Double val)
    {
        Glow glow=new Glow();
        glow.setLevel(val);
        imv.setEffect(glow);

    }


}
