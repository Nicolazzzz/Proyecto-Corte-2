package co.edu.unbosque.model;

import java.io.Serializable;

public abstract class Vuelo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String companyInCharge;
	private int numPassengers;
	private String captain;
	private String secondInCommand;
	private String arrivalTime;
	private String departureTime;
	private double gas;

	public Vuelo() {
		// TODO Auto-generated constructor stub
	}

	public Vuelo(String companyInCharge, int numPassengers, String captain, String secondInCommand, String arrivalTime,
			String departureTime, double gas) {
		super();
		this.companyInCharge = companyInCharge;
		this.numPassengers = numPassengers;
		this.captain = captain;
		this.secondInCommand = secondInCommand;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.gas = gas;
	}

	public String getCompanyInCharge() {
		return companyInCharge;
	}

	public void setCompanyInCharge(String companyInCharge) {
		this.companyInCharge = companyInCharge;
	}

	public int getNumPassengers() {
		return numPassengers;
	}

	public void setNumPassengers(int numPassengers) {
		this.numPassengers = numPassengers;
	}

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}

	public String getSecondInCommand() {
		return secondInCommand;
	}

	public void setSecondInCommand(String secondInCommand) {
		this.secondInCommand = secondInCommand;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public double getGas() {
		return gas;
	}

	public void setGas(double gas) {
		this.gas = gas;
	}

	@Override
	public String toString() {
		return "\nCompañia a cargo: " + companyInCharge + "\nNumero de pasajeros: " + numPassengers + "\nCapitan: "
				+ captain + "\nSegundo al mando: " + secondInCommand + "\nHora de llegada: " + arrivalTime
				+ "\nHora de salida: " + departureTime + "\nCombustible: " + gas;
	}

}
