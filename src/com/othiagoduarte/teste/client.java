package com.othiagoduarte.teste;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {


	private String host;
	private int porta;

	public client(String host, int porta) {
		this.host = host;
		this.porta = porta;
	}

	public void run() throws UnknownHostException, IOException {
		
		Socket clientSocket = new Socket(this.host, this.porta);
		System.out.println("Client connection on server!");

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
