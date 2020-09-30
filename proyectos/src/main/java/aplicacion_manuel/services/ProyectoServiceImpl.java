package aplicacion_manuel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicacion_manuel.classes.Proyecto;
import aplicacion_manuel.repositories.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService{
	@Autowired
	private ProyectoRepository proyectoRepository;

	@Override
	public Proyecto findById(Long Id) {
		// TODO Auto-generated method stub
		return proyectoRepository.findById(Id);
	}

	@Override
	public List<Proyecto> findByNombre(String Nombre) {
		// TODO Auto-generated method stub
		return proyectoRepository.findByNombre(Nombre);
	}

	@Override
	public List<Proyecto> findByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return proyectoRepository.findByDescripcion(descripcion);
	}

	@Override
	public List<Proyecto> findAll() {
		// TODO Auto-generated method stub
		return proyectoRepository.findAll();
	}

	@Override
	public void save(Proyecto proyecto) {
		// TODO Auto-generated method stub
		proyectoRepository.save(proyecto);
		
	}

}
