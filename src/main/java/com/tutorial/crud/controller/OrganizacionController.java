package com.tutorial.crud.controller;

import com.tutorial.crud.entity.OrganizacionesNueva;
import com.tutorial.crud.entity.Organizaciones;
import com.tutorial.crud.service.NuevaOrgService;
import com.tutorial.crud.service.OrganizacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;
import com.tutorial.crud.dto.Mensaje;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/organizaciones")
@CrossOrigin(origins = "*")
public class OrganizacionController {



    OrganizacionesService organizacionesService;
    NuevaOrgService nuevaOrgService;
    @Autowired
    public OrganizacionController(OrganizacionesService organizacionesService, NuevaOrgService nuevaOrgService){
        this.organizacionesService = organizacionesService;
        this.nuevaOrgService = nuevaOrgService;

    }

    @GetMapping(value="/listar")
    public List<Organizaciones> getAllOrganizaciones(){


        return organizacionesService.getAllOrganizaciones();
    }
//    @GetMapping("/detailestado/{estado}")
//    public ResponseEntity <List<Organizaciones>> get(@PathVariable("estado")String estado){
//
//        Organizaciones organizaciones = organizacionesService.getByEstado(estado).get();
//        return new          ResponseEntity(<List<organizaciones>>, HttpStatus.OK);
//    }

    @GetMapping("/detailestado/estado")
    public ResponseEntity<List<Organizaciones>> getLaptopsByName(@RequestParam String estado) {
        return new ResponseEntity<List<Organizaciones>>(organizacionesService.getByEstado(estado), HttpStatus.OK);
    }


    @PostMapping(value="/nueva")
    public ResponseEntity<?> create(@RequestBody OrganizacionesNueva organizacionesNueva){



        if(StringUtils.isBlank(organizacionesNueva.getNombre_os()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(organizacionesDto.get()==null || organizacionesDto.getPrecio()<0 )
//            return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(nuevaOrgService.existsBynombre(organizacionesNueva.getNombre_os()))
//            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        OrganizacionesNueva org = new OrganizacionesNueva(organizacionesNueva.getIdos(),organizacionesNueva.getNombre_os(),organizacionesNueva.getIdparametro_zona(),organizacionesNueva.getIdparametro_tipo_os(),
                organizacionesNueva.getEstado(),organizacionesNueva.getIdparametro_nivel());
        nuevaOrgService.save(org);
        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
    }


}
