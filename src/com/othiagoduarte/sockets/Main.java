package com.othiagoduarte.sockets;

import com.othiagoduarte.windows.JPanelExemplo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Main {
	private static String HOST = "127.0.0.1";
	private static Integer port = 12345;
	

	public static void main(String[] args) throws IOException {
		String portString = "";
		portString = JOptionPane.showInputDialog(null, "Digite uma porta");
		port = Integer.valueOf(portString);
		System.out.println("HOST " + HOST + " - PORT " +  port);
		new Thread(new Server(port)).start();
		new Thread(new Client(HOST, port, instancePane())).start();
		new Thread(new Client(HOST, port, instancePane())).start();
		new Thread(new Client(HOST, port, instancePane())).start();
	}

	public static JPanelExemplo instancePane(){
		return  new JPanelExemplo();
	}
}
