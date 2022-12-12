package com.tutorial.crud.controller;



import java.util.Date;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.crud.entity.Organizaciones;
import com.tutorial.crud.entity.Requisito;
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
public class RequisitoController {
RequisitoService requisitoService;
OrganizacionesService organizacionesService;
@Autowired
public RequisitoController(RequisitoService requisitoService, OrganizacionesService organizacionesService) {
    this.requisitoService = requisitoService;
    this.organizacionesService = organizacionesService;
}



@GetMapping(value="/requisito")
    public List<Requisito> getAllRequisito(){
        return requisitoService.getAllRequisito();
    }


@GetMapping(value="/organizaciones")
    public List<Organizaciones> getAllOrganizaciones(){
        return organizacionesService.getAllOrganizaciones();
    }


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
