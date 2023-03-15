/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DBContext;
import dal.Teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class TeacherDAO extends DBContext{
    
    public ArrayList<Teacher> getAllTeacher(){
        
        ArrayList<Teacher> cc = new ArrayList<>();            
        
        try {
            String sql = "SELECT ROW_NUMBER() OVER(ORDER BY teacherid) AS stt, teacherid, teachername, phone, literacy, nationality, subjectid, classid\n" +
"FROM Teacher;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
               Teacher x = new Teacher(rs.getInt("stt"),rs.getString("teacherid"),rs.getString("teachername"),rs.getString("phone"),
                                       rs.getString("literacy"), rs.getString("nationality"), rs.getString("subjectid"), rs.getString("classid"));
               cc.add(x);
               
            }
        } catch (Exception e) {
        }
        return cc;
   }
    
    public void deleteTeacher(String teacherid) {
        try {
            String sql = "DELETE Teacher WHERE teacherid=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, teacherid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    public int insertTeacher(String teacherid, String teachername, String phone, String literacy, 
            String nationality, String subjectid, String classid) {
        try {
            String sql = "INSERT INTO Teacher VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, teachername);
        ps.setString(2, teacherid);
        ps.setString(3, phone); 
        ps.setString(4, literacy); 
        ps.setString(5, nationality); 
        ps.setString(6, subjectid); 
        ps.setString(7, classid); 
        
        return ps.executeUpdate();

        } catch (Exception e) {
        }
        return 0;
    }
    
    public Teacher getTeacher(String id) {
        try {
            String sql = "SELECT * FROM Teacher WHERE teacherid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Teacher s = new Teacher();
                s.setTeacherid(rs.getString("teacherid"));
                s.setTeachername(rs.getString("teachername"));
                s.setPhone(rs.getString("phone"));
                s.setLiteracy(rs.getString("literacy"));
                s.setNationality(rs.getString("nationality"));
                s.setSubjectid(rs.getString("subjectid"));
                s.setClassid(rs.getString("classid"));
                return s;
            }

        } catch (SQLException ex) {
            
        }
        return null;
    }
    
    public ArrayList<Teacher> searchTeacher(String search) {      
        ArrayList<Teacher> cc = new ArrayList<>();           
        try {
            String sql = "with o as (SELECT ROW_NUMBER() OVER(ORDER BY teacherid) AS stt,teacherid, teachername, phone, literacy, nationality, subjectid, classid\n" +
"FROM Teacher) SELECT * FROM o WHERE teacherid LIKE ? OR teachername LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+ search + "%");
            statement.setString(2,"%"+ search + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Teacher x = new Teacher(rs.getInt("stt"),rs.getString("teacherid"),rs.getString("teachername"),rs.getString("phone"),
                                       rs.getString("literacy"), rs.getString("nationality"), rs.getString("subjectid"), rs.getString("classid"));
                cc.add(x);   
            }  

        } catch (SQLException ex) { 
        }
        return cc;
    }
    
    public ArrayList<Teacher> searchTeacherBySubjectId(String search, String subjectid) {      
        ArrayList<Teacher> cc = new ArrayList<>();           
        try {
            String sql = "with o as (SELECT ROW_NUMBER() OVER(ORDER BY teacherid) AS stt,teacherid, teachername, phone, literacy, nationality, subjectid, classid\n" +
"FROM Teacher) SELECT * FROM o WHERE (teacherid LIKE ? OR teachername LIKE ?) and subjectid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+ search + "%");
            statement.setString(2,"%"+ search + "%");
            statement.setString(3,subjectid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Teacher x = new Teacher(rs.getInt("stt"),rs.getString("teacherid"),rs.getString("teachername"),rs.getString("phone"),
                                       rs.getString("literacy"), rs.getString("nationality"), rs.getString("subjectid"), rs.getString("classid"));
                cc.add(x);   
            }  

        } catch (SQLException ex) { 
        }
        return cc;
    }
    
    public ArrayList<Teacher> searchTeacherByClassId(String search, String classid) {      
        ArrayList<Teacher> cc = new ArrayList<>();           
        try {
            String sql = "with o as (SELECT ROW_NUMBER() OVER(ORDER BY teacherid) AS stt,teacherid, teachername, phone, literacy, nationality, subjectid, classid\n" +
"FROM Teacher) SELECT * FROM o WHERE (teacherid LIKE ? OR teachername LIKE ?) and classid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+ search + "%");
            statement.setString(2,"%"+ search + "%");
            statement.setString(3,classid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Teacher x = new Teacher(rs.getInt("stt"),rs.getString("teacherid"),rs.getString("teachername"),rs.getString("phone"),
                                       rs.getString("literacy"), rs.getString("nationality"), rs.getString("subjectid"), rs.getString("classid"));
                cc.add(x);   
            }  

        } catch (SQLException ex) { 
        }
        return cc;
    }
    
    public ArrayList<Teacher> searchTeacherBySubClassId(String search, String subjectid, String classid) {      
        ArrayList<Teacher> cc = new ArrayList<>();           
        try {
            String sql = "with o as (SELECT ROW_NUMBER() OVER(ORDER BY teacherid) AS stt,teacherid, teachername, phone, literacy, nationality, subjectid, classid\n" +
"FROM Teacher) SELECT * FROM o WHERE (teacherid LIKE ? OR teachername LIKE ?) and subjectid = ? and classid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+ search + "%");
            statement.setString(2,"%"+ search + "%");
            statement.setString(3,subjectid);
            statement.setString(4,classid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Teacher x = new Teacher(rs.getInt("stt"),rs.getString("teacherid"),rs.getString("teachername"),rs.getString("phone"),
                                       rs.getString("literacy"), rs.getString("nationality"), rs.getString("subjectid"), rs.getString("classid"));
                cc.add(x);   
            }  

        } catch (SQLException ex) { 
        }
        return cc;
    }
    
    public void updateTeacher(String teacherid, String teachername, String phone, String literacy,
                              String nationality, String subjectid, String classid) {
        try {
            String sql = "Update Teacher set teachername = ? , phone = ? , literacy = ?, nationality = ?, subjectid = ?, classid = ? where teacherid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, teachername);
            statement.setString(2, phone);
            statement.setString(3, literacy);
            statement.setString(4, nationality);
            statement.setString(5, subjectid);
            statement.setString(6, classid);
            statement.setString(7, teacherid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    
    public static void main(String[] args) {
//        System.out.println(new TeacherDAO().getAllTeacher());
        System.out.println(new TeacherDAO().getTeacher("Bantq20"));
//          System.out.println(new TeacherDAO().searchSubject("el"));
    }
        

    
}

