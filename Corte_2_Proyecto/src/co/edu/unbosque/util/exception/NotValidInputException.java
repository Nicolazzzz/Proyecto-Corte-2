package co.edu.unbosque.util.exception;

/**
 * La clase {@code NotValidInputException} es una excepción personalizada que se
 * lanza cuando se proporciona una entrada no válida.
 * <p>
 * Esta excepción se utiliza para gestionar situaciones en las que la entrada
 * incluye caracteres especiales o datos numéricos, los cuales no son
 * aceptables.
 * </p>
 * 
 * @author Sebastian
 * @since 2024-09-24
 * @version 1.0
 */
public class NotValidInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotValidInputException() {
		super("NO INGRESE CARACTERES ESPECIALES O DATOS NUMERICOS");
	}
}
