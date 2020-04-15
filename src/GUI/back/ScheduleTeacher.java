package GUI.back;

import Entity.SheduleTeacher;
import Service.ServiceScheduleTeacher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ScheduleTeacher {
    @FXML
    private HBox refresh;

    @FXML
    private HBox clear;
    @FXML
    private Label gotoTeacher;

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
    private Label we41;

    @FXML
    private Label we4;

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
    private HBox home;

    @FXML
    private Label logout1;

    @FXML
    void addF1(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Friday","1");
    }

    @FXML
    void addF2(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Friday","2");
    }

    @FXML
    void addF3(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Friday","3");
    }

    @FXML
    void addF4(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Friday","4");
    }

    @FXML
    void addM1(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Monday","1");

    }

    @FXML
    void addM2(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Monday","2");
    }

    @FXML
    void addM3(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Monday","3");
    }

    @FXML
    void addM4(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Monday","4");
    }

    @FXML
    void addSA1(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Saturday","1");
    }

    @FXML
    void addSA2(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Saturday","2");
    }

    @FXML
    void addSA3(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Saturday","3");
    }

    @FXML
    void addSA4(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Saturday","4");
    }

    @FXML
    void addT1(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Tuesday","1");
    }

    @FXML
    void addT3(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Tuesday","3");
    }

    @FXML
    void addT4(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Tuesday","4");
    }

    @FXML
    void addTH1(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Thursday","1");
    }

    @FXML
    void addTH2(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Thursday","2");
    }

    @FXML
    void addTH3(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Thursday","3");
    }

    @FXML
    void addTH4(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Thursday","4");
    }

    @FXML
    void addW1(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Wednesday","1");
    }

    @FXML
    void addW2(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Wednesday","2");
    }

    @FXML
    void addW3(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Wednesday","3");
    }

    @FXML
    void addW4(MouseEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addSession.fxml"));
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 280, 400));
        primaryStage.show();
        AddSession controller = loader.getController();
        controller.initData(id,"Wednesday","4");
    }

    @FXML
    void gotoTeacher(MouseEvent event) {

    }



    @FXML
    void logOut(MouseEvent event) {

    }
    String id="";
    public void initData(String idT) throws SQLException {

        id=idT;
        System.out.println(idT);
        affich();
    }

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
    @FXML
    void refresh(MouseEvent event) throws SQLException {
affich();
    }
    @FXML
    void clear(MouseEvent event) throws SQLException {

        ServiceScheduleTeacher sst = new ServiceScheduleTeacher();
        sst.clear(id);


    }
}
