package com.example.demo;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO findById(int id);

    void newUser(UserDTO userDto);
    void updateUser(int id, UserDTO userDto);
    void deleteUser(int id);
//    UserDTO getById(Integer id);
}
