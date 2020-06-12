package GUI.back.Forum;

import Entity.User;
import GUI.back.Student.StudentModify;
import GUI.back.Student.Students;
import Service.ServiceForum;
import Service.ServiceUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ForumList implements Initializable {



    @FXML
    private TableView<Entity.Forum> Forumlist ;

    @FXML
    private TableColumn<?, ?> titlefm;

    @FXML
    private TableColumn<?, ?> typefm;
    @FXML
    private TableColumn<?, ?> subfm;

    @FXML
    private TableColumn<?, ?> datefm;
    @FXML
    private TableColumn<?, ?> etatfm;
    @FXML
    private TableColumn<?, ?> solvefm;
    @FXML
    private TableColumn<?, ?> nbrfm;
    @FXML
    private TableColumn<?, ?> auteurfm;
    @FXML
    private TableColumn<Forum, Void> deletefm;
    @FXML
    private Text lblName;

    @FXML
    private HBox gotoStudt;

    @FXML
    private Label logout;


    public void maindata(String UserN){
        lblName.setText(UserN);
        System.out.println(UserN);
    }




    @FXML
    private void gotoStudent(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/back/Student/Students.fxml"));
        Parent root = loader.load();
        gotoStudt.getScene().setRoot(root);
        Students controller = loader.getController();
        controller.maindata(lblName.getText());
    }
    @FXML
    private TableColumn<Forum, Void> modifyfm;

    ObservableList<Entity.Forum> data = FXCollections.observableArrayList();
    public void ListForum(){
        try {
            ServiceForum fm = new ServiceForum();
            data= (ObservableList<Entity.Forum>) fm.ForumList() ;
            System.out.println(data);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        titlefm.setCellValueFactory(new PropertyValueFactory<>("title"));
        typefm.setCellValueFactory(new PropertyValueFactory<>("type"));
        subfm.setCellValueFactory(new PropertyValueFactory<>("subject"));
        datefm.setCellValueFactory(new PropertyValueFactory<>("dateajout"));
        etatfm.setCellValueFactory(new PropertyValueFactory<>("etat"));
        solvefm.setCellValueFactory(new PropertyValueFactory<>("solved"));
        nbrfm.setCellValueFactory(new PropertyValueFactory<>("nbreponse"));
        auteurfm.setCellValueFactory(new PropertyValueFactory<>("auteur_id"));
        Callback<TableColumn<Forum, Void>, TableCell<Forum, Void>> UpdateButton = new Callback<TableColumn<Forum, Void>, TableCell<Forum, Void>>() {
            @Override
            public TableCell<Forum, Void> call(final TableColumn<Forum, Void> param) {

                final TableCell<Forum, Void> cell = new TableCell<Forum, Void>() {
                    private final Button btn1 = new Button("Update");
                    {
                        btn1.setOnAction((ActionEvent event) -> {
                            ServiceForum Forum = new ServiceForum();
                            Entity.Forum u = Forumlist.getItems().get(getIndex());
                            try {
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(getClass().getResource("/GUI/back/Forum/ModifySubject.fxml"));
                                Parent root = loader.load();
                                btn1.getScene().setRoot(root);
                                ModifySubject controller = loader.getController();
                                controller.maindata(Forumlist.getItems().get(getIndex()),lblName.getText());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn1);
                        }
                    }
                };
                return cell;
            }

        };

        Callback<TableColumn<Forum, Void>, TableCell<Forum, Void>> DeleteButton = new Callback<TableColumn<Forum, Void>, TableCell<Forum, Void>>() {
            @Override
            public TableCell<Forum, Void> call(final TableColumn<Forum, Void> param) {

                final TableCell<Forum, Void> cell = new TableCell<Forum, Void>() {
                    private final Button btn = new Button("Delete");
                    {
                        btn.setOnAction((ActionEvent event) -> {

                            ServiceForum form = new ServiceForum();
                            Entity.Forum f = Forumlist.getItems().get(getIndex());
                            try {
                                Forumlist.getItems().removeAll(Forumlist.getItems().get(getIndex()));
                                form.deletesubj(f.getId());
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }


                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }

        };

        modifyfm.setCellFactory(UpdateButton);
        deletefm.setCellFactory(DeleteButton);
        Forumlist.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ListForum();
    }
    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }
}
