package GUI.back;

import Entity.Reclamation;
import Service.ServiceReclamation;
import Service.ServiceUser;
import com.email.durgesh.Email;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;

public class ReplyReclamation {


    @FXML
    private TextField idRec;

    @FXML
    private Label logout;

    @FXML
    private Label gotoTeacher;

    @FXML
    private Label lblNom;

    @FXML
    private Text lblMess;

    @FXML
    private JFXTextArea RepField;

    @FXML
    private Button btnRej;

    @FXML
    private Button btnRep;

    @FXML
    void gotoTeacher(MouseEvent event) {

    }

    @FXML
    void logOut(MouseEvent event) {

    }

    @FXML
    void btnRej(MouseEvent event) throws IOException, SQLException, MessagingException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("showReclamation.fxml"));
        Parent root=fxml.load();
        btnRep.getScene().setRoot(root);

        ServiceReclamation rec = new ServiceReclamation();
String mess=RepField.getText();
        rec.RejClaim( Integer.parseInt(idRec.getText()));
        Email email = new Email("youssef.ghedas@esprit.tn","Bigboss10");
        email.setFrom("youssef.ghedas@esprit.tn","Sparkool");
        email.setSubject("Réclamation Parent");
        email.setContent("<h1>votre réclamation a été rejeté </h1>"+mess,"text/html");
        email.addRecipient("youssefghedas100@gmail.com");
        email.send();




    }

    @FXML
    void btnRep(MouseEvent event) throws IOException, SQLException, MessagingException {

        FXMLLoader fxml=new FXMLLoader(getClass().getResource("showReclamation.fxml"));
        Parent root=fxml.load();
        btnRep.getScene().setRoot(root);

        ServiceReclamation rec = new ServiceReclamation();

        rec.addReply(RepField.getText(), Integer.parseInt(idRec.getText()));
        Email email = new Email("youssef.ghedas@esprit.tn","Bigboss10");
        email.setFrom("youssef.ghedas@esprit.tn","Sparkool");
        email.setSubject("Réclamation Parent");
        email.setContent("<h1>votre réclamation a été tariter </h1>"+RepField.getText(),"text/html");
        email.addRecipient("youssefghedas100@gmail.com");
        email.send();

    }

    public String getNomUser(String id) throws SQLException {
        ServiceUser user = new ServiceUser();
        String nom=user.getnomU(id);
        return nom;
    }

    public void initData(Reclamation selectedItem) throws SQLException {
        lblMess.setText(selectedItem.getMessage());
        String id= String.valueOf(selectedItem.getId_Parent());
        String nom=getNomUser(id);
        lblNom.setText(nom);
        String id1= Integer.toString(selectedItem.getId());
        idRec.setText(id1);

    }

}
