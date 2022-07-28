package com.genral9ledge_pro_app.genral9ledge.Model;

public class rajpalModel {
    int image;
    String name;
    String rajya;
    String time;

    public rajpalModel(int image, String name, String rajya, String time) {
        this.image = image;
        this.name = name;
        this.rajya = rajya;
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRajya() {
        return rajya;
    }

    public void setRajya(String rajya) {
        this.rajya = rajya;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
