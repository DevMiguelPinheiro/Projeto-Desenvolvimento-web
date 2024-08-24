package com.api.aluno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.aluno.dto.AlunoDTO;
import com.api.aluno.model.Aluno;
import com.api.aluno.service.AlunoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Aluno> getAlunoById(@PathVariable Long id) {
        return alunoService.findById(id);
    }

    @PostMapping
    public Aluno createAluno(@RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = alunoService.createAluno(alunoDTO.getNome(), alunoDTO.getIdade(), alunoDTO.getEmail());
        return alunoService.saveAluno(aluno);
    }

    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO) throws Exception {
        // Verifica se o aluno existe
        Optional<Aluno> existingAluno = alunoService.findById(id);
        if (existingAluno.isPresent()) {
            Aluno aluno = existingAluno.get();
            aluno.setNome(alunoDTO.getNome());
            aluno.setIdade(alunoDTO.getIdade());
            aluno.setEmail(alunoDTO.getEmail());
            return alunoService.saveAluno(aluno);
        } else {
            // Lançar uma exceção ou retornar um erro se o aluno não for encontrado
            throw new Exception("Aluno não encontrado com ID: ");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable Long id) {
        alunoService.deleteById(id);
    }
}
