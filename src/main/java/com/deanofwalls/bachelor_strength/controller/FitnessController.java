package com.deanofwalls.bachelor_strength.controller;

import com.deanofwalls.bachelor_strength.model.CalculationsModel;
import com.deanofwalls.bachelor_strength.model.UserModel;
import com.deanofwalls.bachelor_strength.service.FitnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller to handle HTTP requests.
 * Rename this class to reflect its purpose, e.g., PersonController if it manages Person entities.
 */
@RestController
public class FitnessController {

    @Autowired
    private FitnessService fitnessService;

//    @PostMapping("/calculate")
@RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public CalculationsModel calculateUserMacros(@RequestBody UserModel userModel) {
        // Call FitnessService to calculate derived values
        CalculationsModel calculationsModel = fitnessService.calculationsModel(userModel);

        return calculationsModel;
    }
}
