package com.tutorial.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.crud.entity.Requisito;


@Repository
public interface RequisitoRepository extends JpaRepository<Requisito , Integer>{

}
