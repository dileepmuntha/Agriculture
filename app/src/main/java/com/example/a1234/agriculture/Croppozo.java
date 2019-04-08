package com.example.a1234.agriculture;

public class Croppozo {
    private String S_No;

    private String Crop_name;
    private String Source_link;
    private String Image_url;

    public Croppozo(String name, String imge, String sourceLink) {

        this.Crop_name=name;
        this.Image_url=imge;
        this.Source_link=sourceLink;
    }

    public String getS_No() {
        return S_No;
    }

    public void setS_No(String s_No) {
        S_No = s_No;
    }

    public String getCrop_name() {
        return Crop_name;
    }

    public void setCrop_name(String crop_name) {
        Crop_name = crop_name;
    }

    public String getSource_link() {
        return Source_link;
    }

    public void setSource_link(String source_link) {
        Source_link = source_link;
    }

    public String getImage_url() {
        return Image_url;
    }

    public void setImage_url(String image_url) {
        Image_url = image_url;
    }
}
