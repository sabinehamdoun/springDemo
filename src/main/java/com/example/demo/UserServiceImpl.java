package com.example.demo;

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
    public UserDTO findById(int id) {
        User user = userRepository.findById(id).get();
        UserDTO userDTO = userMapper.UserToUserDTO(user);
        return userDTO;
    }

    @Override
    public void newUser(UserDTO newUser) {
        User userToAdd = userMapper.UserDTOToUser(newUser);
        userRepository.saveAndFlush(userToAdd);
    }

    @Override
    public void updateUser(int id, UserDTO userDto) {
        User updateUser = userRepository.findById(id).get();
        updateUser.setName(userDto.getName());
        updateUser.setAge(userDto.getAge());
        updateUser.setActive(userDto.getActive());
        userRepository.saveAndFlush(updateUser);

    }

    @Override
    public void deleteUser(int id) {
//        if (userRepository.existsById(id)) {
//            userRepository.deleteById(id);
//        } else {
//
//        }
        userRepository.deleteById(id);
    }
}
