package co.edu.unbosque.util.exception;

public class NotValidTimeFormatException extends Exception {

	public NotValidTimeFormatException() {
		super("FORMATO DE HORAS NO VALIDO, USE (24:00)");
	}

}
