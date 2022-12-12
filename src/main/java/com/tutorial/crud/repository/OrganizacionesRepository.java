package com.tutorial.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.crud.entity.Organizaciones;


@Repository
public interface OrganizacionesRepository extends JpaRepository<Organizaciones , Integer>{

}
