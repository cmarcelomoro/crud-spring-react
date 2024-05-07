package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Pessoa;
import com.repository.PessoaRepository;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping(path="/cadastrar")
    public ResponseEntity<Map<String, Object>> cadastrarPessoa(@RequestParam String nome, @RequestParam String email){
        Pessoa pessoa = new Pessoa(nome,email);
        pessoaRepository.save(pessoa);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Pessoa cadastrada com sucesso!");
        response.put("pessoa", pessoa);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
