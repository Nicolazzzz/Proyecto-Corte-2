package co.edu.unbosque.model;

public abstract class VueloDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String destino;
	private String companyInCharge;
	private int numPassengers;
	private String captain;
	private String secondInCommand;
	private String arrivalTime;
	private String departureTime;
	private double gas;

	public VueloDTO() {
		// TODO Auto-generated constructor stub
	}

	public VueloDTO(String destino, String companyInCharge, int numPassengers, String captain, String secondInCommand,
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

	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	/**
	 * @return the companyInCharge
	 */
	public String getCompanyInCharge() {
		return companyInCharge;
	}

	/**
	 * @param companyInCharge the companyInCharge to set
	 */
	public void setCompanyInCharge(String companyInCharge) {
		this.companyInCharge = companyInCharge;
	}

	/**
	 * @return the numPassengers
	 */
	public int getNumPassengers() {
		return numPassengers;
	}

	/**
	 * @param numPassengers the numPassengers to set
	 */
	public void setNumPassengers(int numPassengers) {
		this.numPassengers = numPassengers;
	}

	/**
	 * @return the captain
	 */
	public String getCaptain() {
		return captain;
	}

	/**
	 * @param captain the captain to set
	 */
	public void setCaptain(String captain) {
		this.captain = captain;
	}

	/**
	 * @return the secondInCommand
	 */
	public String getSecondInCommand() {
		return secondInCommand;
	}

	/**
	 * @param secondInCommand the secondInCommand to set
	 */
	public void setSecondInCommand(String secondInCommand) {
		this.secondInCommand = secondInCommand;
	}

	/**
	 * @return the arrivalTime
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return the departureTime
	 */
	public String getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * @return the gas
	 */
	public double getGas() {
		return gas;
	}

	/**
	 * @param gas the gas to set
	 */
	public void setGas(double gas) {
		this.gas = gas;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "\nDestino: " + destino + "\nCompañia a cargo: " + companyInCharge + "\nNumero de pasajeros: "
				+ numPassengers + "\nCapitan: " + captain + "\nSegundo al mando: " + secondInCommand
				+ "\nHora de llegada: " + arrivalTime + "\nHora de salida: " + departureTime + "\nCombustible: " + gas;
	}

}
