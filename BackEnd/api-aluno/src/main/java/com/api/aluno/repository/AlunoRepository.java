package com.api.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.aluno.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
