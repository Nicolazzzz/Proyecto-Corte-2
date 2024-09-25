package co.edu.unbosque.util.exception;

/**
 * La clase {@code PassengerCapacityException} es una excepción personalizada
 * que se lanza cuando la capacidad de pasajeros de un vuelo no es válida.
 * <p>
 * Esta excepción se utiliza para gestionar casos en los que la capacidad
 * especificada excede un límite predefinido o no cumple con los criterios
 * necesarios para un vuelo.
 * </p>
 * 
 * @author Emmanuel
 * @since 2024-09-24
 * @version 1.0
 */
public class PassengerCapacityException extends Exception {

	/**
	 * Constructor por defecto que inicializa la excepción con un mensaje
	 * predeterminado que indica que la capacidad de pasajeros no es válida.
	 */
	public PassengerCapacityException() {
		super("La capacidad de pasajeros no es válida");
	}
}
