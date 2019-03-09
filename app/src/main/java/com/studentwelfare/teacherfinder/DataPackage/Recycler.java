package com.studentwelfare.teacherfinder.DataPackage;

import android.content.Context;

public class Recycler {
    String name;
    String Img;
    Context ctx;

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    String dsc;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    String ID;
    public Recycler(Context context, String n, String i, String d,String desc){
        this.ctx = context;
        this.setImg(i);
        this.setName(n);
        this.setID(d);
        this.setDsc(desc);
    }

    public String getName() {
        return name;
    }

    public void setImg(String img){
        this.Img = img;
    }

    public String getImg() {
        return Img;
    }

    public void setName(String name) {
        this.name = name;
    }




}
