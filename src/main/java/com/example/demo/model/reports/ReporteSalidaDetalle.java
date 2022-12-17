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

import com.example.demo.modelo.entidad.SalidaDetalle;

@Component("listSalidaDet")
public class ReporteSalidaDetalle extends AbstractPdfView {

  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    @SuppressWarnings("unchecked")
    List<SalidaDetalle> listaSalidaDetalle = (List<SalidaDetalle>) model.get("listaSalidaDet");
    PdfPTable tablaSalidaDetalle = new PdfPTable(7);
    document.setPageSize(PageSize.A4.rotate());
    document.open();
    
    /* TITULO */
    Paragraph titulo = new Paragraph("Reporte de SalidaDetalle", FontFactory.getFont("Arial ", 16, Font.BOLD));
    titulo.setAlignment(Paragraph.ALIGN_CENTER);
    document.add(titulo);
    document.add(new Paragraph("\n"));

    /* COLUMNAS */
    tablaSalidaDetalle.addCell(new Phrase("ID"));
    tablaSalidaDetalle.addCell(new Phrase("Salida"));
    tablaSalidaDetalle.addCell(new Phrase("Producto"));
    tablaSalidaDetalle.addCell(new Phrase("Cantidad"));
    tablaSalidaDetalle.addCell(new Phrase("Costo"));

    /* DATOS */
    listaSalidaDetalle.forEach(SalidaDetalle -> {
      tablaSalidaDetalle.addCell(String.valueOf(SalidaDetalle.getIdSalidaDetalle()));
      tablaSalidaDetalle.addCell(String.valueOf(SalidaDetalle.getIdSalida()));
      tablaSalidaDetalle.addCell(String.valueOf(SalidaDetalle.getIdProducto()));
      tablaSalidaDetalle.addCell(String.valueOf(SalidaDetalle.getCantidad()));
      tablaSalidaDetalle.addCell(String.valueOf(SalidaDetalle.getCosto()));

    });
    document.add(tablaSalidaDetalle);

  }

}