package com.mooo.topichat;

public interface MessageListener {
	
	
	/** When a web-client sends a message, this method will be called */
	public void onMessageRecived(String UID, String dir, String message);
	
}
