/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DBContext;
import dal.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class SubjectDAO extends DBContext{
    
    public ArrayList<Subject> getAllSubject(){
        
        ArrayList<Subject> cc = new ArrayList<>();            
        
        try {
            String sql = "SELECT ROW_NUMBER() OVER(ORDER BY subjectid) AS stt, subjectid, subjectname, majorid\n" +
"FROM Subject;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
               Subject x = new Subject(rs.getInt("stt"),rs.getString("subjectid"),rs.getString("subjectname"),rs.getString("majorid"));
               cc.add(x);
               
            }
        } catch (Exception e) {
        }
        return cc;
   }
    
    public void deleteSubject(String subjectid) {
        try {
            String sql = "DELETE Subject WHERE subjectid=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, subjectid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    public int insertSubject(String subjectid, String subjectname,String majorid) {
        try {
            String sql = "INSERT INTO Subject VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, subjectid);
        ps.setString(2, subjectname);
        ps.setString(3, majorid); 
        return ps.executeUpdate();

        } catch (Exception e) {
        }
        return 0;
    }
    
    public Subject getSubject(String id) {
        try {
            String sql = "SELECT * FROM Subject WHERE subjectid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Subject s = new Subject();
                s.setSubjectid(rs.getString("subjectid"));
                s.setSubjectname(rs.getString("subjectname"));
                s.setMajorid(rs.getString("majorid"));
                return s;
            }

        } catch (SQLException ex) {
            
        }
        return null;
    }
    
    public ArrayList<Subject> searchSubject(String search) {      
        ArrayList<Subject> cc = new ArrayList<>();           
        try {
            String sql = "with o as (SELECT ROW_NUMBER() OVER(ORDER BY subjectid) AS stt, subjectid, subjectname, majorid\n" +
"FROM Subject) SELECT * FROM o WHERE subjectid LIKE ? OR subjectname LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+ search + "%");
            statement.setString(2,"%"+ search + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Subject x = new Subject(rs.getInt("stt"),rs.getString("subjectid"),rs.getString("subjectname"),rs.getString("majorid"));
                cc.add(x);   
            }  

        } catch (SQLException ex) { 
        }
        return cc;
    }
    
    public ArrayList<Subject> searchSubjectByMjorId(String search, String majorid) {      
        ArrayList<Subject> cc = new ArrayList<>();           
        try {
            String sql = "with o as (SELECT ROW_NUMBER() OVER(ORDER BY subjectid) AS stt, subjectid, subjectname, majorid\n" +
"FROM Subject) SELECT * FROM o WHERE (subjectid like ? or subjectname like ?) and majorid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+ search + "%");
            statement.setString(2,"%"+ search + "%");
            statement.setString(3,majorid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Subject x = new Subject(rs.getInt("stt"),rs.getString("subjectid"),rs.getString("subjectname"),rs.getString("majorid"));
                cc.add(x);   
            }  

        } catch (SQLException ex) { 
        }
        return cc;
    }
    
    public void updateSubject(String subjectid, String subjectname, String majorid) {
        try {
            String sql = "Update Subject set subjectname = ? , majorid = ? where subjectid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, subjectname);
            statement.setString(2, majorid);
            statement.setString(3, subjectid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    
    public static void main(String[] args) {
//        System.out.println(new SubjectDAO().getAllSubject());
//        System.out.println(new SubjectDAO().getSubjectr("SE20"));
          System.out.println(new SubjectDAO().searchSubject("el"));
        
    }

    
}

