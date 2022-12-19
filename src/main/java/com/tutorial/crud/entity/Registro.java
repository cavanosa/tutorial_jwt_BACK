package com.tutorial.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registro")
public class Registro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String f_evaluacion;
    @ManyToOne
    @JoinColumn(name="idsolicitud",nullable=false)
    private Solicitud solicitud;
    @ManyToOne
    @JoinColumn(name="idrequisito",nullable=false)
    private Requisito requisito;
    private String archivo;
    @ManyToOne
    @JoinColumn(name="idpersona",nullable=false)
    private Persona persona;


}
