package br.com.coletafacil.ColetaFacil.repository;

import br.com.coletafacil.ColetaFacil.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
