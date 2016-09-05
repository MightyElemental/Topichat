package com.mooo.topichat;

import java.util.ArrayList;
import java.util.List;

public class MessageListenerIniter {
	
	
	public static List<MessageListener> listeners = new ArrayList<MessageListener>();
	
	/** This method should be invoked when a web-client send a message<br>
	 * This method passes the information on to the listeners
	 * 
	 * @param uid
	 *            the UID of the client that sent the message
	 * @param dir
	 *            the directory of the chat
	 * @param message
	 *            the message sent to the server */
	public static void onMessageRecived(String uid, String dir, String message) {
		for (MessageListener l : listeners) {
			l.onMessageRecived(uid, dir, message);
		}
	}
	
	/** Use to add a message listener */
	public static void addListener(MessageListener ml) {
		listeners.add(ml);
	}
}
