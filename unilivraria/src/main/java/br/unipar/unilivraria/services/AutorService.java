package br.unipar.unilivraria.services;

import br.unipar.unilivraria.domain.Autor;
import br.unipar.unilivraria.exceptions.BusinessException;
import br.unipar.unilivraria.repositories.AutorRepository;

import javax.naming.NamingException;
import java.sql.SQLException;

public class AutorService {

    private AutorRepository autorRepository;

    public AutorService() {
        autorRepository = new AutorRepository();
    }

    public Autor inserir(Autor autor) throws BusinessException, SQLException, NamingException {

        if (autor.getNome() == null || autor.getNome().isEmpty()) {
            throw new BusinessException("Nome do autor é obrigatório");
        }

        if (autor.getNome().length() > 100) {
            throw new BusinessException("Nome do autor deve ter no máximo 100 caracteres");
        }

        return autorRepository.inserir(autor);
    }

}
