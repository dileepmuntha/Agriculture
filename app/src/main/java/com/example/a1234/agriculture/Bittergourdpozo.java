package com.example.a1234.agriculture;

import android.os.Parcel;
import android.os.Parcelable;

public class Bittergourdpozo implements Parcelable {
    private String S_No;
    private String LOCATION;
    private String TYPE_;
    private String QUANTITY;
      private String PRICE;

    public Bittergourdpozo(String s_No, String LOCATION, String TYPE_, String QUANTITY, String PRICE) {
       this.S_No = s_No;
        this.LOCATION = LOCATION;
        this.TYPE_ = TYPE_;
        this.QUANTITY = QUANTITY;
        this.PRICE = PRICE;
    }

    protected Bittergourdpozo(Parcel in) {
        S_No = in.readString();
        LOCATION = in.readString();
        TYPE_ = in.readString();
        QUANTITY = in.readString();
        PRICE = in.readString();
    }

    public static final Creator<Bittergourdpozo> CREATOR = new Creator<Bittergourdpozo>() {
        @Override
        public Bittergourdpozo createFromParcel(Parcel in) {
            return new Bittergourdpozo(in);
        }

        @Override
        public Bittergourdpozo[] newArray(int size) {
            return new Bittergourdpozo[size];
        }
    };

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getS_No() {
        return S_No;
    }

    public void setS_No(String s_No) {
        S_No = s_No;
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

    public String getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(S_No);
        dest.writeString(LOCATION);
        dest.writeString(TYPE_);
        dest.writeString(QUANTITY);
        dest.writeString(PRICE);
    }
}

