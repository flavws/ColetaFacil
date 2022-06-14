package br.com.coletafacil.ColetaFacil.service;

import br.com.coletafacil.ColetaFacil.dto.ResgatesDTO;
import br.com.coletafacil.ColetaFacil.model.Resgates;
import br.com.coletafacil.ColetaFacil.repository.ResgatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResgatesService {

    @Autowired
    private ResgatesRepository resgatesRepository;

    public Resgates createResgate(Resgates resgates){
        resgates = resgatesRepository.save(resgates);

        return resgates;
    }

    public List<ResgatesDTO> getResgates(){
        return resgatesRepository.findAll().stream().map(ResgatesDTO::new).collect(Collectors.toList());
    }

    public ResgatesDTO updateResgate(Long id, ResgatesDTO resgatesDTO){
        Optional<Resgates> resgates = resgatesDTO.atualizar(id, resgatesRepository);
        return new ResgatesDTO(resgates.get());
    }

    public ResponseEntity<?> deleteResgate(Long id){
        resgatesRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
