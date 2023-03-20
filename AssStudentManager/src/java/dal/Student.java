/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Student {
    private int stt;
    private int id;
    private String studentid;
    private String name;
    private boolean gender;
    private Date dob;
    private String classid;
    private String majorid;
    private String cname;
    private String pob;
    private String ht;
    private String prr;
    private String naion;
    private String religion;
    private String acadamicl;
    private String nien;
    private String CMND;
    private String phone;
    private String gmail;

    public Student() {
    }

    public Student(int stt, int id, String studentid, String name, boolean gender, Date dob, String classid, String majorid, String cname, String pob, String ht, String prr, String naion, String religion, String acadamicl, String nien, String CMND, String phone, String gmail) {
        this.stt = stt;
        this.id = id;
        this.studentid = studentid;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.classid = classid;
        this.majorid = majorid;
        this.cname = cname;
        this.pob = pob;
        this.ht = ht;
        this.prr = prr;
        this.naion = naion;
        this.religion = religion;
        this.acadamicl = acadamicl;
        this.nien = nien;
        this.CMND = CMND;
        this.phone = phone;
        this.gmail = gmail;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getMajorid() {
        return majorid;
    }

    public void setMajorid(String majorid) {
        this.majorid = majorid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public String getHt() {
        return ht;
    }

    public void setHt(String ht) {
        this.ht = ht;
    }

    public String getPrr() {
        return prr;
    }

    public void setPrr(String prr) {
        this.prr = prr;
    }

    public String getNaion() {
        return naion;
    }

    public void setNaion(String naion) {
        this.naion = naion;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getAcadamicl() {
        return acadamicl;
    }

    public void setAcadamicl(String acadamicl) {
        this.acadamicl = acadamicl;
    }

    public String getNien() {
        return nien;
    }

    public void setNien(String nien) {
        this.nien = nien;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    @Override
    public String toString() {
        return "Student{" + "stt=" + stt + ", id=" + id + ", studentid=" + studentid + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", classid=" + classid + ", majorid=" + majorid + ", cname=" + cname + ", pob=" + pob + ", ht=" + ht + ", prr=" + prr + ", naion=" + naion + ", religion=" + religion + ", acadamicl=" + acadamicl + ", nien=" + nien + ", CMND=" + CMND + ", phone=" + phone + ", gmail=" + gmail + '}' +"\n";
    }

    
    
}
