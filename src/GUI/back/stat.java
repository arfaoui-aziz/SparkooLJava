package GUI.back;

import Utils.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class stat implements Initializable {

    @FXML
    private Label logout;

    @FXML
    private Pane paneView;

    @FXML
    private HBox gotoTeacher;
    @FXML
    private HBox gotoAccount;
    @FXML
    private HBox Classe;
    private Connection cnx = DataBase.getInstance().getCnx();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
int nbrAdmin=0;
int nbrStud=0;
int nbrTeach=0;
int nbrParent=0;
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery("SELECT * FROM `user` WHERE userType='"+"Administrator"+"' ;");
            while (rs.next()) {
nbrAdmin++;
            }
            ResultSet rss = ste.executeQuery("SELECT * FROM `user` WHERE userType='"+"Student"+"' ;");
            while (rss.next()) {
                nbrStud++;
            }
            ResultSet rst = ste.executeQuery("SELECT * FROM `user` WHERE userType='"+"Teacher"+"' ;");
            while (rst.next()) {
                nbrTeach++;
            }
            ResultSet rsp = ste.executeQuery("SELECT * FROM `user` WHERE userType='"+"Parent"+"' ;");
            while (rsp.next()) {
                nbrParent++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        paneView.getChildren().clear();
        ObservableList<PieChart.Data> list= FXCollections.observableArrayList();
        list.add(new PieChart.Data("Student",nbrStud));
        list.add(new PieChart.Data("Teacher",nbrTeach));
        list.add(new PieChart.Data("Parent",nbrParent));
        list.add(new PieChart.Data("Administrator",nbrAdmin));
        PieChart UserTypeChart =new PieChart(list);
        UserTypeChart.setTitle("Users Percentage Per Type");
        paneView.getChildren().add(UserTypeChart);
    }
    @FXML
    private void gotoTeatcher(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Users.fxml"));
        Parent root=fxml.load();
        gotoTeacher.getScene().setRoot(root);
    }

    @FXML
    private void gotoClasse(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Classe/Classes.fxml"));
        Parent root=fxml.load();
        Classe.getScene().setRoot(root);
    }
    @FXML
    private void gotoAccount(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Users.fxml"));
        Parent root=fxml.load();
        gotoAccount.getScene().setRoot(root);
    }
    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("../login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }


}
