package br.unipar.unilivraria.domain;

import br.unipar.unilivraria.dto.AutorInsertRequestDTO;

public class Autor {

    private Integer id;

    private String nome;

    public Autor(AutorInsertRequestDTO autorDTO) {
        this.nome = autorDTO.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
