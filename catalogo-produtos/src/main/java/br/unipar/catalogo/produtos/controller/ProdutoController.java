package br.unipar.catalogo.produtos.controller;

import br.unipar.catalogo.produtos.domain.Produto;
import br.unipar.catalogo.produtos.dto.ProdutoRequestDTO;
import br.unipar.catalogo.produtos.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody @Valid ProdutoRequestDTO produtoRequestDTO,
                                          UriComponentsBuilder builder) {
        Produto produto = new Produto(produtoRequestDTO);
        produto = produtoService.insert(produto);

        URI uri = builder.path("/cliente/{id}").
                        buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(
            @RequestParam(value = "nome", required = false) String nome) {
        List<Produto> retorno = produtoService.findAll(nome);

        return ResponseEntity.ok(retorno);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id,
                          @RequestBody @Valid ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = new Produto(id, produtoRequestDTO);

        produto = produtoService.update(produto);

        return ResponseEntity.ok(produto);
    }

}
