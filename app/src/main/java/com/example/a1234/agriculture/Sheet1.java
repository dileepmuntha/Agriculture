package com.example.a1234.agriculture;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Sheet1 {

    @PrimaryKey
    @NonNull
    private String S_No;

    private String CROP_NAME;

    private String LOCATION;

    private String TYPE_;

    private String PRICE;
    private String  QUANTITY;

    public Sheet1() {


    }

    public String getS_No() {
        return S_No;
    }

    public void setS_No(String s_No) {
        S_No = s_No;
    }

    public String getCROP_NAME() {
        return CROP_NAME;
    }

    public void setCROP_NAME(String CROP_NAME) {
        this.CROP_NAME = CROP_NAME;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public String getTYPE_() {
        return TYPE_;
    }

    public void setTYPE_(String TYPE_) {
        this.TYPE_ = TYPE_;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }
}
