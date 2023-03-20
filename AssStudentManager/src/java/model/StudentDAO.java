/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DBContext;
import dal.Student;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class StudentDAO extends DBContext{
    
    public ArrayList<Student> getAllStudent(){
        
        ArrayList<Student> cc = new ArrayList<>();            
        
        try {
            String sql = "SELECT ROW_NUMBER() OVER(ORDER BY id) AS stt, id, studentid,[name],gender,dob,classid,majorid,cname,pob,ht,prr,\n" +
"nation,religion,academicl,nien,CMND,phone,gmail FROM Student;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
               Student x = new Student(rs.getInt("stt"),rs.getInt("id"),rs.getString("studentid"), rs.getString("name"),rs.getBoolean("gender"), rs.getDate("dob"),
                       rs.getString("classid"), rs.getString("majorid"), rs.getString("cname"), rs.getString("pob"), rs.getString("ht"), 
                       rs.getString("prr"),rs.getString("nation"), rs.getString("religion"), rs.getString("academicl"), rs.getString("nien"),
                       rs.getString("CMND"), rs.getString("phone"), rs.getString("gmail"));
               cc.add(x);
               
            }
        } catch (Exception e) {
        }
        return cc;
   }
    
    public void deleteStudent(int id) {
        try {
            String sql = "DELETE Student WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    public int insertStudent(String studentid, String name, String gender, String dob, String classid, String majorid,
                             String cname, String pob, String ht, String prr, String nation, String religion,String academicl,
                             String nien, String CMND, String phone, String gmail) {
       
        try {
            String sql = "INSERT INTO Student VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, studentid);
        ps.setString(2, name);
        ps.setString(3, gender); 
        ps.setString(4, dob);
        ps.setString(5, classid); 
        ps.setString(6, majorid); 
        ps.setString(7, cname); 
        ps.setString(8, pob);
        ps.setString(9, ht);
        ps.setString(10, prr);
        ps.setString(11, nation);
        ps.setString(12, religion);
        ps.setString(13, academicl);
        ps.setString(14, nien);
        ps.setString(15, CMND);
        ps.setString(16, phone);
        ps.setString(17, gmail);
        return ps.executeUpdate();

        } catch (Exception e) {
        }
        return 0;
    }
    
    public Student getStudent(int id) {
        try {
            String sql = "SELECT * FROM Student WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setStudentid(rs.getString("studentid"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getBoolean("gender"));
                s.setDob(rs.getDate("dob"));
                s.setClassid(rs.getString("classid"));
                s.setMajorid(rs.getString("majorid"));
                s.setCname(rs.getString("cname"));
                s.setPob(rs.getString("pob"));
                s.setHt(rs.getString("ht"));
                s.setPrr(rs.getString("prr"));
                s.setNaion(rs.getString("nation"));
                s.setReligion(rs.getString("religion"));
                s.setAcadamicl(rs.getString("academicl"));
                s.setNien(rs.getString("nien"));
                s.setCMND(rs.getString("CMND"));
                s.setPhone(rs.getString("phone"));
                s.setGmail(rs.getString("gmail"));
                
                
                return s;
            }

        } catch (SQLException ex) {
            
        }
        return null;
    }
    
    public Student getStudentByStudentId(String studentid) {
        try {
            String sql = "SELECT * FROM Student WHERE studentid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,studentid);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setStudentid(rs.getString("studentid"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getBoolean("gender"));
                s.setDob(rs.getDate("dob"));
                s.setClassid(rs.getString("classid"));
                s.setMajorid(rs.getString("majorid"));
                s.setCname(rs.getString("cname"));
                s.setPob(rs.getString("pob"));
                s.setHt(rs.getString("ht"));
                s.setPrr(rs.getString("prr"));
                s.setNaion(rs.getString("nation"));
                s.setReligion(rs.getString("religion"));
                s.setAcadamicl(rs.getString("academicl"));
                s.setNien(rs.getString("nien"));
                s.setCMND(rs.getString("CMND"));
                s.setPhone(rs.getString("phone"));
                s.setGmail(rs.getString("gmail"));
                
                
                return s;
            }

        } catch (SQLException ex) {
            
        }
        return null;
    }
    
    public ArrayList<Student> searchStudent(String search) {      
        ArrayList<Student> cc = new ArrayList<>();           
        try {
            String sql = "with o as (SELECT ROW_NUMBER() OVER(ORDER BY id) AS stt, id, studentid,[name],gender,dob,classid,majorid,cname,pob,ht,prr,\n" +
"nation,religion,academicl,nien,CMND,phone,gmail FROM Student) select * from o WHERE studentid LIKE ? OR [name] LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+ search + "%");
            statement.setString(2,"%"+ search + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Student x = new Student(rs.getInt("stt"),rs.getInt("id"),rs.getString("studentid"), rs.getString("name"),rs.getBoolean("gender"), rs.getDate("dob"),
                       rs.getString("classid"), rs.getString("majorid"), rs.getString("cname"), rs.getString("pob"), rs.getString("ht"), 
                       rs.getString("prr"),rs.getString("nation"), rs.getString("religion"), rs.getString("academicl"), rs.getString("nien"),
                       rs.getString("CMND"), rs.getString("phone"), rs.getString("gmail"));
                cc.add(x);   
            }  

        } catch (SQLException ex) { 
        }
        return cc;
    }
    
    public ArrayList<Student> searchStudentByMajorId(String search, String majorid) {      
        ArrayList<Student> cc = new ArrayList<>();           
        try {
            String sql = "with o as (SELECT ROW_NUMBER() OVER(ORDER BY id) AS stt, id, studentid,[name],gender,dob,classid,majorid,cname,pob,ht,prr,\n" +
"nation,religion,academicl,nien,CMND,phone,gmail FROM Student) select * from o WHERE (studentid LIKE ? OR [name] LIKE ?) and majorid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+ search + "%");
            statement.setString(2,"%"+ search + "%");
            statement.setString(3,majorid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               Student x = new Student(rs.getInt("stt"),rs.getInt("id"),rs.getString("studentid"), rs.getString("name"),rs.getBoolean("gender"), rs.getDate("dob"),
                       rs.getString("classid"), rs.getString("majorid"), rs.getString("cname"), rs.getString("pob"), rs.getString("ht"), 
                       rs.getString("prr"),rs.getString("nation"), rs.getString("religion"), rs.getString("academicl"), rs.getString("nien"),
                       rs.getString("CMND"), rs.getString("phone"), rs.getString("gmail"));
                cc.add(x);   
            }  

        } catch (SQLException ex) { 
        }
        return cc;
    }
    
    public ArrayList<Student> searchStudentByClassId(String search, String classid) {      
        ArrayList<Student> cc = new ArrayList<>();           
        try {
            String sql = "with o as (SELECT ROW_NUMBER() OVER(ORDER BY id) AS stt, id, studentid,[name],gender,dob,classid,majorid,cname,pob,ht,prr,\n" +
"nation,religion,academicl,nien,CMND,phone,gmail FROM Student) select * from o WHERE (studentid LIKE ? OR [name] LIKE ?) and classid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+ search + "%");
            statement.setString(2,"%"+ search + "%");
            statement.setString(3,classid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Student x = new Student(rs.getInt("stt"),rs.getInt("id"),rs.getString("studentid"), rs.getString("name"),rs.getBoolean("gender"), rs.getDate("dob"),
                       rs.getString("classid"), rs.getString("majorid"), rs.getString("cname"), rs.getString("pob"), rs.getString("ht"), 
                       rs.getString("prr"),rs.getString("nation"), rs.getString("religion"), rs.getString("academicl"), rs.getString("nien"),
                       rs.getString("CMND"), rs.getString("phone"), rs.getString("gmail"));
                cc.add(x);   
            }  

        } catch (SQLException ex) { 
        }
        return cc;
    }
    
    public ArrayList<Student> searchStudentByMajClassId(String search, String majorid, String classid) {      
        ArrayList<Student> cc = new ArrayList<>();           
        try {
            String sql = "with o as (SELECT ROW_NUMBER() OVER(ORDER BY id) AS stt, id, studentid,[name],gender,dob,classid,majorid,cname,pob,ht,prr,\n" +
"nation,religion,academicl,nien,CMND,phone,gmail FROM Student) select * from o WHERE (studentid LIKE ? OR [name] LIKE ?)  and majorid = ? and classid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+ search + "%");
            statement.setString(2,"%"+ search + "%");
            statement.setString(3,majorid);
            statement.setString(4,classid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Student x = new Student(rs.getInt("stt"),rs.getInt("id"),rs.getString("studentid"), rs.getString("name"),rs.getBoolean("gender"), rs.getDate("dob"),
                       rs.getString("classid"), rs.getString("majorid"), rs.getString("cname"), rs.getString("pob"), rs.getString("ht"), 
                       rs.getString("prr"),rs.getString("nation"), rs.getString("religion"), rs.getString("academicl"), rs.getString("nien"),
                       rs.getString("CMND"), rs.getString("phone"), rs.getString("gmail"));
            }  

        } catch (SQLException ex) { 
        }
        return cc;
    }
    
    public int updateStudent(String id, String studentid, String name, String gender, String dob, String classid, String majorid, String cname, String pob,
                             String ht, String prr, String nation, String religion, String academicl, String nien, String CMND, String phone, String gmail) throws SQLException {
        
            String sql = "Update Student set studentid = ?, [name] = ?, gender = ?,dob = ?, classid = ?, majorid = ?, cname = ?,\n" +
"pob = ?, ht = ?, prr = ?, nation = ?, religion = ?, academicl = ?, nien =?, CMND =?,phone =?, gmail = ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, studentid);
            statement.setString(2, name);
            statement.setString(3, gender);
            statement.setString(4, dob);
            statement.setString(5, classid);
            statement.setString(6, majorid);
            statement.setString(7, cname);
            statement.setString(8, pob);
            statement.setString(9, ht);
            statement.setString(10, prr);
            statement.setString(11, nation);
            statement.setString(12, religion);
            statement.setString(13, academicl);
            statement.setString(14, nien);
            statement.setString(15, CMND);
            statement.setString(16, phone);
            statement.setString(17, gmail);
            statement.setString(18, id);

            return statement.executeUpdate();

    }
    
    
    public static void main(String[] args) throws SQLException {
//        System.out.println(new StudentDAO().getAllStudent());
//        System.out.println(new StudentDAO().getStudent(3));
//          System.out.println(new StudentDAO().insertStudent("he2", "kiet", "true", "2002-2-2" , "DM1703", "DM20", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"));

//          System.out.println(new StudentDAO().updateStudent("3", "he1", "kiet", "true", "2002-2-2" , "DM1703", "DM20", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"));
//          System.out.println(new TeacherDAO().searchSubject("el"));
            System.out.println(new StudentDAO().getStudentByStudentId("HE161307"));
    }
        

    
}

