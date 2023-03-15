/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

/**
 *
 * @author macbookair
 */
public class Major {
    private int stt;
    private String majorid;
    private String majorname;

    public Major() {
    }

    public Major(int stt, String majorid, String majorname) {
        this.stt = stt;
        this.majorid = majorid;
        this.majorname = majorname;
    }

    
    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public String getMajorid() {
        return majorid;
    }

    public void setMajorid(String majorid) {
        this.majorid = majorid;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    @Override
    public String toString() {
        return "Major{" + "stt=" + stt + ", majorid=" + majorid + ", majorname=" + majorname + '}'+"\n";
    }

    
    

}
