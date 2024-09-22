package co.edu.unbosque.util.exception;

public class PassengerCapacityException extends Exception {
	public PassengerCapacityException() {
		super("La capacidad de pasajeros no es valida");
	}
}
