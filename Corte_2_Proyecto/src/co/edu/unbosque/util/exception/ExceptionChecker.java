package co.edu.unbosque.util.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionChecker {

	public static void notValidInputException(String txt) throws NotValidInputException {

		Pattern p = Pattern.compile("[^a-zA-ZñÑ ]");
		Matcher m = p.matcher(txt);

		if (m.find()) {
			throw new NotValidInputException();
		}

	}

	public static void notValidBooleanException(Boolean b) throws NotValidBooleanException {
		if (b == null) {
			throw new NotValidBooleanException();
		}
	}

	public static void negativeIntNumberException(int n) throws NegativeIntNumberException {
		if (n < 0) {
			throw new NegativeIntNumberException();
		}
	}

	public static void notValidTimeFormatException(String time) throws NotValidTimeFormatException {

		Pattern p = Pattern.compile("[^0-9: ]");
		Matcher m = p.matcher(time);

		if (m.find()) {
			throw new NotValidTimeFormatException();
		}

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

	public static void passengerCapacityHeliceException(int passengers) throws PassengerCapacityException {

		if (passengers < 0 || passengers > 555) {
			throw new PassengerCapacityException();
		}
	}

	public static void passengerCapacityTurbinaException(int passengers) throws PassengerCapacityException {

		if (passengers < 0 || passengers > 300) {
			throw new PassengerCapacityException();
		}
	}
}
