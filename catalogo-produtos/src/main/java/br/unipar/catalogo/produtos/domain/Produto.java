package br.unipar.catalogo.produtos.domain;

import br.unipar.catalogo.produtos.dto.ProdutoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    public Produto(ProdutoRequestDTO produtoRequestDTO) {
        this.nome = produtoRequestDTO.getNome();
        this.preco = produtoRequestDTO.getPreco();
        this.categoria = produtoRequestDTO.getCategoria();
    }

    public Produto(Long id, ProdutoRequestDTO produtoRequestDTO) {
        this.id = id;
        this.nome = produtoRequestDTO.getNome();
        this.preco = produtoRequestDTO.getPreco();
        this.categoria = produtoRequestDTO.getCategoria();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private String categoria;

}
