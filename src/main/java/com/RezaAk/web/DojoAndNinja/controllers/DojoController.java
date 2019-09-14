package com.RezaAk.web.DojoAndNinja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.RezaAk.web.DojoAndNinja.models.Dojo;
import com.RezaAk.web.DojoAndNinja.servces.DojoService;
import com.RezaAk.web.DojoAndNinja.servces.NinjaService;

@Controller
@RequestMapping("/")
public class DojoController {
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("dojos", dojoService.all());
		return "index.jsp";
	}
	@RequestMapping("/dojos/new")
	public String add(Model model, @ModelAttribute("dojo") Dojo dojo) {
		model.addAttribute("dojo", dojo);
		return "dojoadd.jsp";
	}
	@PostMapping("/dojos/new")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, RedirectAttributes errors) {
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/dojos/new";
		} else {
			dojoService.add(dojo);
			return "redirect:/";
		}
	}
	@RequestMapping("/dojos/{id}")
	public String viewDojo(Model model, @PathVariable("id") Long id) {
		Dojo dojo = dojoService.getOne(id);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", dojo.getNinjas());
		return "showdojo.jsp";
	}
}