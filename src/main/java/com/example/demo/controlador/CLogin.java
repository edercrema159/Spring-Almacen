package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.dao.LoginDao;
import com.example.demo.modelo.entidad.Login;


@Controller
public class CLogin {

	@Autowired
	private LoginDao dao;

	@GetMapping("/login")
	public String listar(Model modelo) {
		// List<Login> lista = dao.listar();
		// modelo.addAttribute("listaLogin", lista);
		return "login";
	}

	@GetMapping("/login/nuevo")
	public String nuevo(Model modelo) {
		Login login = new Login();
		modelo.addAttribute("login", login);

		return "nuevoLogin";
	}

	@PostMapping("/login/guardar")
	public String guardar(@PathVariable String usuario, @PathVariable String contraseña, @ModelAttribute Login login) {
		Login user = dao.buscarUsuario(usuario, contraseña);
		dao.guardar(user);
		return "redirect:/";
	}

	@PostMapping("/login/actualizar")
	public String actualizar(@ModelAttribute Login login) {
		dao.actualizar(login);
		return "redirect:/login/";
	}

	@GetMapping("/login/borrar/{idLogin}")
	public String borrar(@PathVariable int idLogin) {
		dao.borrar(idLogin);
		return "redirect:/login/";
	}
}