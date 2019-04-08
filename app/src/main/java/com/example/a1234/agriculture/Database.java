package com.example.a1234.agriculture;

public class Database {
    String Gmail,password,mobileno,adharnumber,confirmpassword;

    public Database(String gmail, String password, String mobileno, String adharnumber, String confirmpassword) {
        Gmail = gmail;
        this.password = password;
        this.mobileno = mobileno;
        this.adharnumber = adharnumber;
        this.confirmpassword = confirmpassword;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getAdharnumber() {
        return adharnumber;
    }

    public void setAdharnumber(String adharnumber) {
        this.adharnumber = adharnumber;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
}
