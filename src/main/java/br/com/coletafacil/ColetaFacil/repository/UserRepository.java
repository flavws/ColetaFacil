package br.com.coletafacil.ColetaFacil.repository;

import br.com.coletafacil.ColetaFacil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User findByEmailAndPassword(String email, String senha);
}
