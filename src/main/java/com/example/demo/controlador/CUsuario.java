package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.dao.UsuarioDao;
import com.example.demo.modelo.entidad.Usuario;

@Controller
public class CUsuario {

	@Autowired
	private UsuarioDao dao;

	@GetMapping("/")
	public String index(Model modelo) {
		// List<Usuario> lista = dao.listar();
		// modelo.addAttribute("listaUsuario", lista);
		return "index";
	}
	@GetMapping("/usuario")
	public String listar(Model modelo) {
		List<Usuario> lista = dao.listar();
		modelo.addAttribute("listaUsuario", lista);
		return "listUsuario";
	}

	@GetMapping("/usuario/nuevo")
	public String nuevo(Model modelo) {
		Usuario usuario = new Usuario();
		modelo.addAttribute("usuario", usuario);
		return "nuevoUsuario";
	}

	@PostMapping("/usuario/guardar")
	public String guardar(@ModelAttribute Usuario usuario) {
		dao.guardar(usuario);
		return "redirect:/usuario/";
	}

	@GetMapping("/usuario/editar/{idUsuario}")
	public String editar(@PathVariable int idUsuario, Model modelo) {
		Usuario usuario = dao.buscarID(idUsuario);
		modelo.addAttribute("usuario", usuario);
		return "editarUsuario";
	}

	@PostMapping("/usuario/actualizar")
	public String actualizar(@ModelAttribute Usuario usuario) {
		dao.actualizar(usuario);
		return "redirect:/usuario/";
	}

	@GetMapping("/usuario/borrar/{idUsuario}")
	public String borrar(@PathVariable int idUsuario) {
		dao.borrar(idUsuario);
		return "redirect:/usuario/";
	}
}