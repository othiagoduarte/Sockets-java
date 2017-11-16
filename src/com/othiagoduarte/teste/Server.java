package com.othiagoduarte.teste;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private static Integer PORT = 12345;
	private int port;
	private ArrayList<PrintStream> clientPrintStream;
	private ServerSocket server;

	public Server(int porta) {
		this.port = porta;
		this.clientPrintStream = new ArrayList<PrintStream>();
	}
	
	public static void main(String[] args) throws IOException {
		new Server(PORT).run();
	}
	
	public void run() throws IOException {
		server = new ServerSocket(this.port);
		System.out.println("Porta 12345 open!");

		while (true) {
			Socket clientSocket = server.accept();
			System.out.println("New connection" + clientSocket.getInetAddress().getHostAddress());
			PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
			
			this.clientPrintStream.add(printStream);

			CustomerProcesses customerProcessesRunnable = new CustomerProcesses(clientSocket.getInputStream(), this);
			new Thread(customerProcessesRunnable).start();
		}
	}

	public void broadcast(String msg) {
		for (PrintStream clientPrintStream : this.clientPrintStream) {
			clientPrintStream.println(msg);
		}
	}

}
