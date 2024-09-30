package com.example.codingtehnique.controller;
import  com.example.codingtehnique.MODEL.Product;
import com.example.codingtehnique.MODEL.User;
import com.example.codingtehnique.dto.UserDto;
import com.example.codingtehnique.service.ProductService;
import com.example.codingtehnique.service.UserService;
import com.example.codingtehnique.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    ProductService productService;
    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto){
        return "register";
    }
    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model){

        userService.save(userDto);
        model.addAttribute("message","Registered Successful");
        return "register";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/user-page")
    public String userPage(Model model, Principal principal){
        UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user",userDetails);
        String username=principal.getName();
        model.addAttribute("username",username);
        List<Product> products=productService.getAllProducts();
        model.addAttribute("products",products);

        return "user";
    }
    @GetMapping("/user/edit")
    public String editOwnProfile(Model model,Principal principal){
        String username=principal.getName();
        User user=userService.findByUsername(username);
        model.addAttribute("user",user);
        return "user/edit";
    }


    @GetMapping("/admin-page")
    public String adminPage(Model model ,Principal principal){
        UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user",userDetails);
        return "admin";
    }

}
