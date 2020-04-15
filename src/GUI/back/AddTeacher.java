package GUI.back;

import Entity.User;
import Service.ServiceUser;
import com.email.durgesh.Email;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import com.jfoenix.controls.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddTeacher {

    ServiceUser user = new ServiceUser();
    @FXML
    private Label logout;

    @FXML
    private Label gotoTeacher;

    @FXML
    private JFXTextField id;

    @FXML
    private Label lid;

    @FXML
    private JFXComboBox<String> gn;

    @FXML
    private Label lgn;

    @FXML
    private JFXTextField adr;

    @FXML
    private Label ladr;

    @FXML
    private Label btnRes;

    @FXML
    private JFXTextField fn;

    @FXML
    private Label lfn;

    @FXML
    private JFXDatePicker bd;

    @FXML
    private Label ldob;

    @FXML
    private JFXTextField ph;

    @FXML
    private Label lph;

    @FXML
    private JFXTextField ln;

    @FXML
    private Label lln;

    @FXML
    private JFXTextField mail;

    @FXML
    private Label lmail;

    @FXML
    private Button pic;

    @FXML
    private Label lpic;

    @FXML
    private Button btnConf;

    @FXML
    private Button Browse;

    private String path="";

    @FXML
    private ImageView showpic;

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

    public void iniLbls(){
        lid.setText("");
        lfn.setText("");
        lln.setText("");
        lph.setText("");
        lpic.setText("");
        ladr.setText("");
        lgn.setText("");
        ldob.setText("");
        lmail.setText("");
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


    @FXML
    void add(MouseEvent event) throws IOException, SQLException, MessagingException {

            iniLbls();
            String id1 = id.getText();
            String mail1 = mail.getText();
            String fn1 = fn.getText();
            String ln1 = ln.getText();
            String gn1 = (String) gn.getValue();
            String adr1 = adr.getText();
            String ph1 = ph.getText();



            if ((path.isEmpty()) || (id1.length() != 8 || !isNumeric(id1) ) || (!mail1.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$") ) || (fn1.length()<3 || !fn1.matches("^[a-zA-Z\\s]*$")) || (ln1.length()<3 || !ln1.matches("^[a-zA-Z\\s]*$")) || (gn.getSelectionModel().isEmpty()) || (adr1.length()<5) || (ph1.length() != 8 || !isNumeric(ph1))  || (bd.getValue() == null || bd.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).compareTo("2000-01-01")==2) ){
               if (id1.length() != 8 || !isNumeric(id1)){lid.setText("Input Invalid !");}
               if (fn1.length()<3 || !fn1.matches("^[a-zA-Z\\s]*$")){lfn.setText("Input Invalid !");}
               if (ln1.length()<3 || !ln1.matches("^[a-zA-Z\\s]*$")){lln.setText("Input Invalid !");}
               if (adr1.length()>5){ladr.setText("Input Invalid !");}
               if (gn.getSelectionModel().isEmpty()){lgn.setText("Select a gender !");}
               if (ph1.length() != 8 || !isNumeric(ph1)){lph.setText("Input Invalid !");}
               if(!mail1.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+
                       "[a-zA-Z0-9_+&*-]+)*@" +
                       "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                       "A-Z]{2,7}$")){lmail.setText("Input Invalid !");}
               if(bd.getValue() == null || bd.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).compareTo("2000-01-01")==2){ldob.setText("Input Invalid !");}
               if (path.isEmpty()){lpic.setText("Please Insert Photo !");}











            }
            else {
                String bd1 = bd.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                User u = new User(id1, mail1, fn1, ln1, gn1, adr1, ph1, path, bd1);
                user.add(u);

                Email email = new Email("amenallah.benayada@esprit.tn","13016198");
                email.setFrom("amenallah.benayada@esprit.tn","Sparkool");
                email.setSubject("Welcome To Sparkool");
                email.setContent("Your Login Information\nUsername:"+fn1+"."+ln1+"\nPassword:"+id1,"text/html");
                email.addRecipient("amenallah.ba98@gmail.com");
                email.send();

                FXMLLoader fxml = new FXMLLoader(getClass().getResource("addDiploma.fxml"));
                Parent root = fxml.load();
                btnConf.getScene().setRoot(root);


                FXMLLoader loader = new FXMLLoader(getClass().getResource("addDiploma.fxml"));
                Parent root1 = (Parent) loader.load();
                AddDiploma secController = loader.getController();
                secController.initData(id.getText());
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            }
            }




    @FXML
    void restAll(MouseEvent event) {
      fn.clear();
      ln.clear();
      adr.clear();
      mail.clear();
      ph.clear();
      path="";
      id.clear();
      gn.valueProperty().set(null);
      bd.setValue(null);
    }

    @FXML
    private void UploadImageTeacher(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("jpeg files (*.jpg)", "*.jpg","jpeg files (*.png)", "*.png","jpeg files (*.jpeg)", "*.jpeg");
        fileChooser.getExtensionFilters().add(extFilter);
        Window primaryStage = null;
        File file = fileChooser.showOpenDialog(primaryStage);
        if(file==null) return ;
        this.path=file.getPath();
        File file1 = new File(path);
        Image image = new Image(file1.toURI().toString());
        showpic.setImage(image);
    }

}
