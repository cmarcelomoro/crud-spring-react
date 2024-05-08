package com.example.apiteste.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.example.apiteste.model.PessoaRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.apiteste.model.Pessoa;
import com.example.apiteste.repository.PessoaRepository;


@Controller

@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path="/cadastrar")
    public ResponseEntity<Map<String, Object>> cadastrarPessoa(@RequestBody PessoaRequestDTO data){
        Pessoa pessoaData = new Pessoa(data);
        pessoaRepository.save(pessoaData);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Pessoa cadastrada com sucesso!");
        response.put("pessoa", pessoaData);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path="/remover")
    public ResponseEntity<Map<String, Object>> removerPessoa(@RequestParam String nome){
        Optional<Pessoa> pessoaOptional = pessoaRepository.findByNome(nome);
        if (!pessoaOptional.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Pessoa não encontrada para o nome fornecido");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        Pessoa pessoa = pessoaOptional.get();
        pessoaRepository.delete(pessoa);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Pessoa removida com sucesso!");
        response.put("pessoa", pessoa);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
