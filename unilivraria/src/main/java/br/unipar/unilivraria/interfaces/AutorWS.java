package br.unipar.unilivraria.interfaces;

import br.unipar.unilivraria.domain.Autor;

import br.unipar.unilivraria.dto.AutorInsertRequestDTO;
import br.unipar.unilivraria.exceptions.BusinessException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface AutorWS {

    @WebMethod
    Autor inserir(AutorInsertRequestDTO autor) throws BusinessException;

    @WebMethod
    Autor editar(Autor autor) throws BusinessException;

    @WebMethod
    List<Autor> buscarTodos() throws BusinessException;

    @WebMethod
    void excluir(Integer id) throws BusinessException;

    @WebMethod
    List<Autor> buscarPorNome(String nome) throws BusinessException;

}
