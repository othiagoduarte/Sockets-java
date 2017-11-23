
package com.othiagoduarte.sockets;

import com.othiagoduarte.windows.JPanelExemplo;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.*;

public class Client implements Runnable {

	private static int sequencial = 0;
	private JPanelExemplo frame;
	private String host;
	private int port;
	private int numeroCliente;
//	private ObjectOutputStream objectOutputStream;
//	private ObjectInputStreamputStream objectInputStreamputStream;

	public Client(String host, int port, JPanelExemplo frame) {
		this.host = host;
		this.port = port;
		this.frame = frame;
		sequencial++;
		numeroCliente = sequencial;
	}

	public void run(){
		
		try {
			String outPut = "";
			Socket clientSocket = new Socket(this.host, this.port);
			System.out.println("Client " + numeroCliente + " connection on server! in port " + this.port);

			Receiver receiverRunable = new Receiver(clientSocket);
			new Thread(receiverRunable).start();

			Scanner scanner = new Scanner(System.in);
			PrintStream printStream = new PrintStream(clientSocket.getOutputStream());

//			objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

		//	JOptionPane.showInputDialog("Cliente " + numeroCliente + scanner.nextLine());
			printStream.println("Cliente " + numeroCliente + scanner.nextLine());

			printStream.close();
			scanner.close();
			clientSocket.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public int getNumeroCliente() {
		return numeroCliente;
	}
}
