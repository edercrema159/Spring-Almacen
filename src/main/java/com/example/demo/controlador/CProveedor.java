package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.dao.ProveedorDao;
import com.example.demo.modelo.entidad.Proveedor;

@Controller
public class CProveedor {

	@Autowired
	private ProveedorDao dao;

	@GetMapping("/proveedor")
	public String listar(Model modelo) {
		List<Proveedor> lista = dao.listar();
		modelo.addAttribute("listaProveedor", lista);
		return "listProveedor";
	}

	@GetMapping("/proveedor/nuevo")
	public String nuevo(Model modelo) {
		Proveedor proveedor = new Proveedor();
		modelo.addAttribute("proveedor", proveedor);
		return "nuevoProveedor";
	}

	@PostMapping("/proveedor/guardar")
	public String guardar(@ModelAttribute Proveedor proveedor) {
		dao.guardar(proveedor);
		return "redirect:/proveedor";
	}

	@GetMapping("/proveedor/editar/{idProveedor}")
	public String editar(@PathVariable int idProveedor, Model modelo) {
		Proveedor proveedor = dao.buscarID(idProveedor);
		modelo.addAttribute("proveedor", proveedor);
		return "editarProveedor";
	}

	@PostMapping("/proveedor/actualizar")
	public String actualizar(@ModelAttribute Proveedor proveedor) {
		dao.actualizar(proveedor);
		return "redirect:/proveedor";
	}

	@GetMapping("/proveedor/borrar/{idProveedor}")
	public String borrar(@PathVariable int idProveedor) {
		dao.borrar(idProveedor);
		return "redirect:/proveedor";
	}
}
