package br.com.coletafacil.ColetaFacil.repository;

import br.com.coletafacil.ColetaFacil.model.Resgates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResgatesRepository extends JpaRepository<Resgates, Long> {
}
