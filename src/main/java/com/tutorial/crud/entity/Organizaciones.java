package com.tutorial.crud.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organizacion_social")
public class Organizaciones implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idos;

//	@ManyToOne
//    @JoinColumn(name="idusuario",nullable=false)
//    private Usuario usuario;
	@Column(unique = true)
	private String nombre_os;
	private String estado;
	@ManyToOne
	@JoinColumn(name="idparametro_tipo_os",nullable=false)
	private Parametros parametros_tipo_os;

	@ManyToOne
	@JoinColumn(name="idparametro_zona",nullable=false)
	private Parametros parametros_zona;
	@ManyToOne
	@JoinColumn(name="idparametro_nivel",nullable=false)
	private Parametros parametros_nivel;


}
