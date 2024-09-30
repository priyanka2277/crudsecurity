package com.example.codingtehnique.service;

import com.example.codingtehnique.MODEL.User;
import com.example.codingtehnique.dto.UserDto;
import com.example.codingtehnique.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Override
    public User save(UserDto userDto){
        User user=new User(userDto.getEmail(),passwordEncoder.encode(userDto.getPassword()),userDto.getRole(),userDto.getFullName());
        return userRepository.save(user);


    }
    public User findByUsername(String username){
        return userRepository.findByEmail(username);
    }
}
