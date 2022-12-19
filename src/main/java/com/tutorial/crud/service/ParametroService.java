package com.tutorial.crud.service;

import com.tutorial.crud.entity.Parametros;
import com.tutorial.crud.repository.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParametroService implements IParametro{
    ParametroRepository parametroRepository;
    @Autowired
    public ParametroService(ParametroRepository parametroRepository) {
        this.parametroRepository = parametroRepository;
    }
    @Override
    public List<Parametros> getAllParametros() {
        return parametroRepository.findAll();
    }

    @Override
    public Parametros save(Parametros parametros) {
        return parametroRepository.save(parametros);
    }

    public List<Parametros> getByTipoparametro(String tipoparametro){
        return parametroRepository.findByTipoparametro(tipoparametro);
    }
}
