package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.dao.CargoDao;
import com.example.demo.modelo.entidad.Cargo;

@Controller
public class CCargo {

	@Autowired
	private CargoDao dao;

	@GetMapping("/cargo")
	public String listar(Model modelo) {
		List<Cargo> lista = dao.listar();
		modelo.addAttribute("listaCargo", lista);
		return "listCargo";
	}

	@GetMapping("/cargo/nuevo")
	public String nuevo(Model modelo) {
		Cargo cargo = new Cargo();
		modelo.addAttribute("cargo", cargo);
		return "nuevoCargo";
	}

	@PostMapping("/cargo/guardar")
	public String guardar(@ModelAttribute Cargo cargo) {
		dao.guardar(cargo);
		return "redirect:/cargo/";
	}

	@GetMapping("/cargo/editar/{idCargo}")
	public String editar(@PathVariable int idCargo, Model modelo) {
		Cargo cargo = dao.buscarID(idCargo);
		modelo.addAttribute("cargo", cargo);
		return "editarCargo";
	}

	@PostMapping("/cargo/actualizar")
	public String actualizar(@ModelAttribute Cargo cargo) {
		dao.actualizar(cargo);
		return "redirect:/cargo/";
	}

	@GetMapping("/cargo/borrar/{idCargo}")
	public String borrar(@PathVariable int idCargo) {
		dao.borrar(idCargo);
		return "redirect:/cargo/";
	}
}
