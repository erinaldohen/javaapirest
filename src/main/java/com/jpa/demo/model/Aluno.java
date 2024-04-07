package com.jpa.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity // Anotação que informa ao Spring que esta classe será uma entidade do banco de dados
@Table(name = "aluno", indexes = {
        @Index(name = "IDX_USER_CPF_UNQ", columnList = "cpf", unique = true)
}) // Anotação que define qual o nome da tabela no banco de dados
public class Aluno implements Serializable { // A classe Aluno implementa uma interface responsável pela serialização.

    private static final long versionSerialUID = 1L;    // Esta variável define a versão da serialização. Caso haja uma mudança significativa na estrutura da classe Aluno o valor da versão deve ser alterado

    @Id // Anotação que informa ao Spring qual será a chave primária da tabela tb_aluno
    @GeneratedValue(strategy = GenerationType.UUID) // Anotação que gera automaticamente um valor para a chave primária
    private String id;

    @Column(name ="cpf")
    private String cpf;
    private String password;
    private String email;

    public Aluno() { // Construtor vazio (padrão)
    }

    // Métodos Get e Set da classe
    public Aluno(String cpf) {
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}