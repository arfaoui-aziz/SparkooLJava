package GUI.back;

import Entity.ContactTeacher;
import Entity.User;
import Service.ServiceContactTeacher;
import Service.ServiceUser;
import com.adobe.acrobat.Viewer;
import com.jfoenix.controls.JFXTextField;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

public class ShowMessage extends JPanel {
    @FXML
    private Label btnDownload;
    @FXML
    private Label logout;

    @FXML
    private HBox gotoHome;

    @FXML
    private HBox gotoTeacher;

    @FXML
    private Label inbox;

    @FXML
    private Label name;

    @FXML
    private Label sub;

    @FXML
    private Text cont;

    @FXML
    private Label repl;

    @FXML
    private Button btnReply;

    @FXML
    private JFXTextField replyText;

    @FXML
    private TextField idM;

    @FXML
    private Label file;

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
    void replyMail(MouseEvent event) throws IOException, SQLException {

        String rp= replyText.getText();

        ServiceContactTeacher ct = new ServiceContactTeacher();

        ct.addReply("-Admin: "+ rp+"\n",Integer.parseInt(idM.getText()));
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("showBox.fxml"));
        Parent root = fxml.load();
        btnReply.getScene().setRoot(root);



    }

    public void initData(ContactTeacher selectedItem) throws SQLException {
        sub.setText(selectedItem.getSubject());
        cont.setText(selectedItem.getMessage());
        ServiceContactTeacher ct = new ServiceContactTeacher();

        name.setText(ct.getNameSender(selectedItem.getId()));
        repl.setText(ct.getReplies(selectedItem.getId()));

        idM.setText(String.valueOf(selectedItem.getId()));
        file.setText(selectedItem.getFile());
        if (!file.getText().isEmpty()){
            btnDownload.setVisible(true);
            btnDownload.setText(file.getText());
        }

    }


    @FXML
    void download(MouseEvent event) throws Exception {

        try {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(new File(file.getText()));
            } else {
                System.out.println("Open is not supported");
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }


    }
}
