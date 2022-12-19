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
@Table(name = "solicitud")
public class Solicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idsolicitud;
    @ManyToOne
    @JoinColumn(name="idos",nullable=false)
    private Organizaciones organizaciones;
    private String estado;
    private String f_ingreso;
    private String n_expediente;
    private String i_gob;
    private String razon_solicitud;
    @JsonIgnore
    @OneToMany(mappedBy="solicitud")
    private List<Registro> registro;
}
