/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author ADMIN
 */
public class Teacher {
    private int stt;
    private String teacherid;
    private String teachername;
    private String phone;
    private String literacy;
    private String nationality;
    private String subjectid;
    private String classid;

    public Teacher() {
    }

    public Teacher(int stt, String teacherid, String teachername, String phone, String literacy, String nationality, String subjectid, String classid) {
        this.stt = stt;
        this.teacherid = teacherid;
        this.teachername = teachername;
        this.phone = phone;
        this.literacy = literacy;
        this.nationality = nationality;
        this.subjectid = subjectid;
        this.classid = classid;
    }
    

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLiteracy() {
        return literacy;
    }

    public void setLiteracy(String literacy) {
        this.literacy = literacy;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    @Override
    public String toString() {
        return "Teacher{" + "stt=" + stt + ", teacherid=" + teacherid + ", teachername=" + teachername + ", phone=" + phone + 
               ", literacy=" + literacy + ", nationality=" + nationality + ", subjectid=" + subjectid + ", classid=" + classid + '}' +"\n";
    }

    
}
