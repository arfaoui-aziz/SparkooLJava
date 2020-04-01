package GUI.back;

import Entity.User;
import Service.ServiceUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import com.jfoenix.controls.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class AddTeacher  {

    @FXML
    private Label logout;

    @FXML
    private Label gotoTeacher;

    @FXML
    private JFXTextField fn;

    @FXML
    private JFXDatePicker bd;

    @FXML
    private JFXTextField adr;

    @FXML
    private JFXTextField ln;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXTextField ph;

    @FXML
    private JFXComboBox<String> gn;

    @FXML
    private JFXTextField mail;

    @FXML
    private JFXTextField pic;
    @FXML
    private Button btnConf;
    ServiceUser user = new ServiceUser();
    @FXML
    private Label btnRes;

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
    public void initialize() {
        gn.getItems().addAll("Male", "Female");
    }

    @FXML
    void add(MouseEvent event) throws IOException, SQLException {
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
        user.add(u);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("addDiploma.fxml"));
        Parent root=fxml.load();
        btnConf.getScene().setRoot(root);

        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("addDiploma.fxml"));
        Parent root1 = loader2.load();
        AddDiploma controller = loader2.getController();
        controller.initData(id.getText());

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
}
