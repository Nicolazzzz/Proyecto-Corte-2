package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase {@code VueloNacionalDTO} representa un Data Transfer Object (DTO)
 * para un vuelo nacional. Esta clase extiende a {@code VueloDTO} y encapsula
 * información específica sobre el tipo de propulsión del vuelo, ya sea turbina
 * o hélice.
 * <p>
 * Esta clase es útil para transferir datos entre la capa de presentación y la
 * capa de negocio en aplicaciones que manejan vuelos nacionales.
 * </p>
 * 
 * @author Emmanuel
 * @since 2024-09-24
 * @version 1.0
 */
public class VueloNacionalDTO extends VueloDTO {

	/** Identificador único para la serialización. */
	private static final long serialVersionUID = 4L;

	/** Indica si el vuelo utiliza un motor a turbina. */
	private boolean esTurbina;

	/** Indica si el vuelo utiliza un motor a hélice. */
	private boolean esHelice;

	/**
	 * Constructor por defecto para crear una instancia vacía de
	 * {@code VueloNacionalDTO}.
	 */
	public VueloNacionalDTO() {
		// Constructor vacío
	}

	/**
	 * Constructor para crear una instancia de {@code VueloNacionalDTO}
	 * especificando el tipo de propulsión.
	 * 
	 * @param esTurbina {@code true} si el vuelo tiene motor a turbina,
	 *                  {@code false} en caso contrario.
	 * @param esHelice  {@code true} si el vuelo tiene motor a hélice, {@code false}
	 *                  en caso contrario.
	 */
	public VueloNacionalDTO(boolean esTurbina, boolean esHelice) {
		super();
		this.esTurbina = esTurbina;
		this.esHelice = esHelice;
	}

	/**
	 * Constructor con parámetros para crear una instancia de
	 * {@code VueloNacionalDTO} con todos los atributos especificados.
	 * 
	 * @param destino         El destino del vuelo.
	 * @param companyInCharge La compañía a cargo del vuelo.
	 * @param numPassengers   El número de pasajeros a bordo.
	 * @param captain         El capitán del vuelo.
	 * @param secondInCommand El segundo al mando del vuelo.
	 * @param arrivalTime     La hora de llegada del vuelo.
	 * @param departureTime   La hora de salida del vuelo.
	 * @param gas             La cantidad de combustible del vuelo.
	 * @param esTurbina       {@code true} si el vuelo tiene motor a turbina,
	 *                        {@code false} en caso contrario.
	 * @param esHelice        {@code true} si el vuelo tiene motor a hélice,
	 *                        {@code false} en caso contrario.
	 */
	public VueloNacionalDTO(String destino, String companyInCharge, int numPassengers, String captain,
			String secondInCommand, String arrivalTime, String departureTime, double gas, boolean esTurbina,
			boolean esHelice) {
		super(destino, companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime, gas);
		this.esTurbina = esTurbina;
		this.esHelice = esHelice;
	}

	/**
	 * Constructor con parámetros para crear una instancia de
	 * {@code VueloNacionalDTO} sin especificar el tipo de propulsión.
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
	public VueloNacionalDTO(String destino, String companyInCharge, int numPassengers, String captain,
			String secondInCommand, String arrivalTime, String departureTime, double gas) {
		super(destino, companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime, gas);
		// Constructor vacío
	}

	/**
	 * Obtiene si el vuelo tiene motor a turbina.
	 * 
	 * @return {@code true} si el vuelo tiene motor a turbina, {@code false} en caso
	 *         contrario.
	 */
	public boolean isEsTurbina() {
		return esTurbina;
	}

	/**
	 * Establece si el vuelo tiene motor a turbina.
	 * 
	 * @param esTurbina {@code true} si el vuelo debe tener motor a turbina,
	 *                  {@code false} en caso contrario.
	 */
	public void setEsTurbina(boolean esTurbina) {
		this.esTurbina = esTurbina;
	}

	/**
	 * Obtiene si el vuelo tiene motor a hélice.
	 * 
	 * @return {@code true} si el vuelo tiene motor a hélice, {@code false} en caso
	 *         contrario.
	 */
	public boolean isEsHelice() {
		return esHelice;
	}

	/**
	 * Establece si el vuelo tiene motor a hélice.
	 * 
	 * @param esHelice {@code true} si el vuelo debe tener motor a hélice,
	 *                 {@code false} en caso contrario.
	 */
	public void setEsHelice(boolean esHelice) {
		this.esHelice = esHelice;
	}

	/**
	 * Devuelve una representación en cadena de texto de los detalles del vuelo
	 * nacional, incluyendo información sobre el tipo de propulsión.
	 * 
	 * @return Una cadena que representa los detalles del vuelo nacional, incluyendo
	 *         si tiene turbina y hélice.
	 */
	@Override
	public String toString() {
		return super.toString() + "\nTiene turbina: " + esTurbina + "\nTiene hélice: " + esHelice;
	}
}
