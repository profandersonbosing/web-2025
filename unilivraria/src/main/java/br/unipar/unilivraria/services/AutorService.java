package br.unipar.unilivraria.services;

import br.unipar.unilivraria.domain.Autor;
import br.unipar.unilivraria.exceptions.BusinessException;

public class AutorService {

    public Autor inserir(Autor autor) throws BusinessException {

        if (autor.getNome() == null || autor.getNome().isEmpty()) {
            throw new BusinessException("Nome do autor é obrigatório");
        }

        if (autor.getNome().length() > 100) {
            throw new BusinessException("Nome do autor deve ter no máximo 100 caracteres");
        }

        return null;
    }

}
