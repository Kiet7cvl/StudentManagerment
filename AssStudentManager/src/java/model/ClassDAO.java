/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DBContext;
import dal.Class;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class ClassDAO extends DBContext{
    
    public ArrayList<Class> getAllClass(){
        
        ArrayList<Class> cc = new ArrayList<>();            
        
        try {
            String sql = "SELECT ROW_NUMBER() OVER(ORDER BY classid) AS stt, classname, classid\n" +
"FROM Class;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
               Class x = new Class(rs.getInt("stt"),rs.getString("classid"),rs.getString("classname"));
               cc.add(x);
               
            }
        } catch (Exception e) {
        }
        return cc;
   }
    
    public void deleteClass(String classid) {
        try {
            String sql = "DELETE Class WHERE classid=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, classid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    public int insertClass(String classid, String classname) {
        try {
            String sql = "INSERT INTO Class VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, classname);
        ps.setString(2, classid);       
        return ps.executeUpdate();

        } catch (Exception e) {
        }
        return 0;
    }
    
    public Class getClass(String id) {
        try {
            String sql = "SELECT * FROM Class WHERE classid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Class s = new Class();
                s.setClassid(rs.getString("classid"));
                s.setClassname(rs.getString("classname"));
                return s;
            }

        } catch (SQLException ex) {
            
        }
        return null;
    }
    
    public ArrayList<Class> searchClass(String search) {      
        ArrayList<Class> cc = new ArrayList<>();           
        try {
            String sql = "with o as (SELECT ROW_NUMBER() OVER(ORDER BY Classid) AS stt, Classname, Classid\n" +
"FROM Class) SELECT * FROM o WHERE Classid LIKE ? OR Classname LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+ search + "%");
            statement.setString(2,"%"+ search + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Class x = new Class(rs.getInt("stt"),rs.getString("classid"),rs.getString("classname"));
                cc.add(x);   
            }  

        } catch (SQLException ex) { 
        }
        return cc;
    }
    
    public void updateClass(String Classid, String Classname) {
        try {
            String sql = "Update Class set classname = ? where classid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Classname);
            statement.setString(2, Classid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    
    public static void main(String[] args) {
        System.out.println(new ClassDAO().getAllClass());
//        System.out.println(new ClassDAO().getClass("SE20"));
//          System.out.println(new ClassDAO().insertClass("TG1", "DAPHO"));
//          System.out.println(new ClassDAO().searchClass("D"));
        
    }

    
}

