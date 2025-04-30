package br.unipar.unilivrariarest.domain;

import br.unipar.unilivrariarest.dto.AutorInsertRequestDTO;
import br.unipar.unilivrariarest.exceptions.BusinessException;

public class Autor {

    private Integer id;

    private String nome;

    public Autor() { }

    public Autor(Integer id, AutorInsertRequestDTO autorInsertRequestDTO) {
        this.id = id;
        this.nome = autorInsertRequestDTO.getNome();
    }

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
