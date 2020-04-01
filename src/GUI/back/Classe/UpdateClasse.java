package GUI.back.Classe;

import Entity.Classe;
import Service.ServiceClasse;
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

public class UpdateClasse {


    @FXML
    private Label logout;

    @FXML
    private Label gotoClasse;

    @FXML
    private JFXComboBox<String> cdegree;

    @FXML
    private JFXComboBox<String> cName;

    @FXML
    private JFXTextField cNumber;

    @FXML
    private JFXTextField id;

    @FXML
    private Button btnAdd;



    public void initialize() {
        cdegree.getItems().addAll("1", "2","3","4","5","6");
        cName.getItems().addAll("A", "B","C","D");
    }
    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }

    @FXML
    private void gotoClasse(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Classes.fxml"));
        Parent root=fxml.load();
        gotoClasse.getScene().setRoot(root);
    }
    @FXML
    void AddClasse(MouseEvent event) throws IOException, SQLException {
       String className = cdegree.getValue()+cName.getValue();
       int classNbr = Integer.parseInt(cNumber.getText());
       String idc = id.getText();
       int cid = Integer.parseInt(idc);
        ServiceClasse classe = new ServiceClasse();
        Classe c = new Classe(className,classNbr);
        classe.update(c,cid);
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Classes.fxml"));
        Parent root=fxml.load();
        btnAdd.getScene().setRoot(root);
    }
    public void recupID(int id){
        this.id.setText(String.valueOf(id));
    }



}
