package com.othiagoduarte.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Receiver implements Runnable{
	private InputStream server;
	private ObjectOutputStream objectOutputStream;

	   public Receiver(Socket socket) throws IOException {
	     this.server = socket.getInputStream();
	     this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
	   }
	 
	   public void run() {
	     Scanner s = new Scanner(this.server);
	     while (s.hasNextLine()) {
	     	System.out.print("IMPRIMIR!!!!!!!!!!!");
	       System.out.println(s.nextLine());
	     }
	   }
}
