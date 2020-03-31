package com.company.test;

import com.company.Entitties.Reclamation;
import com.company.Service.ServiceReclamation;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        ServiceReclamation ser = new ServiceReclamation();

       // Reclamation r1 = new Reclamation("ecole","Parent","01/10/2020","prof" );
        Reclamation r2 = new Reclamation("espri","esprit ok" );

        //
        // ser.ajouter(r1);
        ser.ajouter(r2);

        //ser.delete(35);
        //ser.update(36,"oui","oui");

        List<Reclamation> list = ser.readAll();

        //List<Reclamation> list = ser.trier();

       // List<Reclamation> list = ser.RECHERCHER("Parent");
        System.out.println(list);

    }
    }

