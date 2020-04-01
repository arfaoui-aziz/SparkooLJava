package Service;

import Entity.Classe;
import Entity.User;
import IService.IServiceClasse;
import Utils.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class ServiceClasse implements IServiceClasse<Classe> {
    private Connection cnx = DataBase.getInstance().getCnx();
    private Statement ste;

    @Override
    public void ajouter(Classe c) throws SQLException {
        String requeteInsert = "INSERT INTO classe (class_name,class_nbr) VALUES (?,?)";
        PreparedStatement pst = cnx.prepareStatement(requeteInsert);
        pst.setString(1, c.getClassName());
        pst.setInt(2, c.getClassNbr());
        pst.executeUpdate();
    }

    @Override
    public List<Classe> AfficherClasse() throws SQLException {
        ObservableList<Classe> ClasseData = FXCollections.observableArrayList();
        String readClasses = "Select * from classe ";
        PreparedStatement pst= cnx.prepareStatement(readClasses);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            ClasseData.add(new Classe(rs.getInt(1) ,rs.getString(2),rs.getInt(3) ));
        }
        return ClasseData;
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String requeteDelete = "DELETE FROM classe WHERE class_id=?";
        PreparedStatement pst = cnx.prepareStatement(requeteDelete);
        pst.setInt(1, id);
        pst.executeUpdate();
    }

    @Override
    public void update(Classe c, int id) throws SQLException {
        String requeteUpdate = "UPDATE classe SET class_name=?,class_nbr=? WHERE class_id=?";
        PreparedStatement pst = cnx.prepareStatement(requeteUpdate);
        pst.setInt(3, id);
        pst.setString(1, c.getClassName());
        pst.setInt(2, c.getClassNbr());
        pst.executeUpdate();
    }
}
