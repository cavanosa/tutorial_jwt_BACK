package com.tutorial.crud.repository;

import com.tutorial.crud.entity.UsuarioInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioInfoRepository extends JpaRepository<UsuarioInfo, Integer> {

    Optional<UsuarioInfo> findByNombreUsuario(String nombreUsuario);



}
