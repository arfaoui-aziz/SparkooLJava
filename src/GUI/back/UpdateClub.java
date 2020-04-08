package GUI.back;

import Entity.Club;
import Service.ServiceClub;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UpdateClub {

    @FXML
    private Label logout;

    @FXML
    private Label AllClubs;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXTextField activity;

    @FXML
    private JFXTextField clubName;

    @FXML
    private JFXTextField budget1;

    @FXML
    private JFXTextField members;

    @FXML
    private JFXDatePicker dateCr;

    @FXML
    private Button updateClub;


    @FXML
    void AllEvents(MouseEvent event) {

    }

    @FXML
    void logOut(MouseEvent event)throws IOException {
       }

    ServiceClub NewClub = new ServiceClub();


    public void setDefaultText(int id,String clubName, int members,String activity,Float budget1,String dateCr) {

        this.id.setText(String.valueOf((id)));
        this.clubName.setText(clubName);
        this.members.setText(String.valueOf(members));
        this.activity.setText(activity);
        this.budget1.setText(String.valueOf(budget1));
        this.dateCr.setValue(LocalDate.parse(dateCr));

    }


        @FXML
       void updateC(MouseEvent event) throws SQLException, IOException {
            int idc= Integer.parseInt(id.getText());
            String name=clubName.getText();
            int memb = Integer.parseInt(members.getText());
            String act=activity.getText();
            Float budgeetc = Float.parseFloat(budget1.getText() );
            String datecR = dateCr.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            Club c = new Club(idc,name,memb,act,budgeetc,datecR);
            ServiceClub cl = new ServiceClub();
            cl.update(c,idc);
            FXMLLoader fxml=new FXMLLoader(getClass().getResource("AllClubs.fxml"));
            Parent root=fxml.load();
            updateClub.getScene().setRoot(root);
        }

    }

