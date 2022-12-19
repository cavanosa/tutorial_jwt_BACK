package com.tutorial.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.crud.entity.Organizaciones;

import java.util.List;



@Repository
public interface OrganizacionesRepository extends JpaRepository<Organizaciones , Integer>{




    List<Organizaciones> findByEstado(String estado);
}
