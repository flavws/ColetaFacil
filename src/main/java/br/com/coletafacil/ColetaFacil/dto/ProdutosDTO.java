package br.com.coletafacil.ColetaFacil.dto;

import br.com.coletafacil.ColetaFacil.model.Coletor;
import br.com.coletafacil.ColetaFacil.model.Produtos;
import br.com.coletafacil.ColetaFacil.model.Usuario;
import br.com.coletafacil.ColetaFacil.repository.ProdutosRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosDTO {
    private Long idProduto;

    private String nomeProduto;

    private Integer valorPontos;

    private Integer qtdeEstoque;

    private Coletor coletor;

    private Usuario usuario;

    public ProdutosDTO (Produtos produtos){
        this.idProduto = produtos.getIdProduto();
        this.nomeProduto = produtos.getNomeProduto();
        this.qtdeEstoque = produtos.getQtdeEstoque();
        this.valorPontos = produtos.getValorPontos();
        this.coletor = produtos.getColetor();
        this.usuario = produtos.getUsuario();
    }


    public Optional<Produtos> atualizar(Long id, ProdutosRepository produtosRepository) {
        Optional<Produtos> produtos = produtosRepository.findById(id);

        produtos.get().setIdProduto(this.idProduto);
        produtos.get().setNomeProduto(this.nomeProduto);
        produtos.get().setQtdeEstoque(this.qtdeEstoque);
        produtos.get().setValorPontos(this.valorPontos);
        produtos.get().setColetor(this.coletor);
        produtos.get().setUsuario(this.usuario);

        return produtos;
    }


}
