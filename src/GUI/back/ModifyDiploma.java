package GUI.back;

import Entity.Diploma;
import Entity.User;
import Service.ServiceDiploma;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ModifyDiploma implements Initializable {


        @FXML
        private Label logout;

        @FXML
        private Label gotoTeacher;

        @FXML
        private JFXTextField inti;

        @FXML
        private JFXComboBox<String> lvl;

        @FXML
        private Label btnRes;

        @FXML
        private JFXTextField sch;

        @FXML
        private JFXDatePicker bd;

        @FXML
        private JFXTextField sp;

        @FXML
        private TextField idT;

        @FXML
        private Button btnConf;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvl.getItems().addAll("Bachelor", "Master","Doctoral","Professional");


    }

        @FXML
        void addDiploma(MouseEvent event) {

        }

        @FXML
        void gotoTeacher(MouseEvent event) {

        }

        @FXML
        void logOut(MouseEvent event) throws IOException {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sample/login.fxml"));
            Parent root = fxml.load();
            logout.getScene().setRoot(root);
        }

        @FXML
        void restAll(MouseEvent event) {

        }

    public void initData(String lblInti, String lblsch, String lblspe, String lblobd, String lblvl,String id) {

            inti.setText(lblInti);
            sch.setText(lblsch);
            sp.setText(lblspe);
            bd.setValue(LocalDate.parse(lblobd));
            lvl.setValue(lblvl);
            idT.setText(id);

    }

    @FXML
    void update(MouseEvent event) throws SQLException, IOException {


        String inti1=inti.getText();
        String sch1=sch.getText();
        String sp1=sp.getText();
        String bd1=bd.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String lvl1=lvl.getValue();
        String idN=idT.getText();
        Diploma d = new Diploma(inti1,sch1,sp1,bd1,lvl1,idN);
        ServiceDiploma dip = new ServiceDiploma();
        dip.update(d,idN);

        FXMLLoader fxml=new FXMLLoader(getClass().getResource("teachers.fxml"));
        Parent root=fxml.load();
        btnConf.getScene().setRoot(root);
    }

}
