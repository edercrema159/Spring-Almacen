package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.dao.AreaDao;
import com.example.demo.modelo.entidad.Area;

@Controller
public class CArea {

	@Autowired
	private AreaDao dao;

	@GetMapping("/area")
	public String listar(Model modelo) {
		List<Area> lista = dao.listar();
		modelo.addAttribute("listaArea", lista);
		return "listArea";
	}

	@GetMapping("/area/nuevo")
	public String nuevo(Model modelo) {
		Area area = new Area();
		modelo.addAttribute("area", area);
		return "nuevoArea";
	}

	@PostMapping("/area/guardar")
	public String guardar(@ModelAttribute Area area) {
		dao.guardar(area);
		return "redirect:/area";
	}

	@GetMapping("/area/editar/{idArea}")
	public String editar(@PathVariable int idArea, Model modelo) {
		Area area = dao.buscarID(idArea);
		modelo.addAttribute("area", area);
		return "editarArea";
	}

	@PostMapping("/area/actualizar")
	public String actualizar(@ModelAttribute Area area) {
		dao.actualizar(area);
		return "redirect:/area";
	}

	@GetMapping("/area/borrar/{idArea}")
	public String borrar(@PathVariable int idArea) {
		dao.borrar(idArea);
		return "redirect:/area";
	}
}
