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
        double bmi = calculateBMI(userModel);
        double tdee = calculateTDEE(userModel);
        int recommendedProtein = calculateProteinIntake(userModel);
        int recommendedCalories = calculateCaloriesForHypertrophy(userModel); // Assuming you will implement this

        return new CalculationsModel(bmi, tdee, recommendedProtein, recommendedCalories);
    }

    private double calculateBMI(UserModel userModel) {
        return (userModel.getWeight() * 0.453592) / (Math.pow(userModel.getHeight() / 100, 2));
    }


    private double calculateTDEE(UserModel userModel) {
        // Placeholder for TDEE calculation
        return 0;
    }

    private int calculateProteinIntake(UserModel userModel) {
        // Example: 1.8 grams per kg of body weight
        return (int) (userModel.getWeight() * 0.453592 * 1.8); // Convert lbs to kg
    }

    private int calculateCaloriesForHypertrophy(UserModel userModel) {
        // Placeholder for hypertrophy calories calculation
        return 0;
    }
}