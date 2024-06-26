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
        int bmi = calculateBMI(userModel);
        int tdee = calculateTDEE(userModel);
        int recommendedProtein = calculateProteinIntake(userModel);
        int recommendedCalories = calculateCaloriesForHypertrophy(userModel); // Assuming you will implement this

        return new CalculationsModel(bmi, tdee, recommendedProtein, recommendedCalories);
    }

    public int calculateBMI(UserModel userModel) {
        double result = (userModel.getWeight() * 0.453592) / (Math.pow(userModel.getHeight() / 100.0, 2));
        return (int) Math.round(result);
    }


    public int calculateTDEE(UserModel userModel) {
        String gender = userModel.getGender();
        double result;
        if (gender.equalsIgnoreCase("male")) {
            result = (10 * (userModel.getWeight() / 2.20462) + 6.25 * userModel.getHeight() - 5 * userModel.getAge() + 5) * 1.55;
        } else if (gender.equalsIgnoreCase("female")) {
            result = (10 * (userModel.getWeight() / 2.20462) + 6.25 * userModel.getHeight() - 5 * userModel.getAge() - 161) * 1.55;
        } else {
            return 0;
        }
        return (int) Math.round(result);
    }

    public int calculateProteinIntake(UserModel userModel) {
        // Example: 1.8 grams per kg of body weight
        return (int) (userModel.getWeight() * 0.453592 * 1.8); // Convert lbs to kg
    }

    public int calculateCaloriesForHypertrophy(UserModel userModel) {
        double tdee = calculateTDEE(userModel);
        int caloricSurplus = 500; // A typical surplus for hypertrophy; adjust based on goals
        return (int) (tdee + caloricSurplus);
    }

}