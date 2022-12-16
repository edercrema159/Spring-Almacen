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

import com.example.demo.modelo.entidad.Almacen;

@Component("listAlmacen")
public class ReporteAlmacen extends AbstractPdfView {

  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    @SuppressWarnings("unchecked")
    List<Almacen> listaAlmacen = (List<Almacen>) model.get("listaAlmacenr");
    PdfPTable tablaAlmacen = new PdfPTable(7);
    document.setPageSize(PageSize.A4.rotate());
    document.open();
    
    /* TITULO */
    Paragraph titulo = new Paragraph("Reporte de Almacenes", FontFactory.getFont("Arial ", 16, Font.BOLD));
    titulo.setAlignment(Paragraph.ALIGN_CENTER);
    document.add(titulo);
    document.add(new Paragraph("\n"));

    /* COLUMNAS */
    tablaAlmacen.addCell(new Phrase("ID"));
    tablaAlmacen.addCell(new Phrase("Descripcion"));
    tablaAlmacen.addCell(new Phrase("Area"));

    /* DATOS */
    listaAlmacen.forEach(almacen -> {
      tablaAlmacen.addCell(String.valueOf(almacen.getIdAlmacen()));
      tablaAlmacen.addCell(almacen.getDescripcion());
      tablaAlmacen.addCell(almacen.getArea());
    });
    document.add(tablaAlmacen);

  }

}