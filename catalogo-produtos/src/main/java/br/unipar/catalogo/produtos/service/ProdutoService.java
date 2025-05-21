package br.unipar.catalogo.produtos.service;

import br.unipar.catalogo.produtos.domain.Produto;
import br.unipar.catalogo.produtos.respository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto insert(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll(String nome) {
        if (nome != null && !nome.isEmpty()) {
            return produtoRepository.findByNomeContaining(nome);
        }

        return produtoRepository.findAll();
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }
}
