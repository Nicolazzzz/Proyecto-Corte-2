package co.edu.unbosque.model;

import java.io.Serializable;

public class VueloInternacional extends Vuelo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private boolean requiereVisa;

	public VueloInternacional() {
		// TODO Auto-generated constructor stub
	}

	public VueloInternacional(boolean requiereVisa) {
		super();
		this.requiereVisa = requiereVisa;
	}

	public VueloInternacional(String companyInCharge, int numPassengers, String captain, String secondInCommand,
			String arrivalTime, String departureTime, double gas, boolean requiereVisa) {
		super(companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime, gas);
		this.requiereVisa = requiereVisa;
	}

	public VueloInternacional(String companyInCharge, int numPassengers, String captain, String secondInCommand,
			String arrivalTime, String departureTime, double gas) {
		super(companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime, gas);
		// TODO Auto-generated constructor stub
	}

	public boolean isRequiereVisa() {
		return requiereVisa;
	}

	public void setRequiereVisa(boolean requiereVisa) {
		this.requiereVisa = requiereVisa;
	}

	@Override
	public String toString() {
		return "\nRequiere visa: " + requiereVisa;
	}

}
