package Service;

import Entity.Diploma;
import IService.IServiceDiploma;
import Utils.DataBase;
import Utils.bcrypt;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceDiploma implements IServiceDiploma {
    private Connection cnx = DataBase.getInstance().getConnexion();
    private Statement ste;

    @Override
    public void addDiploma(Diploma d) throws SQLException {
        try {
            String requeteInsert = " INSERT INTO `diploma` (`id`, `intitule`, `ecole`, `specialite`, `niveau`, `date_obtentation`, `id_Teacher`) VALUES (NULL, '" + d.getIntitule() + "', '" + d.getEcole() + "', '" + d.getSpecialite() + "', '" + d.getNiveau() + "', '" + d.getDate_obtentation() + "', '" + d.getIdT() + "');";


            ste = cnx.createStatement();
            ste.executeUpdate(requeteInsert);


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
    }
}
