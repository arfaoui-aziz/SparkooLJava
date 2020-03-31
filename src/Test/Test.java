package Test;

import Entity.Event;
import Service.ServiceEvent;
import Entity.Club;
import Service.ServiceClub;

import java.sql.*;
import java.util.List;


public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        ServiceEvent ser = new ServiceEvent();
        ServiceClub ser1 = new ServiceClub();
        //Event e1 = new Event("FADAAAAAAAAAA", "PLAGE", "ahhahah","04/02/2020","classe" ,20,"hh","hh",20f,20f,30f);
        //Event e2 = new Event("yayayayayayay", "plage", "ahhahah","04/02/2020","classe" ,55,"hh","hh", 30f, 20f,30f) ;

        try {
            List<Event> listR = ser.SearchEvent("events");
            System.out.println(listR);
            //ser.ajouter(e1);
            //ser.ajouter(e2);

           // List<Event> list = ser.readAll();
            //System.out.println(list);

          //  ser.delete("happyyyyyyy");
            // ser.update("events22","malaFADA");

            //Club c1 = new Club("aaaaA",60, "FFFFF",70f,"04/02/2020" );

            //List<Club> listClub = ser1.readAll();
            //System.out.println(listClub);

            //ser1.ajouter(c1);
            //ser1.delete("events");
            //ser1.update("rotaract","malaJAW");

        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}

