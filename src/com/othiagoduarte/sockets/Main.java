package com.othiagoduarte.sockets;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {
	private static String HOST = "127.0.0.1";
	private static Integer port = 12345;
	

	public static void main(String[] args) throws IOException {
		Boolean sair = true;
		while(sair) {
			String portString = "";
			portString = JOptionPane.showInputDialog(null, "Digite uma porta");
			sair = portString.equalsIgnoreCase("Sair");
			port = Integer.valueOf(portString);
			System.out.println("PORT" +  port);
			new Server(port).run();
			new client(HOST, port).run();			
		}
	}	
}	
