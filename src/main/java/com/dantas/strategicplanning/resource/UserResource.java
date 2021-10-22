package com.dantas.strategicplanning.resource;

import com.dantas.strategicplanning.model.User;
import com.dantas.strategicplanning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    UserRepository userRepository;


    @GetMapping
    public List<User> listUsers(){
       return userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user, HttpServletResponse response){

        User userCreated = userRepository.save(user);

        //GENERATE URI TO SET LOCATION OF RESOURCE CREATED INTO API AND SET IN HEADER RESPONSE
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(userCreated.getId()).toUri();

        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(userCreated);

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){

        User userFounded = userRepository.findById(id).orElse(null);

        return Objects.isNull(userFounded)
                ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.ok(userFounded);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}
