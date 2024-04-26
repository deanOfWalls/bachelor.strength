package com.deanofwalls.bachelor_strength;

import com.deanofwalls.bachelor_strength.model.UserModel;
import com.deanofwalls.bachelor_strength.service.FitnessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestProteinIntake {

    @Autowired
    private FitnessService fitnessService;

    @Test
    void testProteinIntake(){
        //Given
        UserModel userModel = new UserModel(0, 0, 170, "null");
        int expectedProteinIntake = 138;

        //When
        int actualProteinIntake = fitnessService.calculateProteinIntake(userModel);

        //Then
        assertEquals(expectedProteinIntake, actualProteinIntake, "The calculated protein intake should match the expected value");

    }


}
