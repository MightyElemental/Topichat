package com.mooo.topichat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Connection {
	
	
	// Main variables
	private Socket client;
	private InetAddress ip;
	private int port;
	private String UID;
	
	// IO
	private InputStream is;
	private OutputStream os;
	
	/** @return the client socket */
	public Socket getClient() {
		return client;
	}
	
	/** @return the IP address of the client */
	public InetAddress getIp() {
		return ip;
	}
	
	/** @return the port of the client */
	public int getPort() {
		return port;
	}
	
	/** @return the UUID */
	public String getUUID() {
		return UID;
	}
	
	/** Sends an object to the client
	 * 
	 * @param message
	 *            the message to send to the client
	 * @throws IOException */
	public void sendMessage(String message) throws IOException {
		os.write(message.getBytes("UTF-8"));
	}
}
