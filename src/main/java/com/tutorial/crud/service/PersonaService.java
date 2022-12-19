package com.tutorial.crud.service;

import com.tutorial.crud.entity.Persona;
import com.tutorial.crud.repository.PersonaRepository;

import com.tutorial.crud.security.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PersonaService{

    @Autowired
    PersonaRepository personRepository;
    public int save(Persona persona){

        personRepository.save(persona);
        return persona.getIdpersona();
    }



    public Optional<Persona> getByDni(String dni){
        return personRepository.findByDni(dni);
    }
    public boolean existsByDni(String dni){
        return personRepository.existsByDni(dni);
    }

}
