package com.springweb.security.controller.home;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@GetMapping(value = { "/", "/index" })
	public String getIndex(Model model) {
		return "index";
	}

	@GetMapping(value = "/menu")
	public String getMenu(Model model) {
	
		List<GrantedAuthority> grantList = (List<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();

		String page = "menu";
		if (grantList.size() == 1) {

			if (grantList.get(0).getAuthority().equals("ROLE_USER")) {
				page = "redirect:/user/";
			} else if (grantList.get(0).getAuthority().equals("ROLE_ADMIN")) {
				page = "redirect:/admin/";
			}

		}
		return page;
	}

	@GetMapping(value = "/login")
	public String getLogin(Model model) {
		return "login";
	}

	@GetMapping(value = "/admin/")
	public String getAdmin(Model model) {
		return "/admin/index";
	}

	@GetMapping(value = "/user/")
	public String getUser(Model model) {
		return "/user/index";
	}

}
