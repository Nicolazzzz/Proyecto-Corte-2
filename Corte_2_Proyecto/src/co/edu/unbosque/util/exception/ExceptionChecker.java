package co.edu.unbosque.util.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase {@code ExceptionChecker} proporciona métodos estáticos para
 * verificar entradas de datos y lanzar excepciones personalizadas según sea
 * necesario.
 * <p>
 * Esta clase es útil para validar datos ingresados por el usuario, asegurando
 * que cumplan con ciertos criterios antes de procesarlos.
 * </p>
 * 
 * @author Mario
 * @since 2024-09-24
 * @version 1.0
 */
public class ExceptionChecker {

	/**
	 * Verifica si la entrada de texto contiene caracteres no válidos.
	 * 
	 * @param txt el texto a validar
	 * @throws NotValidInputException si se encuentran caracteres no alfabéticos
	 */
	public static void notValidInputException(String txt) throws NotValidInputException {
		Pattern p = Pattern.compile("[^a-zA-ZñÑ ]");
		Matcher m = p.matcher(txt);

		if (m.find()) {
			throw new NotValidInputException();
		}
	}

	/**
	 * Verifica si el valor booleano es nulo.
	 * 
	 * @param b el valor booleano a validar
	 * @throws NotValidBooleanException si el valor booleano es nulo
	 */
	public static void notValidBooleanException(Boolean b) throws NotValidBooleanException {
		if (b == null) {
			throw new NotValidBooleanException();
		}
	}

	/**
	 * Verifica si el número entero es negativo.
	 * 
	 * @param n el número entero a validar
	 * @throws NegativeIntNumberException si el número es negativo
	 */
	public static void negativeIntNumberException(int n) throws NegativeIntNumberException {
		if (n < 0) {
			throw new NegativeIntNumberException();
		}
	}

	/**
	 * Verifica si el formato de tiempo es válido.
	 * 
	 * @param time el tiempo a validar en formato HH:mm
	 * @throws NotValidTimeFormatException si el formato de tiempo es inválido
	 */

	public static void notValidTimeFormatException(String time) throws NotValidTimeFormatException {

		boolean punticos = false;

		String contenido = time.charAt(2) + "";
		if (contenido.equals(":"))
			punticos = true;

		if (punticos != true)
			throw new NotValidTimeFormatException();

		if (time.length() < 5 || time.length() > 5) {
			throw new NotValidTimeFormatException();
		}

		if (punticos == true) {

			String[] horas = time.split(":");
			int hora = Integer.parseInt(horas[0]);
			int minutos = Integer.parseInt(horas[1]);

			if (hora < 0 || hora > 23 || minutos < 0 || minutos > 59)
				throw new NotValidTimeFormatException();
		}

	}

	/**
	 * Verifica la capacidad de pasajeros para aviones de hélice.
	 * 
	 * @param passengers el número de pasajeros a validar
	 * @throws PassengerCapacityException si la capacidad no está entre 0 y 555
	 */
	public static void passengerCapacityHeliceException(int passengers) throws PassengerCapacityException {

		if (passengers < 0 || passengers > 555) {
			throw new PassengerCapacityException();
		}
	}

	/**
	 * Verifica la capacidad de pasajeros para aviones a turbina.
	 * 
	 * @param passengers el número de pasajeros a validar
	 * @throws PassengerCapacityException si la capacidad no está entre 0 y 300
	 */
	public static void passengerCapacityTurbinaException(int passengers) throws PassengerCapacityException {

		if (passengers < 0 || passengers > 300) {
			throw new PassengerCapacityException();
		}
	}
}
