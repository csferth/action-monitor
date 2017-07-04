package neverland.service;

import org.springframework.stereotype.Service;

import neverland.messaging.Producer;
import neverland.messaging.Receiver;

@Service
public class MessageService implements IMessageService {

	public void send(String message) {
		thread(new Producer(message), false);
		thread(new Receiver(), false);
	}

	public static void thread(Runnable runnable, boolean daemon) {
        Thread brokerThread = new Thread(runnable);
        brokerThread.setDaemon(daemon);
        brokerThread.start();
    }

}
