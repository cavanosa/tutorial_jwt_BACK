package com.tutorial.crud.util.reportes;
import com.tutorial.crud.entity.Organizaciones;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
public class OrganizacionesExportarPDF {


    private List<Organizaciones> listaorganizaciones;

    public OrganizacionesExportarPDF(List<Organizaciones> listaorganizaciones) {
        super();
        this.listaorganizaciones = listaorganizaciones;
    }

    private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
        PdfPCell celda = new PdfPCell();

        celda.setBackgroundColor(Color.RED);
        celda.setPadding(5);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.WHITE);

        celda.setPhrase(new Phrase("ID", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Nombre ORG", fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Tipo", fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Representante", fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Nivel", fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Inicio", fuente));
        tabla.addCell(celda);
        celda.setPhrase(new Phrase("Fin", fuente));
        tabla.addCell(celda);
    }

    private void escribirDatosDeLaTabla(PdfPTable tabla) {
        for (Organizaciones org : listaorganizaciones) {
            tabla.addCell(String.valueOf(org.getId()));
            tabla.addCell(org.getNombreorg());
             tabla.addCell(org.getTipo());
             tabla.addCell(org.getRepresentante());
             tabla.addCell(org.getNivel());
             tabla.addCell(org.getInicio());
             tabla.addCell(org.getFin());
      
        }
    }

    public void exportar(HttpServletResponse response) throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.RED);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Organizaciones Sociales", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        PdfPTable tabla = new PdfPTable(7);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[]{1f, 2.3f, 1,1f,1f,1f,1f});
        tabla.setWidthPercentage(100);

        escribirCabeceraDeLaTabla(tabla);
        escribirDatosDeLaTabla(tabla);

        documento.add(tabla);
        documento.close();
    }
}
