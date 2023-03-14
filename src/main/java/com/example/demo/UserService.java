package com.example.demo;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    List<UserDTO> findById(int id);

    void newUser(UserDTO userDto);
    void updateUser(UserDTO userDto);
    void deleteUser(int id);
//    UserDTO getById(Integer id);
}
