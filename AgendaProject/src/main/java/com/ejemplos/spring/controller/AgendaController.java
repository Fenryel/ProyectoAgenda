package com.ejemplos.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ejemplos.spring.model.Empleados;
import com.ejemplos.spring.model.Personas;
import com.ejemplos.spring.services.IContactoService;

@Controller
public class AgendaController {
	
	@Autowired
	private IContactoService iContactoService;
	
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		List<Personas> listaPersonas = iContactoService.list();
		ModelAndView model = new ModelAndView("mainAgenda");
		model.addObject("userList", listaPersonas);
		for (Personas p : listaPersonas) {
			System.out.println(p.getApellido1());
		}
		return model;
	}
	
	
	@RequestMapping("listado")
	public ModelAndView handleRequestListado() throws Exception {
		List<Personas> listaPersonas = iContactoService.list();
		ModelAndView model = new ModelAndView("mainAgenda");
		model.addObject("userList", listaPersonas);
		for (Personas p : listaPersonas) {
			System.out.println(p.getApellido1());
		}
		return model;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("contactoForm");
		model.addObject("user", new Personas());
		return model;		
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewUser(HttpServletRequest request) {
		int idPersona = Integer.parseInt(request.getParameter("id"));
		Personas personas = iContactoService.get(idPersona);
		ModelAndView model = new ModelAndView("viewContactoForm");
		model.addObject("user", personas);
		return model;		
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int idPersona = Integer.parseInt(request.getParameter("id"));
		Personas personas = iContactoService.get(idPersona);
		ModelAndView model = new ModelAndView("contactoForm");
		model.addObject("user", personas);
		return model;		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute Personas personas) {
		System.out.println(" -+--+-+--+-+-+-+(POST) "+personas.getNombre());
		iContactoService.modificar(personas);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		iContactoService.borrarContacto(userId);
		return new ModelAndView("redirect:/");		
	}

}
