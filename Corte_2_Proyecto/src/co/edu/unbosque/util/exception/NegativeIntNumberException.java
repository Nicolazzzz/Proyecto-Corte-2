package co.edu.unbosque.util.exception;

/**
 * La clase {@code NegativeIntNumberException} es una excepción personalizada
 * que se lanza cuando se intenta ingresar un número entero negativo.
 * <p>
 * Esta excepción se utiliza para gestionar situaciones en las que el valor
 * ingresado no es válido debido a que es negativo.
 * </p>
 * 
 * @author Emmanuel
 * @since 2024-09-24
 * @version 1.0
 */
public class NegativeIntNumberException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegativeIntNumberException() {
		super("NO PUEDE INGRESAR NÚMEROS NEGATIVOS");
	}
}
