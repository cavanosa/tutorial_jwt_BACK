package com.tutorial.crud.service;

import com.tutorial.crud.entity.OrganizacionesNueva;
import com.tutorial.crud.entity.Parametros;

import java.util.List;

public interface IParametro {
    List<Parametros> getAllParametros();
    Parametros save(Parametros parametros);
}
