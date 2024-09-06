package co.edu.unbosque.model;

public class VueloInternacional extends Vuelo {

	private boolean visaRequired;

	public VueloInternacional() {
		// TODO Auto-generated constructor stub
	}

	public VueloInternacional(boolean visaRequired) {
		super();
		this.visaRequired = visaRequired;
	}

	public VueloInternacional(String companyInCharge, int numPassengers, String captain, String secondInCommand,
			String arrivalTime, String departureTime, boolean visaRequired) {
		super(companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime);
		this.visaRequired = visaRequired;
	}

	public VueloInternacional(String companyInCharge, int numPassengers, String captain, String secondInCommand,
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
