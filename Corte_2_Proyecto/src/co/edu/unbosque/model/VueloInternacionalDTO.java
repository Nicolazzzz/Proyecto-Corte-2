package co.edu.unbosque.model;

public class VueloInternacionalDTO extends VueloDTO {

	private boolean visaRequired;

	public VueloInternacionalDTO() {
		// TODO Auto-generated constructor stub
	}

	public VueloInternacionalDTO(boolean visaRequired) {
		super();
		this.visaRequired = visaRequired;
	}

	public VueloInternacionalDTO(String companyInCharge, int numPassengers, String captain, String secondInCommand,
			String arrivalTime, String departureTime, boolean visaRequired) {
		super(companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime);
		this.visaRequired = visaRequired;
	}

	public VueloInternacionalDTO(String companyInCharge, int numPassengers, String captain, String secondInCommand,
			String arrivalTime, String departureTime) {
		super(companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime);
		// TODO Auto-generated constructor stub
	}

	public boolean isVisaRequired() {
		return visaRequired;
	}

	public void setVisaRequired(boolean visaRequired) {
		this.visaRequired = visaRequired;
	}

	@Override
	public String toString() {
		return super.toString() + "\nVisa required: " + visaRequired;
	}

}
