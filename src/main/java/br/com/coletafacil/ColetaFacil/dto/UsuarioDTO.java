package br.com.coletafacil.ColetaFacil.dto;

import br.com.coletafacil.ColetaFacil.model.Usuario;
import br.com.coletafacil.ColetaFacil.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO{

    private Long idUsuario;

    private String cpf;

    private String email;

    private String senha;

    private String nomeUsuario;

    private Integer ptsAcumulados;

    private String endereco;

    private String cep;

    private String contato;

    public UsuarioDTO(Usuario usuario){
        this.idUsuario = usuario.getIdUsuario();
        this.cpf = usuario.getCpf();
        this.nomeUsuario = usuario.getNomeUsuario();
        this.ptsAcumulados = usuario.getPtsAcumulados();
        this.endereco = usuario.getEndereco();
        this.cep = usuario.getCep();
        this.contato = usuario.getContato();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public Optional<Usuario> atualizar(Long id, UsuarioRepository usuarioRepository) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        usuario.get().setIdUsuario(this.idUsuario);
        usuario.get().setCpf(this.cpf);
        usuario.get().setNomeUsuario(this.nomeUsuario);
        usuario.get().setCep(this.cep);
        usuario.get().setContato(this.contato);
        usuario.get().setEndereco(this.endereco);
        usuario.get().setPtsAcumulados(this.ptsAcumulados);
        usuario.get().setEmail(this.email);
        usuario.get().setSenha(this.senha);

        return usuario;
        // TODO: 06/06/2022 update na tabela 
    }
}
