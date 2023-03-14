package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> users = userRepository.findAll().stream().map( user -> {
            UserDTO userDto = userMapper.UserToUserDTO(user);
            String activeDesc = userDto.getActive() ? "Yes" : "No";
            userDto.setActiveDesc(activeDesc);

            return userDto;
        }).collect(Collectors.toList());

        return users;
    }

    @Override
    public List<UserDTO> findById(int id) {
        return null;
    }

    @Override
    public void newUser(UserDTO user) {
        User userToAdd = userMapper.UserDTOToUser(user);
        userRepository.saveAndFlush(userToAdd);
    }

    @Override
    public void updateUser(UserDTO userDto) {
        userRepository.saveAndFlush(userMapper.UserDTOToUser(userDto));
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
