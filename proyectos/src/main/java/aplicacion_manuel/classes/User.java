package aplicacion_manuel.classes;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	private String email;
	private String firstName;
    private String lastName;
	private String password;
	
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	            name = "alumnos_roles",
	            joinColumns = @JoinColumn(
	                    name = "user_email", referencedColumnName = "email"),
	            inverseJoinColumns = @JoinColumn(
	                    name = "role_id", referencedColumnName = "id"))
	//comprobar si da error cambiar a Set   
	 private Collection<Role> roles;
	 
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "alumnos_proyectos",
		joinColumns =  @JoinColumn(name = "alumnos_email",
			referencedColumnName = "email"),
		inverseJoinColumns =  @JoinColumn(name = "proyectos_id",
				referencedColumnName = "id"))
	private Set<Proyecto> proyectos;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Set<Proyecto> getProyectos() {
		return proyectos;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	public void setProyectos(Set<Proyecto> proyectos) {
		this.proyectos = proyectos;
		
	}
		
	public void addProyecto(Proyecto proyecto) {
		this.proyectos.add(proyecto);
	}
	
}


