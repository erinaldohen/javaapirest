package com.jpa.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.io.Serializable;
import java.util.UUID;

@Entity // Anotação que informa ao Spring que esta classe será uma entidade do banco de dados
@Table(name = "tb_aluno") // Anotação que define qual o nome da tabela no banco de dados
public class Aluno implements Serializable { // A classe Aluno implementa uma interface responsável pela serialização.
    private static final long versionSerialUID = 1L;    // Esta variável define a versão da serialização. Caso haja uma mudança significativa na estrutura da classe Aluno o valor da versão deve ser alterado
    @Id // Anotação que informa ao Spring qual será a chave primária da tabela tb_aluno
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação que gera automaticamente um valor para a chave primária
    private int id;
    private String cpf;

    public Aluno() { // Construtor vazio (padrão)
    }

    // Métodos Get e Set da classe
    public Aluno(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}