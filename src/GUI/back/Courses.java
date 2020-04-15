package GUI.back;

import Entity.Course;
import Service.ServiceCourse;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Courses implements Initializable {
String path="";
    @FXML
    private Label logout;

    @FXML
    private Label gotoTeacher;

    @FXML
    private Label lid;

    @FXML
    private JFXComboBox<String> sub;

    @FXML
    private JFXTextField chapter;

    @FXML
    private Label lgn;

    @FXML
    private HBox addFile;

    @FXML
    private Label ladr;

    @FXML
    private Label btnRes;

    @FXML
    private Button btnConf;

    @FXML
    private Label lfn;


    @FXML
    private ImageView img;



    @FXML
    void add(MouseEvent event) throws SQLException, IOException {
        ServiceCourse c=new ServiceCourse();
        Course cr = new Course(sub.getValue(),chapter.getText(),path);
        c.addCourse(cr);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("teachers.fxml"));
        Parent root=fxml.load();
        btnConf.getScene().setRoot(root);

    }

    @FXML
    void addFile(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files", "*.pdf");
        fileChooser.getExtensionFilters().add(extFilter);
        Window primaryStage = null;
        File file = fileChooser.showOpenDialog(primaryStage);
        if(file==null) return ;
        this.path=file.getPath();
        if (!path.isEmpty()){
            Image image = new Image("GUI/image/front/icons8-pdf.png");
            ladr.setText("A PDF file is uploaded");
            img.setImage(image);
        }
    }

    @FXML
    void gotoTeacher(MouseEvent event) {

    }

    @FXML
    void logOut(MouseEvent event) {

    }

    @FXML
    void restAll(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sub.getItems().addAll("Computer Science", "Mathematics","Physics","History and Geography","Literature","Natural Science","Sport");

    }


}
