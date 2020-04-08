package GUI.back;

import Entity.User;
import Service.ServiceUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddUser {


    @FXML
    private Label logout;

    @FXML
    private Label gotoUser;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXComboBox<String> gender;

    @FXML
    private JFXDatePicker dateB;

    @FXML
    private JFXTextField salaire;

    @FXML
    private JFXTextField firstN;

    @FXML
    private JFXComboBox<String> role;

    @FXML
    private JFXDatePicker joiningD;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXTextField lastN;

    @FXML
    private JFXComboBox<String> userT;

    @FXML
    private JFXTextField mail;

    @FXML
    private JFXTextField address;
    @FXML
    private Button btnAdd;
    @FXML
    private Label lid;
    @FXML
    private Label lgender;
    @FXML
    private Label lDateB;
    @FXML
    private Label lSalaire;
    @FXML
    private Label lfn;
    @FXML
    private Label lrole;
    @FXML
    private Label ljoiningD;

    @FXML
    private Label lPhone;
    @FXML
    private Label lln;
    @FXML
    private Label luserT;
    @FXML
    private Label lEmail;
    @FXML
    private Label lAddress;

    @FXML
    public void initialize() {
        //gender.setPromptText("Gender");
        gender.getItems().addAll("Male", "Female");
        role.getItems().addAll("ROLE_USER","ROLE_ADMIN","ROLE_SUPER_ADMIN");
        userT.getItems().addAll("Administrator","Parent","Teacher","Student");

    }
    public void initLabels(){
        lid.setText("");
        lfn.setText("");
        lln.setText("");
        lgender.setText("");
        lrole.setText("");
        luserT.setText("");
        lDateB.setText("");
        ljoiningD.setText("");
        lEmail.setText("");
        lSalaire.setText("");
        lPhone.setText("");
        lAddress.setText("");
    }




    @FXML
    private void logOut(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("/sample/login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
    }

    @FXML
    private void gotoUser(MouseEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("Users.fxml"));
        Parent root=fxml.load();
        gotoUser.getScene().setRoot(root);
    }
    @FXML
    void AddUser(MouseEvent event) throws IOException, SQLException {
        String Id = id.getText();
        String FirstName = firstN.getText();
        String LastName = lastN.getText();
        String Gender = (String) gender.getValue();
        String Roles = (String) role.getValue();
        String UserType = (String) userT.getValue();
        String DateOfBirth= dateB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String JoiningDate =joiningD.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String Email = mail.getText();
        Float Salaire = Float.parseFloat(salaire.getText());
        String Phone = phone.getText();
        String Address = address.getText();
        if(controleSaisie(Id, FirstName, LastName, Gender, Roles, UserType, DateOfBirth, JoiningDate, Email, Salaire, Phone, Address)) {
            ServiceUser user = new ServiceUser();
            User u = new User(Id, FirstName, LastName, Gender, Roles, UserType, DateOfBirth, JoiningDate, Email, Salaire, Phone, Address);
            user.ajouter(u);
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("Users.fxml"));
            Parent root = fxml.load();
            btnAdd.getScene().setRoot(root);
        }
    }

    public boolean controleSaisie(String Id,String FirstName,String LastName,String Gender,String Roles,String UserType,String DateOfBirth,String JoiningDate,String Email,Float Salaire,String Phone,String Address){
        int i =0;
        if (Id.isEmpty() || Id.length()==0 || Id.length()< 3 || Id.length() >10   ){
                    lid.setText("Invalid Id");
            i = 1;
                }
        if ( FirstName.isEmpty() || FirstName.length()< 3 || FirstName.length() >10 ||  isNumeric(FirstName) ){
            lfn.setText("Invalid FirstName");
            i = 1;
        }
        if (  LastName.isEmpty() || LastName.length()==0 || LastName.length()< 3 || LastName.length() >10 ||  isNumeric(LastName) ){
            lln.setText("Invalid LastName");
            i = 1;
        }
        if ( Gender.isEmpty() || !(Gender.equals("Male") || Gender.equals("Female")) ){
           lgender.setText("Choose a Gender");
            i = 1;
        }
        if (Roles.isEmpty() || !(Roles.equals("ROLE_USER") || Roles.equals("ROLE_ADMIN") || Roles.equals("ROLE_SUPER_ADMIN") )){
            lrole.setText("Choose a Role");
            i = 1 ;
        }
            if( UserType.isEmpty() || !( UserType.equals("Administrator") || UserType.equals("Parent") || UserType.equals("Teacher") || UserType.equals("Student") )){
                luserT.setText("Choose a UserType");
                i = 1;
            }
            if( DateOfBirth.isEmpty() || DateOfBirth.length()==0){
                lDateB.setText("Invalid DateOfBirth");
                i = 1;
            }
        if( JoiningDate.isEmpty() ||JoiningDate.length()==0){
            ljoiningD.setText("Invalid JoiningDate");
            i = 1;
        }
        if(Email.isEmpty() ||Email.length()==0){
            lEmail.setText("Invalid Email");
            i = 1;
        }
            String s = String.valueOf(Salaire);
            if ( s.isEmpty() || !isNumeric(s) || Salaire <400){
                lSalaire.setText("Salaire Invalid");
                i = 1;
            }
        if ( Phone.isEmpty() || !isNumeric(Phone) || Phone.length()!=8 ){
            lPhone.setText("Invalid Phone Number");
            i = 1;
        }
        if(Address.isEmpty() ||Address.length() < 8){
            i = 1;
            lAddress.setText("Invalid Address");
        }

        if (i != 0)
        {
            return false;
        }

initLabels();

return true;

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

}
