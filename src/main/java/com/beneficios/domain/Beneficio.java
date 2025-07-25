package com.beneficios.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Beneficio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome do benefício é obrigatório")
    @Column(nullable = false)
    private String nome;
    private boolean ativo = true;
}
