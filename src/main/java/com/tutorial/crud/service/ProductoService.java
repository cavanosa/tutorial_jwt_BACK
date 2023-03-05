package com.tutorial.crud.service;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.ProductoDto;
import com.tutorial.crud.entity.Producto;
import com.tutorial.crud.exceptions.CustomException;
import com.tutorial.crud.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> list(){
        return productoRepository.findAll();
    }

    public Producto getOne(int id){
        return productoRepository.findById(id)
                .orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND, "ese producto no existe"));
    }

    public Producto getByNombre(String nombre){
        return productoRepository.findByNombre(nombre)
                .orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND, "ese producto no existe"));
    }

    public Mensaje save(ProductoDto dto){
        if(productoRepository.existsByNombre(dto.getNombre()))
            throw new CustomException(HttpStatus.BAD_REQUEST, "ese nombre ya existe");
        Producto producto = new Producto(dto.getNombre(), dto.getPrecio());
        productoRepository.save(producto);
        return new Mensaje(producto.getNombre() + " ha sido creado");
    }

    public Mensaje update(int id, ProductoDto dto) {
        if(!productoRepository.existsById(id))
            throw new CustomException(HttpStatus.NOT_FOUND, "ese producto no existe");
       Optional<Producto> productoOptional = productoRepository.findByNombre(dto.getNombre());
       if(productoOptional.isPresent() && productoOptional.get().getId() != id)
           throw new CustomException(HttpStatus.BAD_REQUEST, "ese nombre ya existe");
        Producto producto = getOne(id);
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        productoRepository.save(producto);
        return new Mensaje(producto.getNombre() + " ha sido actualizado");
    }

    public Mensaje delete(int id){
        Producto producto = getOne(id);
        productoRepository.delete(producto);
        return new Mensaje(producto.getNombre() + " ha sido eliminado");
    }

    public boolean existsById(int id){
        return productoRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return productoRepository.existsByNombre(nombre);
    }
}
