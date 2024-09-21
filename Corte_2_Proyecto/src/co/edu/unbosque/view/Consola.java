package co.edu.unbosque.view;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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

	public double readDouble() {
		return sc.nextDouble();
	}

	public String readLine() {
		return sc.nextLine();
	}

	public boolean readBoolean() {
		String input = sc.next();

		if (input.toLowerCase().equals("si")) {
			return true;
		} else if (input.toLowerCase().equals("no")) {
			return false;
		}
		return false;
	}

	public void mostrarMensajeEmergenteConScrollDark(String texto) {
		JTextArea textArea = new JTextArea(30, 50);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setForeground(Color.WHITE);
		textArea.setText(texto);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setCaretPosition(0);
		textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		JOptionPane.showMessageDialog(null, scrollPane, "Listado de productos", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarMensajeEmergenteConScrollWhite(String texto) {
		JTextArea textArea = new JTextArea(30, 50);
		textArea.setText(texto);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setCaretPosition(0);
		textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		JOptionPane.showMessageDialog(null, scrollPane, "Listado de productos", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Muestra un mensaje emergente simple.
	 * 
	 * @param texto El texto a mostrar en el cuadro de diálogo.
	 */
	public void mostrarMensajeEmergente(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Muestra una alerta emergente.
	 * 
	 * @param texto El texto de alerta a mostrar.
	 */
	public void mostrarAlerta(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Alerta", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Muestra un mensaje de error emergente.
	 * 
	 * @param texto El mensaje de error a mostrar.
	 */
	public void mostrarError(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Error", JOptionPane.ERROR_MESSAGE);
	}

}
