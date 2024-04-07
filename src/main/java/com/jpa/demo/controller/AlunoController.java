package com.jpa.demo.controller;

import com.jpa.demo.dto.AlunoFinder;
import com.jpa.demo.dto.AlunoRegister;
import com.jpa.demo.repository.AlunoRepository;
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
    //    // @RequestBody mapeia o corpo HttpRequest para um objeto de transferência
    public ResponseEntity salvaAluno(@RequestBody AlunoRegister body){
        Aluno alunoObj = new Aluno(); // criando um novo usuário
        alunoObj.setCpf(body.cpf());
        alunoObj.setPassword(body.password());
        alunoObj.setEmail(body.email());


        alunoRepository.save(alunoObj); // invoca o método save para armazenar o objeto no banco de dados
        return ResponseEntity.status(HttpStatus.CREATED).build(); // Retorna o status da resposta HTTP após a compilação
    }

    @GetMapping
    public ResponseEntity<Aluno> getUser(@RequestBody AlunoFinder body){
        Aluno alunoObj = alunoRepository.findByEmail(body.email());

            return ResponseEntity.ok(alunoObj);
    }

    @DeleteMapping
    public ResponseEntity<String> deletarAluno(@RequestBody AlunoFinder body){
        Aluno alunoObj = alunoRepository.findByEmail(body.email());
        alunoRepository.deleteById(alunoObj.getId());

        return ResponseEntity.ok("Aluno deletado com sucesso");

    }
}