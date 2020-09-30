package aplicacion_manuel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import aplicacion_manuel.classes.Proyecto;

@Service
public interface ProyectoService {
	public Proyecto findById(Long Id);
	public List <Proyecto> findByNombre(String Nombre);
	public List <Proyecto> findByDescripcion(String descripcion); 
	public List <Proyecto> findAll(); 
	public void save(Proyecto proyecto);
	//aqui debemos crear una que nos cambia la password y la codifique

}
