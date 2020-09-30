package aplicacion_manuel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplicacion_manuel.classes.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, String>{
	Proyecto findById(Long Id);
	List <Proyecto> findByNombre(String name); 
	List <Proyecto> findByDescripcion(String descripcion); 
}
