package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.dao.SalidaDao;
import com.example.demo.modelo.entidad.Salida;

@Controller
public class CSalida {

	@Autowired
	private SalidaDao dao;

	@GetMapping("/salida")
	public String listar(Model modelo) {
		List<Salida> lista = dao.listar();
		modelo.addAttribute("listaSalida", lista);
		return "listSalida";
	}

	@GetMapping("/salida/nuevo")
	public String nuevo(Model modelo) {
		Salida salida = new Salida();
		modelo.addAttribute("salida", salida);
		return "nuevoSalida";
	}

	@PostMapping("/salida/guardar")
	public String guardar(@ModelAttribute Salida salida) {
		dao.guardar(salida);
		return "redirect:/salida/";
	}

	@GetMapping("/salida/editar/{idSalida}")
	public String editar(@PathVariable int idSalida, Model modelo) {
		Salida salida= dao.buscarID(idSalida);
		modelo.addAttribute("salida", salida);
		return "editarSalida";
	}

	@PostMapping("/salida/actualizar")
	public String actualizar(@ModelAttribute Salida salida) {
		dao.actualizar(salida);
		return "redirect:/salida/";
	}

	@GetMapping("/salida/borrar/{idSalida}")
	public String borrar(@PathVariable int idSalida) {
		dao.borrar(idSalida);
		return "redirect:/salida/";
	}
}
