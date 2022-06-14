package br.com.coletafacil.ColetaFacil.repository;

import br.com.coletafacil.ColetaFacil.model.Coletor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColetorRepository extends JpaRepository<Coletor, Long> {

}
