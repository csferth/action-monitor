package neverland.controllers;


import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import neverland.dto.MessageDTO;
import neverland.entity.Content;
import neverland.messaging.Producer;
import neverland.messaging.Receiver;
import neverland.service.IContentService;
import neverland.service.IMessageService;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private IContentService contentService;
	@Autowired
	private IMessageService messageService;

    /**
     * Listens the /app/guestbook endpoint and when a message is received, encapsulates it in a MessageDTO instance and relays the resulting object to
     * the clients listening at the /topic/entries endpoint.
     * 
     * @param message the message
     * @return the encapsulated message
     */
    @MessageMapping("/guestbook")
    @SendTo("/topic/entries")
    public MessageDTO guestbook(String message) {
        System.out.println("Received message: " + message);
        for (Content content : contentService.getAllContent()) {
        	System.out.println("Content ID: " + content.getContentId());
        	System.out.println("Content DATA: " + content.getData());
        }
        messageService.send(message);
        return new MessageDTO(message);
    }
    
    // create new method that listens to jms produced by receiver, and send to same location as above
    // move this logic to a service
    // pass message to service and handle everything there
    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Message message) {
        System.out.println("Received <" + message + ">");
    }
}
