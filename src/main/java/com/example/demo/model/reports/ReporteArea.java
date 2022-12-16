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

import com.example.demo.modelo.entidad.Area;

@Component("listArea")
public class ReporteArea extends AbstractPdfView {

  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    @SuppressWarnings("unchecked")
    List<Area> listaArea = (List<Area>) model.get("listaArea");
    PdfPTable tablaArea = new PdfPTable(7);
    document.setPageSize(PageSize.A4.rotate());
    document.open();
    
    /* TITULO */
    Paragraph titulo = new Paragraph("Reporte de Areas", FontFactory.getFont("Arial ", 16, Font.BOLD));
    titulo.setAlignment(Paragraph.ALIGN_CENTER);
    document.add(titulo);
    document.add(new Paragraph("\n"));

    /* COLUMNAS */
    tablaArea.addCell(new Phrase("ID"));
    tablaArea.addCell(new Phrase("Descripcion"));


    /* DATOS */
    listaArea.forEach(area -> {
      tablaArea.addCell(String.valueOf(area.getIdArea()));
      tablaArea.addCell(area.getDescripcion());
    });
    document.add(tablaArea);

  }

}