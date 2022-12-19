package com.tutorial.crud.entity;

import com.tutorial.crud.service.ParametroService;
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
@Table(name = "juntadirectiva")
public class JuntaDirectiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idjd;
    @ManyToOne
    @JoinColumn(name="idpersona",nullable=false)
    private Persona persona;
    @ManyToOne
    @JoinColumn(name="idsolicitud",nullable=false)
    private Solicitud solicitud;
    @ManyToOne
    @JoinColumn(name="idparametrocargo",nullable=false)
    private Parametros parametros;


}
