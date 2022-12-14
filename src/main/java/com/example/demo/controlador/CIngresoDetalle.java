package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.dao.IngresoDetalleDao;
import com.example.demo.modelo.entidad.IngresoDetalle;

@Controller
public class CIngresoDetalle {

	@Autowired
	private IngresoDetalleDao dao;

	@GetMapping("/ingresodetalle")
	public String listar(Model modelo) {
		List<IngresoDetalle> lista = dao.listar();
		modelo.addAttribute("listaIngresoDetalle", lista);
		return "listEntrada";
	}

	@GetMapping("/ingresodetalle/{idIngreso}")
	public String listar2(@PathVariable int idIngreso, Model modelo) {
		List<IngresoDetalle> lista = dao.listarFiltrado(idIngreso);
		modelo.addAttribute("listaIngresoDetalle", lista);
		return "listEntrada";
	}

	@GetMapping("/ingresodetalle/nuevo/{idIngreso}")
	public String nuevo(@PathVariable int idIngreso, Model modelo) {
		IngresoDetalle ingresodetalle = new IngresoDetalle();
		modelo.addAttribute("ingresodetalle", ingresodetalle);
		IngresoDetalle id = dao.buscarIDIngreso(idIngreso);
		modelo.addAttribute("idIngreso", id);

		
		List<IngresoDetalle> listaProducto = dao.listarProducto();
		modelo.addAttribute("listaProducto", listaProducto);
		
		return "nuevoIngresoDetalle";
	}

	@PostMapping("/ingresodetalle/guardar")
	public String guardar(@ModelAttribute IngresoDetalle ingresodetalle) {
		dao.guardar(ingresodetalle);
		return "redirect:/ingreso";
	}

	@GetMapping("/ingresodetalle/editar/{idIngresoDetalle}")
	public String editar(@PathVariable int idIngresoDetalle, Model modelo) {
		IngresoDetalle ingresodetalle = dao.buscarID(idIngresoDetalle);
		modelo.addAttribute("ingresodetalle", ingresodetalle);

		
		List<IngresoDetalle> listaProducto = dao.listarProducto();
		modelo.addAttribute("listaProducto", listaProducto);
		
		return "editaringresodetalle";
	}

	@PostMapping("/ingresodetalle/actualizar")
	public String actualizar(@ModelAttribute IngresoDetalle ingresodetalle) {
		dao.actualizar(ingresodetalle);
		return "redirect:/ingreso";
	}

	@GetMapping("/ingresodetalle/borrar/{idIngresoDetalle}")
	public String borrar(@PathVariable int idIngresoDetalle) {
		dao.borrar(idIngresoDetalle);
		return "redirect:/ingreso";
	}
}
