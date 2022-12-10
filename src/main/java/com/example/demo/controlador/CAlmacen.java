package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.dao.AlmacenDao;
import com.example.demo.modelo.entidad.Almacen;


@Controller
public class CAlmacen {

	@Autowired
	private AlmacenDao dao;

	@GetMapping("/almacen")
	public String listar(Model modelo) {
		List<Almacen> lista = dao.listar();
		modelo.addAttribute("listaAlmacen", lista);
		return "listAlmacen";
	}

	@GetMapping("/almacen/nuevo")
	public String nuevo(Model modelo) {
		Almacen almacen = new Almacen();
		modelo.addAttribute("almacen", almacen);

		List<Almacen> listaArea = dao.listarArea();
		modelo.addAttribute("listaArea", listaArea);
		return "nuevoAlmacen";
	}

	@PostMapping("/almacen/guardar")
	public String guardar(@ModelAttribute Almacen almacen) {
		dao.guardar(almacen);
		return "redirect:/almacen/";
	}

	@GetMapping("/almacen/editar/{idAlmacen}")
	public String editar(@PathVariable int idAlmacen, Model modelo) {
		Almacen almacen = dao.buscarID(idAlmacen);
		modelo.addAttribute("almacen", almacen);
		
		List<Almacen> listaArea = dao.listarArea();
		modelo.addAttribute("listaArea", listaArea);
		return "editarAlmacen";
	}

	@PostMapping("/almacen/actualizar")
	public String actualizar(@ModelAttribute Almacen almacen) {
		dao.actualizar(almacen);
		return "redirect:/almacen/";
	}

	@GetMapping("/almacen/borrar/{idAlmacen}")
	public String borrar(@PathVariable int idAlmacen) {
		dao.borrar(idAlmacen);
		return "redirect:/almacen/";
	}
}
