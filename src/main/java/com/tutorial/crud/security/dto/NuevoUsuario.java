package com.tutorial.crud.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {
//    @NotBlank
//    private String nombre;
//    @NotBlank
//    private String apellido_pat;
//    @NotBlank
//    private String apellido_mat;

    private int idpersona;
    @NotBlank
    private String nombreUsuario;
//    @Email
//    private String email;
    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();

//    public String getNombre() {
//        return nombre;
//    }

    

//	public String getApellido_pat() {
//		return apellido_pat;
//	}

//	public void setApellido_pat(String apellido_pat) {
//		this.apellido_pat = apellido_pat;
//	}
//
//	public String getApellido_mat() {
//		return apellido_mat;
//	}
//
//	public void setApellido_mat(String apellido_mat) {
//		this.apellido_mat = apellido_mat;
//	}
//
//	public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdusuario(int idusuario) {
        this.idpersona = idusuario;
    }

    //    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
