package com.tutorial.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.crud.entity.Organizaciones;
import com.tutorial.crud.repository.OrganizacionesRepository;
@Service
public class OrganizacionesService implements IOrganizaciones{
	
	OrganizacionesRepository organizacionesRepository;
	@Autowired
    public OrganizacionesService(OrganizacionesRepository organizacionesRepository) {
        this.organizacionesRepository = organizacionesRepository;
    }
	@Override
	public List<Organizaciones> getAllOrganizaciones() {
		return organizacionesRepository.findAll();
	}

	

	@Override
	public void deleteById(int id) {
		organizacionesRepository.deleteById(id);
		
	}

	@Override
	public Organizaciones save(Organizaciones org) {
		return organizacionesRepository.save(org);
	}
	public List<Organizaciones> getByEstado(String estado){
		return organizacionesRepository.findByEstado(estado);
	}



}
