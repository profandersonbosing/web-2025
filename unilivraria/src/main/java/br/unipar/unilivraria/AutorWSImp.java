package br.unipar.unilivraria;


import br.unipar.unilivraria.domain.Autor;
import br.unipar.unilivraria.dto.AutorInsertRequestDTO;
import br.unipar.unilivraria.exceptions.BusinessException;
import br.unipar.unilivraria.interfaces.AutorWS;

import br.unipar.unilivraria.services.AutorService;
import jakarta.jws.WebService;

@WebService
public class AutorWSImp implements AutorWS {

    @Override
    public Autor inserir(AutorInsertRequestDTO autorDTO) throws BusinessException {
        Autor autor = new Autor(autorDTO);

        AutorService autorService = new AutorService();
        return autorService.inserir(autor);
    }
}
