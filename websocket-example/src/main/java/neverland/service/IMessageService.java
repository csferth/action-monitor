package neverland.service;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public interface IMessageService {
	
	public void send(String message);

}
