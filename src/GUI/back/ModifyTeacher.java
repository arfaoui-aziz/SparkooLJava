package GUI.back;

import Entity.User;
import Service.ServiceUser;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ModifyTeacher implements Initializable {

    @FXML
    private Label logout;

    @FXML
    private Label gotoTeacher;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXComboBox<String> gn;

    @FXML
    private JFXTextField adr;

    @FXML
    private Label btnRes;

    @FXML
    private JFXTextField fn;

    @FXML
    private JFXDatePicker bd;

    @FXML
    private JFXTextField ph;

    @FXML
    private JFXTextField ln;

    @FXML
    private JFXTextField mail;

    @FXML
    private JFXTextField pic;

    @FXML
    private Button btnConf;

    ServiceUser user = new ServiceUser();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gn.getItems().addAll("Male", "Female");

    }




    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }

    @FXML
    private void gotoTeacher(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("teachers.fxml"));
        Parent root=fxml.load();
        gotoTeacher.getScene().setRoot(root);
    }

    @FXML
    void restAll(MouseEvent event) {
        fn.clear();
        ln.clear();
        adr.clear();
        mail.clear();
        ph.clear();
        pic.clear();
        id.clear();
        gn.valueProperty().set(null);
        bd.setValue(null);

    }


    public void initData(User selectedItem) {
        id.setText(selectedItem.getId());
        fn.setText(selectedItem.getFirstName());
        ln.setText(selectedItem.getLastName());
        adr.setText(selectedItem.getAddress());
        mail.setText(selectedItem.getEmail());
        ph.setText(selectedItem.getPhone());
        pic.setText(selectedItem.getPicture());
        id.setText(selectedItem.getId());
        gn.setValue(selectedItem.getGender());
        bd.setValue(LocalDate.parse(selectedItem.getBirthDay()));

    }


    @FXML
    void update(MouseEvent event) throws SQLException, IOException {
        String id1=id.getText();
        String mail1=mail.getText();
        String fn1=fn.getText();
        String ln1=ln.getText();
        String gn1=(String) gn.getValue();
        String adr1=adr.getText();
        String ph1=ph.getText();
        String pic1=pic.getText();
        String bd1= bd.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        User u = new User(id1,mail1,fn1,ln1,gn1,adr1,ph1,pic1,bd1);
        user.update(u,id1);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("teachers.fxml"));
        Parent root=fxml.load();
        btnConf.getScene().setRoot(root);
    }
}
