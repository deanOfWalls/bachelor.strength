package com.deanofwalls.bachelor_strength.service;

import com.deanofwalls.bachelor_strength.model.CalculationsModel;
import com.deanofwalls.bachelor_strength.model.UserModel;
import org.springframework.stereotype.Service;

/**
 * Service layer for business logic.
 * Rename this class to reflect the services it provides, e.g., PersonService for services related to Person entities.
 */
@Service
public class FitnessService {

    public CalculationsModel calculationsModel(UserModel userModel) {
        double bmi = calculateBMI();
        //((10 * (weightInPounds / POUNDS_TO_KILOGRAMS)) + (6.25 * heightInCm) - (5 * age) + 5) * ACTIVITY_FACTOR;
        double tdee = calculateTDEE(userModel.);
        int recommendedProtein = calculateProteinIntake(userModel.getWeight());
        int recommendedCalories = calculateCaloriesForHypertrophy(userModel); // Assuming you will implement this

        return new CalculationsModel(bmi, tdee, recommendedProtein, recommendedCalories);
    }

    private double calculateBMI(UserModel userModel) {
        // Convert height from cm to meters and weight from lbs to kg for BMI calculation
        double heightInMeters = userModel.getHeight() / 100;
        double weight= userModel.getWeight();
        return (weight * 0.453592) / (heightInMeters * heightInMeters);
    }

    private double calculateTDEE(UserModel userModel) {
        // Placeholder for TDEE calculation
        return 0;
    }

    private int calculateProteinIntake(UserModel userModel) {
        // Example: 1.8 grams per kg of body weight
        return (int) (weight * 0.453592 * 1.8); // Convert lbs to kg
    }

    private int calculateCaloriesForHypertrophy(UserModel userModel) {
        // Placeholder for hypertrophy calories calculation
        return 0;
    }
}