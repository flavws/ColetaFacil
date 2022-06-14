package br.com.coletafacil.ColetaFacil.dto;

import br.com.coletafacil.ColetaFacil.model.Coletor;
import br.com.coletafacil.ColetaFacil.model.Produtos;
import br.com.coletafacil.ColetaFacil.model.Resgates;
import br.com.coletafacil.ColetaFacil.model.Usuario;
import br.com.coletafacil.ColetaFacil.repository.ResgatesRepository;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class ResgatesDTO {

    private Long idResgate;

    private LocalDate dataResgate;

    private Usuario usuario;

    private List<Produtos> produtos;

    private Coletor coletor;

    public ResgatesDTO (Resgates resgates){
        this.idResgate = resgates.getIdResgate();
        this.dataResgate = resgates.getDataResgate();
        this.usuario = resgates.getUsuario();
        this.produtos = resgates.getProdutos();
        this.coletor = resgates.getColetor();
    }


    public Optional<Resgates> atualizar(Long id, ResgatesRepository resgatesRepository) {

        Optional<Resgates> resgates = resgatesRepository.findById(id);

        resgates.get().setIdResgate(this.idResgate);
        resgates.get().setDataResgate(this.dataResgate);
        resgates.get().setColetor(this.coletor);
        resgates.get().setProdutos(this.produtos);
        resgates.get().setUsuario(this.usuario);

        return resgates;
    }
}
