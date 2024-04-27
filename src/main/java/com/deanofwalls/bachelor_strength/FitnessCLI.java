package com.deanofwalls.bachelor_strength;

import com.deanofwalls.bachelor_strength.model.UserModel;
import com.deanofwalls.bachelor_strength.service.FitnessService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import java.util.Scanner;

@SpringBootApplication
@Profile("cli")
public class FitnessCLI implements CommandLineRunner {

    @Autowired
    private FitnessService service;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(FitnessCLI.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.setAdditionalProfiles("cli"); // Ensure the 'cli' profile is active
        app.run(args);
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);


            System.out.println("Enter gender (male/female): ");
            String gender = scanner.next();
            System.out.println("Enter age: ");
            int age = scanner.nextInt();
            System.out.println("Enter height in cm: ");
            int height = scanner.nextInt();
            System.out.println("Enter weight in lbs ");
            int weight = scanner.nextInt();

            UserModel userModel = new UserModel(age, height, weight, gender);

            System.out.println("Gender: " + gender);
            System.out.println("Age: " + age);
            System.out.println("Height: " + height + " cm");
            System.out.println("Weight: " + weight + " lbs");
            System.out.println("BMI: " + service.calculateBMI(userModel));
            System.out.println("TDEE: " + service.calculateTDEE(userModel));
            System.out.println("Daily protein goal: " + service.calculateProteinIntake(userModel) + " grams");
            System.out.println("Daily caloric goal: " + service.calculateCaloriesForHypertrophy(userModel) + " calories");
    }
}
