package br.unipar.unilivraria;


import br.unipar.unilivraria.domain.Autor;
import br.unipar.unilivraria.dto.AutorInsertRequestDTO;
import br.unipar.unilivraria.exceptions.BusinessException;
import br.unipar.unilivraria.interfaces.AutorWS;

import br.unipar.unilivraria.services.AutorService;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class AutorWSImp implements AutorWS {

    @Override
    public Autor inserir(AutorInsertRequestDTO autorDTO) throws BusinessException {
        Autor autor = new Autor(autorDTO);

        AutorService autorService = new AutorService();
        return autorService.inserir(autor);
    }

    @Override
    public Autor editar(Autor autor) throws BusinessException {
        AutorService autorService = new AutorService();
        return autorService.editar(autor);
    }

    @Override
    public List<Autor> buscarTodos() throws BusinessException {
        AutorService autorService = new AutorService();
        return autorService.buscarTodos();
    }

    @Override
    public void excluir(Integer id) throws BusinessException {
        AutorService autorService = new AutorService();
        autorService.deletar(id);
    }

    @Override
    public List<Autor> buscarPorNome(String nome) throws BusinessException {
        AutorService autorService = new AutorService();
        return autorService.buscarPorNome(nome);
    }
}
