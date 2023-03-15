package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public UserDTO findById(@PathVariable int id) {
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

    @PutMapping(value = "/updateUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> updateUser(@PathVariable int id, @RequestBody UserDTO userDto) {
        userService.updateUser(id, userDto);
        HashMap<String, Object> map = new HashMap<>();
        map.put("Success", true);
        map.put("message", "User updated");
        return map;
    }

    @DeleteMapping(value = "/deleteUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
