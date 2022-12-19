package com.tutorial.crud.repository;

import com.tutorial.crud.entity.Persona;
import com.tutorial.crud.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona , Integer> {

    Optional<Persona> findByDni(String dni);

    boolean existsByDni(String dni);
}
