package br.com.coletafacil.ColetaFacil.dto;

import br.com.coletafacil.ColetaFacil.model.Parceiros;
import br.com.coletafacil.ColetaFacil.model.Produtos;
import br.com.coletafacil.ColetaFacil.repository.ParceirosRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParceirosDTO {

    private Long idParceiro;

    private String nomeParceiro;

    private String cnpj;

    private String endereco;

    private String contato;

    private List<Produtos> produtos;

    public ParceirosDTO(Parceiros parceiros){
        this.idParceiro = parceiros.getIdParceiro();
        this.cnpj = parceiros.getCnpj();
        this.nomeParceiro = parceiros.getNomeParceiro();
        this.contato = parceiros.getContato();
        this.endereco = parceiros.getEndereco();
        this.produtos = parceiros.getProdutos();
    }


    public Optional<Parceiros> atualizar(Long id, ParceirosRepository parceirosRepository) {

        Optional<Parceiros> parceiros = parceirosRepository.findById(id);

        parceiros.get().setIdParceiro(this.idParceiro);
        parceiros.get().setNomeParceiro(this.nomeParceiro);
        parceiros.get().setCnpj(this.cnpj);
        parceiros.get().setContato(this.contato);
        parceiros.get().setEndereco(this.endereco);
        parceiros.get().setProdutos(this.produtos);

        return parceiros;
    }
}
