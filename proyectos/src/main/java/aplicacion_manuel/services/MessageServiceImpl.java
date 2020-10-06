package aplicacion_manuel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicacion_manuel.classes.Message;
import aplicacion_manuel.repositories.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageRepository messageRepostitory;
	
	@Override
	public Message findById(Long Id) {
		// TODO Auto-generated method stub
		return messageRepostitory.findById(Id);
	}

	@Override
	public void save(Message mensaje) {
		messageRepostitory.save(mensaje);
	}

	@Override
	public List<Message> findSentMessages(String user_email) {
		// TODO Auto-generated method stub
		return messageRepostitory.findSentMessages(user_email);
	}

	@Override
	public List<Message> findReceivedMessages(String friend_email) {
		// TODO Auto-generated method stub
		return messageRepostitory.findReceivedMessages(friend_email);
	}
	
}
