package com.deanofwalls.bachelor_strength;

import com.deanofwalls.bachelor_strength.model.UserModel;
import com.deanofwalls.bachelor_strength.service.FitnessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestCaloriesForHypertrophy {

    @Autowired
    private FitnessService fitnessService;

    @Test
    void testCaloriesForHypertrophy() {
        //Given: setup our test data
        UserModel userModel = new UserModel(30, 180, 170, "male");
        double expectedCaloriesForHypertrophy = 2714 + 500; //rounded value

        //When
        double actualCaloriesForHypertrophy = fitnessService.calculateCaloriesForHypertrophy(userModel);

        //Then
        assertEquals(expectedCaloriesForHypertrophy, actualCaloriesForHypertrophy, 0.01, "The CaloriesForHypertrophy should match the expected value.");
    }
}