package com.springboot.springbootannotations.controller;

import com.springboot.springbootannotations.entity.User;
import com.springboot.springbootannotations.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;
    @PostMapping
    public ResponseEntity<User> creteUser(@RequestBody User user){
        User savesUser= userService.createUser(user);
        return new ResponseEntity<>(savesUser, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user= userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
       List<User>  listAllUsers=userService.getAllUsers();
       return new ResponseEntity<>(listAllUsers,HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestBody User user){
        user.setId(id);
      User updatedUser=  userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("user deleted successfully",HttpStatus.OK);
    }
}
