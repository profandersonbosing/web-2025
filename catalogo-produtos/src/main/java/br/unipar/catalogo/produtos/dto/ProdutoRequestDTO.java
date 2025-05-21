package br.unipar.catalogo.produtos.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {

    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 60)
    private String nome;

    @NotNull
    @PositiveOrZero
    private Double preco;

    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 60)
    private String categoria;

}
