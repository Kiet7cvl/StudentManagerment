/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DBContext;
import dal.Major;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class MajorDAO extends DBContext{
    
    public ArrayList<Major> getAllMajor(){
        
        ArrayList<Major> cc = new ArrayList<>();            
        
        try {
            String sql = "SELECT ROW_NUMBER() OVER(ORDER BY majorid) AS stt, majorname, majorid\n" +
"FROM Major;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
               Major x = new Major(rs.getInt("stt"),rs.getString("majorid"),rs.getString("majorname"));
               cc.add(x);
               
            }
        } catch (Exception e) {
        }
        return cc;
   }
    
    public void deleteMajor(String majorid) {
        try {
            String sql = "DELETE Major WHERE majorid=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, majorid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    public int insertMajor(String majorid, String majorname) {
        try {
            String sql = "INSERT INTO Major VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, majorname);
        ps.setString(2, majorid);       
        return ps.executeUpdate();

        } catch (Exception e) {
        }
        return 0;
    }
    
    public Major getMajor(String id) {
        try {
            String sql = "SELECT * FROM Major WHERE majorid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Major s = new Major();
                s.setMajorid(rs.getString("majorid"));
                s.setMajorname(rs.getString("majorname"));
                return s;
            }

        } catch (SQLException ex) {
            
        }
        return null;
    }
    
    public ArrayList<Major> searchMajor(String search) {      
        ArrayList<Major> cc = new ArrayList<>();           
        try {
            String sql = "with o as (SELECT ROW_NUMBER() OVER(ORDER BY majorid) AS stt, majorname, majorid\n" +
"FROM Major) SELECT * FROM o WHERE majorid LIKE ? OR majorname LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+ search + "%");
            statement.setString(2,"%"+ search + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Major x = new Major(rs.getInt("stt"),rs.getString("majorid"),rs.getString("majorname"));
                cc.add(x);   
            }  

        } catch (SQLException ex) { 
        }
        return cc;
    }
    
    public void updateMajor(String majorid, String majorname) {
        try {
            String sql = "Update Major set majorname = ? where majorid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, majorname);
            statement.setString(2, majorid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    
    public static void main(String[] args) {
//        System.out.println(new MajorDAO().getAllMajor());
//        System.out.println(new MajorDAO().getMajor("SE20"));
//          System.out.println(new MajorDAO().insertMajor("TG1", "DAPHO"));
          System.out.println(new MajorDAO().searchMajor("D"));
        
    }

    
}

