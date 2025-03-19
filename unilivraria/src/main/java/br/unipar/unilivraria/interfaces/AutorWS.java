package br.unipar.unilivraria.interfaces;

import br.unipar.unilivraria.domain.Autor;

import br.unipar.unilivraria.dto.AutorInsertRequestDTO;
import br.unipar.unilivraria.exceptions.BusinessException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import javax.naming.NamingException;
import java.sql.SQLException;

@WebService
public interface AutorWS {

    @WebMethod
    Autor inserir(AutorInsertRequestDTO autor) throws BusinessException, SQLException, NamingException;

}
