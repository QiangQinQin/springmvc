package com.tulun.bean;

public class Student {
    private Integer SID;
    private String Sname;
    private Integer Sage;
    private String Ssex;

    @Override
    public String toString() {
        return "Student{" +
                "SID=" + SID +
                ", Sname='" + Sname + '\'' +
                ", Sage=" + Sage +
                ", Ssex='" + Ssex + '\'' +
                '}';
    }
      public Student() {
    }

    public Student(Integer SID, String sname, Integer sage, String ssex) {
        this.SID = SID;
        Sname = sname;
        Sage = sage;
        Ssex = ssex;
    }

    public Integer getSID() {
        return SID;
    }

    public void setSID(Integer SID) {
        this.SID = SID;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public Integer getSage() {
        return Sage;
    }

    public void setSage(Integer sage) {
        Sage = sage;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }
}
