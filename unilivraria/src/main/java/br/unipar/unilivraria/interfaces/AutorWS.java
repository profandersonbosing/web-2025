package br.unipar.unilivraria.interfaces;

import br.unipar.unilivraria.domain.Autor;

import br.unipar.unilivraria.dto.AutorInsertRequestDTO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface AutorWS {

    @WebMethod
    Autor inserir(AutorInsertRequestDTO autor);

}
