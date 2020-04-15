package GUI.back;




import Entity.Reclamation;
import Service.ServiceReclamation;
import Service.ServiceUser;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.SQLException;

public class ShowReclamation {
    @FXML
    private Label logout;

    @FXML
    private HBox btnRep;

    @FXML
    private HBox btnShow;

    @FXML
    private Label gotoParents;

    @FXML
    private JFXComboBox<String> SearType;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<Reclamation> tableRecla;

    @FXML
    private TableColumn<?, ?> cl_id;

    @FXML
    private TableColumn<?, ?> cl_topic;

    @FXML
    private TableColumn<?, ?> cl_date;

    @FXML
    private TableColumn<?, ?> cl_content;

    @FXML
    void gotoParents(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Users.fxml"));
        Parent root=fxml.load();
        gotoParents.getScene().setRoot(root);
    }

    @FXML
    void logOut(MouseEvent event) {

    }

    @FXML
    void replyClaim(MouseEvent event) throws IOException, SQLException {



        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("replyReclamation.fxml"));
        Parent root = loader.load();
        btnRep.getScene().setRoot(root);

        ReplyReclamation controller = loader.getController();
        controller.initData(tableRecla.getSelectionModel().getSelectedItem());



    }



    @FXML
    void showClaim(MouseEvent event) {

    }

    @FXML
    void readSear(MouseEvent event) {
        String etat=SearType.getValue();
        int ietat = 3;
        if (!etat.isEmpty()){
            if (etat.equals("Waiting")){ietat=1 ;}
            if (etat.equals("Processed")){ietat=2 ;}
            if (etat.equals("Rejected")){ietat=0 ;}

        }

        ObservableList<Reclamation> data = FXCollections.observableArrayList();
        ServiceReclamation rec= new ServiceReclamation();
        try {
            if (ietat != 3) {
                data = (ObservableList<Reclamation>) rec.readByEtat(ietat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        cl_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cl_topic.setCellValueFactory(new PropertyValueFactory<>("type"));
        cl_date.setCellValueFactory(new PropertyValueFactory<>("datecree"));
        cl_content.setCellValueFactory(new PropertyValueFactory<>("message"));





        tableRecla.setItems(data);
    }



    @FXML
    public void initialize() {
        SearType.getItems().addAll("Waiting", "Processed","Rejected");
        ObservableList<Reclamation> data = FXCollections.observableArrayList();
        ServiceReclamation rec = new ServiceReclamation();
        try {

            ServiceUser user = new ServiceUser();
            data= (ObservableList<Reclamation>) rec.readAll() ;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }



        cl_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cl_topic.setCellValueFactory(new PropertyValueFactory<>("type"));
        cl_date.setCellValueFactory(new PropertyValueFactory<>("datecree"));
        cl_content.setCellValueFactory(new PropertyValueFactory<>("message"));





        tableRecla.setItems(data);
    }

}
