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

import com.example.demo.modelo.entidad.Proveedor;

@Component("listProveedor")
public class ReporteProveedor extends AbstractPdfView {

  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    @SuppressWarnings("unchecked")
    List<Proveedor> listaProveedor = (List<Proveedor>) model.get("listaProveedor");
    PdfPTable tablaProveedor = new PdfPTable(7);
    document.setPageSize(PageSize.A4.rotate());
    document.open();
    
    /* TITULO */
    Paragraph titulo = new Paragraph("Reporte de Proveedores", FontFactory.getFont("Arial ", 16, Font.BOLD));
    titulo.setAlignment(Paragraph.ALIGN_CENTER);
    document.add(titulo);
    document.add(new Paragraph("\n"));

    /* COLUMNAS */
    tablaProveedor.addCell(new Phrase("ID"));
    tablaProveedor.addCell(new Phrase("Razon Social"));
    tablaProveedor.addCell(new Phrase("RUC"));
    tablaProveedor.addCell(new Phrase("Dirección"));
    tablaProveedor.addCell(new Phrase("Departamento"));
    tablaProveedor.addCell(new Phrase("Telefono"));
    tablaProveedor.addCell(new Phrase("Correo"));

    /* DATOS */
    listaProveedor.forEach(proveedor -> {
      tablaProveedor.addCell(String.valueOf(proveedor.getIdProveedor()));
      tablaProveedor.addCell(proveedor.getRazonSocial());
      tablaProveedor.addCell(proveedor.getRuc());
      tablaProveedor.addCell(proveedor.getDireccion());
      tablaProveedor.addCell(proveedor.getDepartamento());
      tablaProveedor.addCell(proveedor.getTelefono());
      tablaProveedor.addCell(proveedor.getCorreo());
    });
    document.add(tablaProveedor);

  }

}
