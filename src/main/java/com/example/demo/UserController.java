package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "user")

@CrossOrigin(origins = "*")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findById(@PathVariable Map<String, String> pathMap) {
        int id = Integer.valueOf(pathMap.get("id"));
        return userService.findById(id);
    }

    @PostMapping(value = "/addNewUser", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> addNewUser(@RequestBody UserDTO userDto) {
        userService.newUser(userDto);
        HashMap<String, Object> map = new HashMap<>();
        map.put("Success", true);
        map.put("message", "User created successfully");
        return map;
    }

    @PutMapping(value = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(UserDTO userDto) {

    }

    @DeleteMapping(value = "/deleteUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(int id) {
        userService.deleteUser(id);
    }
}
