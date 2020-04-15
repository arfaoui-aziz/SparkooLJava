package GUI.back;

import Entity.ContactTeacher;
import Entity.User;
import Service.ServiceContactTeacher;
import Service.ServiceUser;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class ShowBox implements Initializable {

    @FXML
    private Label logout;

    @FXML
    private HBox gotoHome;

    @FXML
    private HBox gotoTeacher;


    @FXML
    private Label inbox;

    @FXML
    private Label showNew;
    @FXML
    private Label showAll;

    @FXML
    private TableView<ContactTeacher> tabTeacher;


    @FXML
    private TableColumn<?, ?> cl_id;

    @FXML
    private TableColumn<?, ?> cl_sender;

    @FXML
    private TableColumn<?, ?> cl_subject;

    @FXML
    private TableColumn<?, ?> cl_content;

    @FXML
    private TableColumn<?, ?> cl_date;

    @FXML
    private JFXTextField search;

    @FXML
    private HBox btnReply;

    ObservableList<ContactTeacher> data = FXCollections.observableArrayList();
    ServiceContactTeacher ct = new ServiceContactTeacher();

    @FXML
    void gotoHome(MouseEvent event) {

    }

    @FXML
    void gotoTeacher(MouseEvent event) {

    }

    @FXML
    void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root = fxml.load();
        logout.getScene().setRoot(root);
    }

    @FXML
    void showAll(MouseEvent event) {
        showAll.setTextFill(Color.web("#5f8bc5"));
        showNew.setTextFill(Color.web("#485460"));
refresh();
aff(2);
    }
void refresh(){
    for ( int i = 0; i<tabTeacher.getItems().size(); i++) {
        tabTeacher.getItems().clear();
    }
}
    @FXML
    void showNew(MouseEvent event) {
        showNew.setTextFill(Color.web("#5f8bc5"));
        showAll.setTextFill(Color.web("#485460"));

        refresh();
        aff(0);
    }
    public void aff(int i) {
        try {
            ServiceUser usr = new ServiceUser();
            data = (ObservableList<ContactTeacher>) ct.readAll(i);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cl_id.setCellValueFactory((new PropertyValueFactory<>("id")));
        cl_sender.setCellValueFactory(new PropertyValueFactory<>("id_Teacher"));
        cl_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        cl_content.setCellValueFactory(new PropertyValueFactory<>("message"));
        cl_date.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));

        tabTeacher.setItems(data);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
aff(2);
        try {
            setNbNotShowed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setNbNotShowed() throws SQLException {
        ServiceContactTeacher ct = new ServiceContactTeacher();

        inbox.setText("Inbox ("+ct.NumberOfNotShowed()+")");
        showNew.setText("New ("+ct.NumberOfNotShowed()+")");

    }

    @FXML
    void reply(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showMessage.fxml"));
        Parent root = loader.load();
        btnReply.getScene().setRoot(root);

        ShowMessage controller = loader.getController();
        controller.initData(tabTeacher.getSelectionModel().getSelectedItem());


    }

}