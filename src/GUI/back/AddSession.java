package GUI.back;

import Service.ServiceMarks;
import Service.ServiceScheduleTeacher;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.security.auth.Subject;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddSession implements Initializable {

    @FXML
    private JFXComboBox<String> sub;

    @FXML
    private JFXComboBox<String> classe;

    @FXML
    private JFXComboBox<String> bloc;

    @FXML
    private JFXComboBox<String> floor;

    @FXML
    private JFXComboBox<String> num;

    @FXML
    private Button btnCan;

    @FXML
    private Button btConf;

    @FXML
    private TextField idT;


    String id_Teacher="";
    String da="";
    String s="";
    @FXML
    void addAbsence(MouseEvent event) throws SQLException {

        ServiceScheduleTeacher sst= new ServiceScheduleTeacher();
String full=classe.getValue()+" "+bloc.getValue()+floor.getValue()+num.getValue();
        sst.addSession(da,s,sub.getValue(),full,id_Teacher);
        Stage primaryStage = new Stage();

        Stage stage = (Stage) btnCan.getScene().getWindow();
        stage.close();


    }

    @FXML
    void cancelButtonAction(MouseEvent event) {
        Stage primaryStage = new Stage();

        Stage stage = (Stage) btnCan.getScene().getWindow();
        stage.close();
    }

    public void initData(String id, String day, String se) {
        id_Teacher=id;
        da=day;
        s=se;
    }
@Override
public void initialize(URL location, ResourceBundle resources) {

    classe.getItems().addAll("1A1","1A2","1A3","2A1","2A2","2A3","3A1","3A2","3A3");
    sub.getItems().addAll("C++","JAVA","PI DEV","C","Python","Android");
    bloc.getItems().addAll("A","B","C");
    floor.getItems().addAll("1","2","3");
    num.getItems().addAll("1","2","3","4");


}
}
