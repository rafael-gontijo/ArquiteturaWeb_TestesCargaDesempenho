package com.example.users.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // Renomeia a tabela para evitar conflito com palavra reservada
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
}