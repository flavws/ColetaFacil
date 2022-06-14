package br.com.coletafacil.ColetaFacil.service;

import br.com.coletafacil.ColetaFacil.dto.ParceirosDTO;
import br.com.coletafacil.ColetaFacil.dto.UsuarioDTO;
import br.com.coletafacil.ColetaFacil.model.Parceiros;
import br.com.coletafacil.ColetaFacil.model.Usuario;
import br.com.coletafacil.ColetaFacil.repository.ParceirosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParceirosService {

    @Autowired
    ParceirosRepository parceirosRepository;

    public Parceiros createParceiro(Parceiros parceiros){
        parceiros = parceirosRepository.save(parceiros);
        return parceiros;
    }

    public List<ParceirosDTO> getParceiro(){
        return parceirosRepository.findAll().stream().map(ParceirosDTO::new).collect(Collectors.toList());
    }

    public ParceirosDTO updateParceiro(Long id, ParceirosDTO parceirosDTO){
        Optional<Parceiros> parceiros = parceirosDTO.atualizar(id, parceirosRepository);
        return new ParceirosDTO(parceiros.get());
    }

    public ResponseEntity<?> deleteParceiro(Long id){
        parceirosRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
