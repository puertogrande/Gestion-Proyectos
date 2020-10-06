package aplicacion_manuel.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aplicacion_manuel.classes.*;
import aplicacion_manuel.services.MessageServiceImpl;
import aplicacion_manuel.services.ProyectoServiceImpl;
import aplicacion_manuel.services.UserServiceImpl;
import aplicacion_manuel.webdto.User_MessageDTO;

@Controller
public class main_controller {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private ProyectoServiceImpl proyectoServiceImpl;
	
	@Autowired
	private MessageServiceImpl messageServiceImpl;

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
	
	//comprobar si esto es el mejor caso de uso
	//usuario manda mensaje a otro usuario
	@RequestMapping(value="mensajeForm/{email_receptor}", method = RequestMethod.GET)
	String mensaje(Model model,Principal principal, @PathVariable String email_receptor) {
		System.out.print(email_receptor);
		//aqui tienes que crear un objeto mensaje usuario que te de los valores del mensaje y tambien el email del usuario al que va dirigido al mensaje
		model.addAttribute("user_MessageDTO", new User_MessageDTO());
		model.addAttribute("email_emisor",principal.getName());
		model.addAttribute("email_receptor",email_receptor);
		return "mensajeForm";
	}
	
	@RequestMapping(value="/mensajeForm", method = RequestMethod.POST)
	String creacion_proyecto(@ModelAttribute User_MessageDTO user_MessageDTO) {	
		User usuario_emisor = userServiceImpl.findByEmail(user_MessageDTO.getEmailsourceUser());
		User usuario_receptor = userServiceImpl.findByEmail(user_MessageDTO.getEmailtargetUser());
		Message nuevo_mensaje= new Message(null,user_MessageDTO.getAsunto(), user_MessageDTO.getTexto(),usuario_emisor,usuario_receptor);
		usuario_emisor.addMessage(nuevo_mensaje);
		usuario_receptor.addMessage(nuevo_mensaje);
		messageServiceImpl.save(nuevo_mensaje);
		return "index";
	}
	
	
	 @GetMapping("/mensajes")
	    public String mensajes(Model model,Principal principal) {
			 List<Message> mensajes_enviados = messageServiceImpl.findSentMessages(principal.getName());
			 model.addAttribute("mensajes_enviados", messageServiceImpl.findSentMessages(principal.getName()));
			 System.out.print(mensajes_enviados);
			 List<Message> mensajes_recibidos = messageServiceImpl.findReceivedMessages(principal.getName());
			 model.addAttribute("mensajes_recibidos", messageServiceImpl.findReceivedMessages(principal.getName()));			 
			 System.out.print(mensajes_recibidos);
			 return "mensajes";
	    }

}
