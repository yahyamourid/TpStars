package com.example.tpstars.beans;

public class Star {
    private int id;
    private String name;
    private String img;
    private float star;
    private int country;
    private static int comp;

    public Star(String name, String img, float star, int country) {
        this.id = ++comp;
        this.name = name;
        this.img = img;
        this.star = star;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public static int getComp() {
        return comp;
    }

    public static void setComp(int comp) {
        Star.comp = comp;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }
}


