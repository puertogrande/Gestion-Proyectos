package aplicacion_manuel.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplicacion_manuel.classes.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	User findByEmail(String email);
	List<User> findAll();
}
