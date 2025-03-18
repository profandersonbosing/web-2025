package br.unipar.unilivraria;


import br.unipar.unilivraria.domain.Autor;
import br.unipar.unilivraria.dto.AutorInsertRequestDTO;
import br.unipar.unilivraria.interfaces.AutorWS;

import br.unipar.unilivraria.services.AutorService;
import jakarta.jws.WebService;

@WebService
public class AutorWSImp implements AutorWS {

    @Override
    public Autor inserir(AutorInsertRequestDTO autorDTO) {
        Autor autor = new Autor(autorDTO);

        AutorService autorService = new AutorService();
        return autorService.inserir(autor);
    }
}
