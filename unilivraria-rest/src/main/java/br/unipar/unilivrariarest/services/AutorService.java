package br.unipar.unilivrariarest.services;

import br.unipar.unilivrariarest.domain.Autor;
import br.unipar.unilivrariarest.exceptions.BusinessException;
import br.unipar.unilivrariarest.repositories.AutorRepository;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

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

    public Autor editar(Autor autor) throws BusinessException {
        if (autor.getId() == null) {
            throw new BusinessException("Id do autor é obrigatório para edição");
        }

        if (autor.getNome() == null || autor.getNome().isEmpty()) {
            throw new BusinessException("Nome do autor é obrigatório");
        }

        if (autor.getNome().length() > 100) {
            throw new BusinessException("Nome do autor deve ter no máximo 100 caracteres");
        }

        try {
            autorRepository.editar(autor);
            return autor;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("Erro ao editar autor. Entre o contato com o suporte do WebService");
        }
    }

    public List<Autor> buscarTodos() throws BusinessException {
        try {
            return autorRepository.buscarTodos();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            throw new BusinessException("Erro ao buscar autores. Entre o contato com o suporte do WebService");
        }
    }

    public void deletar(Integer id) throws BusinessException {

        if (id == null) {
            throw new BusinessException("Id do autor é obrigatório para exclusão");
        }

        try {
            autorRepository.deletar(id);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            throw new BusinessException("Erro ao deletar autor. Entre o contato com o suporte do WebService");
        }
    }

    public List<Autor> buscarPorNome(String nome) throws BusinessException {

        if (nome == null || nome.isEmpty()) {
            throw new BusinessException("Nome do autor é obrigatório para busca");
        }

        try {
            return autorRepository.buscarPorNome(nome);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            throw new BusinessException("Erro ao buscar autores. Entre o contato com o suporte do WebService");
        }
    }

}
