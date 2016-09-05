package com.mooo.topichat;

import java.util.ArrayList;
import java.util.List;

public class MessageListenerIniter {
	
	
	public static List<MessageListener> listeners = new ArrayList<MessageListener>();
	
	/** This method should be invoked when a web-client send a message<br>
	 * This method passes the information on to the listeners */
	public static void onMessageRecived(String UID, String dir, String message) {
		for (MessageListener l : listeners) {
			l.onMessageRecived(UID, dir, message);
		}
	}
}
