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

import com.example.demo.modelo.entidad.Cargo;

@Component("listCargo")
public class ReporteCargo extends AbstractPdfView {

  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    @SuppressWarnings("unchecked")
    List<Cargo> listaCargo = (List<Cargo>) model.get("listaCargo");
    PdfPTable tablaCargo = new PdfPTable(7);
    document.setPageSize(PageSize.A4.rotate());
    document.open();
    
    /* TITULO */
    Paragraph titulo = new Paragraph("Reporte de Cargos", FontFactory.getFont("Arial ", 16, Font.BOLD));
    titulo.setAlignment(Paragraph.ALIGN_CENTER);
    document.add(titulo);
    document.add(new Paragraph("\n"));

    /* COLUMNAS */
    tablaCargo.addCell(new Phrase("ID"));
    tablaCargo.addCell(new Phrase("Descripcion"));

    /* DATOS */
    listaCargo.forEach(cargo -> {
      tablaCargo.addCell(String.valueOf(cargo.getIdCargo()));
      tablaCargo.addCell(cargo.getDescripcion());

    });
    document.add(tablaCargo);

  }

}