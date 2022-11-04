package com.example.coffeeshop;

public class Drinks
{
    private String name;
    private String desc;
    private int imgid;
    public static final Drinks[] drinks={

            new Drinks("Capachino","This is a description",R.drawable.logo),
            new Drinks("Capachino","This is a description",R.drawable.logo),
            new Drinks("Capachino","This is a description",R.drawable.logo)

    };
    private Drinks(String name,String desc,int imgid)
    {
        this.name=name;
        this.imgid=imgid;
        this.desc=desc;
    }
    public String getName() {
        return name;
    }
    public String getDesc()
    {
        return desc;
    }
    public int getImgid()
    {
        return imgid;
    }
    public String toString()
    {
        return this.name;
    }




}

