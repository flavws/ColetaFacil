package br.com.coletafacil.ColetaFacil.repository;

import br.com.coletafacil.ColetaFacil.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
}
