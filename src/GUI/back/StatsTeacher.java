package GUI.back;

import Entity.Diploma;
import Entity.User;
import Service.ServiceAbsence;
import Service.ServiceContactTeacher;
import Service.ServiceDiploma;
import Service.ServiceUser;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import com.itextpdf.text.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StatsTeacher implements Initializable {
    @FXML
    private Label logout;

    @FXML
    private TableView<User> tabTeacher;

    @FXML
    private ImageView btnGenerate;
    @FXML
    private JFXComboBox<String> year;
    @FXML
    private PieChart pie;
    @FXML
    private TableColumn<?, ?> cl_id;

    @FXML
    private TableColumn<?, ?> cl_name;

    @FXML
    private TableColumn<?, ?> cl_Lname;

    @FXML
    private TableColumn<?, ?> cl_phone;
    @FXML
    private HBox btnWarn;

    @FXML
    private LineChart<?, ?> chart;

    @FXML
    private BarChart<?, ?> chart1;

    @FXML
    void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root = fxml.load();
        logout.getScene().setRoot(root);
    }
   /* public void rafraichir()
    {
        ResultSet stat=null;
        ServiceUser user = new ServiceUser();
        try {
            stat=user.StatSexM();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        pie.getData().clear();

        try {
            while(stat.next())
            {


                pie.getData().add(new PieChart.Data(stat.getString(1),10.4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //rafraichir();
        aff();
        StatLineChart();
        StatBarChart();
        year.getItems().addAll("2020","2019","2018");

    }

    public void StatLineChart(){

        XYChart.Series series= new XYChart.Series();
        ServiceAbsence sab= new ServiceAbsence();
        ArrayList<Integer> abs=sab.statAbsence();
        for (int i=0;i<36;i++){
            series.getData().add(new XYChart.Data("Week "+i,abs.get(i)));
        }




         chart.getData().addAll(series);


    }
    public void StatBarChart(){

        XYChart.Series series= new XYChart.Series<>();
        ServiceDiploma sab= new ServiceDiploma();




       series.getData().add(new XYChart.Data<>("Computer Science",sab.statSpeciality("Computer Science")));
        series.getData().add(new XYChart.Data<>("Mathematics",sab.statSpeciality("Mathematics")));
        series.getData().add(new XYChart.Data<>("Physics",sab.statSpeciality("Physics")));
        series.getData().add(new XYChart.Data<>("H & G",sab.statSpeciality("History and Geography")));
        series.getData().add(new XYChart.Data<>("Literature",sab.statSpeciality("Literature")));
        series.getData().add(new XYChart.Data<>("Natural Science",sab.statSpeciality("Natural Science")));
        series.getData().add(new XYChart.Data<>("Sport",sab.statSpeciality("Sport")));







        chart1.getData().addAll(series);


    }

    public void aff() {
        ObservableList<User> data = FXCollections.observableArrayList();
        ServiceUser user = new ServiceUser();

        try {
            ServiceUser usr = new ServiceUser();
            data = (ObservableList<User>) user.readDangerZone();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cl_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cl_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        cl_Lname.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        cl_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tabTeacher.setItems(data);
    }


    @FXML
    void warnHim(MouseEvent event) throws IOException, SQLException {
        Stage primaryStage = new Stage();

        ServiceContactTeacher ct = new ServiceContactTeacher();
        ct.addWarning(tabTeacher.getSelectionModel().getSelectedItem().getId());


        FXMLLoader loader = new FXMLLoader();
        Parent root1 = FXMLLoader.load(getClass().getResource("validation.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root1, 280, 400));
        primaryStage.show();

    }

    @FXML
    void generate(MouseEvent event) {
        Document document = new Document();
        try{
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("Stats.pdf"));
            document.open();
            document.add(new Paragraph("Recruitment Sheet of "+year.getValue()));


            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(105);
            table.setSpacingBefore(11f);
            table.setSpacingAfter(11f);

            float[] colWidth={2f,2f,2f};
            table.setWidths(colWidth);
            PdfPCell c1=new PdfPCell(new Paragraph("ID N°"));
            PdfPCell c2=new PdfPCell(new Paragraph("First Name"));
            PdfPCell c3=new PdfPCell(new Paragraph("Last Name"));
            table.addCell(c1);
            table.addCell(c2);
            table.addCell(c3);
            ArrayList<User> tabU=new ArrayList<User>();
            ServiceUser su=new ServiceUser();
            tabU = su.readInPDF(year.getValue());
            for (int i=0;i<tabU.size();i++){
                PdfPCell c11=new PdfPCell(new Paragraph(tabU.get(i).getId()));
                PdfPCell c22=new PdfPCell(new Paragraph(tabU.get(i).getFirstName()));
                PdfPCell c33=new PdfPCell(new Paragraph(tabU.get(i).getLastName()));
                table.addCell(c11);
                table.addCell(c22);
                table.addCell(c33);
            }
            document.add(table);






            document.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
