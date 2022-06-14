package br.com.coletafacil.ColetaFacil.controller;

import br.com.coletafacil.ColetaFacil.dto.ResgatesDTO;
import br.com.coletafacil.ColetaFacil.model.Resgates;
import br.com.coletafacil.ColetaFacil.repository.ResgatesRepository;
import br.com.coletafacil.ColetaFacil.service.ResgatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resgate")
public class ResgateController {

    @Autowired
    ResgatesService resgatesService;

    @Autowired
    ResgatesRepository resgatesRepository;

    @PostMapping
    public Resgates createResgate(@RequestBody Resgates resgates){
        return resgatesService.createResgate(resgates);
    }

    @GetMapping
    public List<ResgatesDTO> getResgates(){
        return resgatesService.getResgates();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResgatesDTO> updateResgate(@PathVariable Long id, @RequestBody ResgatesDTO resgatesDTO){
        return ResponseEntity.ok(resgatesService.updateResgate(id, resgatesDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResgate(@PathVariable Long id){
        return ResponseEntity.ok(resgatesService.deleteResgate(id));
    }
}
