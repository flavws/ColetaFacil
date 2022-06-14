package br.com.coletafacil.ColetaFacil.controller;

import br.com.coletafacil.ColetaFacil.dto.ParceirosDTO;
import br.com.coletafacil.ColetaFacil.model.Parceiros;
import br.com.coletafacil.ColetaFacil.repository.ParceirosRepository;
import br.com.coletafacil.ColetaFacil.service.ParceirosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parceiros")
public class ParceirosController {

    @Autowired
    ParceirosRepository parceirosRepository;

    @Autowired
    ParceirosService parceirosService;

    @PostMapping
    public Parceiros createParceiro(@RequestBody Parceiros parceiros){
        return parceirosService.createParceiro(parceiros);
    }

    @GetMapping
    public List<ParceirosDTO> getParceiros(){
        return parceirosService.getParceiro();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParceirosDTO> updateParceiro(@PathVariable Long id, @RequestBody ParceirosDTO parceirosDTO){
        return ResponseEntity.ok(parceirosService.updateParceiro(id, parceirosDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParceiro (@PathVariable Long id){
        return ResponseEntity.ok(parceirosService.deleteParceiro(id));
    }
}
