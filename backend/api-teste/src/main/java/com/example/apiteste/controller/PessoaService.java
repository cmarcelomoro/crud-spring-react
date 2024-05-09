package com.example.apiteste.controller;

import com.example.apiteste.model.Pessoa;
import com.example.apiteste.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired

    private PessoaRepository pessoaRepository;

    public Pessoa buscarPessoa(Integer id) {

        Pessoa pessoa = pessoaRepository.findById(id).orElse(null);

        return pessoa;
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {

        pessoaRepository.findById(id).ifPresent(pessoa -> {
            pessoa.setEmail(pessoaAtualizada.getEmail());
            pessoa.setNome(pessoaAtualizada.getNome());
            pessoaRepository.save(pessoa);
        });

        return pessoaAtualizada;
    }
}