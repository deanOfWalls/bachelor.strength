package com.deanofwalls.bachelor_strength.controller;

import com.deanofwalls.bachelor_strength.model.CalculationsModel;
import com.deanofwalls.bachelor_strength.model.UserModel;
import com.deanofwalls.bachelor_strength.service.FitnessService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller to handle HTTP requests.
 * Rename this class to reflect its purpose, e.g., PersonController if it manages Person entities.
 */
@RestController
@RequestMapping("/")
public class FitnessController {

    @Autowired
    private FitnessService fitnessService;

    @PostMapping("/calculate")
    public ResponseEntity<CalculationsModel>


}
