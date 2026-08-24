package com.amogh.journalApp.controller;

import com.amogh.journalApp.entity.JournalEntry;
import com.amogh.journalApp.entity.User;
import com.amogh.journalApp.service.JournalEntryService;
import com.amogh.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User>  getALUsers()
    {
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody  User user)
    {
        userService.saveEntry(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String username)
    {
        User userInDB = userService.findByUsername(username);
        if(userInDB != null) {
            userInDB.setUsername(user.getUsername());
            userInDB.setPassowrd(user.getPassowrd());
            userService.saveEntry(userInDB);
        }
        return new ResponseEntity<>(userInDB, HttpStatus.NO_CONTENT);

    }
}