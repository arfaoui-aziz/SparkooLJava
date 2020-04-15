package GUI.front.Dark;

import Entity.Diploma;
import Entity.SheduleTeacher;
import Entity.User;
import GUI.front.Light.LightHome;
import Service.ServiceDiploma;
import Service.ServiceScheduleTeacher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class DShowSchedule {

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
    private VBox M1;

    @FXML
    private Label mn1;

    @FXML
    private Label mn11;

    @FXML
    private VBox T1;

    @FXML
    private Label tu1;

    @FXML
    private Label tu11;

    @FXML
    private VBox W1;

    @FXML
    private Label we1;

    @FXML
    private Label we11;

    @FXML
    private VBox TH1;

    @FXML
    private Label th1;

    @FXML
    private Label th11;

    @FXML
    private VBox F1;

    @FXML
    private Label fr1;

    @FXML
    private Label fr11;

    @FXML
    private VBox S1;

    @FXML
    private Label sa1;

    @FXML
    private Label sa11;

    @FXML
    private VBox M2;

    @FXML
    private Label mn2;

    @FXML
    private Label mn21;

    @FXML
    private VBox T2;

    @FXML
    private Label tu2;

    @FXML
    private Label tu21;

    @FXML
    private VBox W2;

    @FXML
    private Label we2;

    @FXML
    private Label we21;

    @FXML
    private VBox TH2;

    @FXML
    private Label th2;

    @FXML
    private Label th21;

    @FXML
    private VBox F2;

    @FXML
    private Label fr2;

    @FXML
    private Label fr21;

    @FXML
    private VBox S2;

    @FXML
    private Label sa2;

    @FXML
    private Label sa21;

    @FXML
    private VBox M3;

    @FXML
    private Label mn3;

    @FXML
    private Label mn31;

    @FXML
    private VBox T3;

    @FXML
    private Label tu3;

    @FXML
    private Label tu31;

    @FXML
    private VBox W3;

    @FXML
    private Label we3;

    @FXML
    private Label we31;

    @FXML
    private VBox TH3;

    @FXML
    private Label th3;

    @FXML
    private Label th31;

    @FXML
    private VBox F3;

    @FXML
    private Label fr3;

    @FXML
    private Label fr31;

    @FXML
    private VBox S3;

    @FXML
    private Label sa3;

    @FXML
    private Label sa31;

    @FXML
    private VBox M4;

    @FXML
    private Label mn4;

    @FXML
    private Label mn41;

    @FXML
    private VBox T4;

    @FXML
    private Label tu4;

    @FXML
    private Label tu41;

    @FXML
    private VBox W4;

    @FXML
    private Label we4;

    @FXML
    private Label we41;

    @FXML
    private VBox TH4;

    @FXML
    private Label th4;

    @FXML
    private Label th41;

    @FXML
    private VBox F4;

    @FXML
    private Label fr4;

    @FXML
    private Label fr41;

    @FXML
    private VBox S4;

    @FXML
    private Label sa4;

    @FXML
    private Label sa41;

    @FXML
    void addF1(MouseEvent event) {

    }

    @FXML
    void addF2(MouseEvent event) {

    }

    @FXML
    void addF3(MouseEvent event) {

    }

    @FXML
    void addF4(MouseEvent event) {

    }

    @FXML
    void addM1(MouseEvent event) {

    }

    @FXML
    void addM2(MouseEvent event) {

    }

    @FXML
    void addM3(MouseEvent event) {

    }

    @FXML
    void addM4(MouseEvent event) {

    }

    @FXML
    void addSA1(MouseEvent event) {

    }

    @FXML
    void addSA2(MouseEvent event) {

    }

    @FXML
    void addSA3(MouseEvent event) {

    }

    @FXML
    void addSA4(MouseEvent event) {

    }

    @FXML
    void addT1(MouseEvent event) {

    }

    @FXML
    void addT3(MouseEvent event) {

    }

    @FXML
    void addT4(MouseEvent event) {

    }

    @FXML
    void addTH1(MouseEvent event) {

    }

    @FXML
    void addTH2(MouseEvent event) {

    }

    @FXML
    void addTH3(MouseEvent event) {

    }

    @FXML
    void addTH4(MouseEvent event) {

    }

    @FXML
    void addW1(MouseEvent event) {

    }

    @FXML
    void addW2(MouseEvent event) {

    }

    @FXML
    void addW3(MouseEvent event) {

    }

    @FXML
    void addW4(MouseEvent event) {

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


    @FXML
    void switchTheme(MouseEvent event) {

    }

String id="";
    User user;
    public void affich() throws SQLException {
        ServiceScheduleTeacher sst = new ServiceScheduleTeacher();
        SheduleTeacher st;

        if(sst.read(id,"Monday","1")!=null){ st=sst.read(id,"Monday","1");mn1.setText(st.getSubject());mn11.setText(st.getClasse());}
        if(sst.read(id,"Monday","2")!=null){ st=sst.read(id,"Monday","2");mn2.setText(st.getSubject());mn21.setText(st.getClasse());}
        if(sst.read(id,"Monday","3")!=null){ st=sst.read(id,"Monday","2");mn3.setText(st.getSubject());mn31.setText(st.getClasse());}
        if(sst.read(id,"Monday","4")!=null){st=sst.read(id,"Monday","4");mn4.setText(st.getSubject());mn41.setText(st.getClasse());}

        if(sst.read(id,"Tuesday","1")!=null){st=sst.read(id,"Tuesday","1");tu1.setText(st.getSubject());tu11.setText(st.getClasse());}
        if(sst.read(id,"Tuesday","2")!=null){ st=sst.read(id,"Tuesday","2");tu2.setText(st.getSubject());tu21.setText(st.getClasse());}
        if(sst.read(id,"Tuesday","3")!=null){ st=sst.read(id,"Tuesday","3");tu3.setText(st.getSubject());tu31.setText(st.getClasse());}
        if(sst.read(id,"Tuesday","4")!=null){ st=sst.read(id,"Tuesday","4");tu4.setText(st.getSubject());tu41.setText(st.getClasse());}


        if(sst.read(id,"Wednesday","1")!=null){ st=sst.read(id,"Wednesday","1");we1.setText(st.getSubject());we11.setText(st.getClasse());}
        if(sst.read(id,"Wednesday","2")!=null){st=sst.read(id,"Wednesday","2");we2.setText(st.getSubject());we21.setText(st.getClasse());}
        if(sst.read(id,"Wednesday","3")!=null){st=sst.read(id,"Wednesday","3");we3.setText(st.getSubject());we31.setText(st.getClasse());}
        if(sst.read(id,"Wednesday","4")!=null){st=sst.read(id,"Wednesday","4");we4.setText(st.getSubject());we41.setText(st.getClasse());}

        if(sst.read(id,"Thursday","1")!=null){ st=sst.read(id,"Thursday","1");th1.setText(st.getSubject());th11.setText(st.getClasse());}
        if(sst.read(id,"Thursday","2")!=null){ st=sst.read(id,"Thursday","2");th2.setText(st.getSubject());th21.setText(st.getClasse());}
        if(sst.read(id,"Thursday","3")!=null){st=sst.read(id,"Thursday","3");th3.setText(st.getSubject());th31.setText(st.getClasse());}
        if(sst.read(id,"Thursday","4")!=null){st=sst.read(id,"Thursday","4");th4.setText(st.getSubject());th41.setText(st.getClasse());}

        if(sst.read(id,"Friday","1")!=null){st=sst.read(id,"Friday","1");fr1.setText(st.getSubject());fr11.setText(st.getClasse());}
        if(sst.read(id,"Friday","2")!=null){ st=sst.read(id,"Friday","2");fr2.setText(st.getSubject());fr21.setText(st.getClasse());}
        if(sst.read(id,"Friday","3")!=null){ st=sst.read(id,"Friday","3");fr3.setText(st.getSubject());fr31.setText(st.getClasse());}
        if(sst.read(id,"Friday","4")!=null){ st=sst.read(id,"Friday","4");fr4.setText(st.getSubject());fr41.setText(st.getClasse());}


        if(sst.read(id,"Saturday","1")!=null){ st=sst.read(id,"Saturday","1");sa1.setText(st.getSubject());sa11.setText(st.getClasse());}
        if(sst.read(id,"Saturday","2")!=null){ st=sst.read(id,"Saturday","2");sa2.setText(st.getSubject());sa21.setText(st.getClasse());}
        if(sst.read(id,"Saturday","3")!=null){ st=sst.read(id,"Saturday","3");sa3.setText(st.getSubject());sa31.setText(st.getClasse());}
        if(sst.read(id,"Saturday","4")!=null){ st=sst.read(id,"Saturday","4");sa4.setText(st.getSubject());sa41.setText(st.getClasse());}


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

        id=u.getId();
        affich();


    }
}