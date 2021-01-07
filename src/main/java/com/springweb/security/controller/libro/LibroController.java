package com.springweb.security.controller.libro;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springweb.security.entity.Libro;
import com.springweb.security.service.autor.AutorService;
import com.springweb.security.service.libro.LibroService;

@Controller
public class LibroController {

	@Autowired
	private LibroService libroService;

	@Autowired
	private AutorService autorService;

	@GetMapping(value = { "/admin/libro/" })
	public String lista(Model m) {
		List<Libro> libros = libroService.findAll();
		m.addAttribute("libros", libros);
		m.addAttribute("librosSize", libros.size());
		return "libro/index";
	}

	@GetMapping(value = { "/admin/libro/form" })
	public String form(Model m) {
		m.addAttribute("libro", new Libro());
		m.addAttribute("autores", autorService.findAll());
		return "libro/form";
	}

	@GetMapping(value = { "/admin/libro/form/{id}" })
	public String formId(@PathVariable(name = "id", required = true) Long id, Model m) {
		Libro lib = libroService.findById(id).orElse(null);
		if (null == lib) {
			m.addAttribute("error", "error.proceso");
			lib = new Libro();
		}
		m.addAttribute("libro", lib);
		m.addAttribute("autores", autorService.findAll());
		return "libro/form";
	}

	@PostMapping(value = { "/admin/libro/form" })
	public String formPost(@Valid Libro libro, BindingResult result, Model m) {

		if (!result.hasErrors()) {
			String message = "";
			try {
				Libro lib = libroService.save(libro);
				if (lib == null) {
					message = libro.getId() == null ? "error.insertar" : "error.actualizar";
					m.addAttribute("error", message);
				} else {
					message = libro.getId() == null ? "exito.insertar" : "exito.actualizar";
					m.addAttribute("exito", message);
					libro = lib;
				}
			} catch (Exception e) {
				m.addAttribute("error", "error.proceso");
			}
		}
		m.addAttribute("libro", libro);
		m.addAttribute("autores", autorService.findAll());
		return "libro/form";
	}

}
