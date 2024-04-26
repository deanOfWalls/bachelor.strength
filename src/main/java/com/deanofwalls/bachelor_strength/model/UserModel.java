package com.deanofwalls.bachelor_strength.model;

/**
 * Data model (entity) class.
 * Rename this class to represent the entity it models, e.g., PersonModel, ProductModel, etc.
 */
public class UserModel {
    // Model attributes, constructors, getters, and setters

    private int age;
    private double height; //stored in cm
    private int weight; //stored in lbs
    private String gender;

    public UserModel(int age, double height, int weight, String gender) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
