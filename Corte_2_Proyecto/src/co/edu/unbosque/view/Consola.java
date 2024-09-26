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

		JOptionPane.showMessageDialog(null, scrollPane, "Listado de vuelos", JOptionPane.INFORMATION_MESSAGE);
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

		JOptionPane.showMessageDialog(null, scrollPane, "Listado de vuelos", JOptionPane.INFORMATION_MESSAGE);
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

	public String seleccionarAerolinea(String[] aerolineas) {
		// Mostrar una lista desplegable de aerolíneas con JOptionPane
		String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una aerolínea:",
				"Listado de Aerolíneas", JOptionPane.QUESTION_MESSAGE, null, aerolineas, // Lista de opciones
				aerolineas[0]); // Opción predeterminada

		// Validar que el usuario haya seleccionado una opción válida
		if (seleccion == null) {
			seleccion = "No se seleccionó ninguna aerolínea";
		}

		return seleccion;
	}

	public boolean leerBoolean(String entrada) {
		if (entrada.toLowerCase().contains("si")) {
			return true;
		}
		return false;
	}
}
