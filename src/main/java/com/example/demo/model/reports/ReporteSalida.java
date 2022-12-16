package com.example.demo.model.reports;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import com.example.demo.modelo.entidad.Salida;

@Component("listSalida")
public class ReporteSalida extends AbstractPdfView {

  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    @SuppressWarnings("unchecked")
    List<Salida> listaSalida = (List<Salida>) model.get("listaSalida");
    PdfPTable tablaSalida = new PdfPTable(7);
    document.setPageSize(PageSize.A4.rotate());
    document.open();
    
    /* TITULO */
    Paragraph titulo = new Paragraph("Reporte de Salidas", FontFactory.getFont("Arial ", 16, Font.BOLD));
    titulo.setAlignment(Paragraph.ALIGN_CENTER);
    document.add(titulo);
    document.add(new Paragraph("\n"));

    /* COLUMNAS */
    tablaSalida.addCell(new Phrase("ID"));
    tablaSalida.addCell(new Phrase("Documento"));
    tablaSalida.addCell(new Phrase("Fecha"));
    tablaSalida.addCell(new Phrase("Almacen"));
    tablaSalida.addCell(new Phrase("Proveedor"));

    /* DATOS */
    listaSalida.forEach(salida -> {
      tablaSalida.addCell(String.valueOf(salida.getIdSalida()));
      tablaSalida.addCell(salida.getDocumento());
      tablaSalida.addCell(salida.getFecha());
      tablaSalida.addCell(String.valueOf(salida.getIdAlmacen()));
      tablaSalida.addCell(String.valueOf(salida.getIdProveedor()));

    });
    document.add(tablaSalida);

  }

}