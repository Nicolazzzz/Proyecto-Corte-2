package co.edu.unbosque.util.exception;

/**
 * La clase {@code NotValidBooleanException} es una excepción personalizada que
 * se lanza cuando una respuesta booleana no es válida.
 * <p>
 * Esta excepción se utiliza para gestionar situaciones en las que la respuesta
 * proporcionada no corresponde con los valores de verdad esperados (sí/no).
 * </p>
 * 
 * @author Sebastian
 * @since 2024-09-24
 * @version 1.0
 */
public class NotValidBooleanException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotValidBooleanException() {
		super("NO CORRESPONDE SU RESPUESTA CON EL VALOR DE VERDAD, EN PREGUNTAS CON RESPUESTAS SI/NO --> VERIFIQUE QUE SU RESPUESTA SEA ESA");
	}
}
