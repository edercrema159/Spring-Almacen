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

import com.example.demo.modelo.entidad.Ingreso;

@Component("listIngreso")
public class ReporteIngreso extends AbstractPdfView {

  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    @SuppressWarnings("unchecked")
    List<Ingreso> listaIngreso = (List<Ingreso>) model.get("listaIngreso");
    PdfPTable tablaIngreso = new PdfPTable(5);
    document.setPageSize(PageSize.A4.rotate());
    document.open();
    
    /* TITULO */
    Paragraph titulo = new Paragraph("Reporte de Ingresos", FontFactory.getFont("Arial ", 16, Font.BOLD));
    titulo.setAlignment(Paragraph.ALIGN_CENTER);
    document.add(titulo);
    document.add(new Paragraph("\n"));

    /* COLUMNAS */
    tablaIngreso.addCell(new Phrase("ID"));
    tablaIngreso.addCell(new Phrase("Documento"));
    tablaIngreso.addCell(new Phrase("Proveedor"));
    tablaIngreso.addCell(new Phrase("Fecha"));
    tablaIngreso.addCell(new Phrase("Almacen"));

    /* DATOS */
    listaIngreso.forEach(ingreso -> {
      tablaIngreso.addCell(String.valueOf(ingreso.getIdIngreso()));
      tablaIngreso.addCell(ingreso.getDocumento());
      tablaIngreso.addCell(ingreso.getProveedor());
      tablaIngreso.addCell(ingreso.getFecha());
      tablaIngreso.addCell(ingreso.getAlmacen());

    });
    document.add(tablaIngreso);

  }

}