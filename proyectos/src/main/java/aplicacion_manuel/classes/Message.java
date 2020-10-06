package aplicacion_manuel.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String asunto;
	private String texto;
	// ...
    /**
     * the user who asked the friendship
     */
    @ManyToOne()
    @JoinColumn(name = "user_email")
    private User sourceUser;

    /**
     * the user to whom the friendship was asked
     */
    @ManyToOne()
    @JoinColumn(name = "friend_email")
    private User targetUser;
    
	public Message() {
		super();
	}
	

	public Message(Long id, String asunto, String texto, User sourceUser, User targetUser) {
		super();
		this.id = id;
		this.asunto = asunto;
		this.texto = texto;
		this.sourceUser = sourceUser;
		this.targetUser = targetUser;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public User getSourceUser() {
		return sourceUser;
	}

	public void setSourceUser(User sourceUser) {
		this.sourceUser = sourceUser;
	}

	public User getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", asunto=" + asunto + ", texto=" + texto + ", sourceUser=" + sourceUser
				+ ", targetUser=" + targetUser + "]";
	}
    
    
	

}
