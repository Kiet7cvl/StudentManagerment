/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author ADMIN
 */
public class Class {
    private int stt;
    private String classid;
    private String classname;

    public Class() {
    }

    public Class(int stt, String classid, String classname) {
        this.stt = stt;
        this.classid = classid;
        this.classname = classname;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "Class{" + "stt=" + stt + ", classid=" + classid + ", classname=" + classname + '}' +"\n";
    }
    
    
    
}
