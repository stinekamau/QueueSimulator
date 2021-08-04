package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Restaurant {
    Image img;
    ImageView imv;
    public Restaurant(double x,double y,double setHeight,double setWidth) throws FileNotFoundException {
        img=new Image(new FileInputStream("C:\\Users\\user\\Videos\\QueueSimulator\\src\\sample\\restaurant.png"));
        imv=new ImageView(img);
        imv.setX(x);imv.setY(y);
        imv.setFitHeight(setHeight);
        imv.setFitWidth(setWidth);
    }

    public Restaurant(double x,double y) throws FileNotFoundException {
        img=new Image(new FileInputStream("C:\\Users\\user\\Videos\\QueueSimulator\\src\\sample\\restaurant.png"));
        imv=new ImageView(img);
        imv.setX(x);imv.setY(y);

    }

    public ImageView getImv() {
        return imv;
    }
}
