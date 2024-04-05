package com.jpa.demo.repository;

import com.jpa.demo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Informa ao Spring que esta interface atuará como um repositório de banco de dados.
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}