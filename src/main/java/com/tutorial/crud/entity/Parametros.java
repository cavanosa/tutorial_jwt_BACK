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
@Table(name = "parametros")
public class Parametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idparametros;
    private String tipoparametro;
    private String nombre;
    @JsonIgnore
    @OneToMany (mappedBy = "parametros_nivel")
    private List<Organizaciones>Organizaciones;
    @JsonIgnore
    @OneToMany (mappedBy = "parametros_zona")
    private List<Organizaciones>zona;
    @JsonIgnore
    @OneToMany (mappedBy = "parametros_tipo_os")
    private List<Organizaciones>tipo;

}
