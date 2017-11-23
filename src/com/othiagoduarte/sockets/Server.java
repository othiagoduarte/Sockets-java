package com.othiagoduarte.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Server implements Runnable {
	private static Integer PORT = 12345;
	private int port;
	private ArrayList<PrintStream> clientPrintStream;
	private ArrayList<JOptionPane> clientJOptionPane;
	private ServerSocket server;

	public Server(int porta) {
		this.port = porta;
		this.clientPrintStream = new ArrayList<PrintStream>();
		this.clientJOptionPane = new ArrayList<JOptionPane>();
	}
	
	public static void main(String[] args) throws IOException {
		new Server(PORT).run();
	}
	
	public void run(){
		try {
			server = new ServerSocket(this.port);
			System.out.println("Server open in port "+ this.port);

			while (true) {
				Socket clientSocket = server.accept();
				System.out.println("New connection" + clientSocket.getInetAddress().getHostAddress());
				PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
				
				this.clientPrintStream.add(printStream);
				this.clientJOptionPane.add(new JOptionPane());;

				CustomerProcesses customerProcessesRunnable = new CustomerProcesses(clientSocket.getInputStream(), this);
				new Thread(customerProcessesRunnable).start();
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void broadcast(String msg) {
		for (PrintStream clientPrintStream : this.clientPrintStream) {
			clientPrintStream.println(msg);
		}
		for ( JOptionPane jop : this.clientJOptionPane) {
			jop.showConfirmDialog(null, msg);
		}
	}

}
