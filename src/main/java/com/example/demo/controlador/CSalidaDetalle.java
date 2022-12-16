package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.dao.SalidaDetalleDao;
import com.example.demo.modelo.entidad.SalidaDetalle;

@Controller
public class CSalidaDetalle {

	@Autowired
	private SalidaDetalleDao dao;

	@GetMapping("/salidadetalle")
	public String listar(Model modelo) {
		List<SalidaDetalle> lista = dao.listar();
		modelo.addAttribute("listaSalidaDetalle", lista);
		return "listSalida";
	}

	@GetMapping("/salidadetalle/nuevo")
	public String nuevo(Model modelo) {
		SalidaDetalle salidadetalle = new SalidaDetalle();
		modelo.addAttribute("salidadetalle", salidadetalle);
		return "nuevoSalidaDetalle";
	}

	@PostMapping("/salidadetalle/guardar")
	public String guardar(@ModelAttribute SalidaDetalle salidadetalle) {
		dao.guardar(salidadetalle);
		return "redirect:/salidadetalle/";
	}

	@GetMapping("/salidadetalle/editar/{idSalidaDetalle}")
	public String editar(@PathVariable int idSalidaDetalle, Model modelo) {
		SalidaDetalle salidadetalle = dao.buscarID(idSalidaDetalle);
		modelo.addAttribute("salidadetalle", salidadetalle);
		return "editarSalidaDetalle";
	}

	@PostMapping("/salidadetalle/actualizar")
	public String actualizar(@ModelAttribute SalidaDetalle salidadetalle) {
		dao.actualizar(salidadetalle);
		return "redirect:/salidadetalle/";
	}

	@GetMapping("/salidadetalle/borrar/{idSalidaDetalle}")
	public String borrar(@PathVariable int idSalidaDetalle) {
		dao.borrar(idSalidaDetalle);
		return "redirect:/salidadetalle/";
	}
}
