package com.tutorial.crud.controller;



import java.util.Date;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.entity.*;
import com.tutorial.crud.service.ParametroService;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tutorial.crud.service.OrganizacionesService;
import com.tutorial.crud.service.RequisitoService;
import com.tutorial.crud.util.reportes.OrganizacionesExportarEXCEL;
import com.tutorial.crud.util.reportes.OrganizacionesExportarPDF;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api")
public class DataController {
    RequisitoService requisitoService;
    OrganizacionesService organizacionesService;
    ParametroService parametroService;
@Autowired
public DataController(RequisitoService requisitoService, OrganizacionesService organizacionesService,ParametroService parametroService) {

    this.requisitoService = requisitoService;
    this.organizacionesService = organizacionesService;
    this.parametroService = parametroService;

}

//    @GetMapping(value="/zona")
//    public List<Zona> getAllZona(){
//        return zonaService.readAll();
//    }

    @GetMapping("/listar/parametros")
    public List<Parametros>  getAllParametros() {
        return parametroService.getAllParametros();
    }
    @GetMapping("/tipo/tipoparametro")
    public ResponseEntity<List<Parametros>> getBytipo(@RequestParam String tipoparametro) {
        return new ResponseEntity<List<Parametros>>(parametroService.getByTipoparametro(tipoparametro), HttpStatus.OK);
    }

    @PostMapping(value="/nuevo/parametro")
    public ResponseEntity<?> create(@RequestBody Parametros parametros){

        parametroService.save(parametros);
        return new ResponseEntity(new Mensaje("parametrocreado"), HttpStatus.OK);
    }

@GetMapping(value="/requisito")
    public List<Requisito> getAllRequisito(){
        return requisitoService.getAllRequisito();
    }




//    @GetMapping(value="/tipo")
//    public List<Tipo> getAllTipo(){
//        return tipoService.getAllTipo();
//    }


@GetMapping(value="/exportarExcel")
public void exportarListadoDeEmpleadosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
    response.setContentType("application/octet-stream");

    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    String fechaActual = dateFormatter.format(new Date());

    String cabecera = "Content-Disposition";
    String valor = "attachment; filename=OrganizacioneSociales_" + fechaActual + ".xlsx";

    response.setHeader(cabecera, valor);
    List<Organizaciones> libros = organizacionesService.getAllOrganizaciones();
    OrganizacionesExportarEXCEL exporter = new OrganizacionesExportarEXCEL(libros);
    exporter.exportar(response);

}

@GetMapping(value="/exportarPDF")
public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
    response.setContentType("application/pdf");

    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    String fechaActual = dateFormatter.format(new Date());

    String cabecera = "Content-Disposition";
    String valor = "attachment; filename=OrganizacionesSociales_" + fechaActual + ".pdf";

    response.setHeader(cabecera, valor);

    List<Organizaciones> organizaciones = organizacionesService.getAllOrganizaciones();

    OrganizacionesExportarPDF exporter = new OrganizacionesExportarPDF(organizaciones);
    exporter.exportar(response);
}




}
