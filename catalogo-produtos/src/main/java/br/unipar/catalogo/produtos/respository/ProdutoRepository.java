package br.unipar.catalogo.produtos.respository;

import br.unipar.catalogo.produtos.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findByNomeContaining(String nome);

}
