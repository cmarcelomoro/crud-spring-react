package com.example.apiteste.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pessoa {

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer id; 
   @Column(nullable=false)
   private String nome;
   @Column(nullable=false, unique=true)
   private String email;

   public Pessoa(PessoaRequestDTO data) {
      this.nome = data.nome();
      this.email = data.email();
   }
   
   public Pessoa(Integer id,String nome, String email) {
      this.nome = nome;
      this.id = id;
      this.email = email;
   }

   public Pessoa (PessoaRequestDTO data){
      this.nome = data.nome();
      this.email = data.email();
   }


   public Pessoa(String nome, String email) {
      this.nome = nome;
      this.email = email;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}