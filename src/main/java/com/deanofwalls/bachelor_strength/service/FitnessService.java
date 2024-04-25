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
    // Business logic and interactions with the repository

    public CalculationsModel calculateMetrics(UserModel userModel){
        double bmi = calculateBMI(userModel.getWeight(), userModel.getHeight());
//        double tdee = calculateTDEE(userModel)
        int recommendedProtein = calculateProteinIntake(userModel.getWeight());
    }


    private double calculateBMI(int weight, double height){
        return weight / (height * height);
    }

}
