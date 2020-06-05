package GUI.back.Classe;

import Entity.User;
import Service.ServiceClasse;
import Service.ServiceUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClassAssign implements Initializable {

    @FXML
    private TextField stname;
    @FXML
    private ComboBox Classto;
    @FXML
    private TextField nbrof;
    @FXML
    private Button assignbt;
@FXML
    private HBox students;

    public void maindata(User selectedItem){

        stname.setText(selectedItem.getId());
        nbrof.setText(selectedItem.getId());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            Classcombo();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Classcombo() throws SQLException {
        ServiceClasse classe = new ServiceClasse();
        ServiceUser user = new ServiceUser();
        int old_class = user.getold(stname.getText());
        String old_name = classe.getclass_name(old_class);
        Classto.getItems().addAll(classe.ClassList());

    }

    public void getplacesnb() throws SQLException {
        ServiceClasse classe = new ServiceClasse();

        int nbr =classe.getNumber(Classto.getSelectionModel().getSelectedItem().toString());

        nbrof.setText(String.valueOf(nbr));

    }

    public void assignStudent() throws SQLException {
        ServiceUser user = new ServiceUser();
        ServiceClasse classe = new ServiceClasse();
        int old_class = user.getold(stname.getText());
        String old_name = classe.getclass_name(old_class);
        int old_nbr = classe.getNumber(old_name);
        int classe_id = classe.getclass_id(Classto.getSelectionModel().getSelectedItem().toString());
        String classe_name = classe.getclass_name(classe_id);
        System.out.println(old_name);
        System.out.println(classe_name);

        if (old_class != 0 && classe_id!=old_class)
        {
            user.assignStudent(classe_id,stname.getText());
            classe.updatebr(old_nbr+1,old_name);
            classe.updatebr(Integer.parseInt(nbrof.getText())-1,classe_name);

        }
        else
        {
            System.out.println("Same one");
        }

    }

    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/back/Student/Students.fxml"));
        Parent root=fxml.load();
        students.getScene().setRoot(root);
    }



}
