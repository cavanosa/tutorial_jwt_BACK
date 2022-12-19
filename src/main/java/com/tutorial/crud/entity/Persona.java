package com.tutorial.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idpersona;
    private String nombres_pers;
    private String apellido_pat;
    private String apellido_mat;
    @Column(unique = true)
    private String dni;
    private String correo;
    private String f_nacimiento;
    private String telefono;
    private String direccion;
    @JsonIgnore
    @OneToMany(mappedBy="persona")
    private List<Registro> registro;
    @JsonIgnore
    @OneToMany(mappedBy="persona")
    private List<JuntaDirectiva> juntaDirectivas;

}
