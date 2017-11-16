package com.othiagoduarte.teste;

import java.io.IOException;

public class Main {
	private static String HOST = "127.0.0.1";
	private static Integer port = 12345;
	

	public static void main(String[] args) throws IOException {
		new client(HOST, port).run();
		new client(HOST, port).run();
		new client(HOST, port).run();
		new client(HOST, port).run();
		new client(HOST, port).run();
	}	
}	
