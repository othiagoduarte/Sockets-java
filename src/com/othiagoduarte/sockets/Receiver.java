package com.othiagoduarte.sockets;

import java.io.InputStream;
import java.util.Scanner;

public class Receiver implements Runnable{
	private InputStream server;
	 
	   public Receiver(InputStream server) {
	     this.server = server;
	   }
	 
	   public void run() {
	     Scanner s = new Scanner(this.server);
	     while (s.hasNextLine()) {
	       System.out.println(s.nextLine());
	     }
	   }
}
