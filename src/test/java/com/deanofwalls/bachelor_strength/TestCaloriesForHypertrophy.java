package com.deanofwalls.bachelor_strength;

import com.deanofwalls.bachelor_strength.model.UserModel;
import com.deanofwalls.bachelor_strength.service.FitnessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = MainApplication.class)
@ActiveProfiles("web")
public class TestCaloriesForHypertrophy {

    @Autowired
    private FitnessService fitnessService;

    @Test
    void testCaloriesForHypertrophy() {
        //Given: setup our test data
        UserModel userModel = new UserModel(30, 180, 170, "male");
        int expectedCaloriesForHypertrophy = 2714 + 500; //rounded value

        //When
        int actualCaloriesForHypertrophy = fitnessService.calculateCaloriesForHypertrophy(userModel);

        //Then
        assertEquals(expectedCaloriesForHypertrophy, actualCaloriesForHypertrophy, 0.01, "The CaloriesForHypertrophy should match the expected value.");
    }
}
