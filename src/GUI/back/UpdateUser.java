package GUI.back;

import Entity.User;
import Service.ServiceUser;
import com.jfoenix.controls.JFXComboBox;
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
import java.util.ResourceBundle;

public class UpdateUser implements Initializable {
    @FXML
    private Label logout;

    @FXML
    private Label gotoTeacher;

    @FXML
    private JFXTextField lblfn;

    @FXML
    private JFXTextField lblocc;

    @FXML
    private JFXTextField lbladr;

    @FXML
    private JFXTextField lblln;

    @FXML
    private JFXTextField lblid;

    @FXML
    private JFXTextField lblph;

    @FXML
    private JFXComboBox<String> lblgn;

    @FXML
    private JFXTextField lblmail;

    @FXML
    private JFXTextField lblphoto;

    @FXML
    private Button btnConf;

    @FXML
    void update(MouseEvent event) throws SQLException, IOException {

        String id1 = lblid.getText();
        String mail1 = lblmail.getText();
        String fn1 = lblfn.getText();
        String ln1 = lblln.getText();
        String gn1 = (String) lblgn.getValue();
        String adr1 = lbladr.getText();
        String ph1 = lblph.getText();
        String pic1 = lblphoto.getText();
        String occu = lblocc.getText();

        User u = new User(id1, mail1, fn1, ln1, gn1, adr1, ph1, pic1,occu);
        ServiceUser user=new ServiceUser();
        user.update(u,id1);

        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Users.fxml"));
        Parent root=fxml.load();
        btnConf.getScene().setRoot(root);
    }

    @FXML
    void gotoTeacher(MouseEvent event) {

    }

    @FXML
    void logOut(MouseEvent event) {

    }

    public void initData(User selectedItem) {
        lblid.setText(selectedItem.getId());
        lbladr.setText(selectedItem.getAddress());
        lblfn.setText(selectedItem.getFirstName());
        lblln.setText(selectedItem.getLastName());
        lblgn.setValue(selectedItem.getGender());
        lblmail.setText(selectedItem.getEmail());
        lblocc.setText(selectedItem.getOccupation());
        lblph.setText(selectedItem.getPhone());
        lblphoto.setText(selectedItem.getPicture());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblgn.getItems().addAll("Male", "Female");

    }


}
