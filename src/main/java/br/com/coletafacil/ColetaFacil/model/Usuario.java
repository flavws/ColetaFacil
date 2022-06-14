package br.com.coletafacil.ColetaFacil.model;

import com.sun.istack.NotNull;
import com.sun.xml.bind.v2.TODO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotNull
    private String cpf;
    // TODO: 06/06/2022 colocar campos obrigatórios
    @NotNull
    private String nomeUsuario;

    @NotNull
    private String email;

    @NotNull
    private String senha;

    private Integer ptsAcumulados;

    private String endereco;

    private String cep;

    private String contato;
}
