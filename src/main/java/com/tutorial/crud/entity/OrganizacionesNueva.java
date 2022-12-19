package com.tutorial.crud.entity;

import com.tutorial.crud.security.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain=true)
@Entity
@Table(name = "organizacion_social")
public class OrganizacionesNueva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idos;
    private String nombre_os;
    private int idparametro_zona;
    private int idparametro_tipo_os;
    private String estado;
    private int idparametro_nivel;
}
