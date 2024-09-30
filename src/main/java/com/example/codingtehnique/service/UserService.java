package com.example.codingtehnique.service;

import com.example.codingtehnique.MODEL.User;
import com.example.codingtehnique.dto.UserDto;

public interface UserService {
    User save(UserDto userDto);
    User findByUsername(String username);
}
