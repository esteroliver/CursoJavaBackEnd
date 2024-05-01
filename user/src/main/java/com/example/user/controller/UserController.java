package com.example.user.controller;

import com.example.user.repository.UserRepository;

import com.example.user.dto.UserDTO;
import com.example.user.model.UserModel;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public ResponseEntity<List<UserModel>> obterTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getMethodName(@PathVariable UUID id) {
        Optional<UserModel> us = userRepository.findById(id);
        if(us.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não foi encontrado.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(us.get());
    }

    @PostMapping("/user")
    public ResponseEntity<UserModel> postMethodName(@RequestBody UserDTO usDTO) {
        UserModel us = new UserModel();
        BeanUtils.copyProperties(usDTO, us);
        userRepository.save(us);
        return ResponseEntity.status(HttpStatus.CREATED).body(us);
    }
    
}
