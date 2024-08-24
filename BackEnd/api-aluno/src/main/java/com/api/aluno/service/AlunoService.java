package com.api.aluno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.aluno.exceptions.ResourceNotFoundException;
import com.api.aluno.model.Aluno;
import com.api.aluno.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    // Método para criar um novo aluno
    public Aluno createAluno(String nome, int idade, String email) {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setEmail(email);
        return aluno;
    }

    // Método para salvar ou atualizar um aluno
    public Aluno saveAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // Método para encontrar todos os alunos
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    // Método para encontrar um aluno por ID
    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    // Método para deletar um aluno por ID
    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }

    // Método para atualizar um aluno existente
    public Aluno updateAluno(Long id, Aluno alunoAtualizado) {
        Optional<Aluno> alunoExistente = alunoRepository.findById(id);
        if (alunoExistente.isPresent()) {
            Aluno aluno = alunoExistente.get();
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setIdade(alunoAtualizado.getIdade());
            aluno.setEmail(alunoAtualizado.getEmail());
            return alunoRepository.save(aluno);
        } else {
            // Lançar uma exceção ou retornar um erro se o aluno não for encontrado
            throw new ResourceNotFoundException("Aluno não encontrado com ID: " + id);
        }
    }
}
