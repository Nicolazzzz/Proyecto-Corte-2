package co.edu.unbosque.util.exception;

public class NotValidBooleanException extends Exception {

	public NotValidBooleanException() {
		super("NO CORRESPONDE SU RESPUESTA CON EL VALOR DE VERDAD, EN PREGUNTAS CON RESPUESTAS SI/NO --> VERIFIQUE QUE SU RESPUESTA SEA ESA");

	}
}
