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

import com.example.demo.modelo.entidad.Producto;

@Component("listProducto")
public class ReporteProducto extends AbstractPdfView {

  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    @SuppressWarnings("unchecked")
    List<Producto> listaProducto = (List<Producto>) model.get("listaProducto");
    PdfPTable tablaProducto = new PdfPTable(4);
    document.setPageSize(PageSize.A4.rotate());
    document.open();
    
    /* TITULO */
    Paragraph titulo = new Paragraph("Reporte de Productos", FontFactory.getFont("Arial ", 16, Font.BOLD));
    titulo.setAlignment(Paragraph.ALIGN_CENTER);
    document.add(titulo);
    document.add(new Paragraph("\n"));

    /* COLUMNAS */
    tablaProducto.addCell(new Phrase("ID"));
    tablaProducto.addCell(new Phrase("Descripcion"));
    tablaProducto.addCell(new Phrase("ProductoCategoria"));
    tablaProducto.addCell(new Phrase("Cantidad"));

    /* DATOS */
    listaProducto.forEach(producto -> {
      tablaProducto.addCell(String.valueOf(producto.getIdProducto()));
      tablaProducto.addCell(producto.getDescripcion());
      tablaProducto.addCell(String.valueOf(producto.getIdProductoCategoria()));
      tablaProducto.addCell(String.valueOf(producto.getCantidad()));

    });
    document.add(tablaProducto);

  }

}