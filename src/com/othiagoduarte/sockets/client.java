package com.othiagoduarte.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {


	private String host;
	private int port;

	public client(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void run() throws UnknownHostException, IOException {
		
		Socket clientSocket = new Socket(this.host, this.port);
		System.out.println("Client connection on server! in port " + this.port);

		Receiver receiverRunable = new Receiver(clientSocket.getInputStream());
		new Thread(receiverRunable).start();

		Scanner scanner = new Scanner(System.in);
		PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
		
		while (scanner.hasNextLine()) {
			printStream.println(scanner.nextLine());
		}

		printStream.close();
		scanner.close();
		clientSocket.close();
	}
}
