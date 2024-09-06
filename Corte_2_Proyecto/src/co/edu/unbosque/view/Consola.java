package co.edu.unbosque.view;

import java.util.Scanner;

public class Consola {

	private Scanner sc;

	public Consola() {
		sc = new Scanner(System.in);
	}

	public void burnLine() {
		sc.nextLine();
	}

	public void printLine(String text) {
		System.out.println(text);
	}

	public void print(String text) {
		System.out.print(text);
	}

	public int readInt() {
		return sc.nextInt();
	}

	public String readLine() {
		return sc.nextLine();
	}

}
