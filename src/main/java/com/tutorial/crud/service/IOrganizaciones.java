package com.tutorial.crud.service;

import java.util.List;

import com.tutorial.crud.entity.Organizaciones;

public interface IOrganizaciones {

 List<Organizaciones> getAllOrganizaciones();    
 Organizaciones save(Organizaciones org);
    void deleteById(int id);
}
