package com.coach.coach.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coach.coach.entity.Coach;
import com.coach.coach.repository.CoachRepository;
import com.coach.coach.service.CoachService;

@RestController
@RequestMapping("/coaches")
@CrossOrigin(origins = "http://localhost:3000/")
public class CoachController {

    @Autowired
    private CoachRepository coachRepository;
    
    @Autowired
    private CoachService coachService;

    @PostMapping("/register")
    public ResponseEntity<?> registerCoach(@Valid @RequestBody Coach coach, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        coachRepository.save(coach);
        return ResponseEntity.ok("Coach registered successfully!");
    }
    
   

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam(value = "id") Long id,
                                        @RequestParam(value = "password") String password) {
        boolean isValid = coachService.isValid(id, password);
        if (isValid) {
            return new ResponseEntity<>("Successfully logged in", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid id or password", HttpStatus.UNAUTHORIZED);
        }
    }
    
    @GetMapping("/data")
    public ResponseEntity<?> getAllData() {
        try {
            List<Coach> data = coachService.getAllData();
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}


