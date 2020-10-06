package aplicacion_manuel.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import aplicacion_manuel.classes.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, String>{
	Message findById(Long Id);
	
	@Query("FROM Message WHERE user_email = ?1")
	List<Message> findSentMessages(String user_email);
	
	@Query("FROM Message WHERE friend_email = ?1")
	List<Message> findReceivedMessages(String friend_email);
}
