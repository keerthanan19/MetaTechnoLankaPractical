package com.example.metatechnolankapractical.Object;

import android.graphics.drawable.Drawable;

public class Data {
    private String ID;
    private String Title;
    private String Headline;
    private Drawable Image;
    private String GradientColors;
    private String Description;
    private String Nutrition;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getHeadline() {
        return Headline;
    }

    public void setHeadline(String headline) {
        Headline = headline;
    }

    public Drawable getImage() {
        return Image;
    }

    public void setImage(Drawable image) {
        Image = image;
    }

    public String getGradientColors() {
        return GradientColors;
    }

    public void setGradientColors(String gradientColors) {
        GradientColors = gradientColors;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getNutrition() {
        return Nutrition;
    }

    public void setNutrition(String nutrition) {
        Nutrition = nutrition;
    }
}
