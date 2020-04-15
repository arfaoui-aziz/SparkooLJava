package IService;

import Entity.ContactTeacher;

import java.sql.SQLException;
import java.util.List;

public interface IServiceContactTeacher {

     String NumberOfNotShowed() throws SQLException ;
     List<ContactTeacher> readAll(int i) throws SQLException ;
     String getReplies(int id) throws SQLException ;
     String readById(int id) throws SQLException ;
     String getNameSender(int id) throws SQLException ;
     void addReply(String rp, int id) throws SQLException ;
     void addWarning(String id) throws SQLException ;
     List<ContactTeacher> readSent(String id) throws SQLException ;
     List<ContactTeacher> readReplied(String id) throws SQLException ;
     List<ContactTeacher> readReceived(String id) throws SQLException ;
     void sendMail(String id,String sub,String cont,String file) throws SQLException ;









     }
