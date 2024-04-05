package com.jpa.demo.controller;

import com.jpa.demo.repository.AlunoRepository;
import com.jpa.demo.dto.AlunoRecord;
import com.jpa.demo.model.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno") // Define o endpoint da aplicação, um endereco utilizado para comunicação entre uma API e um sistema externo.
public class AlunoController {
    @Autowired // Injeção de dependêcia, permite que o Spring controle as instância da classe AlunoRepository
    private AlunoRepository alunoRepository;
    public AlunoController(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @PostMapping // Método POST
    // ResponseEntity representa toda a resposta HTTP
    // @RequestBody mapeia o corpo HttpRequest para um objeto de transferência
    public ResponseEntity<AlunoRecord> salvaAluno(@RequestBody AlunoRecord alunoRecord){
        Aluno alunoObj = new Aluno(alunoRecord.cpf()); // alunoObj vai receber o DTO de alunoRecord
        alunoRepository.save(alunoObj); // invoca o método save para armazenar o objeto no banco de dados
        return ResponseEntity.status(HttpStatus.CREATED).build(); // Retorna o status da resposta HTTP após a compilação
    }
}