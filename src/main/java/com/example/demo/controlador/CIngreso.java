package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.dao.IngresoDao;
import com.example.demo.modelo.entidad.Ingreso;

@Controller
public class CIngreso {

	@Autowired
	private IngresoDao dao;

	@GetMapping("/ingreso")
	public String listar(Model modelo) {
		List<Ingreso> lista = dao.listar();
		modelo.addAttribute("listaIngreso", lista);
		return "listIngreso";
	}

	@GetMapping("/ingreso/nuevo")
	public String nuevo(Model modelo) {
		Ingreso ingreso = new Ingreso();
		modelo.addAttribute("ingreso", ingreso);

		List<Ingreso> listaProveedor = dao.listarProveedor();
		modelo.addAttribute("listaProveedor", listaProveedor);

		List<Ingreso> listaAlmacen = dao.listarAlmacen();
		modelo.addAttribute("listaAlmacen", listaAlmacen);
		return "nuevoIngreso";
	}

	@PostMapping("/ingreso/guardar")
	public String guardar(@ModelAttribute Ingreso ingreso) {
		dao.guardar(ingreso);
		return "redirect:/ingreso";
	}

	@GetMapping("/ingreso/editar/{idIngreso}")
	public String editar(@PathVariable int idIngreso, Model modelo) {
		Ingreso ingreso = dao.buscarID(idIngreso);
		modelo.addAttribute("ingreso", ingreso);

		List<Ingreso> listaProveedor = dao.listarProveedor();
		modelo.addAttribute("listaProveedor", listaProveedor);

		List<Ingreso> listaAlmacen = dao.listarAlmacen();
		modelo.addAttribute("listaAlmacen", listaAlmacen);
		return "editarIngreso";
	}

	@PostMapping("/ingreso/actualizar")
	public String actualizar(@ModelAttribute Ingreso ingreso) {
		dao.actualizar(ingreso);
		return "redirect:/ingreso";
	}

	@GetMapping("/ingreso/borrar/{idIngreso}")
	public String borrar(@PathVariable int idIngreso) {
		dao.borrar(idIngreso);
		return "redirect:/ingreso";
	}
}
