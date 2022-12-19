package com.tutorial.crud.service;

import com.tutorial.crud.entity.UsuarioInfo;
import com.tutorial.crud.repository.UsuarioInfoRepository;
import com.tutorial.crud.security.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UsuarioInfoService {

    @Autowired
    UsuarioInfoRepository usuarioInfoRepository;
    public Optional<UsuarioInfo> getByNombreUsuario(String nombreUsuario){
        return usuarioInfoRepository.findByNombreUsuario(nombreUsuario);
    }
}
