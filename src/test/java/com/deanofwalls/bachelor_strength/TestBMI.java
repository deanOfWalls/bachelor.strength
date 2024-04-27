package com.deanofwalls.bachelor_strength;

import com.deanofwalls.bachelor_strength.model.CalculationsModel;
import com.deanofwalls.bachelor_strength.model.UserModel;
import com.deanofwalls.bachelor_strength.service.FitnessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the application.
 * Rename to reflect the specific tests it contains, e.g., PersonServiceTests for tests related to the PersonService.
 */
@SpringBootTest(classes = MainApplication.class)
@ActiveProfiles("web")
public class TestBMI {

	@Autowired
	private FitnessService fitnessService;

	@Test
	void testBMI() {
		// Given: setup our test data
		UserModel userModel = new UserModel(0, 178, 170, null);
		int expectedBMI = 24;

		// When
		int actualBMI =  fitnessService.calculateBMI(userModel);

		// Then
		assertEquals(expectedBMI, actualBMI, "The BMI calculation should match the expected value.");
	}
}
