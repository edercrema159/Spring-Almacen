package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.dao.ProductoDao;
import com.example.demo.modelo.entidad.Producto;

@Controller
public class CProducto {

	@Autowired
	private ProductoDao dao;

	@GetMapping("/producto")
	public String listar(Model modelo) {
		List<Producto> lista = dao.listar();
		modelo.addAttribute("listaProducto", lista);
		return "listProducto";
	}

	@GetMapping("/producto/nuevo")
	public String nuevo(Model modelo) {
		Producto producto = new Producto();
		modelo.addAttribute("producto", producto);

		List<Producto> listaCategoria = dao.listarCategoria();
		modelo.addAttribute("listaProductoCategoria", listaCategoria);
		return "nuevoProducto";
	}

	@PostMapping("/producto/guardar")
	public String guardar(@ModelAttribute Producto producto) {
		dao.guardar(producto);
		return "redirect:/producto/";
	}

	@GetMapping("/producto/editar/{idProducto}")
	public String editar(@PathVariable int idProducto, Model modelo) {
		Producto producto = dao.buscarID(idProducto);
		modelo.addAttribute("producto", producto);

		List<Producto> listaCategoria = dao.listarCategoria();
		modelo.addAttribute("listaProductoCategoria", listaCategoria);
		return "editarProducto";
	}

	@PostMapping("/producto/actualizar")
	public String actualizar(@ModelAttribute Producto producto) {
		dao.actualizar(producto);
		return "redirect:/producto/";
	}

	@GetMapping("/producto/borrar/{idProducto}")
	public String borrar(@PathVariable int idProducto) {
		dao.borrar(idProducto);
		return "redirect:/producto/";
	}
}
