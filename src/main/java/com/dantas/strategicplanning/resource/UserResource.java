package com.dantas.strategicplanning.resource;

import com.dantas.strategicplanning.model.User;
import com.dantas.strategicplanning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    UserRepository userRepository;


    @GetMapping
    public List<User> listUsers(){
       return userRepository.findAll();
    }
}
