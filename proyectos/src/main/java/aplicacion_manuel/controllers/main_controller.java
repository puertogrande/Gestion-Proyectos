package aplicacion_manuel.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aplicacion_manuel.classes.*;
import aplicacion_manuel.services.ProyectoServiceImpl;
import aplicacion_manuel.services.UserServiceImpl;

@Controller
public class main_controller {
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private ProyectoServiceImpl proyectoServiceImpl;

	@RequestMapping(value = {"/","/index"})
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
    @RequestMapping("/datos/personales")
	String datos_usuario(Model model, Principal principal) {
		model.addAttribute("usuario", userServiceImpl.findByEmail(principal.getName()));
		model.addAttribute("proyectos", userServiceImpl.findByEmail(principal.getName()).getProyectos());
		return "datos_personales";
	}
	
	@RequestMapping("/proyectos")
	String todos_proyectos(Model model) {
		System.out.print("El enlace me lleva a los proyectos");
		model.addAttribute("proyectos", proyectoServiceImpl.findAll());
		return "proyectos";
	}
	
	@RequestMapping("/usuarios")
	String todos_usuarios(Model model) {
		model.addAttribute("usuarios", userServiceImpl.findAll());
		return "usuarios";
	}

	@RequestMapping(value="/proyectoForm", method= RequestMethod.GET)
	String nuevo_proyecto(Model model) {
		model.addAttribute("proyecto", new Proyecto());
		return "proyectoForm";
	}
	
	@RequestMapping(value="/proyectoForm", method= RequestMethod.POST)
	String creacion_proyecto(@ModelAttribute Proyecto proyecto, Model model) {
		proyectoServiceImpl.save(proyecto);
		return "index";
	}

	@RequestMapping("/proyectos/usuario/{usuarioemail}")
	String proyectos_alumno(Model model, @PathVariable String usuarioemail) {	
		model.addAttribute("usuario", userServiceImpl.findByEmail(usuarioemail));
		model.addAttribute("proyectos", userServiceImpl.findByEmail(usuarioemail).getProyectos());
		return "proyectos_alumno";
	}
	
	@RequestMapping("/proyectos/compañeros/{proyectoid}")
	String compisproyecto(Model model, @PathVariable Long proyectoid) {
		model.addAttribute("proyecto", proyectoServiceImpl.findById(proyectoid));
		return "compañeros";
	}
	
	//para unir una many to many lo que se hace es introducir los datos en ambas listas
	@RequestMapping("unirse/proyecto/{proyectoid}")
	String unirse_proyecto(Principal principal,  @PathVariable Long proyectoid) {
		Proyecto proyecto = proyectoServiceImpl.findById(proyectoid);
		User usuario = userServiceImpl.findByEmail(principal.getName());
		usuario.addProyecto(proyecto);
		proyecto.addUsuario(usuario);
		proyectoServiceImpl.save(proyecto);
		userServiceImpl.save_user(usuario);
		return "index";
	}
}
