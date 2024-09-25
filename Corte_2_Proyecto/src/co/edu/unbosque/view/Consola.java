package co.edu.unbosque.view;

import java.awt.Color;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * La clase {@code Consola} proporciona métodos para interactuar con el usuario
 * a través de la consola y cuadros de diálogo emergentes.
 * <p>
 * Esta clase permite la entrada de datos y la visualización de mensajes de
 * información, advertencia y error, facilitando la interacción en aplicaciones
 * Java.
 * </p>
 * 
 * @author Santiago
 * @since 2024-09-24
 * @version 1.0
 */
public class Consola {

	private Scanner sc;

	/**
	 * Constructor que inicializa el objeto {@code Scanner} para la entrada de
	 * datos.
	 */
	public Consola() {
		sc = new Scanner(System.in);
	}

	/**
	 * Limpia la línea actual de entrada del escáner.
	 */
	public void burnLine() {
		sc.nextLine();
	}

	/**
	 * Imprime una línea de texto en la consola.
	 * 
	 * @param text el texto a imprimir
	 */
	public void printLine(String text) {
		System.out.println(text);
	}

	/**
	 * Imprime texto sin salto de línea al final.
	 * 
	 * @param text el texto a imprimir
	 */
	public void print(String text) {
		System.out.print(text);
	}

	/**
	 * Lee un número entero de la entrada del usuario.
	 * 
	 * @return el número entero ingresado
	 */
	public int readInt() {
		return sc.nextInt();
	}

	/**
	 * Lee un número decimal de la entrada del usuario.
	 * 
	 * @return el número decimal ingresado
	 */
	public double readDouble() {
		return sc.nextDouble();
	}

	/**
	 * Lee una línea de texto de la entrada del usuario.
	 * 
	 * @return la línea de texto ingresada
	 */
	public String readLine() {
		return sc.nextLine();
	}

	/**
	 * Lee una respuesta booleana de la entrada del usuario.
	 * 
	 * @return {@code true} si el usuario ingresa "si", {@code false} si ingresa
	 *         "no"
	 */
	public boolean readBoolean() {
		String input = sc.next();
		if (input.toLowerCase().equals("si")) {
			return true;
		} else if (input.toLowerCase().equals("no")) {
			return false;
		}
		return false;
	}

	/**
	 * Muestra un mensaje emergente con un área de texto desplazable y fondo oscuro.
	 * 
	 * @param texto el texto a mostrar
	 */
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

	/**
	 * Muestra un mensaje emergente con un área de texto desplazable y fondo blanco.
	 * 
	 * @param texto el texto a mostrar
	 */
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
	 * @param texto el texto a mostrar en el cuadro de diálogo
	 */
	public void mostrarMensajeEmergente(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Muestra una alerta emergente.
	 * 
	 * @param texto el texto de alerta a mostrar
	 */
	public void mostrarAlerta(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Alerta", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Muestra un mensaje de error emergente.
	 * 
	 * @param texto el mensaje de error a mostrar
	 */
	public void mostrarError(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
