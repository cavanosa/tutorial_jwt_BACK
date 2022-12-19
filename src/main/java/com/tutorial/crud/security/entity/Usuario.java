package com.tutorial.crud.security.entity;

import com.tutorial.crud.entity.Parametros;
import com.tutorial.crud.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private int idpersona;

//    @NotNull
//    private int idpersona;
//    @NotNull
//    private String nombre;
//    @NotNull
//    private String apellido_pat;
//    @NotNull
//    private String apellido_mat;
//    @NotNull
//
//    @NotNull
//    private String email;
    @NotNull
    @Column(unique = true)
    private String nombreUsuario;
    @NotNull
    private String password;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario(@NotNull String nombreUsuario,int idpersona, @NotNull String password) {
        this.nombreUsuario = nombreUsuario;
        this.idpersona = idpersona;
        this.password = password;

    }
}
