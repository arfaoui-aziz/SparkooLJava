package com.company.Service;

import com.company.Entitties.Reclamation;
import com.company.IService.IService;
import com.company.Utils.DataBase;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
public class ServiceReclamation implements IService<Reclamation> {
    private Connection con;
    private Statement ste;
    private PreparedStatement pst ;
    private ResultSet res ;


    public ServiceReclamation() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouter(Reclamation r) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO reclamation (`type`, `typeuser`,`datecree`,`message`) VALUES ('" + r.getType() + "', 'Parent', NOW(), '" + r.getMessage() + "');";
        try {
            ste = con.createStatement();
            ste.executeUpdate(requeteInsert);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public void delete(int id)  {
        try {
            String requete = " delete from reclamation where id='"+id+"'" ;
            pst = con.prepareStatement(requete);
            ste=con.createStatement();
            ste.executeUpdate(requete);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update( int id,String type, String message){
        try {
            String requete = " update reclamation set type=? , message=?  where id='"+id+"'"  ;
            pst = con.prepareStatement(requete);
            pst.setString(1,type);
            pst.setString(2,message);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Reclamation> readAll() throws SQLException {
        List<Reclamation> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from reclamation");
        while (rs.next()) {
            int id=rs.getInt(1);
            String type=rs.getString("type");
            String typeuser=rs.getString("typeuser");
            String  datecree=rs.getString("datecree");
            String message=rs.getString("message");
            Reclamation p=new Reclamation(id, type, typeuser, datecree,message);
            arr.add(p);
        }
        return arr;
    }

    @Override
    public List<Reclamation> trier() throws SQLException {
        List<Reclamation> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from reclamation order by type desc");
        while (rs.next()) {
            int id=rs.getInt(1);
            String type=rs.getString("type");
            String typeuser=rs.getString("typeuser");
            String datecree=rs.getString("datecree");
            String message=rs.getString("message");
            Reclamation p=new Reclamation(id, type, typeuser, datecree, message);
            arr.add(p);
        }
        return arr;
    }

    public List<Reclamation> RECHERCHER(String Parent) throws SQLException {
        List<Reclamation> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from reclamation where typeuser= '"+Parent+"' ");
        while (rs.next()) {
            int id=rs.getInt(1);
            String type=rs.getString("type");
            String typeuser=rs.getString("typeuser");
            String datecree=rs.getString("datecree");
            String message=rs.getString("message");

            Reclamation p=new Reclamation(id, type, typeuser, datecree, message);
            arr.add(p);
        }
        return arr;
    }
}
