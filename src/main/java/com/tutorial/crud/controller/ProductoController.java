package com.tutorial.crud.controller;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.ProductoDto;
import com.tutorial.crud.entity.Producto;
import com.tutorial.crud.service.ProductoService;
import io.micrometer.common.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @ApiOperation("Muestra una lista de productos")
    @GetMapping("/lista")
    public ResponseEntity<List<Producto>> list(){
        return ResponseEntity.ok(productoService.list());
    }

    @ApiIgnore
    @GetMapping("/detail/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") int id){
        return ResponseEntity.ok(productoService.getOne(id));
    }

    @ApiIgnore
    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Producto> getByNombre(@PathVariable("nombre") String nombre){
        return ResponseEntity.ok(productoService.getByNombre(nombre));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Mensaje> create(@Valid @RequestBody ProductoDto dto){
        return ResponseEntity.ok(productoService.save(dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Mensaje> update(@PathVariable("id")int id, @Valid @RequestBody ProductoDto dto) {
        return ResponseEntity.ok(productoService.update(id, dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Mensaje> delete(@PathVariable("id")int id){
        return ResponseEntity.ok(productoService.delete(id));
    }


}
