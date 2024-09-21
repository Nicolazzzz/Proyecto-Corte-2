package co.edu.unbosque.model;

public class VueloInternacionalDTO extends VueloDTO {

	private boolean requiereVisa;

	public VueloInternacionalDTO() {
		// TODO Auto-generated constructor stub
	}

	public VueloInternacionalDTO(boolean requiereVisa) {
		super();
		this.requiereVisa = requiereVisa;
	}

	public VueloInternacionalDTO(String companyInCharge, int numPassengers, String captain, String secondInCommand,
			String arrivalTime, String departureTime, double gas, boolean requiereVisa) {
		super(companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime, gas);
		this.requiereVisa = requiereVisa;
	}

	public VueloInternacionalDTO(String companyInCharge, int numPassengers, String captain, String secondInCommand,
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
