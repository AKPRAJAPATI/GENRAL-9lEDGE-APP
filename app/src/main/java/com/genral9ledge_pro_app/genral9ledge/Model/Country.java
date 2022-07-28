package com.genral9ledge_pro_app.genral9ledge.Model;

public class Country {
    private int image;
    private String rajya;
    private String rajdhani;

    public Country(int image, String rajya, String rajdhani) {
        this.image = image;
        this.rajya = rajya;
        this.rajdhani = rajdhani;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getRajya() {
        return rajya;
    }

    public void setRajya(String rajya) {
        this.rajya = rajya;
    }

    public String getRajdhani() {
        return rajdhani;
    }

    public void setRajdhani(String rajdhani) {
        this.rajdhani = rajdhani;
    }
}
