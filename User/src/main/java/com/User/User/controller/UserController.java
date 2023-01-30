package com.User.User.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.User.User.entity.Coach;
import com.User.User.entity.User;
import com.User.User.exception.InvalidInputException;
import com.User.User.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signup")
    public ResponseEntity<String> signup(@Valid @RequestBody User user) {
        try {
            userService.signup(user);
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } catch (InvalidInputException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("login")
    public ResponseEntity<String> login(@RequestParam Long id, @RequestParam String password) {
        User user = userService.validateUser(id, password);
        if(user != null) {
            return new ResponseEntity<>("Welcome " + user.getId(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid id or password", HttpStatus.UNAUTHORIZED);
        }
}
/*
 * @GetMapping("getcoaches") public ResponseEntity<?> getallcoaches () { try {
 * List<Coach> data = userService.getDataFromCoach(); return new
 * ResponseEntity<>(data, HttpStatus.OK); } catch (Exception e) { return new
 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
 */

}