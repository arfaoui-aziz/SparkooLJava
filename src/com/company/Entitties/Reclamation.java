package com.company.Entitties;

import java.util.Date;

public class Reclamation {
    private int id;
    private String type;
    private String typeuser;
    private String datecree;
    private String message;

    public Reclamation(int id, String type, String typeuser,String datecree, String message) {
        this.id = id;
        this.type = type;
        this.typeuser = typeuser;
        this.datecree=datecree;
        this.message= message;
    }

    public Reclamation( String type, String typeuser,String datecree, String message) {

        this.type = type;
        this.typeuser = typeuser;
        this.datecree=datecree;
        this.message= message;
    }


    public Reclamation( String type,String datecree, String message) {

        this.type = type;
        this.datecree=datecree;
        this.message= message;
    }

    public Reclamation( String type, String message) {

        this.type = type;
        this.message= message;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeuser() {
        return typeuser;
    }

    public void setTypeuser(String typeuser) {
        this.typeuser = typeuser;
    }

    public String getDatecree() {
        return datecree;
    }

    public void setDatecree(String datecree) {
        this.datecree = datecree;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", typeuser='" + typeuser + '\'' +
                ", datecree='" + datecree + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
