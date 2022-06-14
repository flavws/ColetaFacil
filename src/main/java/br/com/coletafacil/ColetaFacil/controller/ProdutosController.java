package br.com.coletafacil.ColetaFacil.controller;

import br.com.coletafacil.ColetaFacil.dto.ProdutosDTO;
import br.com.coletafacil.ColetaFacil.model.Produtos;
import br.com.coletafacil.ColetaFacil.repository.ProdutosRepository;
import br.com.coletafacil.ColetaFacil.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    ProdutosRepository produtosRepository;

    @Autowired
    ProdutosService produtosService;

    @PostMapping
    public Produtos createProduto(@RequestBody Produtos produtos){
        return produtosService.createProduto(produtos);
    }

    @GetMapping
    public List<ProdutosDTO> getProdutos(){
        return produtosService.getProduto();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosDTO> updateProduto(@PathVariable Long id, @RequestBody ProdutosDTO produtosDTO){
        return ResponseEntity.ok(produtosService.updateProduto(id, produtosDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduto (@PathVariable Long id){
        return ResponseEntity.ok(produtosService.deleteProduto(id));
    }



}
