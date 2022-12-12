package com.tutorial.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.crud.entity.Requisito;
import com.tutorial.crud.repository.RequisitoRepository;


@Service
public class RequisitoService implements IRequisito{
	
	
	RequisitoRepository requisitoRepository;
	
	 @Autowired
    public RequisitoService(RequisitoRepository requisitoRepository) {
        this.requisitoRepository = requisitoRepository;
    }
	
	@Override
	public List<Requisito> getAllRequisito() {
		
		return requisitoRepository.findAll();
	}

	@Override
	public Requisito save(Requisito rqt) {
		
		return requisitoRepository.save(rqt);
	}

	@Override
	public void deleteById(int id) {
		
		requisitoRepository.deleteById(id);
	}

}
