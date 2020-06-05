package Service;

import Entity.Forum;
import Entity.Marks;
import Utils.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ServiceMarks {

    ObservableList<Marks> data = FXCollections.observableArrayList();

    public List<Marks> Markslist(String student) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getCnx();
            String sql= "Select * from note  WHERE student='"+student+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            System.out.println(sql);
            while (rs.next()){
                Marks  Mark =new Marks(rs.getInt("id"),rs.getDouble("CC"),rs.getDouble("Exam"),rs.getString("subject"),rs.getString("student"));
                data.add(Mark);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(data);
        return data;
    }
}
