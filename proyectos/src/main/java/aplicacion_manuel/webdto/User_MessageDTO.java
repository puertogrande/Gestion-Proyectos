package aplicacion_manuel.webdto;


public class User_MessageDTO {
	private String asunto;
	private String texto;
	private String emailsourceUser;
	private String emailtargetUser;
	
	public User_MessageDTO() {
		super();
	}

	public User_MessageDTO(String asunto, String texto, String emailsourceUser, String emailtargetUser) {
		super();
		this.asunto = asunto;
		this.texto = texto;
		this.emailsourceUser = emailsourceUser;
		this.emailtargetUser = emailtargetUser;
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

	public String getEmailsourceUser() {
		return emailsourceUser;
	}

	public void setEmailsourceUser(String emailsourceUser) {
		this.emailsourceUser = emailsourceUser;
	}

	public String getEmailtargetUser() {
		return emailtargetUser;
	}

	public void setEmailtargetUser(String emailtargetUser) {
		this.emailtargetUser = emailtargetUser;
	}

	@Override
	public String toString() {
		return "User_MessageDTO [asunto=" + asunto + ", texto=" + texto + ", emailsourceUser=" + emailsourceUser
				+ ", emailtargetUser=" + emailtargetUser + "]";
	}
	
}
