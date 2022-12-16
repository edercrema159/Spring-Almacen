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

import com.example.demo.modelo.entidad.ProductoCategoria;

@Component("listCategoria")
public class ReporteProductoCategoria extends AbstractPdfView {

  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    @SuppressWarnings("unchecked")
    List<ProductoCategoria> listaProductoCategoria = (List<ProductoCategoria>) model.get("listaProductoCategoria");
    PdfPTable tablaProductoCategoria = new PdfPTable(7);
    document.setPageSize(PageSize.A4.rotate());
    document.open();
    
    /* TITULO */
    Paragraph titulo = new Paragraph("Reporte de Producto Categoria", FontFactory.getFont("Arial ", 16, Font.BOLD));
    titulo.setAlignment(Paragraph.ALIGN_CENTER);
    document.add(titulo);
    document.add(new Paragraph("\n"));

    /* COLUMNAS */
    tablaProductoCategoria.addCell(new Phrase("ID"));
    tablaProductoCategoria.addCell(new Phrase("Descripcion"));

    /* DATOS */
    listaProductoCategoria.forEach(ProductoCategoria -> {
      tablaProductoCategoria.addCell(String.valueOf(ProductoCategoria.getIdProductoCategoria()));
      tablaProductoCategoria.addCell(ProductoCategoria.getDescripcion());

    });
    document.add(tablaProductoCategoria);

  }

}