package com.example.a1234.agriculture;

public class deseasepozo {
    private String Crops;
    private String Crops_Disease;
    private String Link;

    public deseasepozo(String crops, String crops_Disease, String link) {
        Crops = crops;
        Crops_Disease = crops_Disease;
        Link = link;
    }

    public String getCrops() {
        return Crops;
    }

    public void setCrops(String crops) {
        Crops = crops;
    }

    public String getCrops_Disease() {
        return Crops_Disease;
    }

    public void setCrops_Disease(String crops_Disease) {
        Crops_Disease = crops_Disease;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
