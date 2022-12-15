package com.tutorial.crud.util.reportes;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tutorial.crud.entity.Organizaciones;
public class OrganizacionesExportarEXCEL {


    private XSSFWorkbook libro;
    private XSSFSheet hoja;

    private List<Organizaciones> listaorganizaciones;

    public OrganizacionesExportarEXCEL(List<Organizaciones> listaorganizaciones) {
        this.listaorganizaciones = listaorganizaciones;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("Organizaciones");
    }

    private void escribirCabeceraDeTabla() {
        Row fila = hoja.createRow(0);

        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setBold(true);
        fuente.setFontHeight(16);
        estilo.setFont(fuente);

        Cell celda = fila.createCell(0);
        celda.setCellValue("ID");
        celda.setCellStyle(estilo);

        celda = fila.createCell(1);
        celda.setCellValue("Nombre org");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("Tipo");
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(3);
        celda.setCellValue("Representante");
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(4);
        celda.setCellValue("Zona");
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(5);
        celda.setCellValue("Nivel");
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(6);
        celda.setCellValue("Inicio");
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(7);
        celda.setCellValue("Fin");
        celda.setCellStyle(estilo);

    }

    private void escribirDatosDeLaTabla() {
        int nueroFilas = 1;

        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for (Organizaciones lib : listaorganizaciones) {
            Row fila = hoja.createRow(nueroFilas++);

            Cell celda = fila.createCell(0);
            
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(lib.getNombreorg());
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

            celda = fila.createCell(2);
            celda.setCellValue(lib.getTipo());
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

            celda = fila.createCell(3);
            
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);
            
            celda = fila.createCell(4);
            celda.setCellValue(lib.getZona());
            hoja.autoSizeColumn(4);
            celda.setCellStyle(estilo);
            
            celda = fila.createCell(5);
            celda.setCellValue(lib.getNivel());
            hoja.autoSizeColumn(5);
            celda.setCellStyle(estilo);

            celda = fila.createCell(6);
            celda.setCellValue(lib.getInicio());
            hoja.autoSizeColumn(6);
            celda.setCellStyle(estilo);
            
            celda = fila.createCell(7);
            celda.setCellValue(lib.getFin());
            hoja.autoSizeColumn(7);
            celda.setCellStyle(estilo);

        }
    }

    public void exportar(HttpServletResponse response) throws IOException {
        escribirCabeceraDeTabla();
        escribirDatosDeLaTabla();

        ServletOutputStream outPutStream = response.getOutputStream();
        libro.write(outPutStream);

        libro.close();
        outPutStream.close();
    }
}
