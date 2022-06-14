package br.com.coletafacil.ColetaFacil.service;

import br.com.coletafacil.ColetaFacil.dto.ColetorDTO;
import br.com.coletafacil.ColetaFacil.model.Coletor;
import br.com.coletafacil.ColetaFacil.repository.ColetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColetorService {

    @Autowired
    private ColetorRepository coletorRepository;

    public Coletor createColetor(Coletor coletor){
        coletor = coletorRepository.save(coletor);

        return coletor;
    }

    public List<Coletor> getColetor(){
        return coletorRepository.findAll();
    }

    public ResponseEntity<?> deleteColetor(Long id){
        coletorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ColetorDTO updateColetor(Long id, ColetorDTO coletorDTO){
        Optional<Coletor> coletor = coletorDTO.atualizar(id, coletorRepository);
        return new ColetorDTO(coletor.get());
    }
}
