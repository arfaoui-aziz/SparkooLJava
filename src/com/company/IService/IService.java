package com.company.IService;

import com.company.Entitties.Reclamation;

import java.sql.SQLException;
import java.util.List;

public interface  IService<R> {
    void ajouter(R r) throws SQLException;

    void delete(int id ) throws SQLException;

    void update( int id,String type, String message);

   List<R> readAll() throws SQLException;

    List<R> trier() throws SQLException;

    List<R> RECHERCHER(String Parent) throws SQLException;

}