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

import com.example.demo.modelo.entidad.IngresoDetalle;

@Component("listIngresoDetalle")
public class ReporteIngresoDetalle extends AbstractPdfView {

  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    @SuppressWarnings("unchecked")
    List<IngresoDetalle> listaIngresoDetalle = (List<IngresoDetalle>) model.get("listaIngresoDetalle");
    PdfPTable tablaIngresoDetalle = new PdfPTable(7);
    document.setPageSize(PageSize.A4.rotate());
    document.open();
    
    /* TITULO */
    Paragraph titulo = new Paragraph("Reporte de Ingreso y Detalles", FontFactory.getFont("Arial ", 16, Font.BOLD));
    titulo.setAlignment(Paragraph.ALIGN_CENTER);
    document.add(titulo);
    document.add(new Paragraph("\n"));

    /* COLUMNAS */
    tablaIngresoDetalle.addCell(new Phrase("ID"));
    tablaIngresoDetalle.addCell(new Phrase("Ingreso"));
    tablaIngresoDetalle.addCell(new Phrase("Producto"));
    tablaIngresoDetalle.addCell(new Phrase("Cantidad"));
    tablaIngresoDetalle.addCell(new Phrase("Costo"));

    /* DATOS */
    listaIngresoDetalle.forEach(IngresoDetalle -> {
      tablaIngresoDetalle.addCell(String.valueOf(IngresoDetalle.getIdIngresoDetalle()));
      tablaIngresoDetalle.addCell(String.valueOf(IngresoDetalle.getIdIngreso()));
      tablaIngresoDetalle.addCell(String.valueOf(IngresoDetalle.getIdProducto()));
      tablaIngresoDetalle.addCell(String.valueOf(IngresoDetalle.getCantidad()));
      tablaIngresoDetalle.addCell(String.valueOf(IngresoDetalle.getCosto()));
      
    });
    document.add(tablaIngresoDetalle);

  }

}