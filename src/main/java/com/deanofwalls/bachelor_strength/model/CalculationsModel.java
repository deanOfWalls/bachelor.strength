package com.deanofwalls.bachelor_strength.model;

public class CalculationsModel {
    private int bmi;
    private int tdee;
    private int recommendedProtein;
    private int recommendedCalories;

    public CalculationsModel(int bmi, int tdee, int recommendedProtein, int recommendedCalories) {
        this.bmi = bmi;
        this.tdee = tdee;
        this.recommendedProtein = recommendedProtein;
        this.recommendedCalories = recommendedCalories;
    }

    public double getBMI() {
        return bmi;
    }

    public void setBMI(int bmi) {
        this.bmi = bmi;
    }

    public double getTDEE() {
        return tdee;
    }

    public void setTDEE(int tdee) {
        this.tdee = tdee;
    }

    public int getRecommendedProtein() {
        return recommendedProtein;
    }

    public void setRecommendedProtein(int recommendedProtein) {
        this.recommendedProtein = recommendedProtein;
    }

    public int getRecommendedCalories() {
        return recommendedCalories;
    }

    public void setRecommendedCalories(int recommendedCalories) {
        this.recommendedCalories = recommendedCalories;
    }
}
