package GUI.back;

import Entity.Diploma;
import Entity.User;
import Service.ServiceDiploma;
import Service.ServiceUser;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class DetailTeacher {
    @FXML
    private Label logout;

    @FXML
    private HBox gotoTeacher;

    @FXML
    private Label gotoTeacher1;

    @FXML
    private Label lblFLname;

    @FXML
    private Label lbfn;

    @FXML
    private Label lbln;

    @FXML
    private Label lbg;

    @FXML
    private Label lbad;

    @FXML
    private Label lbph;

    @FXML
    private Label lbbd;

    @FXML
    private Label lbm;

    @FXML
    private Label lblInti;

    @FXML
    private Label lblsch;

    @FXML
    private Label lblspe;

    @FXML
    private Label lblobd;

    @FXML
    private Label lblvl;

    @FXML
    private ImageView btnModif;

    @FXML
    private TextField idT;

    @FXML
    private ImageView pic;

    ObservableList<User> data = FXCollections.observableArrayList();
    ServiceUser user = new ServiceUser();

    @FXML
    private void gotoTeatcher(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("teachers.fxml"));
        Parent root = fxml.load();
        gotoTeacher.getScene().setRoot(root);
    }

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root = fxml.load();
        logout.getScene().setRoot(root);
    }

    public void setLabels(User selectedItem) throws SQLException {


        String idN = selectedItem.getId();

        ServiceUser usr = new ServiceUser();
        User use = (User) user.readById(idN);

        ServiceDiploma dipS = new ServiceDiploma();
        Diploma dip = (Diploma) dipS.readById(idN);

        File file = new File(use.getPicture());
        Image image = new Image(file.toURI().toString());
        pic.setImage(image);

        lbfn.setText(use.getFirstName());
        lbln.setText(use.getLastName());
        lbg.setText(use.getGender());
        lbad.setText(use.getBirthDay());
        lbph.setText(use.getPhone());
        lbbd.setText(use.getBirthDay());
        lbm.setText(use.getEmail());
        idT.setText(idN);
        lblInti.setText(dip.getIntitule());
        lblsch.setText(dip.getEcole());
        lblspe.setText(dip.getSpecialite());
        lblobd.setText(dip.getDate_obtentation());
        lblvl.setText(dip.getNiveau());


    }


    @FXML
    void dipModif(MouseEvent event) throws IOException {


        Stage primaryStage = new Stage();


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ModifyDiploma.fxml"));
        Parent root = loader.load();
        btnModif.getScene().setRoot(root);
        ModifyDiploma controller = loader.getController();
        controller.initData(lblInti.getText(), lblsch.getText(), lblspe.getText(), lblobd.getText(), lblvl.getText(),idT.getText());


    }

    @FXML
    void Absence(MouseEvent event) throws IOException {


        FXMLLoader fxml = new FXMLLoader(getClass().getResource("showAbsence.fxml"));
        Parent root = fxml.load();
        logout.getScene().setRoot(root);


    }
}
