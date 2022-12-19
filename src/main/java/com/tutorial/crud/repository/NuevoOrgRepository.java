package com.tutorial.crud.repository;


import com.tutorial.crud.entity.OrganizacionesNueva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NuevoOrgRepository extends JpaRepository<OrganizacionesNueva, Integer> {
//    Boolean existsByNombre_os(String Nombre_os);
}
