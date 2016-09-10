package com.mooo.topichat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

public class Server {
	
	
	/** A map of all the connected clients
	 * 
	 * @param String
	 *            the UUID of the client
	 * @param Connection
	 *            the TCP socket of the client */
	private Map<String, Connection> connections = new HashMap<String, Connection>();
	
	/** The server socket */
	private ServerSocket serverSocket;
	
	/** Sends a message through TCP to the web-client
	 * 
	 * @param message
	 *            the message to be sent
	 * @param ip
	 *            the IP address of the client
	 * @param port
	 *            the port of the client */
	public void sendMessage(String message, InetAddress ip, int port) throws IOException {
		getConnection(ip, port).sendMessage(message);
	}
	
	/** Get the TCP Connection for the specified IP
	 * 
	 * @param ip
	 *            the IP address of the client
	 * @param port
	 *            the port of the client */
	public Connection getConnection(InetAddress ip, int port) {
		for (Connection con : connections.values()) {
			if (ip.equals(con.getIp()) && port == con.getPort()) { return con; }
		}
		return null;
	}
}
