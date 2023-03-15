/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author ADMIN
 */
public class Subject {
    private int stt;
    private String subjectid;
    private String subjectname;
    private String majorid;

    public Subject() {
    }

    public Subject(int stt, String subjectid, String subjectname, String majorid) {
        this.stt = stt;
        this.subjectid = subjectid;
        this.subjectname = subjectname;
        this.majorid = majorid;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getMajorid() {
        return majorid;
    }

    public void setMajorid(String majorid) {
        this.majorid = majorid;
    }

    @Override
    public String toString() {
        return "subject{" + "stt=" + stt + ", subjectid=" + subjectid + ", subjectname=" + subjectname + ", majorid=" + majorid + '}' +"\n";
    }
    
    
}
