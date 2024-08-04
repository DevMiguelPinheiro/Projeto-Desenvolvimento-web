package com.api.api_user.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api_user.entities.Aluno;
import com.api.api_user.repositories.AlunoRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
    private AlunoRepository repository;

    @PostMapping(value = "inserir")
    public ResponseEntity<?> saveAluno(@Valid @RequestBody Aluno aluno, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Aluno savedAluno = repository.save(aluno);
        return ResponseEntity.ok(savedAluno);
    }

    @GetMapping(value = "/listar")
    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = repository.findAll();
        System.out.println("Alunos retornados: " + alunos);
        return alunos;
    }


    @GetMapping(value = "/obter/{matricula}")
    public ResponseEntity<?> getAlunoByMatricula(@PathVariable Long matricula) {
        Optional<Aluno> aluno = repository.findByMatricula(matricula);
        return aluno.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
    }
