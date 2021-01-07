package com.springweb.security.controller.autor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springweb.security.entity.Autor;
import com.springweb.security.service.autor.AutorService;
import com.springweb.security.service.pais.PaisService;

@Controller
public class AutorController {
	
	@Autowired
	private AutorService autorService;

	@Autowired
	private PaisService paisService;
	
	@GetMapping(value = {"/admin/autor/"})
	public String getAutores(Model m) {
		m.addAttribute("autores", autorService.findAll());
		return "/autor/index";
	}
	
	@GetMapping(value = {"/admin/autor/form"})
	public String getForm(Model m) {
		m.addAttribute("autor", new Autor());
		m.addAttribute("paises", paisService.findAll());
		return "/autor/form";
	}

	@GetMapping(value = { "/admin/autor/form/{id}" })
	public String formId(@PathVariable(name = "id", required = true) Long id, Model m) {
		Autor aut = autorService.findById(id).orElse(null);
		if (null == aut) {
			m.addAttribute("error", "error.proceso");
			aut = new Autor();
		}
		m.addAttribute("autor", aut);
		m.addAttribute("paises", paisService.findAll());
		return "/autor/form";
	}
	
	@PostMapping(value = {"/admin/autor/form"})
	public String getForm(@Valid Autor autor, BindingResult result, Model m) {
		
		if (!result.hasErrors()) {
			
			String msg = "";
			try {
				Autor aut = autorService.save(autor);
				if (aut == null) {
					msg = autor.getId() == null ? "error.insertar" : "error.actualizar";
					m.addAttribute("error", msg);
				} else {
					msg = autor.getId() == null ? "exito.insertar" : "exito.actualizar";
					m.addAttribute("exito", msg);
					autor = aut;
				}
			} catch (Exception e) {
				m.addAttribute("error", "error.proceso");
			}
			
		}
		m.addAttribute("autor", autor);
		m.addAttribute("paises", paisService.findAll());
		return "/autor/form";
	}

}
