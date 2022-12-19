package com.tutorial.crud.repository;

import com.tutorial.crud.entity.Organizaciones;
import com.tutorial.crud.entity.Parametros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParametroRepository extends JpaRepository<Parametros, Integer> {

    List<Parametros> findByTipoparametro(String tipoparametro);


}



