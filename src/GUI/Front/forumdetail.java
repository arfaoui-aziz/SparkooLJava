package GUI.Front;

import Entity.Commentaire;
import Entity.Forum;
import Entity.User;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import javax.mail.FetchProfile;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class forumdetail implements Initializable {


    @FXML
    private Label lblName;
    @FXML
    private Label title;
    @FXML
    private Label subject;
    @FXML
    private Label author;
    @FXML
    private Label like;
    @FXML
    private Label dislike;
    @FXML
    private TableView<Commentaire>  commentst;
    @FXML
    private TableColumn<?, ?> comments;
    @FXML
    private TableColumn<?, ?> commentor;
    @FXML
    private TableColumn<Commentaire, Void> edit;

    @FXML
    private TextField commentsection;
    @FXML
    private Button solved;
    @FXML
    private Button submit;

    @FXML
    private VBox home;
    @FXML
    private VBox btnInfo;
    @FXML
    private VBox btnMarks;
    @FXML
    private VBox btnCourse;
    @FXML
    private VBox btnMessage;
    @FXML
    private VBox btnSignout;


    private int subjectid;
    ObservableList<Entity.Commentaire> data = FXCollections.observableArrayList();
    public void maindata(Forum selectedItem , String user) throws SQLException {
        ServiceForum Forum = new ServiceForum();

        lblName.setText(user);
        title.setText(selectedItem.getTitle());
        subject.setText(selectedItem.getSubject());
        author.setText(selectedItem.getAuteur_id());
        subjectid=selectedItem.getId();
        like.setText(Integer.toString(Forum.showlike(selectedItem.getId())));
        if (selectedItem.getSolved() == 1)
        {
            commentsection.setDisable(true);
            submit.setDisable(true);
            solved.setDisable(true);
        }
        Listcomments(selectedItem.getId());


    }

    public void Listcomments(int subject) {
        try {
            ServiceForum fm = new ServiceForum();
            data = (ObservableList<Commentaire>) fm.Commentslist(subject);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        comments.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        commentor.setCellValueFactory(new PropertyValueFactory<>("comentor_id"));

        if( author.getText().equals(lblName.getText()))
        {
            System.out.println("00000000000000000000000000000000000000000000000000000000000");
            solved.setVisible(true);
        }
        commentst.setItems(data);



    }

    public void votelike() throws SQLException {
        ServiceForum Forum = new ServiceForum();


        if (Forum.voted(lblName.getText()) == 0 )
        {

            boolean acces = Forum.like(lblName.getText(),subjectid, (byte) 0);
        }
        if (Forum.showstatus(subjectid,lblName.getText()) == 1 )
        {
            Forum.updatelike(subjectid,lblName.getText());
        }
        like.setText(Integer.toString(Forum.showlike(subjectid)));
        dislike.setText(Integer.toString(Forum.showdislike(subjectid)));

    }


    public void votedislike() throws SQLException {
        ServiceForum Forum = new ServiceForum();

System.out.println(Forum.showstatus(subjectid,lblName.getText()));
        if (Forum.voted(lblName.getText()) == 0 )
        {
            boolean acces = Forum.dislike(lblName.getText(),subjectid, (byte) 1);
        }
        if (Forum.showstatus(subjectid,lblName.getText()) == 0 )
        {
            Forum.updatedislike(subjectid,lblName.getText());
        }
        dislike.setText(Integer.toString(Forum.showdislike(subjectid)));
        like.setText(Integer.toString(Forum.showlike(subjectid)));

    }



    public void submitcomment() throws SQLException {
        ServiceForum Forum = new ServiceForum();
        Forum.commentsubmit(lblName.getText(),subjectid,commentsection.getText());
        Listcomments(subjectid);
    }

    public void solvedsubject() throws SQLException {
        ServiceForum Forum = new ServiceForum();
        Forum.solved(subjectid);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println(subject.getText());

    }
    @FXML
    void gotoHome(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Front/HomeFront.fxml"));
            Parent root = loader.load();
            home.getScene().setRoot(root);
            Home controller = loader.getController();
            controller.maindata(lblName.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gotoMarks(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Front/marks.fxml"));
        Parent root = loader.load();
        btnMarks.getScene().setRoot(root);
        marks controller = loader.getController();
        controller.maindata(lblName.getText());


    }

    @FXML
    void gotoForum(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Front/forumlist.fxml"));
        Parent root = loader.load();
        btnMarks.getScene().setRoot(root);
        ForumList controller = loader.getController();
        controller.maindata(lblName.getText());
    }
    @FXML
    void gotoaddman(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Front/addsubject.fxml"));
        Parent root = loader.load();
        btnMessage.getScene().setRoot(root);
        addsubject controller = loader.getController();
        controller.maindata(lblName.getText());
    }

    @FXML
    void gotologin(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/login.fxml"));
        Parent root = loader.load();
        btnSignout.getScene().setRoot(root);
    }

    @FXML
    void gotoInformation(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/Front/information.fxml"));
            Parent root = loader.load();
            btnInfo.getScene().setRoot(root);
            information controller = loader.getController();
            ServiceUser user = new ServiceUser();
            User User1 = user.getStud(lblName.getText());
            controller.maindata(User1);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
