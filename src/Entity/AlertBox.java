package Entity;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import   javafx.scene.control.*;

import java.awt.*;
import java.awt.Button;

public class AlertBox {

    public  void display(String title, String message)
    {
        Stage window= new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(300);
         Label label = new Label();
        label.setText(message);
        javafx.scene.image.Image image = new javafx.scene.image.Image("/Utils/checkmark.gif");
        ImageView iv2 = new ImageView();
        iv2.setImage(image);
        iv2.setFitWidth(300);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(true);
        javafx.scene.control.Button CloseButton = new javafx.scene.control.Button("Close");
        CloseButton.setOnAction(e -> window.close());
        window.getIcons().add(new Image("/Utils/checkmark.gif"));
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,iv2,CloseButton);
        label.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300 ,300);
        window.setScene(scene);
        window.showAndWait();
    }
}
