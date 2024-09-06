package co.edu.unbosque.model;

public class VueloNacional extends Vuelo {

	public boolean isTurbine;
	public boolean isHelix;

	public VueloNacional() {
		// TODO Auto-generated constructor stub
	}

	public VueloNacional(boolean isTurbine, boolean isHelix) {
		super();
		this.isTurbine = isTurbine;
		this.isHelix = isHelix;
	}

	public VueloNacional(String companyInCharge, int numPassengers, String captain, String secondInCommand,
			String arrivalTime, String departureTime, boolean isTurbine, boolean isHelix) {
		super(companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime);
		this.isTurbine = isTurbine;
		this.isHelix = isHelix;
	}

	public VueloNacional(String companyInCharge, int numPassengers, String captain, String secondInCommand,
			String arrivalTime, String departureTime) {
		super(companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime);
		// TODO Auto-generated constructor stub
	}

	public boolean isTurbine() {
		return isTurbine;
	}

	public void setTurbine(boolean isTurbine) {
		this.isTurbine = isTurbine;
	}

	public boolean isHelix() {
		return isHelix;
	}

	public void setHelix(boolean isHelix) {
		this.isHelix = isHelix;
	}

	@Override
	public String toString() {
		return super.toString() + "\nIs Turbine= " + isTurbine + "\nIs Helix= " + isHelix;
	}

}
