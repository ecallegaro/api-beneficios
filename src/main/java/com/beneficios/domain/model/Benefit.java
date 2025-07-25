package com.beneficios.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
public class Benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome do benefício é obrigatório")
    @Column(nullable = false)
    @Size(min = 3, max = 300, message = "O nome do benefício deve ter no máximo 300 caracteres")
    private String nome;
    @Size(max = 255, message = "A descrição do benefício deve ter no máximo 255 caracteres")
    private String description;
    private boolean ativo = true;
}
