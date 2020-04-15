package Service;

import Entity.Diploma;
import Entity.User;
import IService.IServiceDiploma;
import Utils.DataBase;
import Utils.bcrypt;

import java.sql.*;
import java.util.ArrayList;

public class ServiceDiploma implements IServiceDiploma {
    private Connection cnx = DataBase.getInstance().getConnexion();
    private Statement ste;

    @Override
    public void addDiploma(Diploma d) throws SQLException {
        try {
            String requeteInsert = " INSERT INTO `diploma` ( `intitule`, `ecole`, `specialite`, `niveau`, `date_obtentation`, `id_Teacher`) VALUES ( '" + d.getIntitule() + "', '" + d.getEcole() + "', '" + d.getSpecialite() + "', '" + d.getNiveau() + "', '" + d.getDate_obtentation() + "', '" + d.getIdT() + "');";


            ste = cnx.createStatement();
            ste.executeUpdate(requeteInsert);


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
    }

    @Override
    public Diploma readById(String id) throws SQLException {
        try {
            Connection cnx = DataBase.getInstance().getConnexion();
            String sql= "Select * from diploma where id_Teacher='"+id+"'";
            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                return new Diploma(rs.getString("intitule"),rs.getString("ecole"),rs.getString("specialite"),rs.getString("niveau"),rs.getString("date_obtentation"),rs.getString("id_Teacher"));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void update(Diploma d, String id) throws SQLException {
        PreparedStatement ste=cnx.prepareStatement("UPDATE `diploma` SET `intitule` = '"+d.getIntitule()+"', `ecole` = '"+d.getEcole()+"', `specialite` = '"+d.getSpecialite()+"', `niveau` = '"+d.getNiveau()+"', `date_obtentation` = '"+d.getDate_obtentation()+"' WHERE `diploma`.`id_Teacher` = '"+id+"';\n");

        ste.executeUpdate();
    }




    @Override
    public int statSpeciality (String s){



        try {
            Connection cnx = DataBase.getInstance().getConnexion();

            String sql = "SELECT count(diploma.specialite) AS nbS FROM diploma where specialite = '"+s+"'";


            PreparedStatement stat= cnx.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){

                return Integer.parseInt(rs.getString("nbS"));


            }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return 0;
    }
}
