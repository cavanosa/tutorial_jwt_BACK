package com.tutorial.crud.controller;

import com.tutorial.crud.entity.UsuarioInfo;
import com.tutorial.crud.service.UsuarioInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.crud.security.entity.Usuario;
import com.tutorial.crud.security.service.UsuarioService;

@RestController
@RequestMapping("/profile")
@CrossOrigin
public class ProfileController {

    @Autowired
    UsuarioInfoService usuarioInfoService;
	   @Autowired
	    UsuarioService usuarioService;
	    
	   
	   @GetMapping("/detailname/{nombreUsuario}")
            public ResponseEntity<Usuario> getByNombre(@PathVariable("nombreUsuario")String nombreUsuario){
        
       UsuarioInfo usuarioInfo = usuarioInfoService.getByNombreUsuario(nombreUsuario).get();
        return new ResponseEntity(usuarioInfo, HttpStatus.OK);
    }
	   
	   
}
