package br.com.coletafacil.ColetaFacil.service;

import br.com.coletafacil.ColetaFacil.dto.UsuarioDTO;
import br.com.coletafacil.ColetaFacil.model.Usuario;
import br.com.coletafacil.ColetaFacil.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario createUsuario(Usuario usuario){
        usuario = usuarioRepository.save(usuario);
        return usuario;
    }

    public List<UsuarioDTO> getUsuario(){
        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO){
        Optional<Usuario> usuario = usuarioDTO.atualizar(id, usuarioRepository);
        return new UsuarioDTO(usuario.get());
    }

    public ResponseEntity<?> deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
