package org.ncu.hirewheels.controller;


import org.ncu.hirewheels.entities.ResponseUser;
import org.ncu.hirewheels.entities.UserLogin;
import org.ncu.hirewheels.entities.Users;
import org.ncu.hirewheels.exceptions.UnauthorizedUserException;
import org.ncu.hirewheels.exceptions.UserNotRegisteredException;
import org.ncu.hirewheels.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/hirewheel/v1")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "/users" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addUser(@RequestBody Users users) {
        return new ResponseEntity<Boolean>(userService.createUser(users), HttpStatus.CREATED);
    }
    @PostMapping(value = "/users/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUser> login(@RequestBody UserLogin userLogin) 
        throws UserNotRegisteredException, UnauthorizedUserException{
        return new ResponseEntity<ResponseUser>(userService.getUsers(userLogin), HttpStatus.ACCEPTED);
    }
    
}
