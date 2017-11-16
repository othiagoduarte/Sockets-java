package com.othiagoduarte.sockets;

import java.io.InputStream;
import java.util.Scanner;

public class CustomerProcesses implements Runnable {
	private InputStream cliente;
	   
	private Server servidor;
	 
	   public CustomerProcesses(InputStream cliente, Server servidor) {
	     this.cliente = cliente;
	     this.servidor = servidor;
	   }
	 
	   public void run() {
	     Scanner s = new Scanner(this.cliente);
	     while (s.hasNextLine()) {
	       servidor.broadcast(s.nextLine());
	     }
	     s.close();
	   }

}
