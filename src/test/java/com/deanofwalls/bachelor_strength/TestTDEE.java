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
public class TestTDEE {

    @Autowired
    private FitnessService fitnessService;

    @Test
    public void testTDEE(){
        //Given: setup our test data
        UserModel userModel = new UserModel(30, 180, 170, "male");
        int expectedTDEE = 2714; //rounded value

        //When
        int actualTDEE = Math.round(fitnessService.calculateTDEE(userModel));

        //Then
        assertEquals(expectedTDEE, actualTDEE);
    }


}
