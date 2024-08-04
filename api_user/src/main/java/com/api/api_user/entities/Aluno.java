package com.api.api_user.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aluno")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matricula;

    @NotNull
    private String email;
    private String nome;
    private int idade;

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

}
