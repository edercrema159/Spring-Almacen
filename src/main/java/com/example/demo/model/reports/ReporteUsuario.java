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

import com.example.demo.modelo.entidad.Usuario;

@Component("listUsuario")
public class ReporteUsuario extends AbstractPdfView {

  @Override
  protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    @SuppressWarnings("unchecked")
    List<Usuario> listaUsuario = (List<Usuario>) model.get("listaUsuario");
    PdfPTable tablaUsuario = new PdfPTable(7);
    document.setPageSize(PageSize.A4.rotate());
    document.open();
    
    /* TITULO */
    Paragraph titulo = new Paragraph("Reporte de Usuarios", FontFactory.getFont("Arial ", 16, Font.BOLD));
    titulo.setAlignment(Paragraph.ALIGN_CENTER);
    document.add(titulo);
    document.add(new Paragraph("\n"));

    /* COLUMNAS */
    tablaUsuario.addCell(new Phrase("ID"));
    tablaUsuario.addCell(new Phrase("Usuario"));
    tablaUsuario.addCell(new Phrase("Contraseña"));
    tablaUsuario.addCell(new Phrase("Cargo"));
    tablaUsuario.addCell(new Phrase("Nombres"));
    tablaUsuario.addCell(new Phrase("Apellidos"));
    tablaUsuario.addCell(new Phrase("Documento"));
    tablaUsuario.addCell(new Phrase("Telefono"));
    tablaUsuario.addCell(new Phrase("Correo"));

    /* DATOS */
    listaUsuario.forEach(Usuario -> {
      tablaUsuario.addCell(String.valueOf(Usuario.getIdUsuario()));
      tablaUsuario.addCell(Usuario.getUsuario());
      tablaUsuario.addCell(String.valueOf(Usuario.getContraseña()));
      tablaUsuario.addCell(String.valueOf(Usuario.getIdCargo()));
      tablaUsuario.addCell(Usuario.getNombres());
      tablaUsuario.addCell(Usuario.getApellidos());
      tablaUsuario.addCell(String.valueOf(Usuario.getDocumento()));
      tablaUsuario.addCell(String.valueOf(Usuario.getTelefono()));
      tablaUsuario.addCell(Usuario.getCorreo());

      
    });
    document.add(tablaUsuario);

  }

}