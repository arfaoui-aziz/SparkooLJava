package Service;

import Entity.Absence;
import Entity.Diploma;
import Entity.User;
import IService.IServiceAbsence;
import Utils.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceAbsence implements IServiceAbsence {
    private Connection cnx = DataBase.getInstance().getConnexion();
    private Statement ste;




    @Override
    public void addAbsence(Absence a) throws SQLException {
        try {
            String requeteInsert = " INSERT INTO `absent_teacher` (`id`, `semaine`, `annee_univ`, `jour`, `id_Teacher`) VALUES (NULL, '"+a.getSemaine()+"', '"+a.getAnnee_univ()+"', '"+a.getJour()+"', '"+a.getId_Teacher()+"');";


            ste = cnx.createStatement();
            ste.executeUpdate(requeteInsert);


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
    }

    @Override
    public ArrayList<String> showAbsences(String week, String uy,String id) throws SQLException {
        ArrayList<String> days = new ArrayList<String>();

        try {
            Connection cnx = DataBase.getInstance().getConnexion();

            String sql = "SELECT `jour` FROM `absent_teacher` WHERE `semaine`='"+week+"' and `annee_univ`='"+uy+"' and `id_Teacher`='"+id+"'";


            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                days.add(rs.getString("jour"));


            }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return days;
    }


public ArrayList<Integer> statAbsence (){
    ArrayList<Integer> abs = new ArrayList<Integer>();
for (int i=0;i<36;i++){
    abs.add(0);
}

    try {
        Connection cnx = DataBase.getInstance().getConnexion();

        String sql = "SELECT semaine, count(semaine) FROM absent_teacher GROUP by semaine ";


        PreparedStatement stat= cnx.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();

        while (rs.next()){


            abs.set(Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(2)));

        }


    } catch (SQLException ex) {
        System.err.println(ex.getMessage());

    }
    return abs;
}


    @Override
    public String NumberOfAbsence(String id) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "SELECT count(*) FROM absent_teacher WHERE id_Teacher='"+id+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return "0";
    }

}
