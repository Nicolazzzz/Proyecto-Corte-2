package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase abstracta que representa un vuelo. Esta clase implementa la interfaz
 * {@link Serializable} para permitir la serialización de sus objetos y contiene
 * los atributos comunes para todos los tipos de vuelos.
 * <p>
 * Un vuelo tiene información sobre el destino, la compañía a cargo, el número
 * de pasajeros, el capitán, el segundo al mando, la hora de llegada, la hora de
 * salida y la cantidad de combustible.
 * </p>
 * 
 * @author Mario
 * @version 1.0
 * @since 2024-09-24
 */
public abstract class Vuelo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String destino;
	private String companyInCharge;
	private int numPassengers;
	private String captain;
	private String secondInCommand;
	private String arrivalTime;
	private String departureTime;
	private double gas;

	/**
	 * Constructor por defecto para crear un objeto Vuelo sin inicializar sus
	 * atributos.
	 */
	public Vuelo() {
		// Constructor vacío generado automáticamente
	}

	/**
	 * Constructor que inicializa un vuelo con los parámetros especificados.
	 * 
	 * @param destino         El destino del vuelo.
	 * @param companyInCharge La compañía a cargo del vuelo.
	 * @param numPassengers   El número de pasajeros.
	 * @param captain         El capitán del vuelo.
	 * @param secondInCommand El segundo al mando del vuelo.
	 * @param arrivalTime     La hora de llegada del vuelo.
	 * @param departureTime   La hora de salida del vuelo.
	 * @param gas             La cantidad de combustible disponible para el vuelo.
	 */
	public Vuelo(String destino, String companyInCharge, int numPassengers, String captain, String secondInCommand,
			String arrivalTime, String departureTime, double gas) {
		super();
		this.destino = destino;
		this.companyInCharge = companyInCharge;
		this.numPassengers = numPassengers;
		this.captain = captain;
		this.secondInCommand = secondInCommand;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.gas = gas;
	}

	// Métodos getters y setters con Javadoc

	/**
	 * Obtiene el destino del vuelo.
	 * 
	 * @return El destino del vuelo.
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * Establece el destino del vuelo.
	 * 
	 * @param destino El destino a establecer.
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	/**
	 * Obtiene la compañía a cargo del vuelo.
	 * 
	 * @return La compañía a cargo.
	 */
	public String getCompanyInCharge() {
		return companyInCharge;
	}

	/**
	 * Establece la compañía a cargo del vuelo.
	 * 
	 * @param companyInCharge La compañía a establecer.
	 */
	public void setCompanyInCharge(String companyInCharge) {
		this.companyInCharge = companyInCharge;
	}

	/**
	 * Obtiene el número de pasajeros del vuelo.
	 * 
	 * @return El número de pasajeros.
	 */
	public int getNumPassengers() {
		return numPassengers;
	}

	/**
	 * Establece el número de pasajeros del vuelo.
	 * 
	 * @param numPassengers El número de pasajeros a establecer.
	 */
	public void setNumPassengers(int numPassengers) {
		this.numPassengers = numPassengers;
	}

	/**
	 * Obtiene el nombre del capitán del vuelo.
	 * 
	 * @return El nombre del capitán.
	 */
	public String getCaptain() {
		return captain;
	}

	/**
	 * Establece el nombre del capitán del vuelo.
	 * 
	 * @param captain El nombre del capitán a establecer.
	 */
	public void setCaptain(String captain) {
		this.captain = captain;
	}

	/**
	 * Obtiene el nombre del segundo al mando.
	 * 
	 * @return El nombre del segundo al mando.
	 */
	public String getSecondInCommand() {
		return secondInCommand;
	}

	/**
	 * Establece el nombre del segundo al mando.
	 * 
	 * @param secondInCommand El nombre del segundo al mando a establecer.
	 */
	public void setSecondInCommand(String secondInCommand) {
		this.secondInCommand = secondInCommand;
	}

	/**
	 * Obtiene la hora de llegada del vuelo.
	 * 
	 * @return La hora de llegada.
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * Establece la hora de llegada del vuelo.
	 * 
	 * @param arrivalTime La hora de llegada a establecer.
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * Obtiene la hora de salida del vuelo.
	 * 
	 * @return La hora de salida.
	 */
	public String getDepartureTime() {
		return departureTime;
	}

	/**
	 * Establece la hora de salida del vuelo.
	 * 
	 * @param departureTime La hora de salida a establecer.
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * Obtiene la cantidad de combustible disponible.
	 * 
	 * @return La cantidad de combustible.
	 */
	public double getGas() {
		return gas;
	}

	/**
	 * Establece la cantidad de combustible disponible.
	 * 
	 * @param gas La cantidad de combustible a establecer.
	 */
	public void setGas(double gas) {
		this.gas = gas;
	}

	/**
	 * Devuelve una representación en cadena de los atributos del vuelo.
	 * 
	 * @return Los detalles del vuelo en formato de cadena de texto.
	 */
	@Override
	public String toString() {
		return "\nDestino: " + destino + "\nCompañia a cargo: " + companyInCharge + "\nNumero de pasajeros: "
				+ numPassengers + "\nCapitan: " + captain + "\nSegundo al mando: " + secondInCommand
				+ "\nHora de llegada: " + arrivalTime + "\nHora de salida: " + departureTime + "\nCombustible: " + gas;
	}
}
