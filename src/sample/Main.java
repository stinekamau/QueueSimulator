package sample;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.LinkedList;



public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        LinkedList<Figures> figs=new LinkedList<>();
        final int[] counter = {1};
        final int[] lastCounter = {5};

        final int[] baseStance={300};
        final int[] lastStance={1100};


        Button addFirst=new Button("addFirst");
        addFirst.setStyle("-fx-font-size: 2em; ");

        Button addLast=new Button("addLast");
        addLast.setStyle("-fx-font-size: 2em; ");

        Button removeFirst=new Button("removeFirst");
        removeFirst.setStyle("-fx-font-size: 2em; ");

        Button removeLast=new Button("removelast");
        removeLast.setStyle("-fx-font-size: 2em; ");


        HBox topButtons=new HBox();

        Button first=new Button("First");
        first.setStyle("-fx-font-size: 2em; ");

        Button last=new Button("Last");
        last.setStyle("-fx-font-size: 2em; ");

        Button size=new Button("Size");
        size.setStyle("-fx-font-size: 2em; ");

        Button isEmpty=new Button("isEmpty");
        isEmpty.setStyle("-fx-font-size: 2em; ");


        topButtons.getChildren().addAll(addFirst,addLast,removeFirst,removeLast,first,last,size,isEmpty);
        topButtons.setSpacing(10);
        Restaurant rst=new Restaurant(100,300,400,400);
        Pane root=new Pane();
        root.getChildren().addAll(topButtons,rst.getImv());





        addFirst.setOnAction(e->{
            try {

                if(figs.size()<6)
                {
                    Figures fig=new Figures(150,150);
                    String cust="Customer "+counter[0];
                    Font font= Font.font(cust, FontWeight.BOLD, FontPosture.ITALIC,12);
                    Label client=new Label(cust,fig.getImv());
                    client.setFont(font);
                    client.setLayoutX(baseStance[0]);
                    client.setLayoutY(500);

                    figs.addFirst(fig);

                    root.getChildren().addAll(client);
                    counter[0]++;
                    baseStance[0]+=200;
                }
                else
                {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Operation Error");
                    alert.setContentText("Queue is full");
                    alert.show();
                }





            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }


        });

        addLast.setOnAction(e->
        {
            if(figs.size()<6)
            {
                Figures fig= null;
                try {
                    fig = new Figures(150,150);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                String cust="Customer "+counter[0];
                Font font= Font.font(cust, FontWeight.BOLD, FontPosture.ITALIC,12);
                Label client=new Label(cust,fig.getImv());
                client.setFont(font);
                client.setLayoutX(lastStance[0]);
                client.setLayoutY(500);
                figs.addFirst(fig);

                root.getChildren().addAll(client);
                counter[0]--;
                baseStance[0]-=200;


            }else
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Operation Error");
                alert.setContentText("Queue is full");
                alert.show();
            }

        });









        Scene sc=new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Queue Simulation");
        primaryStage.show();







//        Group root=new Group();

    }
}
