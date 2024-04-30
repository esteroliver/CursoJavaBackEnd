package com.example.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.repositories.ProdutoRepository;

@RestController
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    
}
