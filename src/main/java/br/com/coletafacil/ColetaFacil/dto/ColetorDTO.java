package br.com.coletafacil.ColetaFacil.dto;

import br.com.coletafacil.ColetaFacil.model.Coletor;
import br.com.coletafacil.ColetaFacil.repository.ColetorRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColetorDTO {

    private Long idColetor;

    private String cpf;

    private String nome;

    private Integer pontos;

    private String veiculo;

    private String endereco;

    private String cep;

    private String contato;

    public ColetorDTO(Coletor coletor) {
        this.idColetor = coletor.getIdColetor();
        this.cpf = coletor.getCpf();
        this.nome = coletor.getNome();
        this.pontos = coletor.getPontos();
        this.veiculo = coletor.getVeiculo();
        this.endereco = coletor.getEndereco();
        this.cep = coletor.getCep();
        this.contato = coletor.getContato();
    }

    public Optional<Coletor> atualizar(Long id, ColetorRepository coletorRepository){

        Optional<Coletor> coletorEntity = coletorRepository.findById(id);

        coletorEntity.get().setIdColetor(this.idColetor);
        coletorEntity.get().setCep(this.cep);
        coletorEntity.get().setContato(this.contato);
        coletorEntity.get().setCpf(this.cpf);
        coletorEntity.get().setNome(this.nome);
        coletorEntity.get().setPontos(this.pontos);
        coletorEntity.get().setVeiculo(this.veiculo);
        coletorEntity.get().setEndereco(this.endereco);

        coletorRepository.save(coletorEntity.get());

        return coletorEntity;
    }
}
