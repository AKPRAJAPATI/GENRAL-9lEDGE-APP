package com.genral9ledge_pro_app.genral9ledge.Model;

public class purvPradhanMantri {
    private int photo;
    private String name;
    private String kab_se_kab_tak;

    public purvPradhanMantri(int photo, String name, String kab_se_kab_tak) {
        this.photo = photo;
        this.name = name;
        this.kab_se_kab_tak = kab_se_kab_tak;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
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
}
