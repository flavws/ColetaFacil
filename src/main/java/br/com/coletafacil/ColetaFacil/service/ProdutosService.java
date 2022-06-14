package br.com.coletafacil.ColetaFacil.service;

import br.com.coletafacil.ColetaFacil.dto.ProdutosDTO;
import br.com.coletafacil.ColetaFacil.model.Produtos;
import br.com.coletafacil.ColetaFacil.repository.ProdutosRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutosService {

    @Autowired
    ProdutosRepository produtosRepository;

    public Produtos createProduto(Produtos produtos){
        produtos = produtosRepository.save(produtos);

        return produtos;
    }

    public List<ProdutosDTO> getProduto(){
        return produtosRepository.findAll().stream().map(ProdutosDTO::new).collect(Collectors.toList());
    }

    public ProdutosDTO updateProduto(Long id, ProdutosDTO produtosDTO){
        Optional<Produtos> produtos = produtosDTO.atualizar(id, produtosRepository);
        return new ProdutosDTO(produtos.get());
    }

    public ResponseEntity<?> deleteProduto(Long id){
        produtosRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
