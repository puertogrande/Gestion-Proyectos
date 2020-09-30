package aplicacion_manuel.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import aplicacion_manuel.classes.User;
import aplicacion_manuel.webdto.UserRegistrationDTO;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    User save(UserRegistrationDTO registration);
    void save_user(User usuario);
    List<User>findAll();
}
