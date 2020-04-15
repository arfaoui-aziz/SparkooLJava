package GUI.back;

import Entity.User;
import Service.ServiceUser;
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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class StatParent implements Initializable {

    @FXML
    private PieChart pie;

    @FXML
    private HBox home;

    @FXML
    private Label logout1;

    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root = fxml.load();
        logout1.getScene().setRoot(root);
    }

    private Connection cnx = DataBase.getInstance().getConnexion();
    private Statement ste;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int nbrP=0;
        int nbrS=0;

        try {
            Statement ste = cnx.createStatement();

            ResultSet rss = ste.executeQuery("SELECT * FROM `user` WHERE userType='"+"Student"+"' ;");
            while (rss.next()) {
                nbrS++;
            }

            ResultSet rsp = ste.executeQuery("SELECT * FROM `user` WHERE userType='"+"Parent"+"' ;");
            while (rsp.next()) {
                nbrP++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ObservableList<PieChart.Data> list= FXCollections.observableArrayList();
        list.add(new PieChart.Data("Signed :"+nbrP,nbrP));
        list.add(new PieChart.Data("Not Signed :"+(nbrS-nbrP),nbrS-nbrP));

pie.setData(list);
        pie.setTitle("Signed Parents");
    }
}

