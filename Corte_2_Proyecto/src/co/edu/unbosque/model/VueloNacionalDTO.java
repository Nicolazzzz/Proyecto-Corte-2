package co.edu.unbosque.model;

public class VueloNacionalDTO extends VueloDTO {

	public boolean isTurbine;
	public boolean isHelix;

	public VueloNacionalDTO() {
		// TODO Auto-generated constructor stub
	}

	public VueloNacionalDTO(boolean isTurbine, boolean isHelix) {
		super();
		this.isTurbine = isTurbine;
		this.isHelix = isHelix;
	}

	public VueloNacionalDTO(String companyInCharge, int numPassengers, String captain, String secondInCommand,
			String arrivalTime, String departureTime, boolean isTurbine, boolean isHelix) {
		super(companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime);
		this.isTurbine = isTurbine;
		this.isHelix = isHelix;
	}

	public VueloNacionalDTO(String companyInCharge, int numPassengers, String captain, String secondInCommand,
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
