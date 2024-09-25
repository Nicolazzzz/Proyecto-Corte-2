package co.edu.unbosque.util.exception;

/**
 * La clase {@code NotValidTimeFormatException} es una excepción personalizada
 * que se lanza cuando se proporciona un formato de tiempo no válido.
 * <p>
 * Esta excepción se utiliza para gestionar situaciones en las que el formato de
 * hora ingresado no cumple con el estándar esperado de 24 horas (HH:mm).
 * </p>
 * 
 * @author Sebastian
 * @since 2024-09-24
 * @version 1.0
 */
public class NotValidTimeFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor por defecto que inicializa la excepción con un mensaje
	 * predeterminado que indica que el formato de horas no es válido.
	 */
	public NotValidTimeFormatException() {
		super("FORMATO DE HORAS NO VÁLIDO, USE (24:00)");
	}
}
