package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase {@code VueloInternacional} representa un vuelo internacional y
 * extiende la clase {@code Vuelo}. Esta clase añade la funcionalidad de
 * verificar si se requiere una visa para el vuelo.
 * <p>
 * Implementa la interfaz {@code Serializable} para permitir la serialización de
 * objetos de esta clase.
 * </p>
 * 
 * @author Mario
 * @since 2024-09-24
 * @version 1.0
 */
public class VueloInternacional extends Vuelo implements Serializable {

	/** Identificador único para la serialización. */
	private static final long serialVersionUID = 3L;

	/** Indica si el vuelo requiere visa. */
	private boolean requiereVisa;

	/**
	 * Constructor por defecto para crear una instancia vacía de
	 * {@code VueloInternacional}.
	 */
	public VueloInternacional() {
		// Constructor vacío
	}

	/**
	 * Constructor para crear una instancia de {@code VueloInternacional}
	 * especificando si se requiere visa.
	 * 
	 * @param requiereVisa {@code true} si el vuelo requiere visa, {@code false} en
	 *                     caso contrario.
	 */
	public VueloInternacional(boolean requiereVisa) {
		super();
		this.requiereVisa = requiereVisa;
	}

	/**
	 * Constructor con parámetros para crear una instancia de
	 * {@code VueloInternacional} con todos los atributos especificados.
	 * 
	 * @param destino         El destino del vuelo.
	 * @param companyInCharge La compañía a cargo del vuelo.
	 * @param numPassengers   El número de pasajeros a bordo.
	 * @param captain         El capitán del vuelo.
	 * @param secondInCommand El segundo al mando del vuelo.
	 * @param arrivalTime     La hora de llegada del vuelo.
	 * @param departureTime   La hora de salida del vuelo.
	 * @param gas             La cantidad de combustible del vuelo.
	 * @param requiereVisa    {@code true} si el vuelo requiere visa, {@code false}
	 *                        en caso contrario.
	 */
	public VueloInternacional(String destino, String companyInCharge, int numPassengers, String captain,
			String secondInCommand, String arrivalTime, String departureTime, double gas, boolean requiereVisa) {
		super(destino, companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime, gas);
		this.requiereVisa = requiereVisa;
	}

	/**
	 * Constructor con parámetros para crear una instancia de
	 * {@code VueloInternacional} sin especificar si se requiere visa.
	 * 
	 * @param destino         El destino del vuelo.
	 * @param companyInCharge La compañía a cargo del vuelo.
	 * @param numPassengers   El número de pasajeros a bordo.
	 * @param captain         El capitán del vuelo.
	 * @param secondInCommand El segundo al mando del vuelo.
	 * @param arrivalTime     La hora de llegada del vuelo.
	 * @param departureTime   La hora de salida del vuelo.
	 * @param gas             La cantidad de combustible del vuelo.
	 */
	public VueloInternacional(String destino, String companyInCharge, int numPassengers, String captain,
			String secondInCommand, String arrivalTime, String departureTime, double gas) {
		super(destino, companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime, gas);
		// Constructor vacío
	}

	/**
	 * Obtiene si el vuelo requiere visa.
	 * 
	 * @return {@code true} si el vuelo requiere visa, {@code false} en caso
	 *         contrario.
	 */
	public boolean isRequiereVisa() {
		return requiereVisa;
	}

	/**
	 * Establece si el vuelo requiere visa.
	 * 
	 * @param requiereVisa {@code true} si el vuelo debe requerir visa,
	 *                     {@code false} en caso contrario.
	 */
	public void setRequiereVisa(boolean requiereVisa) {
		this.requiereVisa = requiereVisa;
	}

	/**
	 * Obtiene el identificador de serialización.
	 * 
	 * @return El identificador de serialización.
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Devuelve una representación en cadena de texto de los detalles del vuelo
	 * internacional.
	 * 
	 * @return Una cadena que representa los detalles del vuelo internacional.
	 */
	@Override
	public String toString() {
		return super.toString() + "\nRequiere visa: " + requiereVisa;
	}
}
