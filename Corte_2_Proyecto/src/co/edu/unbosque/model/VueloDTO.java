package co.edu.unbosque.model;

/**
 * La clase {@code VueloDTO} representa un objeto de transferencia de datos
 * (DTO) para los detalles de un vuelo. Esta clase encapsula información
 * relevante sobre un vuelo, como el destino, la compañía a cargo, el número de
 * pasajeros, el capitán, el segundo al mando, los horarios de llegada y salida,
 * y la cantidad de combustible (gas).
 * <p>
 * Es una clase abstracta que debe ser extendida por clases concretas que
 * representen tipos específicos de vuelos.
 * </p>
 * 
 * @author Emmanuel
 * @since 2024-09-24
 * @version 1.0
 */
public abstract class VueloDTO {

	/** Identificador único para la serialización. */
	private static final long serialVersionUID = 1L;

	/** El destino del vuelo. */
	private String destino;

	/** La compañía a cargo del vuelo. */
	private String companyInCharge;

	/** El número de pasajeros a bordo del vuelo. */
	private int numPassengers;

	/** El capitán del vuelo. */
	private String captain;

	/** El segundo al mando del vuelo. */
	private String secondInCommand;

	/** La hora de llegada del vuelo. */
	private String arrivalTime;

	/** La hora de salida del vuelo. */
	private String departureTime;

	/** La cantidad de combustible (gas) del vuelo. */
	private double gas;

	/**
	 * Constructor por defecto para crear una instancia vacía de {@code VueloDTO}.
	 */
	public VueloDTO() {
		// Constructor vacío
	}

	/**
	 * Constructor con parámetros para crear una instancia de {@code VueloDTO} con
	 * todos los atributos especificados.
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
	public VueloDTO(String destino, String companyInCharge, int numPassengers, String captain, String secondInCommand,
			String arrivalTime, String departureTime, double gas) {
		this.destino = destino;
		this.companyInCharge = companyInCharge;
		this.numPassengers = numPassengers;
		this.captain = captain;
		this.secondInCommand = secondInCommand;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.gas = gas;
	}

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
	 * @param destino El nuevo destino del vuelo.
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	/**
	 * Obtiene la compañía a cargo del vuelo.
	 * 
	 * @return La compañía a cargo del vuelo.
	 */
	public String getCompanyInCharge() {
		return companyInCharge;
	}

	/**
	 * Establece la compañía a cargo del vuelo.
	 * 
	 * @param companyInCharge La nueva compañía a cargo del vuelo.
	 */
	public void setCompanyInCharge(String companyInCharge) {
		this.companyInCharge = companyInCharge;
	}

	/**
	 * Obtiene el número de pasajeros a bordo del vuelo.
	 * 
	 * @return El número de pasajeros.
	 */
	public int getNumPassengers() {
		return numPassengers;
	}

	/**
	 * Establece el número de pasajeros a bordo del vuelo.
	 * 
	 * @param numPassengers El nuevo número de pasajeros.
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
	 * @param captain El nuevo nombre del capitán.
	 */
	public void setCaptain(String captain) {
		this.captain = captain;
	}

	/**
	 * Obtiene el nombre del segundo al mando del vuelo.
	 * 
	 * @return El nombre del segundo al mando.
	 */
	public String getSecondInCommand() {
		return secondInCommand;
	}

	/**
	 * Establece el nombre del segundo al mando del vuelo.
	 * 
	 * @param secondInCommand El nuevo nombre del segundo al mando.
	 */
	public void setSecondInCommand(String secondInCommand) {
		this.secondInCommand = secondInCommand;
	}

	/**
	 * Obtiene la hora de llegada del vuelo.
	 * 
	 * @return La hora de llegada del vuelo.
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * Establece la hora de llegada del vuelo.
	 * 
	 * @param arrivalTime La nueva hora de llegada del vuelo.
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * Obtiene la hora de salida del vuelo.
	 * 
	 * @return La hora de salida del vuelo.
	 */
	public String getDepartureTime() {
		return departureTime;
	}

	/**
	 * Establece la hora de salida del vuelo.
	 * 
	 * @param departureTime La nueva hora de salida del vuelo.
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * Obtiene la cantidad de combustible (gas) del vuelo.
	 * 
	 * @return La cantidad de gas.
	 */
	public double getGas() {
		return gas;
	}

	/**
	 * Establece la cantidad de combustible (gas) del vuelo.
	 * 
	 * @param gas La nueva cantidad de gas.
	 */
	public void setGas(double gas) {
		this.gas = gas;
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
	 * Devuelve una representación en cadena de texto de los detalles del vuelo.
	 * 
	 * @return Una cadena que representa los detalles del vuelo.
	 */
	@Override
	public String toString() {
		return "\nDestino: " + destino + "\nCompañia a cargo: " + companyInCharge + "\nNumero de pasajeros: "
				+ numPassengers + "\nCapitan: " + captain + "\nSegundo al mando: " + secondInCommand
				+ "\nHora de llegada: " + arrivalTime + "\nHora de salida: " + departureTime + "\nCombustible: " + gas;
	}
}
