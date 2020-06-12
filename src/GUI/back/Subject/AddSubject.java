package GUI.back.Subject;

import Entity.Classe;
import Entity.Subject;
import Service.ServiceClasse;
import Service.ServiceSubject;
import Utils.DataBase;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddSubject {


    @FXML
    private Label logout;

    @FXML
    private Label gotoSubjects;

    @FXML
    private JFXTextField sName;

    @FXML
    private JFXTextField sCoefficient;

    @FXML
    private JFXComboBox<String> sClasse;

    @FXML
    private Button btnAdd;

    private Connection cnx = DataBase.getInstance().getCnx();

    public void initialize() throws SQLException {
        String AllClasses = "Select * from classe ";
        PreparedStatement pst= cnx.prepareStatement(AllClasses);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String classe = rs.getString(2);
            sClasse.getItems().add(classe);
        }

    }
    @FXML
    void AddSubject(MouseEvent event) throws IOException, SQLException {
        String SubjectName = sName.getText();
        int coefficient = Integer.parseInt(sCoefficient.getText());
        String SubjectByClasse = sClasse.getValue();

        ServiceSubject subject = new ServiceSubject();
        Subject s = new Subject(SubjectName,coefficient,SubjectByClasse);
        subject.ajouter(s);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Subjects.fxml"));
        Parent root=fxml.load();
        btnAdd.getScene().setRoot(root);
    }

    @FXML
    void gotoSubjects(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Subjects.fxml"));
        Parent root=fxml.load();
        gotoSubjects.getScene().setRoot(root);
    }

    @FXML
    void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
        Parent root = fxml.load();
        logout.getScene().setRoot(root);
    }
}
