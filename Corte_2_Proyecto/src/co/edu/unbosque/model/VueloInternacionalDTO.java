package co.edu.unbosque.model;

public class VueloInternacionalDTO extends VueloDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private boolean requiereVisa;

	public VueloInternacionalDTO() {
		// TODO Auto-generated constructor stub
	}

	public VueloInternacionalDTO(boolean requiereVisa) {
		super();
		this.requiereVisa = requiereVisa;
	}

	public VueloInternacionalDTO(String destino, String companyInCharge, int numPassengers, String captain,
			String secondInCommand, String arrivalTime, String departureTime, double gas, boolean requiereVisa) {
		super(destino, companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime, gas);
		this.requiereVisa = requiereVisa;
	}

	public VueloInternacionalDTO(String destino, String companyInCharge, int numPassengers, String captain,
			String secondInCommand, String arrivalTime, String departureTime, double gas) {
		super(destino, companyInCharge, numPassengers, captain, secondInCommand, arrivalTime, departureTime, gas);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the requiereVisa
	 */
	public boolean isRequiereVisa() {
		return requiereVisa;
	}

	/**
	 * @param requiereVisa the requiereVisa to set
	 */
	public void setRequiereVisa(boolean requiereVisa) {
		this.requiereVisa = requiereVisa;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "\nRequiere visa: " + requiereVisa;
	}

}
