package GUI.front.Dark;

import Entity.Diploma;
import Entity.User;
import GUI.front.Light.LightHome;
import Service.ServiceAbsence;
import Service.ServiceDelay;
import Service.ServiceDiploma;
import Service.ServiceUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class DAttendanceSheet {

    User user;

    @FXML
    private ImageView btnVoice;
    @FXML
    private HBox btnTheme;

    @FXML
    private Circle photo;

    @FXML
    private Label lblName;

    @FXML
    private Label lblType;

    @FXML
    private Label lblSpeciality;

    @FXML
    private VBox btnHome;

    @FXML
    private VBox btnInfo;

    @FXML
    private VBox btnShedule;

    @FXML
    private VBox btnCourse;

    @FXML
    private VBox btnMessage;

    @FXML
    private VBox btnMarks;

    @FXML
    private VBox btnAccount;

    @FXML
    private VBox btnSignout;

    @FXML
    private Label lblNom;

    @FXML
    private Label lblGn;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblMail;

    @FXML
    private Label lblSpe;

    @FXML
    private Label lblND;

    @FXML
    private Label lblNA;
    @FXML
    private Label lblID;

    @FXML
    private VBox searchBox;

    @FXML
    private TextField inputWeek;

    @FXML
    private Label lblerror;

    @FXML
    private Button btnSearch;

    @FXML
    private VBox tableAb;

    @FXML
    private Label Nweek;

    @FXML
    private ImageView mon;

    @FXML
    private ImageView tue;

    @FXML
    private ImageView wed;

    @FXML
    private ImageView thu;

    @FXML
    private ImageView fr;

    @FXML
    private ImageView sa;

    @FXML
    void speak(MouseEvent event) {
        String source = new File("/Users/amen/Documents/SparkoolGit/src/GUI/sound/Info.mp4").toURI().toString();
        Media media = null;
        media = new Media(source);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    @FXML
    void gotoAccount(MouseEvent event) throws IOException, SQLException {

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DModifyLogin.fxml"));
        Parent root = fxml.load();
        btnAccount.getScene().setRoot(root);
        DModifyLogin controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoCourses(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DShowCourses.fxml"));
        Parent root = fxml.load();
        btnCourse.getScene().setRoot(root);
        DShowCourses controller = fxml.getController();
        controller.initData(user);
    }
    @FXML
    void gotoHome(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getClassLoader().getResource("DarkHome.fxml"));
        Parent root = fxml.load();
        btnTheme.getScene().setRoot(root);
        DarkHome controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoInfo(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DAttendanceSheet.fxml"));
        Parent root = fxml.load();
        btnInfo.getScene().setRoot(root);
        DAttendanceSheet controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoMarks(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DAddMark.fxml"));
        Parent root = fxml.load();
        btnMarks.getScene().setRoot(root);
        DAddMark controller = fxml.getController();
        controller.initData(user);


    }

    @FXML
    void gotoMessage(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DContact.fxml"));
        Parent root = fxml.load();
        btnInfo.getScene().setRoot(root);
        DContact controller = fxml.getController();
        controller.initData(user);



    }

    @FXML
    void gotoShedule(MouseEvent event) throws IOException, SQLException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("DShowSchedule.fxml"));
        Parent root = fxml.load();
        btnCourse.getScene().setRoot(root);
        DShowSchedule controller = fxml.getController();
        controller.initData(user);
    }

    @FXML
    void gotoSignout(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root = fxml.load();
        btnSignout.getScene().setRoot(root);
    }

    public static boolean isNumeric(final String str) {

        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;

    }

    @FXML
    void searchAb(MouseEvent event) throws SQLException {
        lblerror.setText("");
        File file1 = new File("src/GUI/image/front/icons8-tick_box.png");
        Image image1 = new Image(file1.toURI().toString());
        mon.setImage(image1);
        tue.setImage(image1);
        wed.setImage(image1);
        thu.setImage(image1);
        fr.setImage(image1);
        sa.setImage(image1);

        if (inputWeek.getText().isEmpty() || !isNumeric(inputWeek.getText()) || Integer.parseInt(inputWeek.getText()) > 36 || Integer.parseInt(inputWeek.getText()) < 1 ){
            lblerror.setText("Number must be between 1 and 36");

        }
        else {
            tableAb.setVisible(true);
            Nweek.setText("Week " + inputWeek.getText());

            ServiceAbsence sAb = new ServiceAbsence();
            ArrayList<String> arrDays = new ArrayList<String>();
            File file = new File("src/GUI/image/front/icons8-close_window.png");
            Image image = new Image(file.toURI().toString());

            arrDays = sAb.showAbsences(inputWeek.getText(), "2019-20", user.getId());

            for (int i = 0; i < arrDays.size(); i++) {
                String jj = arrDays.get(i);
                if (Objects.equals("Monday", jj)) {
                    mon.setImage(image);
                }
                if (Objects.equals("Tuesday", jj)) {
                    tue.setImage(image);
                }
                if (Objects.equals("Wednesday", jj)) {
                    wed.setImage(image);
                }
                if (Objects.equals("Thursay", jj)) {
                    thu.setImage(image);
                }
                if (Objects.equals("Friday", jj)) {
                    fr.setImage(image);
                }
                if (Objects.equals("Sturday", jj)) {
                    sa.setImage(image);
                }
            }


        }
    }

    @FXML
    void showBox(MouseEvent event) {
        searchBox.setVisible(true);

    }

    @FXML
    void switchTheme(MouseEvent event) {

    }

    public void initData(User u) throws SQLException {

        lblName.setText(u.getFirstName()+' '+u.getLastName());
        ServiceDiploma d= new ServiceDiploma();
        Diploma dp = d.readById(u.getId());
        lblSpeciality.setText(dp.getSpecialite());
        lblType.setText(u.getUserType());
        File file = new File(u.getPicture());
        Image image = new Image(file.toURI().toString());
        photo.setFill(new ImagePattern(image));
        user=u;

        ServiceUser usr=new ServiceUser();
        User us = usr.readById(u.getId());
        lblNom.setText(lblName.getText());
        lblGn.setText(us.getGender());
        lblPhone.setText("+216 "+us.getPhone());
        lblMail.setText(us.getEmail());
        lblSpe.setText(lblSpeciality.getText());
        lblID.setText(u.getId());



        ServiceAbsence ab = new ServiceAbsence();
        ServiceDelay de = new ServiceDelay();
        if (Integer.parseInt(ab.NumberOfAbsence(u.getId())) > 5 ){
            lblNA.setText(ab.NumberOfAbsence(u.getId()) + " (You're in the Red Zone️)");
        }
        else {lblNA.setText(ab.NumberOfAbsence(u.getId()));}

        lblND.setText(de.NumberOfDelay(u.getId()));







    }
}
