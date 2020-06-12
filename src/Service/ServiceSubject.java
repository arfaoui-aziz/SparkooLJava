package Service;

import Entity.Subject;
import IService.IServiceSubject;
import Utils.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;


public class ServiceSubject implements IServiceSubject<Subject> {

    private Connection cnx = DataBase.getInstance().getCnx();
    private Statement ste;
    @Override
    public void ajouter(Subject s) throws SQLException {
        String requeteInsert = "INSERT INTO subject (subject_name, coefficient ,SubjectByClasse) VALUES (?,?,?)";
        PreparedStatement pst = cnx.prepareStatement(requeteInsert);
        pst.setString(1, s.getSubjectName());
        pst.setInt(2, s.getCoefficient());
        pst.setString(3, s.getSubjectByClasse());
        pst.executeUpdate();
    }

    @Override
    public List<Subject> AfficherSubject() throws SQLException {
        ObservableList<Subject> SubjectData = FXCollections.observableArrayList();
        String readSubjects = "Select * from subject ";
        PreparedStatement pst= cnx.prepareStatement(readSubjects);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            SubjectData.add(new Subject(rs.getInt(1) ,rs.getString(2),rs.getInt(3),rs.getString(4) ));
        }
        return SubjectData;
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String requeteDelete = "DELETE FROM subject WHERE subject_id=?";
        PreparedStatement pst = cnx.prepareStatement(requeteDelete);
        pst.setInt(1, id);
        pst.executeUpdate();
    }

    @Override
    public void update(Subject s, int id) throws SQLException {
        String requeteUpdate = "UPDATE subject SET subject_name=?,coefficient=?,SubjectByClasse=? WHERE subject_id=?";
        PreparedStatement pst = cnx.prepareStatement(requeteUpdate);
        pst.setInt(4, id);
        pst.setString(1, s.getSubjectName());
        pst.setInt(2, s.getCoefficient());
        pst.setString(3, s.getSubjectByClasse());

        pst.executeUpdate();
    }
}
