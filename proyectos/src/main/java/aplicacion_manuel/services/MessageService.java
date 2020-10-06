package aplicacion_manuel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import aplicacion_manuel.classes.Message;



@Service
public interface MessageService {
	public Message findById(Long Id);
	public void save(Message proyecto);
	public List<Message> findSentMessages(String user_email);
	public List<Message> findReceivedMessages(String friend_email);

}
