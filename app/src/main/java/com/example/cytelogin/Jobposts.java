package com.example.cytelogin;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Jobposts {

    private List<Jobposts> posts;
    private Context mContext;


    public Jobposts(final Context context, final List<Jobposts> mData) {
        this.posts = posts;
        this.mContext = context;
    }

    public List<Jobposts> getData() {
        return posts;
    }


    public Jobposts(int id, String title, String industry, String city) {
        this.id = id;
        this.title = title;
        this.industry = industry;
        this.city = city;
    }

    private int id;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String title;
    private String industry;
    private String city;




}
