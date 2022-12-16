package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.dao.ProductoCategoriaDao;
import com.example.demo.modelo.entidad.ProductoCategoria;

@Controller
public class CProductoCategoria {

	@Autowired
	private ProductoCategoriaDao dao;

	@GetMapping("/productocategoria")
	public String listar(Model modelo) {
		List<ProductoCategoria> lista = dao.listar();
		modelo.addAttribute("listaProductoCategoria", lista);
		return "listCategoria";
	}

	@GetMapping("/productocategoria/nuevo")
	public String nuevo(Model modelo) {
		ProductoCategoria productocategoria = new ProductoCategoria();
		modelo.addAttribute("productocategoria", productocategoria);
		return "nuevoProductoCategoria";
	}

	@PostMapping("/productocategoria/guardar")
	public String guardar(@ModelAttribute ProductoCategoria productocategoria) {
		dao.guardar(productocategoria);
		return "redirect:/productocategoria/";
	}

	@GetMapping("/productocategoria/editar/{idProductoCategoria}")
	public String editar(@PathVariable int idProductoCategoria, Model modelo) {
		ProductoCategoria productocategoria= dao.buscarID(idProductoCategoria);
		modelo.addAttribute("productocategoria", productocategoria);
		return "editarProductoCategoria";
	}

	@PostMapping("/productocategoria/actualizar")
	public String actualizar(@ModelAttribute ProductoCategoria productocategoria) {
		dao.actualizar(productocategoria);
		return "redirect:/productocategoria/";
	}

	@GetMapping("/productocategoria/borrar/{idProductoCategoria}")
	public String borrar(@PathVariable int idProductoCategoria) {
		dao.borrar(idProductoCategoria);
		return "redirect:/productocategoria/";
	}
}