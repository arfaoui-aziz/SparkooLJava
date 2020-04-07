package GUI.back;

import Entity.User;
import Service.ServiceUser;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;

public class AddUser {
    @FXML
    private Label logout;

    @FXML
    private Label gotoTeacher;

    @FXML
    private JFXTextField lblfn;

    @FXML
    private Label lfn;

    @FXML
    private JFXTextField lblocc;

    @FXML
    private Label locc;

    @FXML
    private JFXTextField lbladr;

    @FXML
    private Label ladr;

    @FXML
    private JFXTextField lblln;

    @FXML
    private Label lln;

    @FXML
    private JFXTextField lblid;

    @FXML
    private Label lid;

    @FXML
    private JFXTextField lblph;

    @FXML
    private Label lph;

    @FXML
    private JFXComboBox<String> lblgn;

    @FXML
    private Label lgn;

    @FXML
    private JFXTextField lblmail;

    @FXML
    private Label lmail;

    @FXML
    private JFXTextField lblphoto;

    @FXML
    private Label lphoto;

    @FXML
    private Button btnConf;


    ServiceUser user = new ServiceUser();


    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }


    public static boolean isNumeric(final String str) {

        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;

    }
    public void iniLbls(){
        lid.setText("");
        lfn.setText("");
        lln.setText("");
        lph.setText("");
        lphoto.setText("");
        ladr.setText("");
        lgn.setText("");
        locc.setText("");
        lmail.setText("");

    }
    @FXML
    void add(MouseEvent event) throws IOException, SQLException {

iniLbls();
        String id1 = lblid.getText();
        String mail1 = lblmail.getText();
        String fn1 = lblfn.getText();
        String ln1 = lblln.getText();
        String gn1 = (String) lblgn.getValue();
        String adr1 = lbladr.getText();
        String ph1 = lblph.getText();
        String pic1 = lblphoto.getText();
        String occu = lblocc.getText();

        if ((id1.length() != 8 || !isNumeric(id1) ) || (occu.length()<3 || !occu.matches("^[a-zA-Z]*$")) || (fn1.length()<3 || !fn1.matches("^[a-zA-Z]*$")) || (ln1.length()<3 || !ln1.matches("^[a-zA-Z]*$")) || (lblgn.getSelectionModel().isEmpty()) || (ph1.length() != 8 || !isNumeric(ph1)) || (!mail1.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$") ) || (adr1.length()<5)){
            if (occu.length()<3 || !occu.matches("^[a-zA-Z]*$")){locc.setText("Invalid Input !");}

            if (id1.length() != 8 || !isNumeric(id1)){lid.setText("Input Invalid !");}
            if (fn1.length()<3 || !fn1.matches("^[a-zA-Z]*$")){lfn.setText("Invalid Input !");}
            if (ln1.length()<3 || !ln1.matches("^[a-zA-Z]*$")){lln.setText("Invalid Input !");}
            if (lblgn.getSelectionModel().isEmpty()){lgn.setText("Invalid Input !");}
            if (ph1.length() != 8 || !isNumeric(ph1)){lph.setText("Invalid Input !");}
            if(!mail1.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$")){lmail.setText("Input Invalid !");}
            if (adr1.length()<5){ladr.setText("Input Invalid !");}




        }
else {
            User u = new User(id1, mail1, fn1, ln1, gn1, adr1, ph1, pic1, occu);
            user.add(u);
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("Users.fxml"));
            Parent root = fxml.load();
            btnConf.getScene().setRoot(root);

        }

    }
    @FXML
    private void gotoTeacher(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Users.fxml"));
        Parent root=fxml.load();
        gotoTeacher.getScene().setRoot(root);
    }

    @FXML
    public void initialize() {
        lblgn.getItems().addAll("Male", "Female");
    }

}
