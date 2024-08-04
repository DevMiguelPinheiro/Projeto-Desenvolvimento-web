package com.api.api_user.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.api_user.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	@Query("SELECT a FROM Aluno a WHERE a.matricula = :matricula")
	Optional<Aluno> findByMatricula(Long matricula);



}
