package GUI.back;

import Entity.Delay;
import Entity.User;
import Service.ServiceAbsence;
import Service.ServiceContactTeacher;
import Service.ServiceDelay;
import Service.ServiceUser;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class ShowAbsence implements Initializable {

    @FXML
    private Label logout;

    @FXML
    private JFXComboBox<String> uy;

    @FXML
    private JFXComboBox<String> week;

    @FXML
    private ImageView mn;

    @FXML
    private ImageView tu;

    @FXML
    private ImageView we;

    @FXML
    private ImageView th;

    @FXML
    private ImageView fr;

    @FXML
    private ImageView sa;

    @FXML
    private Button btnSearch;
    @FXML
    private JFXDatePicker date1;

    @FXML
    private JFXDatePicker date2;

    @FXML
    private Label weekN;

    @FXML
    private TextField idT;

    @FXML
    private VBox table;





    @FXML
    private TableView<Delay> tabDelay;

    @FXML
    private TableColumn<?, ?> cl_day;

    @FXML
    private TableColumn<?, ?> cl_duration;
    @FXML
    void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root = fxml.load();
        logout.getScene().setRoot(root);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        week.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36");
        uy.getItems().addAll("2019-20","2018-19","2017-18");
    }

    public void setImg(ImageView day) {
        File file = new File("src/GUI/image/icons8-delete.png");
        Image image = new Image(file.toURI().toString());
        day.setImage(image);
    }

    public void recherche(ActionEvent event) throws SQLException {
        File file = new File("src/GUI/image/icons8-checkmark.png");
        Image image = new Image(file.toURI().toString());
        mn.setImage(image);
        tu.setImage(image);
        we.setImage(image);
        th.setImage(image);
        fr.setImage(image);
        sa.setImage(image);
        table.setVisible(true);
        String uy1 = (String) uy.getValue();
        String week1 = (String) week.getValue();

        weekN.setText("Week "+week1);

        ServiceAbsence sAb = new ServiceAbsence();
        ArrayList<String> arrDays = new ArrayList<String>();

        arrDays=sAb.showAbsences(week1,uy1,idT.getText());

        for (int i = 0; i < arrDays.size(); i++) {
            String jj=arrDays.get(i);
            if (Objects.equals("Monday", jj)) {
                setImg(mn);
            }
            if (Objects.equals("Tuesday", jj)) {
                setImg(tu);
            }
            if (Objects.equals("Wednesday", jj)) {
                setImg(we);
            }
            if (Objects.equals("Thursay", jj)) {
                setImg(th);
            }if (Objects.equals("Friday", jj)) {
                setImg(fr);
            }
            if (Objects.equals("Sturday", jj)) {
                setImg(sa);
            }
        }

    }


    public void initData(String id) {
idT.setText(id);
    }

    @FXML
    void SearchByDate(ActionEvent event) {
        String id=idT.getText();
        String d1= String.valueOf(date1.getValue());
        String d2= String.valueOf(date2.getValue());

        ObservableList<Delay> data = FXCollections.observableArrayList();
        ServiceDelay delay = new ServiceDelay();
        try {
            ServiceUser usr = new ServiceUser();
            data = (ObservableList<Delay>) delay.readByDate(id,d1,d2);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cl_day.setCellValueFactory(new PropertyValueFactory<>("jour"));
        cl_duration.setCellValueFactory(new PropertyValueFactory<>("duree"));


        tabDelay.setItems(data);


    }


}
