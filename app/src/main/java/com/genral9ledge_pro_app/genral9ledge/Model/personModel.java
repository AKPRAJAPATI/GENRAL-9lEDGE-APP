package com.genral9ledge_pro_app.genral9ledge.Model;

import java.io.Serializable;

public class personModel implements Serializable {
    private int getImage;
    private String first_secondNumber;
    private String name;
    private String kab_se_kab_tak;
    private String kitane_din;

    public personModel(int getImage, String first_secondNumber, String name, String kab_se_kab_tak, String kitane_din) {
        this.getImage = getImage;
        this.first_secondNumber = first_secondNumber;
        this.name = name;
        this.kab_se_kab_tak = kab_se_kab_tak;
        this.kitane_din = kitane_din;
    }

    public int getGetImage() {
        return getImage;
    }

    public void setGetImage(int getImage) {
        this.getImage = getImage;
    }

    public String getFirst_secondNumber() {
        return first_secondNumber;
    }

    public void setFirst_secondNumber(String first_secondNumber) {
        this.first_secondNumber = first_secondNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKab_se_kab_tak() {
        return kab_se_kab_tak;
    }

    public void setKab_se_kab_tak(String kab_se_kab_tak) {
        this.kab_se_kab_tak = kab_se_kab_tak;
    }

    public String getKitane_din() {
        return kitane_din;
    }

    public void setKitane_din(String kitane_din) {
        this.kitane_din = kitane_din;
    }
}
